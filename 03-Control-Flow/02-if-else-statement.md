# If-Else Statement in Java

## Introduction

The `if-else` statement is a decision-making statement used to execute one block of code when a condition is **true** and another block of code when the condition is **false**.

Unlike the `if` statement, the `if-else` statement always executes one of the two blocks.

---

# Why Do We Need the If-Else Statement?

Sometimes, we need to perform different actions based on whether a condition is true or false.

For example:

- Check whether a student has passed or failed.
- Determine if a person is eligible to vote.
- Identify whether a number is positive or negative.
- Verify if a user has entered the correct password.

The `if-else` statement helps us make these decisions.

---

# Syntax

```java
if (condition) {

    // Executes when the condition is true

} else {

    // Executes when the condition is false

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
 Execute If      Execute Else
     Block          Block
       │             │
       └──────┬──────┘
              │
       Next Statement
```

---

# Difference Between if and if-else

| if                                                    | if-else                                                |
| ----------------------------------------------------- | ------------------------------------------------------ |
| Executes only when the condition is true.             | Executes one of two blocks based on the condition.     |
| No alternative block is available.                    | Provides an alternative (`else`) block.                |
| Suitable when only one condition needs to be checked. | Suitable when there are exactly two possible outcomes. |

---

# Example 1

```java
public class IfElseExample {

    public static void main(String[] args) {

        int age = 17;

        if (age >= 18) {
            System.out.println("Eligible to Vote");
        } else {
            System.out.println("Not Eligible to Vote");
        }

    }

}
```

### Output

```text
Not Eligible to Vote
```

---

# Example 2

```java
public class IfElseExample {

    public static void main(String[] args) {

        int marks = 60;

        if (marks >= 35) {
            System.out.println("Student Passed");
        } else {
            System.out.println("Student Failed");
        }

    }

}
```

### Output

```text
Student Passed
```

---

# Key Points

- The `if` block executes only when the condition is `true`.
- The `else` block executes only when the condition is `false`.
- Exactly one block (`if` or `else`) is executed.
- Curly braces `{}` are recommended for better readability.

---

# Advantages

- Makes programs capable of handling two possible outcomes.
- Improves decision-making in applications.
- Easy to understand and implement.
- Reduces unnecessary code duplication.

---

# Common Mistakes

### Incorrect

```java
if (10)
```

❌ Invalid because Java requires a boolean expression.

### Correct

```java
if (10 > 5)
```

✅ Valid because the condition evaluates to `true`.

---

# Interview Questions

### 1. What is an if-else statement?

**Answer:** The `if-else` statement executes one block of code when a condition is true and another block when the condition is false.

---

### 2. Can both the `if` and `else` blocks execute together?

**Answer:** No. Only one of the two blocks executes.

---

### 3. What type of value must the condition return?

**Answer:** A boolean value (`true` or `false`).

---

### 4. Is the `else` block mandatory?

**Answer:** No. If only one condition needs to be checked, the `if` statement alone is sufficient.

---

# Summary

The `if-else` statement is used to choose between two alternative blocks of code based on a condition. If the condition is true, the `if` block executes; otherwise, the `else` block executes. It is one of the most commonly used decision-making statements in Java.

---

## Related Topics

- If Statement
- Nested If
- Switch Statement
- Ternary Operator
