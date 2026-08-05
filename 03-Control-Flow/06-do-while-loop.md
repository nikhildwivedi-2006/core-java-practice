# Do-While Loop in Java

## Introduction

The `do-while` loop is an exit-controlled loop used to execute a block of code repeatedly.

Unlike the `while` loop, the condition is checked **after** executing the loop body. Therefore, the loop body executes **at least once**, even if the condition is false.

---

# Why Do We Need Do-While Loop?

The `do-while` loop is useful when a block of code must execute at least once before checking the condition.

Examples:

- Displaying a menu at least once.
- Taking user input at least once.
- Asking the user whether they want to continue.
- Menu-driven applications.

---

# Syntax

```java
do {

    // Code to be executed

} while (condition);
```

> **Note:** A semicolon (`;`) is mandatory after the `while(condition)`.

---

# Flow of Execution

```text
      Execute Code
            │
            ▼
       Check Condition
            │
      ┌─────┴─────┐
      │           │
    True       False
      │           │
      └─────► Exit
```

---

# Example 1

```java
public class DoWhileExample {

    public static void main(String[] args) {

        int i = 1;

        do {

            System.out.println(i);
            i++;

        } while (i <= 5);

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
public class DoWhileExample {

    public static void main(String[] args) {

        int number = 10;

        do {

            System.out.println(number);

        } while (number < 5);

    }

}
```

### Output

```text
10
```

Although the condition is false, the loop executes once because the condition is checked after the loop body.

---

# Key Points

- It is an **exit-controlled loop**.
- The loop body executes at least once.
- The condition is checked after execution.
- A semicolon (`;`) is required after the `while` statement.

---

# Advantages

- Guarantees at least one execution.
- Useful for menu-driven programs.
- Easy to understand and implement.

---

# Common Mistakes

### Missing Semicolon

```java
do {

    System.out.println("Java");

} while (true)
```

❌ This is invalid because the semicolon (`;`) is missing.

### Correct

```java
do {

    System.out.println("Java");

} while (true);
```

---

# While vs Do-While

| While Loop                         | Do-While Loop                     |
| ---------------------------------- | --------------------------------- |
| Entry-controlled loop              | Exit-controlled loop              |
| Condition checked before execution | Condition checked after execution |
| May execute zero times             | Executes at least one time        |

---

# When to Use Do-While Loop?

Use a `do-while` loop when:

- The loop body must execute at least once.
- The condition should be checked after execution.
- Building menu-driven or interactive programs.

---

# Interview Questions

### 1. What is a do-while loop?

**Answer:** A do-while loop is an exit-controlled loop in which the loop body executes before checking the condition.

---

### 2. What is the main difference between while and do-while?

**Answer:** The `while` loop checks the condition before execution, whereas the `do-while` loop checks it after execution.

---

### 3. Can a do-while loop execute when the condition is false?

**Answer:** Yes. It always executes at least once.

---

### 4. Why is a semicolon required after `while(condition)`?

**Answer:** It marks the end of the `do-while` statement.

---

# Summary

The do-while loop is an exit-controlled loop that executes the loop body first and checks the condition afterward. It is commonly used when the code must execute at least once regardless of the condition.

---

## Related Topics

- While Loop
- For Loop
- Enhanced For Loop
