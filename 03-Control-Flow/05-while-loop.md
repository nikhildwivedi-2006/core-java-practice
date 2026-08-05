# While Loop in Java

## Introduction

The `while` loop is an entry-controlled loop used to execute a block of code repeatedly as long as a specified condition is **true**.

The condition is checked **before** the execution of the loop body.

---

# Why Do We Need While Loop?

Sometimes we need to execute the same block of code multiple times.

Instead of writing the same statements repeatedly, we use loops.

Examples:

- Print numbers from 1 to 10.
- Read user input until a valid value is entered.
- Display menu options repeatedly.
- Perform repetitive tasks.

---

# Syntax

```java
while (condition) {

    // Code to be executed

}
```

The loop continues until the condition becomes **false**.

---

# When to Use While Loop?

Use a `while` loop when:

- The number of iterations is unknown.
- The loop depends on a condition.
- The condition should be checked before execution.

Examples:

- Reading user input until valid data is entered.
- Menu-driven programs.
- Login validation.

---

# Flow of Execution

```text
        Condition
            │
      ┌─────┴─────┐
      │           │
    True       False
      │           │
Execute Code     Exit
      │
      └──────┐
             │
      Check Condition Again
```

---

# Example 1

```java
public class WhileLoopExample {

    public static void main(String[] args) {

        int i = 1;

        while (i <= 5) {

            System.out.println(i);
            i++;

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
public class WhileLoopExample {

    public static void main(String[] args) {

        int number = 5;

        while (number >= 1) {

            System.out.println(number);
            number--;

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

# Key Points

- The condition is checked before the loop starts.
- If the condition is false initially, the loop body will not execute even once.
- Suitable when the number of iterations is not known in advance.

---

# Advantages

- Reduces code repetition.
- Easy to understand.
- Useful when the number of iterations is unknown.
- Improves code readability.

---

# Common Mistakes

### Infinite Loop

```java
int i = 1;

while (i <= 5) {

    System.out.println(i);

}
```

❌ The value of `i` is never updated, so the condition always remains true.

### Correct

```java
int i = 1;

while (i <= 5) {

    System.out.println(i);
    i++;

}
```

---

# Interview Questions

### 1. What is a while loop?

**Answer:** A while loop is an entry-controlled loop that executes a block of code repeatedly while the given condition is true.

---

### 2. When is the condition checked?

**Answer:** Before executing the loop body.

---

### 3. Can a while loop execute zero times?

**Answer:** Yes. If the condition is false initially, the loop body will not execute.

---

### 4. What causes an infinite loop?

**Answer:** When the loop condition never becomes false.

---

# Summary

The while loop is an entry-controlled loop that repeatedly executes a block of code while a condition remains true. It is commonly used when the number of iterations is not known beforehand.

---

## Related Topics

- Do-While Loop
- For Loop
- Enhanced For Loop
