# finally Block in Java

## Introduction

The `finally` block is used with exception handling to execute important cleanup code.

It is generally used with:

```text
try
catch
finally
```

The `finally` block normally executes whether an exception occurs or not.

Basic structure:

```java
try {

    // risky code

} catch (Exception e) {

    // exception handling

} finally {

    // cleanup code
}
```

---

# Why Do We Need finally?

Some resources need to be cleaned up after program execution.

Examples:

```text
Files
Database connections
Network connections
Streams
Resources
```

The `finally` block helps ensure cleanup code is executed.

Example:

```java
try {

    System.out.println("Trying operation");

} finally {

    System.out.println("Cleanup operation");
}
```

Output:

```text
Trying operation
Cleanup operation
```

---

# Basic finally Example

```java
public class FinallyExample {

    public static void main(String[] args) {

        try {

            int result = 10 / 2;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

        } finally {

            System.out.println("Finally block executed");
        }
    }
}
```

Output:

```text
Result: 5
Finally block executed
```

Even though no exception occurs, the `finally` block executes.

---

# finally When Exception Occurs

Example:

```java
public class FinallyExample {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

        } finally {

            System.out.println("Finally block executed");
        }
    }
}
```

Output:

```text
Cannot divide by zero
Finally block executed
```

The `finally` block executes after the `catch` block.

---

# finally Without catch

A `finally` block can be used without a `catch` block.

Example:

```java
public class FinallyExample {

    public static void main(String[] args) {

        try {

            System.out.println("Inside try");

        } finally {

            System.out.println("Inside finally");
        }
    }
}
```

Output:

```text
Inside try
Inside finally
```

A `try` block must have at least:

```text
catch
```

or:

```text
finally
```

---

# finally Execution Flow

## Case 1: No Exception

```text
try
 ↓
All statements execute
 ↓
finally
 ↓
Program continues
```

---

## Case 2: Exception Occurs and Is Handled

```text
try
 ↓
Exception occurs
 ↓
Remaining try code skipped
 ↓
Matching catch
 ↓
finally
 ↓
Program continues
```

---

## Case 3: Exception Occurs and Is Not Handled

```text
try
 ↓
Exception occurs
 ↓
finally
 ↓
Exception propagates
```

Example:

```java
public class FinallyExample {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } finally {

            System.out.println("Finally executed");
        }
    }
}
```

Output:

```text
Finally executed

Exception in thread "main"
java.lang.ArithmeticException: / by zero
```

Even when an exception is not handled, `finally` executes before the exception propagates.

---

# finally with return

This is an important concept.

Consider:

```java
public class FinallyReturnExample {

    static int getNumber() {

        try {

            return 10;

        } finally {

            System.out.println("Finally executed");
        }
    }

    public static void main(String[] args) {

        System.out.println(getNumber());
    }
}
```

Output:

```text
Finally executed
10
```

The `finally` block executes before the method actually returns.

Flow:

```text
try
 ↓
return prepared
 ↓
finally executes
 ↓
value returned
```

---

# return Inside finally

A `return` statement inside `finally` can override the return value from `try` or `catch`.

Example:

```java
public class FinallyReturnExample {

    static int getNumber() {

        try {

            return 10;

        } finally {

            return 20;
        }
    }

    public static void main(String[] args) {

        System.out.println(getNumber());
    }
}
```

Output:

```text
20
```

The value from `finally` overrides the value from `try`.

This is generally considered bad practice.

Avoid:

```java
return
```

inside a `finally` block.

---

# finally with System.exit()

The `finally` block normally executes, but there are situations where it may not execute.

One example is:

```java
System.exit();
```

Example:

```java
public class FinallyExample {

    public static void main(String[] args) {

        try {

            System.out.println("Inside try");

            System.exit(0);

        } finally {

            System.out.println("Inside finally");
        }
    }
}
```

Output:

```text
Inside try
```

The `finally` block does not execute because the JVM terminates.

---

# When finally May Not Execute

The `finally` block normally executes, but not always.

Examples include:

## 1. JVM Termination

```java
System.exit(0);
```

---

## 2. JVM Crash

If the JVM crashes unexpectedly, `finally` may not execute.

---

## 3. Forced Process Termination

If the program process is forcefully terminated, the `finally` block may not execute.

---

## Important Note

The safest statement is:

> The `finally` block is designed to execute regardless of whether an exception occurs, but JVM termination or abnormal process termination can prevent it from running.

---

# finally and Nested try

A `finally` block can also be used with nested `try` blocks.

Example:

```java
public class NestedFinallyExample {

    public static void main(String[] args) {

        try {

            try {

                int result = 10 / 0;

            } catch (ArithmeticException e) {

                System.out.println("Inner catch");

            } finally {

                System.out.println("Inner finally");
            }

        } finally {

            System.out.println("Outer finally");
        }
    }
}
```

Output:

```text
Inner catch
Inner finally
Outer finally
```

---

# Resource Cleanup

The most common purpose of `finally` is resource cleanup.

Example conceptually:

```java
Connection connection = null;

try {

    // database operation

} catch (Exception e) {

    // handle exception

} finally {

    // close connection
}
```

Similarly:

```text
Open File
   ↓
Perform Operation
   ↓
Exception may occur
   ↓
finally
   ↓
Close File
```

---

# finally vs finalize()

These two concepts often confuse beginners.

They are completely different.

| finally                          | finalize()                                                             |
| -------------------------------- | ---------------------------------------------------------------------- |
| Block used in exception handling | Method related to garbage collection                                   |
| Executes during program flow     | Called by garbage collector before reclaiming an object (historically) |
| Used for cleanup operations      | Not recommended for resource management                                |
| Keyword                          | Method                                                                 |
| Part of exception handling       | Related to object lifecycle                                            |

Example:

```java
finally {

    System.out.println("Cleanup");
}
```

While `finalize()` was historically:

```java
@Override
protected void finalize() {

}
```

Important:

Modern Java strongly discourages relying on `finalize()` because it is deprecated.

---

# Common Mistakes

## 1. Thinking finally Executes Only When Exception Occurs

Incorrect.

`finally` normally executes whether an exception occurs or not.

---

## 2. Using return Inside finally

Avoid:

```java
finally {

    return value;
}
```

It can override returns and suppress exceptions.

---

## 3. Ignoring JVM Termination

`finally` does not have an absolute guarantee if the JVM or process terminates abnormally.

---

## 4. Using finally Instead of Proper Resource Management

For modern Java resource handling, `try-with-resources` is often preferred.

Example:

```java
try (FileReader file =
        new FileReader("data.txt")) {

    // use file

} catch (IOException e) {

    System.out.println("File error");
}
```

Java automatically closes the resource.

---

# finally vs try-with-resources

| finally                           | try-with-resources                 |
| --------------------------------- | ---------------------------------- |
| Manual cleanup                    | Automatic resource cleanup         |
| Requires explicit close operation | Automatically closes resources     |
| Traditional approach              | Modern preferred approach          |
| Can be used for general cleanup   | Best for `AutoCloseable` resources |

Example using `finally`:

```java
FileReader file = null;

try {

    file = new FileReader("data.txt");

} finally {

    if (file != null) {

        try {

            file.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
```

Using try-with-resources:

```java
try (FileReader file =
        new FileReader("data.txt")) {

    // use file
}
```

The second approach is cleaner.

---

# Important Rules

### Rule 1

`finally` normally executes whether an exception occurs or not.

---

### Rule 2

`finally` executes after `try` or `catch`.

---

### Rule 3

A `try` block can have `finally` without `catch`.

```java
try {

} finally {

}
```

---

### Rule 4

`finally` can execute even when an exception is not handled.

The exception propagates after `finally`.

---

### Rule 5

Avoid `return` inside `finally`.

It can override return values or suppress exceptions.

---

### Rule 6

`finally` may not execute if the JVM terminates.

Example:

```java
System.exit(0);
```

---

### Rule 7

Use `finally` primarily for cleanup operations.

---

# Important Interview Questions

### 1. What is the finally block?

**Answer:**

The `finally` block is used to execute cleanup code and normally executes whether an exception occurs or not.

---

### 2. Does finally always execute?

**Answer:**

It normally executes, but JVM termination, crashes, or forced process termination can prevent execution.

---

### 3. Can finally be used without catch?

**Answer:**

Yes.

Example:

```java
try {

} finally {

}
```

---

### 4. Can try exist without catch?

**Answer:**

Yes, if it has a `finally` block.

---

### 5. What happens if an exception is not handled?

**Answer:**

The `finally` block executes first, and then the exception propagates.

---

### 6. Does finally execute after return?

**Answer:**

Yes. The `finally` block executes before the method actually returns.

---

### 7. What happens if finally contains return?

**Answer:**

The return statement in `finally` can override the return value from `try` or `catch`. Therefore, it should generally be avoided.

---

### 8. What is the difference between finally and finalize()?

**Answer:**

`finally` is a block used in exception handling, while `finalize()` is a method historically related to garbage collection and is deprecated in modern Java.

---

### 9. What is the modern alternative for resource cleanup?

**Answer:**

`try-with-resources`.

---

# Quick Revision

```text
try
 ↓
Possible exception
 ↓
catch (if exception handled)
 ↓
finally
 ↓
Program continues
```

No exception:

```text
try → finally → continue
```

Exception handled:

```text
try → catch → finally → continue
```

Exception not handled:

```text
try → finally → exception propagates
```

Remember:

```text
finally
   ↓
Cleanup code
   ↓
Normally executes
```

---

# Summary

The `finally` block is mainly used for cleanup operations.

It normally executes regardless of whether:

```text
Exception occurs
```

or:

```text
No exception occurs
```

Basic structure:

```java
try {

    // risky code

} catch (Exception e) {

    // handle exception

} finally {

    // cleanup code
}
```

Important points:

- Executes normally in both success and exception cases
- Commonly used for cleanup
- Can be used without `catch`
- Executes before a method returns
- Avoid `return` inside `finally`
- May not execute if JVM terminates abnormally
- `try-with-resources` is preferred for modern resource management

Remember:

```text
try → catch → finally
```

And:

```text
finally = cleanup
```
