# Arrays in Java

## Introduction

An **Array** is a collection of elements of the same data type stored in contiguous memory locations.

Each element in an array is accessed using its **index**, and indexing starts from **0**.

Arrays are used to store multiple values in a single variable instead of creating separate variables for each value.

---

# Why Do We Need Arrays?

Without arrays, we need separate variables to store multiple values.

Example:

```java
int mark1 = 80;
int mark2 = 75;
int mark3 = 90;
int mark4 = 88;
int mark5 = 92;
```

Using an array:

```java
int[] marks = {80, 75, 90, 88, 92};
```

Arrays make the code cleaner, easier to manage, and more efficient.

---

# Features of Arrays

- Stores multiple values of the same data type.
- Elements are stored using indexes.
- Indexing starts from **0**.
- The size of an array is fixed after creation.
- Arrays can store primitive data types as well as objects.

---

# Declaration of an Array

```java
int[] numbers;
```

or

```java
int numbers[];
```

Both declarations are valid, but `int[] numbers` is the recommended style.

---

# Creating an Array

```java
int[] numbers = new int[5];
```

This creates an array of size **5**.

---

# Array Initialization

### Method 1

```java
int[] numbers = new int[5];

numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;
```

---

### Method 2

```java
int[] numbers = {10, 20, 30, 40, 50};
```

---

# Accessing Array Elements

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[0]);
System.out.println(numbers[1]);
System.out.println(numbers[2]);
```

### Output

```text
10
20
30
```

---

# Array Index

Every element in an array has an index.

Example:

```text
Index :   0    1    2    3    4
Value :  10   20   30   40   50
```

---

# Array Length

The length of an array can be obtained using the `length` property.

```java
int[] numbers = {10, 20, 30, 40};

System.out.println(numbers.length);
```

### Output

```text
4
```

---

# Traversing an Array

### Using For Loop

```java
int[] numbers = {10, 20, 30};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

---

### Using Enhanced For Loop

```java
for (int number : numbers) {
    System.out.println(number);
}
```

---

# Advantages

- Easy to store multiple values.
- Fast access using indexes.
- Reduces code repetition.
- Forms the foundation of many data structures.

---

# Limitations

- Fixed size after creation.
- Can store only one type of data.
- Insertion and deletion are not efficient.

---

# Common Mistakes

### Accessing an Invalid Index

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

❌ This throws an `ArrayIndexOutOfBoundsException`.

---

### Correct

```java
System.out.println(numbers[2]);
```

---

# Interview Questions

### 1. What is an array?

**Answer:** An array is a collection of elements of the same data type stored in contiguous memory locations.

---

### 2. What is the default index of the first element?

**Answer:** `0`

---

### 3. Can the size of an array be changed after creation?

**Answer:** No. The size of an array is fixed.

---

### 4. How do we find the length of an array?

**Answer:** Using the `length` property.

Example:

```java
numbers.length
```

---

### 5. Can an array store different data types?

**Answer:** No. An array stores elements of the same data type.

---

# Summary

An array is a fixed-size collection of elements of the same data type. It provides fast access using indexes and is widely used in Java programming and Data Structures.

---

## Related Topics

- Enhanced For Loop
- Two-Dimensional Arrays
- Jagged Arrays
- Collections Framework
