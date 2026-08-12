# Nested If Statement in Java

## Introduction

A **Nested If** statement is an `if` statement placed inside another `if` statement.

The inner `if` statement is executed only if the outer `if` condition is **true**.

Nested If is useful when multiple conditions need to be checked one after another.

---

# Why Do We Need Nested If?

Sometimes, checking a single condition is not enough. We need to verify multiple conditions before performing an action.

For example:

- A student must first pass the exam, then check if they scored above 75% for a distinction.
- A user must first log in successfully, then check if they have admin access.
- A person must first be eligible to vote, then check if they have a valid voter ID.

In such cases, Nested If is used.

---

# Syntax

```java
if (condition1) {

    if (condition2) {

        // Executes when both conditions are true

    }

}
```

---

# Flow of Execution

```text
         Condition 1
              │
      ┌───────┴────────┐
      │                │
    True            False
      │                │
      ▼                │
   Condition 2         Skip
      │
  ┌───┴────┐
  │        │
True     False
  │        │
Execute   Skip
  │
Next Statement
```

---

# Example 1

```java
public class NestedIfExample {

    public static void main(String[] args) {

        int age = 20;
        boolean hasLicense = true;

        if (age >= 18) {

            if (hasLicense) {
                System.out.println("Eligible to Drive");
            }

        }

    }

}
```

### Output

```text
Eligible to Drive
```

---

# Example 2

```java
public class NestedIfExample {

    public static void main(String[] args) {

        int marks = 82;

        if (marks >= 35) {

            if (marks >= 75) {
                System.out.println("Passed with Distinction");
            }

        }

    }

}
```

### Output

```text
Passed with Distinction
```

---

# Key Points

- An `if` statement can be placed inside another `if` statement.
- The inner `if` executes only if the outer `if` condition is true.
- Nested If is useful when multiple conditions depend on each other.
- Too many nested `if` statements can make the code difficult to read.

---

# Advantages

- Helps check multiple dependent conditions.
- Improves decision-making in complex programs.
- Easy to understand for small logical checks.

---

# Disadvantages

- Deep nesting reduces code readability.
- Difficult to maintain if there are many nested levels.

---

# Common Mistake

### Incorrect

```java
if (age >= 18)
    if (hasLicense)
        System.out.println("Eligible");
else
    System.out.println("Not Eligible");
```

❌ This can lead to the **Dangling Else Problem**, where it may be unclear which `if` the `else` belongs to.

### Correct

```java
if (age >= 18) {

    if (hasLicense) {
        System.out.println("Eligible");
    }

} else {
    System.out.println("Not Eligible");
}
```

Using braces `{}` improves readability and avoids confusion.

---

# Interview Questions

### 1. What is a Nested If statement?

**Answer:** A Nested If statement is an `if` statement placed inside another `if` statement.

---

### 2. When is the inner `if` statement executed?

**Answer:** It executes only when the outer `if` condition is true.

---

### 3. Can we write multiple Nested If statements?

**Answer:** Yes, but excessive nesting should be avoided because it reduces code readability.

---

### 4. What is the Dangling Else Problem?

**Answer:** It is a situation where it becomes unclear which `if` statement an `else` belongs to. Using braces `{}` avoids this problem.

---

# Summary

A Nested If statement allows one `if` statement to be placed inside another. It is useful when multiple dependent conditions need to be checked before executing a block of code. Proper use of braces makes Nested If statements easier to read and maintain.

---

## Related Topics

- If Statement
- If-Else Statement
- Switch Statement
- Logical Operators

