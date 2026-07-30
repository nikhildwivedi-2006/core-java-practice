# Data Types in Java

## Introduction

A data type specifies the type of data that a variable can store. Java is a **statically typed** programming language, which means every variable must have a declared data type before it is used.

Data types help the compiler allocate memory efficiently and perform type checking during compilation.

---

# Types of Data Types

Java data types are divided into two categories:

1. Primitive Data Types
2. Non-Primitive (Reference) Data Types

```text
                Data Types
                    │
        ┌───────────┴───────────┐
        │                       │
 Primitive Data Types   Non-Primitive Data Types
        │                       │
 byte, short, int...     String, Array, Class...
```

---

# Primitive Data Types

Primitive data types are predefined by Java and store simple values.

| Data Type | Size            | Default Value | Example     |
| --------- | --------------- | ------------- | ----------- |
| byte      | 1 byte          | 0             | 100         |
| short     | 2 bytes         | 0             | 25000       |
| int       | 4 bytes         | 0             | 100000      |
| long      | 8 bytes         | 0L            | 9876543210L |
| float     | 4 bytes         | 0.0f          | 12.5f       |
| double    | 8 bytes         | 0.0           | 12.56789    |
| char      | 2 bytes         | '\u0000'      | 'A'         |
| boolean   | 1 bit (logical) | false         | true        |

---

# Non-Primitive Data Types

Non-primitive data types store references to objects rather than actual values.

Examples:

- String
- Array
- Class
- Interface
- Object

Example:

```java
String name = "Nikhil";
```

---

# Primitive vs Non-Primitive

| Primitive           | Non-Primitive                         |
| ------------------- | ------------------------------------- |
| Stores actual value | Stores reference                      |
| Fixed size          | Size varies                           |
| Faster              | Comparatively slower                  |
| Built into Java     | Created by programmer or Java library |

---

# Memory Representation

```text
Primitive Variable

int age = 20;

Stack
+------+
| 20   |
+------+

-------------------------

Reference Variable

String name = "Java";

Stack             Heap
+------+      +-----------+
| Ref  | ---> | "Java"    |
+------+      +-----------+
```

---

# Key Points

- Java has 8 primitive data types.
- Primitive data types store actual values.
- Non-primitive data types store object references.
- String is a non-primitive data type.

---

# Interview Questions

### 1. How many primitive data types are there in Java?

**Answer:** Eight.

### 2. Which data type is used to store decimal values?

**Answer:** `float` and `double`.

### 3. Which data type stores only true or false?

**Answer:** `boolean`.

### 4. Is String a primitive data type?

**Answer:** No, it is a non-primitive (reference) data type.

---

# Summary

Java data types define the type of values that variables can store. They are categorized into primitive and non-primitive data types. Choosing the appropriate data type improves memory usage, performance, and code readability.
