# Exception Handling Basics in Java

## Introduction

An exception is an unexpected event that occurs during the execution of a program and disrupts the normal flow of execution.

Example:

```java
int a = 10;
int b = 0;

int result = a / b;
```

This causes:

```text
ArithmeticException
```

because division by zero is not allowed.

Java provides **Exception Handling** to handle such situations gracefully.

---

# Why Do We Need Exception Handling?

Without exception handling, an exception can terminate the program unexpectedly.

Example:

```java
public class Demo {

    public static void main(String[] args) {

        int result = 10 / 0;

        System.out.println("Program continues...");
    }
}
```

The statement after the exception will not execute.

Output:

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

With exception handling, we can handle the problem and allow the program to continue.

---

# Basic Exception Handling

Java mainly uses:

```text
try
catch
finally
throw
throws
```

For now, we will focus on:

```text
try
catch
finally
```

---

# try Block

The `try` block contains code that may produce an exception.

Syntax:

```java
try {

    // risky code

}
```

Example:

```java
try {

    int result = 10 / 0;

}
```

However, a `try` block cannot be used alone.

It must be followed by at least one:

```text
catch
```

or

```text
finally
```

---

# catch Block

The `catch` block handles an exception thrown from the `try` block.

Example:

```java
try {

    int result = 10 / 0;

} catch (ArithmeticException e) {

    System.out.println("Cannot divide by zero");
}
```

Output:

```text
Cannot divide by zero
```

---

# How try-catch Works

Consider:

```java
try {

    int result = 10 / 0;

    System.out.println("After division");

} catch (ArithmeticException e) {

    System.out.println("Exception handled");
}

System.out.println("Program continues");
```

Flow:

```text
        try block
            ↓
     Exception occurs
            ↓
    Remaining try code skipped
            ↓
       catch block
            ↓
    Program continues
```

Output:

```text
Exception handled
Program continues
```

---

# Exception Object

When an exception occurs, Java creates an exception object.

Example:

```java
catch (ArithmeticException e) {

    System.out.println(e);
}
```

Here:

```text
e
↓
Reference to exception object
```

We can use this object to get information about the exception.

---

# Common Exception Methods

## getMessage()

Returns the detail message of the exception.

Example:

```java
try {

    int result = 10 / 0;

} catch (ArithmeticException e) {

    System.out.println(e.getMessage());
}
```

Output may be:

```text
/ by zero
```

---

## toString()

Returns the exception class name and message.

```java
catch (ArithmeticException e) {

    System.out.println(e.toString());
}
```

Example output:

```text
java.lang.ArithmeticException: / by zero
```

---

## printStackTrace()

Prints detailed information about where the exception occurred.

```java
catch (ArithmeticException e) {

    e.printStackTrace();
}
```

It is mainly useful while debugging.

---

# Multiple catch Blocks

A single `try` block can have multiple `catch` blocks.

Example:

```java
try {

    int[] numbers = {10, 20, 30};

    System.out.println(numbers[5]);

} catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

} catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid array index");

} catch (Exception e) {

    System.out.println("Some other exception");
}
```

Only the matching `catch` block executes.

---

# Parent-Child Relationship in Multiple catch Blocks

This is a very important rule.

Exceptions follow inheritance relationships.

For example:

```text
Object
   ↑
Throwable
   ↑
Exception
   ↑
RuntimeException
   ↑
ArithmeticException
```

Therefore:

```text
ArithmeticException → Child
Exception           → Parent
```

When using multiple `catch` blocks, the **child/specific exception must come before the parent/general exception**.

---

# Correct Order

```java
try {

    int result = 10 / 0;

} catch (ArithmeticException e) {

    System.out.println("Arithmetic Exception");

} catch (Exception e) {

    System.out.println("Exception");
}
```

This is correct because:

```text
ArithmeticException
       ↓
      Child
       ↓
Exception
       ↓
     Parent
```

The specific exception is handled first.

---

# Incorrect Order

```java
try {

    int result = 10 / 0;

} catch (Exception e) {

    System.out.println("Exception");

} catch (ArithmeticException e) {

    System.out.println("Arithmetic Exception");
}
```

This causes a **compile-time error**.

Why?

Because:

```text
Exception
```

is the parent of:

```text
ArithmeticException
```

The first `catch` already catches `ArithmeticException`.

Therefore, the second catch becomes unreachable.

---

# Golden Rule for Multiple catch

Always remember:

```text
Specific / Child Exception
            ↓
General / Parent Exception
```

Example:

```java
catch (ArithmeticException e) {

}

catch (RuntimeException e) {

}

catch (Exception e) {

}
```

This follows:

```text
ArithmeticException
       ↓
RuntimeException
       ↓
Exception
```

Child first → Parent later.

---

# Another Parent-Child Example

Consider:

```text
Exception
   ↑
RuntimeException
   ↑
NullPointerException
```

Correct:

```java
try {

    String name = null;

    System.out.println(name.length());

} catch (NullPointerException e) {

    System.out.println("Null pointer");

} catch (RuntimeException e) {

    System.out.println("Runtime exception");

} catch (Exception e) {

    System.out.println("Exception");
}
```

The order is:

```text
NullPointerException
        ↓
RuntimeException
        ↓
Exception
```

---

# Exception Hierarchy and catch

A parent `catch` can catch child exceptions.

Example:

```java
try {

    int result = 10 / 0;

} catch (Exception e) {

    System.out.println("Exception handled");
}
```

Even though the actual exception is:

```text
ArithmeticException
```

the `Exception` catch can handle it because:

```text
ArithmeticException IS-A Exception
```

This is a result of inheritance and polymorphism.

---

# One catch for Multiple Related Exceptions

Modern Java also supports multi-catch.

Syntax:

```java
catch (ExceptionType1 | ExceptionType2 e)
```

Example:

```java
try {

    // risky code

} catch (ArithmeticException | NullPointerException e) {

    System.out.println("Exception handled");
}
```

This allows multiple unrelated exception types to be handled by the same block.

---

# Important Multi-catch Rule

The exceptions used in a multi-catch cannot have a parent-child relationship.

Incorrect:

```java
catch (Exception | ArithmeticException e) {

}
```

Why?

Because:

```text
ArithmeticException
        ↓
Exception
```

`Exception` already covers `ArithmeticException`.

Therefore, this is not allowed.

---

# finally Block

The `finally` block contains code that normally executes whether an exception occurs or not.

Example:

```java
try {

    int result = 10 / 2;

} catch (ArithmeticException e) {

    System.out.println("Exception");

} finally {

    System.out.println("Finally executed");
}
```

Output:

```text
Finally executed
```

The `finally` block is commonly used for cleanup operations.

Detailed `finally` behavior will be covered in:

```text
finally-block.md
```

---

# try-catch-finally

All three can be used together.

```java
try {

    int result = 10 / 0;

} catch (ArithmeticException e) {

    System.out.println("Exception handled");

} finally {

    System.out.println("Cleanup code");
}
```

Output:

```text
Exception handled
Cleanup code
```

Flow:

```text
        try
         ↓
   Exception occurs
         ↓
       catch
         ↓
      finally
```

---

# Nested try

A `try` block can be placed inside another `try` block.

Example:

```java
try {

    try {

        int result = 10 / 0;

    } catch (ArithmeticException e) {

        System.out.println("Inner exception");

    }

} catch (Exception e) {

    System.out.println("Outer exception");
}
```

Output:

```text
Inner exception
```

Nested exception handling can be useful when different parts of a program require different handling logic.

---

# try Without catch

A `try` block can exist without a `catch` if it is followed by `finally`.

Valid:

```java
try {

    System.out.println("Hello");

} finally {

    System.out.println("Finally");
}
```

But this is invalid:

```java
try {

    System.out.println("Hello");
}
```

A `try` block must be followed by:

```text
catch
```

or

```text
finally
```

---

# Error vs Exception

Both `Error` and `Exception` are subclasses of `Throwable`.

Hierarchy:

```text
Object
   ↑
Throwable
   ├── Error
   └── Exception
```

## Error

Errors generally represent serious problems that applications usually should not try to handle.

Examples:

```text
OutOfMemoryError
StackOverflowError
```

## Exception

Exceptions represent conditions that an application can often handle.

Examples:

```text
IOException
SQLException
ArithmeticException
NullPointerException
```

---

# Checked vs Unchecked Exceptions

Java exceptions are commonly divided into:

```text
Exceptions
   ├── Checked Exceptions
   └── Unchecked Exceptions
```

---

# Checked Exceptions

Checked exceptions are checked by the compiler at compile time.

Example:

```text
IOException
SQLException
FileNotFoundException
```

The programmer must handle them or declare them using `throws`.

Example:

```java
import java.io.FileReader;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) {

        try {

            FileReader file = new FileReader("data.txt");

        } catch (IOException e) {

            System.out.println("File error");
        }
    }
}
```

---

# Unchecked Exceptions

Unchecked exceptions occur at runtime.

They generally extend:

```text
RuntimeException
```

Examples:

```text
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
NumberFormatException
```

Example:

```java
int result = 10 / 0;
```

This produces:

```text
ArithmeticException
```

---

# Checked vs Unchecked

| Checked Exception                    | Unchecked Exception                  |
| ------------------------------------ | ------------------------------------ |
| Checked at compile time              | Occurs during runtime                |
| Compiler forces handling/declaration | Compiler does not force handling     |
| Usually extends `Exception` directly | Extends `RuntimeException`           |
| Example: `IOException`               | Example: `ArithmeticException`       |
| Often related to external conditions | Often caused by programming mistakes |

---

# Common Runtime Exceptions

## ArithmeticException

Occurs during invalid arithmetic operations.

```java
int result = 10 / 0;
```

---

## NullPointerException

Occurs when trying to use a null reference where an object is required.

```java
String name = null;

System.out.println(name.length());
```

---

## ArrayIndexOutOfBoundsException

Occurs when accessing an invalid array index.

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

---

## NumberFormatException

Occurs when an invalid string is converted into a number.

```java
int number = Integer.parseInt("abc");
```

---

# Exception Handling Flow

Suppose:

```java
try {

    statement1;
    statement2;
    statement3;

} catch (Exception e) {

    statement4;
}

statement5;
```

If `statement2` throws an exception:

```text
statement1
    ↓
statement2
    ↓
Exception occurs
    ↓
statement3 skipped
    ↓
catch executes
    ↓
statement5 executes
```

---

# Important Rules

### Rule 1

A `try` block must be followed by `catch`, `finally`, or both.

### Rule 2

Multiple `catch` blocks are allowed.

### Rule 3

Only the first matching `catch` block executes.

### Rule 4

In multiple catch blocks, child exceptions must come before parent exceptions.

```text
Child → Parent
```

### Rule 5

A parent exception can catch its child exceptions.

```java
catch (Exception e)
```

can catch:

```text
ArithmeticException
NullPointerException
RuntimeException
```

and many others.

### Rule 6

A multi-catch cannot contain parent-child exceptions together.

Incorrect:

```java
catch (Exception | ArithmeticException e)
```

### Rule 7

`finally` is normally used for cleanup operations.

### Rule 8

An exception object can be accessed using the catch parameter.

```java
catch (Exception e)
```

---

# Best Practices

## 1. Catch Specific Exceptions

Prefer:

```java
catch (ArithmeticException e)
```

instead of unnecessarily using:

```java
catch (Exception e)
```

Specific handling makes the code clearer.

---

## 2. Don't Leave catch Empty

Avoid:

```java
catch (Exception e) {

}
```

An empty catch block can hide problems.

---

## 3. Use Meaningful Messages

Prefer:

```java
System.out.println("Cannot divide by zero");
```

instead of:

```java
System.out.println("Error");
```

---

## 4. Don't Use Exceptions for Normal Program Flow

Exceptions should handle exceptional situations, not replace normal conditional logic.

---

# Interview Questions

### 1. What is an exception?

An exception is an unexpected event that disrupts the normal flow of program execution.

### 2. What is exception handling?

Exception handling is a mechanism used to handle runtime problems and maintain the normal flow of the program.

### 3. What is the purpose of try?

The `try` block contains code that may throw an exception.

### 4. What is the purpose of catch?

The `catch` block handles an exception thrown from the corresponding `try` block.

### 5. Can we have multiple catch blocks?

Yes.

### 6. What is the order of multiple catch blocks?

Specific child exceptions should come before general parent exceptions.

```text
Child → Parent
```

### 7. Why can't parent catch come before child catch?

Because the parent catch can already handle the child exception, making the child catch unreachable.

### 8. Can one parent catch handle multiple child exceptions?

Yes.

Example:

```java
catch (Exception e)
```

can handle many child exception types.

### 9. What is multi-catch?

Multi-catch allows multiple unrelated exception types to be handled by one catch block.

```java
catch (IOException | SQLException e)
```

### 10. Can multi-catch contain parent and child exceptions?

No.

Example:

```java
catch (Exception | IOException e)
```

is invalid because `IOException` is a child of `Exception`.

### 11. What is the difference between Error and Exception?

`Error` generally represents serious system-level problems, while exceptions represent conditions that applications can often handle.

### 12. What are checked exceptions?

Checked exceptions are checked by the compiler and must generally be handled or declared.

### 13. What are unchecked exceptions?

Unchecked exceptions are runtime exceptions that are not forced by the compiler to be handled.

---

# Quick Revision

```text
Exception Handling
       │
       ├── try
       │
       ├── catch
       │
       ├── finally
       │
       ├── throw
       │
       └── throws
```

Multiple catch:

```text
Specific / Child
       ↓
General / Parent
```

Exception hierarchy:

```text
Object
   ↓
Throwable
   ├── Error
   │
   └── Exception
          ↓
    RuntimeException
          ↓
    Runtime Exceptions
```

Remember:

```text
Child catch → Parent catch
```

---

# Summary

Exception handling allows Java programs to handle unexpected situations without terminating abruptly.

The basic mechanism is:

```java
try {

    // risky code

} catch (Exception e) {

    // handling code
}
```

Important concepts include:

- `try`
- `catch`
- Multiple catch blocks
- Parent-child relationship
- Multi-catch
- `finally`
- Checked exceptions
- Unchecked exceptions
- Error vs Exception

The most important rule for multiple catch blocks is:

```text
Specific child exception first
            ↓
General parent exception later
```

This rule exists because Java follows inheritance and polymorphism when matching exceptions.
