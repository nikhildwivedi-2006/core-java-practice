# Variables in Java

## Introduction

A variable is a named memory location used to store data that can be accessed and modified during program execution.

A variable is like a container which is used to store the values or data

In Java, every variable must be declared with a specific data type before it can be used. The data type determines the type of value the variable can store.

Example:

```java
int age = 20;
```

Here:

- `int` → Data Type
- `age` → Variable Name
- `20` → Value

---

# Why Do We Need Variables?

Variables allow us to:

- Store data temporarily
- Perform calculations
- Reuse values
- Improve code readability
- Build dynamic applications

Without variables, every value would have to be written manually throughout the program.

---

# Syntax

```java
dataType variableName = value;
```

Example:

```java
String name = "Nikhil";
int age = 20;
double salary = 55000.75;
```

---

# Types of Variables in Java

Java provides four types of variables:

1. Local Variable
2. Instance Variable
3. Static Variable

---

# 1. Local Variable

A local variable is declared inside a method, constructor, or block.

Its scope is limited to that block only.

A local variable is available only inside the block where it is declared. Once the execution of that block is completed, the variable is destroyed and cannot be accessed anymore.

Example:

```java
public class LocalExample {

    public static void main(String[] args) {

        int marks = 90; //local variable

        System.out.println(marks);

    }

}
```

### Characteristics

- Created when the method starts.
- Destroyed when the method ends.
- Cannot be accessed outside the method.
- Must be initialized before use.

---

# 2. Instance Variable

An instance variable is declared inside a class but outside all methods.

Each object gets its own separate copy of an instance variable.

Example:

```java
public class Student {

    String name = "Nikhil";

}
```

### Characteristics

- Belongs to an object.
- Every object has its own value.
- Stored in Heap Memory.

---

# 3. Static Variable

A static variable belongs to the class instead of individual objects.

Only one copy of a static variable exists regardless of how many objects are created.

If all students belong to the same institute, we can declare the institute name as a static variable because every student shares the same value. Only one copy of the variable is created and shared among all objects.

Example:

```java
class Student {

    static String college = "IIT Kanpur";

}
```

### Characteristics

- Shared among all objects.
- Memory is allocated only once.
- Accessed using the class name.

Example:

```java
Student.college
```

---

# Scope of Variables

| Variable Type | Scope         |
| ------------- | ------------- |
| Local         | Inside Method |
| Instance      | Entire Object |
| Static        | Entire Class  |

---

# Naming Rules

A variable name:

- Can start with a letter, `_`, or `$`
- Cannot start with a number
- Cannot contain spaces
- Cannot use Java keywords
- Should follow camelCase naming convention

Valid Examples:

```java
studentName
totalMarks
employeeSalary
```

Invalid Examples:

```java
1age
class
student name
int
for
```

---

# Best Practices

✔ Use meaningful variable names.

✔ Follow camelCase naming.

✔ Keep variable scope as small as possible.

✔ Initialize variables before using them.

✔ Avoid single-letter names except in loops.

---

# Real-Life Example

Suppose you are building an ATM application.

```java
String accountHolder = "Nikhil";
double balance = 15000.50;
boolean isActive = true;
```

Here,

- `accountHolder` stores the customer's name.
- `balance` stores the account balance.
- `isActive` stores the account status.

Variables make the application dynamic by allowing values to change during execution.

---

# Interview Questions

### 1. What is a variable?

**Answer:** A variable is a named memory location used to store data.

---

### 2. How many types of variables are available in Java?

**Answer:** Three:

- Local
- Instance
- Static

---

### 3. Where is a local variable stored?

**Answer:** Stack Memory.

---

### 4. Where are instance variables stored?

**Answer:** Heap Memory.

---

### 5. Which variable is shared among all objects?

**Answer:** Static Variable.

---

### 6. Can a local variable be accessed outside a method?

**Answer:** No.

---

### 7. Which naming convention is recommended for variables?

**Answer:** camelCase.

---

# Summary

Variables are fundamental building blocks of Java programs. They provide a way to store and manipulate data efficiently. Java supports Local, Instance, Static, and Parameter variables, each having its own scope, lifetime, and purpose. Choosing meaningful variable names and understanding variable scope helps in writing clean, maintainable, and efficient code.
