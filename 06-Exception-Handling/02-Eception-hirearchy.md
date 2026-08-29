# Exception Hierarchy in Java

## Introduction

In Java, all exceptions and errors are part of a class hierarchy.

The root class for exception-related problems is:

```text
Throwable
```

Only objects that are subclasses of `Throwable` can be thrown and caught by Java's exception handling mechanism.

The basic hierarchy is:

```text
Object
   │
   └── Throwable
          │
          ├── Error
          │
          └── Exception
                 │
                 ├── RuntimeException
                 │
                 └── Other Exceptions
```

Understanding this hierarchy is important because Java exception handling follows inheritance.

---

# Throwable Class

`Throwable` is the parent class of all errors and exceptions in Java.

Basic hierarchy:

```text
Object
   ↓
Throwable
   ├── Error
   │
   └── Exception
```

The `Throwable` class provides methods such as:

```java
getMessage()
toString()
printStackTrace()
```

These methods help us get information about errors and exceptions.

---

# Main Types of Throwable

There are two main subclasses of `Throwable`:

```text
Throwable
   │
   ├── Error
   │
   └── Exception
```

## Error

`Error` represents serious problems that generally occur outside the normal control of an application.

Examples:

```text
OutOfMemoryError
StackOverflowError
VirtualMachineError
```

These problems are generally not intended to be handled by normal application code.

---

## Exception

`Exception` represents problems that can often be handled by an application.

Examples:

```text
IOException
SQLException
ArithmeticException
NullPointerException
```

Exceptions are mainly divided into:

```text
Exception
   │
   ├── Checked Exceptions
   │
   └── Unchecked Exceptions
```

---

# Complete Exception Hierarchy

A simplified hierarchy is:

```text
Object
   │
   └── Throwable
          │
          ├── Error
          │      │
          │      ├── OutOfMemoryError
          │      ├── StackOverflowError
          │      └── VirtualMachineError
          │
          └── Exception
                 │
                 ├── RuntimeException
                 │      │
                 │      ├── ArithmeticException
                 │      ├── NullPointerException
                 │      ├── ArrayIndexOutOfBoundsException
                 │      ├── NumberFormatException
                 │      └── ClassCastException
                 │
                 ├── IOException
                 ├── SQLException
                 └── ClassNotFoundException
```

This hierarchy is simplified, but it shows the most commonly used exception types.

---

# Error

An `Error` usually represents a serious problem related to the JVM or system environment.

Example:

```text
StackOverflowError
```

This can occur when method calls continue recursively without reaching a stopping condition.

Example:

```java
public class Demo {

    static void recursiveMethod() {

        recursiveMethod();
    }

    public static void main(String[] args) {

        recursiveMethod();
    }
}
```

This eventually causes:

```text
StackOverflowError
```

Another example:

```text
OutOfMemoryError
```

This occurs when the JVM cannot allocate enough memory.

---

# Exception

Exceptions represent abnormal situations that occur during program execution.

Example:

```java
int result = 10 / 0;
```

This produces:

```text
ArithmeticException
```

Unlike many `Error` types, exceptions can often be handled using:

```java
try
catch
```

Example:

```java
try {

    int result = 10 / 0;

} catch (ArithmeticException e) {

    System.out.println("Cannot divide by zero");
}
```

---

# Checked Exceptions

Checked exceptions are checked by the compiler at compile time.

The compiler requires the programmer to either:

```text
Handle the exception
```

or:

```text
Declare the exception using throws
```

Examples:

```text
IOException
SQLException
ClassNotFoundException
FileNotFoundException
```

Example:

```java
import java.io.FileReader;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) {

        try {

            FileReader file =
                    new FileReader("data.txt");

        } catch (IOException e) {

            System.out.println("File not found");
        }
    }
}
```

The compiler forces us to handle or declare this type of exception.

---

# Unchecked Exceptions

Unchecked exceptions occur during runtime.

They are subclasses of:

```text
RuntimeException
```

The compiler does not force us to handle them.

Hierarchy:

```text
Exception
   │
   └── RuntimeException
          │
          ├── ArithmeticException
          ├── NullPointerException
          ├── ArrayIndexOutOfBoundsException
          ├── NumberFormatException
          └── ClassCastException
```

These exceptions are often caused by programming mistakes.

---

# RuntimeException

`RuntimeException` is the parent class of many commonly occurring runtime exceptions.

Example:

```text
RuntimeException
       │
       ├── ArithmeticException
       ├── NullPointerException
       ├── ArrayIndexOutOfBoundsException
       └── NumberFormatException
```

Because these exceptions inherit from `RuntimeException`, a parent `catch` can handle them.

Example:

```java
try {

    int result = 10 / 0;

} catch (RuntimeException e) {

    System.out.println("Runtime exception handled");
}
```

Output:

```text
Runtime exception handled
```

This works because:

```text
ArithmeticException IS-A RuntimeException
```

---

# Common Runtime Exceptions

## 1. ArithmeticException

Occurs when an invalid arithmetic operation is performed.

Example:

```java
int result = 10 / 0;
```

---

## 2. NullPointerException

Occurs when we try to access a method or property using a `null` reference.

Example:

```java
String name = null;

System.out.println(name.length());
```

---

## 3. ArrayIndexOutOfBoundsException

Occurs when an invalid array index is accessed.

Example:

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

---

## 4. NumberFormatException

Occurs when an invalid string is converted into a number.

Example:

```java
int number = Integer.parseInt("abc");
```

---

## 5. ClassCastException

Occurs when an object is incorrectly cast to an incompatible type.

Example:

```java
Object object = "Hello";

Integer number = (Integer) object;
```

This causes:

```text
ClassCastException
```

---

# Important Parent-Child Relationships

Java exception handling follows inheritance.

For example:

```text
Throwable
   ↓
Exception
   ↓
RuntimeException
   ↓
ArithmeticException
```

Therefore:

```text
ArithmeticException
IS-A RuntimeException

RuntimeException
IS-A Exception

Exception
IS-A Throwable
```

This relationship is very important when using multiple `catch` blocks.

---

# Catching Child Exception Using Parent Reference

A parent exception type can catch exceptions of its child classes.

Example:

```java
try {

    int result = 10 / 0;

} catch (RuntimeException e) {

    System.out.println("Exception handled");
}
```

Output:

```text
Exception handled
```

Here the actual exception is:

```text
ArithmeticException
```

But:

```java
catch (RuntimeException e)
```

can handle it because:

```text
ArithmeticException
        ↓
RuntimeException
```

---

# Catching Using Exception

The `Exception` class can catch most normal exceptions that inherit from it.

Example:

```java
try {

    String name = null;

    System.out.println(name.length());

} catch (Exception e) {

    System.out.println("Exception handled");
}
```

Here the actual exception is:

```text
NullPointerException
```

But `Exception` can handle it because:

```text
NullPointerException
        ↓
RuntimeException
        ↓
Exception
```

---

# Multiple Catch and Exception Hierarchy

When multiple `catch` blocks are used, Java checks them from top to bottom.

Therefore, specific child exceptions must come before general parent exceptions.

Correct:

```java
try {

    int result = 10 / 0;

} catch (ArithmeticException e) {

    System.out.println("Arithmetic Exception");

} catch (RuntimeException e) {

    System.out.println("Runtime Exception");

} catch (Exception e) {

    System.out.println("General Exception");
}
```

Hierarchy:

```text
ArithmeticException
        ↓
RuntimeException
        ↓
Exception
```

Order:

```text
Child / Specific
       ↓
Parent / General
```

---

# Incorrect Catch Order

This is invalid:

```java
try {

    int result = 10 / 0;

} catch (Exception e) {

    System.out.println("Exception");

} catch (ArithmeticException e) {

    System.out.println("Arithmetic Exception");
}
```

Why?

Because:

```java
catch (Exception e)
```

already catches `ArithmeticException`.

Therefore:

```java
catch (ArithmeticException e)
```

becomes unreachable.

This produces a compile-time error.

---

# Why Does Java Follow This Rule?

Java checks `catch` blocks from top to bottom.

Suppose the parent comes first:

```text
Exception
   ↓
ArithmeticException
```

When an `ArithmeticException` occurs:

```text
Java checks Exception catch
          ↓
Matches because ArithmeticException is a child
          ↓
Exception handled
          ↓
ArithmeticException catch never reached
```

Therefore, Java prevents unreachable catch blocks at compile time.

---

# Exception vs RuntimeException

| Exception                                 | RuntimeException                |
| ----------------------------------------- | ------------------------------- |
| Parent class for most exceptions          | Child of `Exception`            |
| Includes checked and unchecked exceptions | Represents unchecked exceptions |
| Can be checked or runtime-related         | Always unchecked                |
| Example: `IOException`                    | Example: `NullPointerException` |

Hierarchy:

```text
Exception
   │
   ├── Checked Exceptions
   │
   └── RuntimeException
          │
          └── Unchecked Exceptions
```

---

# Error vs Exception

| Error                            | Exception                            |
| -------------------------------- | ------------------------------------ |
| Serious JVM/system-level problem | Application-level abnormal condition |
| Usually not handled              | Can often be handled                 |
| Extends `Throwable`              | Extends `Throwable`                  |
| Example: `OutOfMemoryError`      | Example: `IOException`               |
| Often unrecoverable              | Often recoverable                    |

---

# Checked vs Unchecked Exceptions

| Checked                            | Unchecked                  |
| ---------------------------------- | -------------------------- |
| Checked at compile time            | Occurs at runtime          |
| Must be handled or declared        | Handling is not mandatory  |
| Usually external conditions        | Often programming mistakes |
| Does not extend `RuntimeException` | Extends `RuntimeException` |
| `IOException`                      | `NullPointerException`     |
| `SQLException`                     | `ArithmeticException`      |

---

# Throwable Methods

Because both `Error` and `Exception` inherit from `Throwable`, they can use methods such as:

## getMessage()

Returns the exception message.

```java
try {

    int result = 10 / 0;

} catch (Exception e) {

    System.out.println(e.getMessage());
}
```

Output:

```text
/ by zero
```

---

## toString()

Returns the exception class name and message.

```java
System.out.println(e.toString());
```

Example:

```text
java.lang.ArithmeticException: / by zero
```

---

## printStackTrace()

Displays detailed information about where the exception occurred.

```java
e.printStackTrace();
```

This is useful for debugging.

---

# Important Interview Questions

### 1. What is the root class of all exceptions and errors?

**Answer:** `Throwable`.

---

### 2. What are the two main subclasses of Throwable?

**Answer:**

```text
Error
Exception
```

---

### 3. What is the difference between Error and Exception?

**Answer:** Errors generally represent serious JVM or system-level problems, while exceptions represent abnormal conditions that an application can often handle.

---

### 4. What is a checked exception?

**Answer:** A checked exception is checked by the compiler and must generally be handled or declared using `throws`.

---

### 5. What is an unchecked exception?

**Answer:** An unchecked exception is a subclass of `RuntimeException` that occurs at runtime and is not required by the compiler to be explicitly handled.

---

### 6. Is RuntimeException checked or unchecked?

**Answer:** Unchecked.

---

### 7. Can a parent catch block catch child exceptions?

**Answer:** Yes.

Example:

```java
catch (Exception e)
```

can catch:

```text
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
```

because they are descendants of `Exception`.

---

### 8. Why should child exceptions come before parent exceptions?

**Answer:** Because the parent catch can already handle the child exception, making the child catch unreachable.

---

### 9. What is the parent of RuntimeException?

**Answer:**

```text
Exception
```

---

### 10. What is the parent of Exception?

**Answer:**

```text
Throwable
```

---

# Quick Revision

```text
Object
   │
Throwable
   │
   ├── Error
   │      │
   │      ├── StackOverflowError
   │      └── OutOfMemoryError
   │
   └── Exception
          │
          ├── Checked Exceptions
          │      ├── IOException
          │      └── SQLException
          │
          └── RuntimeException
                 │
                 ├── ArithmeticException
                 ├── NullPointerException
                 ├── ArrayIndexOutOfBoundsException
                 └── NumberFormatException
```

Remember:

```text
Throwable
    ↓
Error + Exception

Exception
    ↓
Checked + Unchecked

RuntimeException
    ↓
Unchecked Exceptions
```

And for multiple catch blocks:

```text
Specific Child
      ↓
General Parent
```

---

# Summary

Java uses a hierarchy for errors and exceptions.

The root class is:

```text
Throwable
```

Its two main subclasses are:

```text
Error
Exception
```

Exceptions are commonly divided into:

```text
Checked Exceptions
Unchecked Exceptions
```

Unchecked exceptions are subclasses of:

```text
RuntimeException
```

Understanding this hierarchy is important because exception handling follows inheritance.

The most important rule is:

```text
Child catch first
Parent catch later
```

This prevents unreachable catch blocks and allows specific exceptions to be handled correctly.
