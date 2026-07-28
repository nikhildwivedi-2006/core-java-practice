# First Java Program

## Introduction

A Java program is a collection of classes and methods. Every Java application starts its execution from the **main()** method.

The first program written by most Java developers is the **Hello World** program, which is used to understand the basic structure of a Java program.

---

# Hello World Program

```java
public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello, World!");

    }

}
```

---

# Explanation of the Program

## 1. public

The **public** keyword is an access modifier.

It makes the class or method accessible from anywhere in the program.

---

## 2. class

A **class** is a blueprint used to create objects.

Every Java program must contain at least one class.

Example:

```java
public class HelloWorld
```

Here, **HelloWorld** is the class name.

---

## 3. static

The **static** keyword means the method belongs to the class rather than an object.

Because the **main()** method is static, the JVM can call it directly without creating an object.

---

## 4. void

The **void** keyword indicates that the method does not return any value.

---

## 5. main()

The **main()** method is the entry point of every Java application.

The JVM starts executing the program from this method.

Syntax:

```java
public static void main(String[] args)
```

---

## 6. String[] args

**String[] args** stores command-line arguments passed to the Java program.

If no arguments are passed, it remains an empty array.

Example:

```bash
java HelloWorld Nikhil
```

Then:

```java
args[0] = "Nikhil"
```

---

## 7. System

**System** is a predefined Java class.

It provides access to system resources such as standard input, standard output, and error output.

---

## 8. out

**out** is a static object of the `PrintStream` class.

It is used to display output on the console.

---

## 9. println()

The **println()** method prints the specified message and moves the cursor to the next line.

Example:

```java
System.out.println("Hello");
System.out.println("Java");
```

Output:

```text
Hello
Java
```

---

# Program Execution

1. Write the Java program in a `.java` file.
2. Save the file with the same name as the public class.
3. Compile the program using the Java compiler (`javac`).
4. The compiler generates a `.class` file (Bytecode).
5. The JVM executes the bytecode.
6. The output is displayed on the console.

---

# Output

```text
Hello, World!
```

---

# Important Points

- Every Java program starts from the `main()` method.
- The file name should match the public class name.
- Java is case-sensitive.
- The JVM calls the `main()` method automatically.
- `System.out.println()` is used to print output.

---

# Interview Questions

### 1. Which method is the entry point of a Java program?

**Answer:** `public static void main(String[] args)`

---

### 2. Why is the `main()` method static?

**Answer:** Because the JVM calls it directly without creating an object of the class.

---

### 3. Why is the `main()` method public?

**Answer:** So that the JVM can access it from anywhere and start program execution.

---

### 4. What is the purpose of the `void` keyword?

**Answer:** It indicates that the method does not return any value.

---

### 5. What is `String[] args`?

**Answer:** It is an array of strings that stores command-line arguments passed to the program.

---

### 6. What is `System.out.println()`?

**Answer:** It is used to print output on the console and move the cursor to the next line.

---

# Summary

Every Java program starts from the `main()` method. The JVM invokes this method automatically to begin execution. The `public`, `static`, and `void` keywords define how the method is accessed and executed, while `System.out.println()` is used to display output on the console.
