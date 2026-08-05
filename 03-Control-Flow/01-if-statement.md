# If Statement in Java

## Introduction

The `if` statement is the simplest decision-making statement in Java.

It is used to execute a block of code only when a specified condition is **true**. If the condition is **false**, the code inside the `if` block is skipped.

---

# Why Do We Need the If Statement?

In real-world applications, programs often need to make decisions based on certain conditions.

For example:

- Check whether a student has passed or failed.
- Verify if a user is eligible to vote.
- Validate a login password.
- Determine whether a number is positive or negative.

The `if` statement allows a program to make such decisions.

---

# Syntax

```java
if (condition) {

    // Code to be executed if the condition is true

}
```

The condition must evaluate to a **boolean** value (`true` or `false`).

---

# Flow of Execution

```text
        Condition
            │
     ┌──────┴──────┐
     │             │
   True         False
     │             │
Execute Code   Skip Code
     │             │
     └──────┬──────┘
            │
      Next Statement
```

---

# Example 1

```java
public class IfStatementExample {

    public static void main(String[] args) {

        int age = 20;

        if (age >= 18) {
            System.out.println("Eligible to Vote");
        }

    }

}
```

### Output

```text
Eligible to Vote
```

---

# Example 2

```java
public class IfStatementExample {

    public static void main(String[] args) {

        int number = 15;

        if (number > 0) {
            System.out.println("Positive Number");
        }

    }

}
```

### Output

```text
Positive Number
```

---

# Key Points

- The `if` statement executes only when the condition is `true`.
- If the condition is `false`, the block is skipped.
- Curly braces `{}` are recommended even for a single statement to improve readability.
- Multiple `if` statements can be used independently.

---

# Advantages

- Simple and easy to understand.
- Helps in decision-making.
- Executes code only when required.
- Improves program flexibility.

---

# Interview Questions

### 1. What is an if statement?

**Answer:** The `if` statement is a decision-making statement that executes a block of code only when a specified condition is true.

---

### 2. What type of value should an if condition return?

**Answer:** A boolean value (`true` or `false`).

---

### 3. Will the if block execute if the condition is false?

**Answer:** No. The block is skipped.

---

### 4. Can we write an if statement without braces?

**Answer:** Yes, if there is only one statement. However, using braces is recommended for better readability and maintainability.

Example:

```java
if (age >= 18)
    System.out.println("Eligible");
```

---

# Summary

The `if` statement is used to execute a block of code only when a given condition is true. It is the basic decision-making statement in Java and is widely used to control the flow of program execution.

---

## Related Topics

- If-Else Statement
- Nested If
- Switch Statement
- Operators
