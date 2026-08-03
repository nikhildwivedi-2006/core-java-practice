# Scanner Class in Java

## Introduction

The Scanner class is used to take input from the user during program execution. It is a part of the `java.util` package and provides methods to read different types of input such as integers, floating-point numbers, characters, strings, and boolean values.

Before using the Scanner class, it must be imported into the program.

---

# Why Do We Need Scanner Class?

By default, Java programs use hardcoded values.

Example:

```java
int age = 20;
```

If we want the user to enter values at runtime, we use the Scanner class.

---

# Import Scanner Class

```java
import java.util.Scanner;
```

---

# Creating a Scanner Object

```java
Scanner sc = new Scanner(System.in);
```

Here:

- `Scanner` → Class Name
- `sc` → Object Name
- `System.in` → Standard input stream (keyboard)

---

# Common Methods of Scanner Class

| Method        | Description           | Example            |
| ------------- | --------------------- | ------------------ |
| nextInt()     | Reads an integer      | `sc.nextInt()`     |
| nextDouble()  | Reads a double value  | `sc.nextDouble()`  |
| nextFloat()   | Reads a float value   | `sc.nextFloat()`   |
| nextLong()    | Reads a long value    | `sc.nextLong()`    |
| nextBoolean() | Reads a boolean value | `sc.nextBoolean()` |
| next()        | Reads a single word   | `sc.next()`        |
| nextLine()    | Reads an entire line  | `sc.nextLine()`    |

---

# Example 1 : Integer Input

```java
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");

        int age = sc.nextInt();

        System.out.println("Age = " + age);

        sc.close();

    }

}
```

### Output

```text
Enter your age: 20
Age = 20
```

---

# Example 2 : String Input

```java
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = sc.nextLine();

        System.out.println("Welcome " + name);

        sc.close();

    }

}
```

### Output

```text
Enter your name: Nikhil
Welcome Nikhil
```

---

# Difference Between next() and nextLine()

| next()              | nextLine()                       |
| ------------------- | -------------------------------- |
| Reads only one word | Reads the complete line          |
| Stops at whitespace | Reads until Enter key is pressed |

Example Input:

```text
Nikhil Dwivedi
```

```java
String name = sc.next();
```

Output:

```text
Nikhil
```

```java
String name = sc.nextLine();
```

Output:

```text
Nikhil Dwivedi
```

---

## ⚠️ Important Note

### Using `nextInt()` Before `nextLine()`

When `nextInt()`, `nextDouble()`, or similar methods are used, they do **not** consume the newline character (`\n`) generated when the Enter key is pressed.

As a result, if `nextLine()` is called immediately after `nextInt()`, it reads the leftover newline instead of waiting for user input.

### Incorrect Example

```java
Scanner sc = new Scanner(System.in);

System.out.print("Enter your age: ");
int age = sc.nextInt();

System.out.print("Enter your name: ");
String name = sc.nextLine(); // Reads an empty string
```

### Correct Example

```java
Scanner sc = new Scanner(System.in);

System.out.print("Enter your age: ");
int age = sc.nextInt();

sc.nextLine(); // Consumes the leftover newline

System.out.print("Enter your name: ");
String name = sc.nextLine();

System.out.println("Age  : " + age);
System.out.println("Name : " + name);
```

### Why does this happen?

The `nextInt()` method reads only the integer value and leaves the newline character (`\n`) in the input buffer. The next call to `nextLine()` reads this leftover newline immediately, resulting in an empty string.

**Interview Tip:** Always call `sc.nextLine()` after `nextInt()`, `nextDouble()`, or similar methods if you want to read a complete line of text next.

---

# Closing the Scanner

After reading input, it is recommended to close the Scanner object.

```java
sc.close();
```

This releases the resources associated with the Scanner.

---

# Advantages

- Easy to use.
- Supports multiple data types.
- Simplifies user input.
- Suitable for console applications.

---

# Interview Questions

### 1. Which package contains the Scanner class?

**Answer:** `java.util`

---

### 2. Why do we use the Scanner class?

**Answer:** To take user input during program execution.

---

### 3. What is the difference between `next()` and `nextLine()`?

**Answer:** `next()` reads a single word, whereas `nextLine()` reads the entire line.

---

### 4. Why should we call `close()` on a Scanner object?

**Answer:** To release the resources associated with the Scanner.

---

# Summary

The Scanner class is used to read user input from the keyboard. It provides various methods to read different data types such as integers, floating-point numbers, strings, and boolean values. It is one of the most commonly used classes for console-based Java applications.

---

## Related Topics

- Variables
- Data Types
- Operators
- Control Flow Statements
