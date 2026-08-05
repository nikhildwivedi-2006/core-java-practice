# For Loop in Java

## Introduction

The `for` loop is an entry-controlled loop used to execute a block of code repeatedly for a specific number of times.

It is commonly used when the number of iterations is known in advance.

---

# Why Do We Need the For Loop?

When a task needs to be repeated a fixed number of times, writing the same code repeatedly is inefficient.

The `for` loop provides a simple and organized way to perform repetitive tasks.

Examples:

- Print numbers from 1 to 10.
- Display multiplication tables.
- Traverse an array.
- Print patterns.

---

# Syntax

```java
for (initialization; condition; update) {

    // Code to be executed

}
```

### Components of a For Loop

### 1. Initialization

Executed only once before the loop starts.

Example:

```java
int i = 1;
```

---

### 2. Condition

Checked before every iteration.

If the condition is `true`, the loop executes.

If the condition is `false`, the loop terminates.

---

### 3. Update

Executed after every iteration.

Usually increments or decrements the loop variable.

Example:

```java
i++;
```

---

# Flow of Execution

```text
Initialization
      │
      ▼
 Check Condition
      │
 ┌────┴────┐
 │         │
True     False
 │         │
 ▼         ▼
Execute   Exit
 │
 ▼
Update
 │
 └────────────► Check Condition
```

---

# Example 1

```java
public class ForLoopExample {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

    }

}
```

### Output

```text
1
2
3
4
5
```

---

# Example 2

```java
public class ForLoopExample {

    public static void main(String[] args) {

        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }

    }

}
```

### Output

```text
5
4
3
2
1
```

---

# Infinite For Loop

If the condition is omitted or always remains `true`, the loop runs forever.

Example:

```java
for (;;) {

    System.out.println("Infinite Loop");

}
```

Use it carefully because it never terminates unless a `break` statement is used.

---

# Key Points

- The `for` loop is an entry-controlled loop.
- It is best suited when the number of iterations is known.
- Initialization executes only once.
- The condition is checked before every iteration.
- The update statement executes after each iteration.

---

# Advantages

- Easy to read and write.
- Reduces code repetition.
- Ideal for fixed iterations.
- Widely used in arrays and algorithms.

---

# When to Use the For Loop?

Use a `for` loop when:

- The number of iterations is known.
- Printing numbers or patterns.
- Traversing arrays.
- Implementing algorithms.

---

# Common Mistakes

### Infinite Loop

```java
for (int i = 1; i <= 5;) {

    System.out.println(i);

}
```

❌ The update statement is missing, so the loop never ends.

### Correct

```java
for (int i = 1; i <= 5; i++) {

    System.out.println(i);

}
```

---

## Note

A `for` loop can be placed inside another `for` loop. This is called a **Nested For Loop**.

Nested loops are commonly used for:

- Pattern printing
- Matrix operations
- Multi-dimensional arrays

This topic will be covered in detail with Arrays.

---

# Interview Questions

### 1. What is a for loop?

**Answer:** A for loop is an entry-controlled loop used to execute a block of code repeatedly for a fixed number of iterations.

---

### 2. How many parts does a for loop contain?

**Answer:** Three parts:

- Initialization
- Condition
- Update

---

### 3. When is the initialization executed?

**Answer:** Only once, before the loop starts.

---

### 4. Can we create an infinite for loop?

**Answer:** Yes.

Example:

```java
for (;;) {

}
```

---

### 5. When should we use a for loop?

**Answer:** When the number of iterations is known beforehand.

---

# Summary

The `for` loop is an entry-controlled loop that is best suited for executing a block of code a fixed number of times. It combines initialization, condition checking, and update in a single statement, making the code concise and easy to understand.

---

## Related Topics

- While Loop
- Do-While Loop
- Enhanced For Loop
- Arrays
