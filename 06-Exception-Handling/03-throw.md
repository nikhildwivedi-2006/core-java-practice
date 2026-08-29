# throw and throws in Java

## Introduction

Java provides two keywords related to exception handling:

```text
throw
throws
```

Although their names look similar, they are used for different purposes.

```text
throw  → Used to explicitly throw an exception
throws → Used to declare possible exceptions
```

---

# throw Keyword

The `throw` keyword is used to explicitly throw an exception.

Normally, Java automatically throws exceptions when an error occurs.

Example:

```java
int result = 10 / 0;
```

Java automatically throws:

```text
ArithmeticException
```

However, sometimes we want to manually create and throw an exception.

For this purpose, we use:

```java
throw
```

---

# Syntax

```java
throw new ExceptionType("Message");
```

Example:

```java
throw new ArithmeticException("Invalid operation");
```

Here:

```text
throw
  ↓
Explicitly throws
  ↓
Exception object
```

---

# Basic Example

```java
public class ThrowExample {

    public static void main(String[] args) {

        int age = 16;

        if (age < 18) {

            throw new ArithmeticException(
                    "You are not eligible to vote"
            );
        }

        System.out.println("Eligible to vote");
    }
}
```

Output:

```text
Exception in thread "main" java.lang.ArithmeticException:
You are not eligible to vote
```

Here, the exception is manually thrown.

---

# Handling Exception Thrown Using throw

We can handle a manually thrown exception using `try-catch`.

Example:

```java
public class ThrowExample {

    public static void main(String[] args) {

        try {

            int age = 16;

            if (age < 18) {

                throw new IllegalArgumentException(
                        "Age must be 18 or above"
                );
            }

            System.out.println("Eligible");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
```

Output:

```text
Age must be 18 or above
Program continues...
```

---

# throw Always Throws an Object

The `throw` keyword is followed by an object.

Example:

```java
throw new ArithmeticException();
```

This is valid because:

```java
new ArithmeticException()
```

creates an exception object.

We cannot write:

```java
throw ArithmeticException;
```

because `ArithmeticException` is a class, not an object.

---

# Throwing Different Exceptions

We can manually throw different exception types.

## ArithmeticException

```java
throw new ArithmeticException("Invalid calculation");
```

---

## NullPointerException

```java
throw new NullPointerException("Object is null");
```

---

## IllegalArgumentException

```java
throw new IllegalArgumentException("Invalid argument");
```

---

# throw with Conditions

`throw` is commonly used with conditional statements.

Example:

```java
int marks = -10;

if (marks < 0) {

    throw new IllegalArgumentException(
            "Marks cannot be negative"
    );
}
```

This is useful for validating input.

---

# throw and Program Flow

When an exception is thrown:

```text
Statement 1
     ↓
throw exception
     ↓
Remaining statements skipped
     ↓
Control moves to matching catch block
```

Example:

```java
try {

    System.out.println("Before");

    throw new RuntimeException("Something went wrong");

    // unreachable code

} catch (RuntimeException e) {

    System.out.println("Exception handled");
}
```

Output:

```text
Before
Exception handled
```

Any statement after an unconditional `throw` becomes unreachable.

---

# throw with Custom Message

We can provide a custom message while creating an exception.

Example:

```java
throw new IllegalArgumentException(
        "Username cannot be empty"
);
```

The message can later be accessed using:

```java
e.getMessage();
```

Example:

```java
try {

    throw new IllegalArgumentException(
            "Invalid username"
    );

} catch (IllegalArgumentException e) {

    System.out.println(e.getMessage());
}
```

Output:

```text
Invalid username
```

---

# Re-throwing an Exception

An exception caught in a `catch` block can be thrown again.

Example:

```java
public class RethrowExample {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Exception caught");

            throw e;
        }
    }
}
```

Output:

```text
Exception caught
```

After printing the message, the exception is thrown again.

This is called:

```text
Re-throwing an exception
```

---

# throws Keyword

The `throws` keyword is used in a method declaration.

It declares that a method may throw one or more exceptions.

Syntax:

```java
returnType methodName() throws ExceptionType {

    // method body
}
```

Example:

```java
void readFile() throws IOException {

    // code
}
```

Here, the method declares that it may throw an:

```text
IOException
```

---

# Basic throws Example

```java
import java.io.FileReader;
import java.io.IOException;

public class ThrowsExample {

    static void readFile() throws IOException {

        FileReader file =
                new FileReader("data.txt");
    }

    public static void main(String[] args) {

        try {

            readFile();

        } catch (IOException e) {

            System.out.println("File not found");
        }
    }
}
```

Here:

```text
readFile()
     ↓
may throw IOException
     ↓
declared using throws
     ↓
handled by caller
```

---

# Why Do We Use throws?

Checked exceptions must generally be:

```text
Handled
```

or:

```text
Declared
```

The `throws` keyword allows a method to declare:

> This method may throw this exception. The caller is responsible for handling it.

Example:

```java
void readData() throws IOException {

}
```

The responsibility can then move to the calling method.

---

# Exception Propagation

Consider:

```java
method1()
   ↓
method2()
   ↓
method3()
```

If `method3()` throws an exception:

```text
method3()
   ↓
method2()
   ↓
method1()
```

The exception can propagate up the method call stack until it is handled.

Example:

```java
public class ExceptionPropagation {

    static void method3() {

        int result = 10 / 0;
    }

    static void method2() {

        method3();
    }

    static void method1() {

        method2();
    }

    public static void main(String[] args) {

        try {

            method1();

        } catch (ArithmeticException e) {

            System.out.println("Exception handled");
        }
    }
}
```

Output:

```text
Exception handled
```

The exception travels through the method call stack until it reaches a matching `catch` block.

---

# throw vs throws

| throw                                     | throws                              |
| ----------------------------------------- | ----------------------------------- |
| Used to explicitly throw an exception     | Used to declare possible exceptions |
| Used inside a method                      | Used in method declaration          |
| Throws an exception object                | Declares exception classes          |
| Followed by an exception object           | Followed by exception type(s)       |
| Can throw one exception object at a time  | Can declare multiple exceptions     |
| Used for checked and unchecked exceptions | Mainly used for checked exceptions  |

---

# Example Comparing throw and throws

```java
import java.io.IOException;

public class ThrowVsThrows {

    static void validateAge(int age) {

        if (age < 18) {

            throw new IllegalArgumentException(
                    "Age must be 18 or above"
            );
        }
    }

    static void readData() throws IOException {

        throw new IOException("File error");
    }

    public static void main(String[] args) {

        try {

            validateAge(16);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        try {

            readData();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
```

Here:

```text
throw
```

actually throws an exception.

While:

```text
throws
```

declares that a method may throw an exception.

---

# Can throw Be Used for Checked Exceptions?

Yes.

Example:

```java
import java.io.IOException;

public class Demo {

    static void readData() throws IOException {

        throw new IOException("File error");
    }
}
```

However, because `IOException` is a checked exception, it must be:

```text
Caught
```

or:

```text
Declared using throws
```

---

# Can throws Be Used with Unchecked Exceptions?

Yes, but it is usually not required.

Example:

```java
void divide() throws ArithmeticException {

    int result = 10 / 0;
}
```

This is valid.

However, `ArithmeticException` is unchecked, so declaring it with `throws` is not mandatory.

---

# Multiple Exceptions with throws

A method can declare multiple exceptions.

Example:

```java
void processData()
        throws IOException, SQLException {

}
```

This means the method may throw:

```text
IOException
SQLException
```

---

# Important Rules of throw

### Rule 1

`throw` is used to explicitly throw an exception.

```java
throw new RuntimeException();
```

---

### Rule 2

`throw` is followed by an exception object.

```java
throw new Exception();
```

---

### Rule 3

Code after an unconditional `throw` is unreachable.

Example:

```java
throw new RuntimeException();

System.out.println("Hello"); // Compile-time error
```

---

### Rule 4

`throw` can throw both checked and unchecked exceptions.

---

### Rule 5

A thrown checked exception must be handled or declared.

---

# Important Rules of throws

### Rule 1

`throws` is used in the method declaration.

```java
void method() throws IOException {

}
```

---

### Rule 2

`throws` declares possible exceptions.

It does not actually throw an exception.

---

### Rule 3

A method can declare multiple exceptions.

```java
void method()
        throws IOException, SQLException {

}
```

---

### Rule 4

`throws` is mainly used for checked exceptions.

---

# throw and Inheritance

Exception handling also follows inheritance when using `throw`.

Example:

```java
throw new ArithmeticException();
```

Since:

```text
ArithmeticException
        ↓
RuntimeException
        ↓
Exception
        ↓
Throwable
```

The thrown object can be caught using:

```java
catch (ArithmeticException e)
```

or:

```java
catch (RuntimeException e)
```

or:

```java
catch (Exception e)
```

The closest matching catch is generally preferred.

---

# Best Practices

## 1. Use Meaningful Exception Types

Prefer:

```java
throw new IllegalArgumentException(
        "Age cannot be negative"
);
```

instead of:

```java
throw new Exception("Error");
```

Choose an exception type that describes the actual problem.

---

## 2. Provide Useful Messages

Prefer:

```java
throw new IllegalArgumentException(
        "Password must contain at least 8 characters"
);
```

instead of:

```java
throw new IllegalArgumentException("Invalid");
```

---

## 3. Don't Use Exceptions for Normal Control Flow

Avoid using exceptions where normal conditions can be handled using:

```java
if
else
```

---

## 4. Catch Specific Exceptions

Prefer:

```java
catch (IOException e)
```

instead of always using:

```java
catch (Exception e)
```

---

# Important Interview Questions

### 1. What is the difference between throw and throws?

**Answer:**

`throw` is used to explicitly throw an exception object, while `throws` is used in a method declaration to declare possible exceptions.

---

### 2. Where is throw used?

**Answer:**

Inside a method or block.

---

### 3. Where is throws used?

**Answer:**

In the method declaration.

---

### 4. Does throws actually throw an exception?

**Answer:**

No. It only declares that a method may throw an exception.

---

### 5. Can throw throw checked exceptions?

**Answer:**

Yes, but checked exceptions must be handled or declared.

---

### 6. Can a method declare multiple exceptions using throws?

**Answer:**

Yes.

Example:

```java
void method()
        throws IOException, SQLException {

}
```

---

### 7. What happens after throw?

**Answer:**

Normal program flow stops, and control moves to a matching catch block or propagates to the caller.

---

### 8. Can we throw an existing exception object?

**Answer:**

Yes.

Example:

```java
catch (Exception e) {

    throw e;
}
```

This is called re-throwing an exception.

---

# Quick Revision

```text
throw
  │
  ├── Explicitly throws exception
  ├── Used inside method
  ├── Followed by object
  └── Example:
      throw new RuntimeException();
```

```text
throws
  │
  ├── Declares possible exception
  ├── Used in method declaration
  ├── Followed by exception class
  └── Example:
      void read() throws IOException
```

---

# Summary

Java provides two related keywords:

```text
throw
throws
```

`throw`:

```text
Actually throws an exception object.
```

Example:

```java
throw new IllegalArgumentException(
        "Invalid input"
);
```

`throws`:

```text
Declares that a method may throw an exception.
```

Example:

```java
void readFile() throws IOException {

}
```

Remember:

```text
throw
  ↓
Action

throws
  ↓
Declaration
```

This is the easiest way to remember the difference between them.
