# Two-Dimensional Arrays in Java

## Introduction

A Two-Dimensional (2D) Array is an array of arrays.

It is used to store data in the form of rows and columns, similar to a table or matrix.

---

# Why Do We Need a Two-Dimensional Array?

A 2D array is useful when data is naturally arranged in rows and columns.

Examples:

- Student marks
- Matrix operations
- Chess board
- Seating arrangement

---

# Syntax

```java
dataType[][] arrayName = new dataType[rows][columns];
```

Example:

```java
int[][] marks = new int[3][4];
```

This creates an array with **3 rows** and **4 columns**.

---

# Initialization

```java
int[][] marks = {
    {80, 75, 90},
    {65, 70, 85},
    {95, 88, 91}
};
```

---

# Accessing Elements

```java
System.out.println(marks[0][0]);
System.out.println(marks[2][1]);
```

### Output

```text
80
88
```

---

# Traversing a Two-Dimensional Array

```java
for (int i = 0; i < marks.length; i++) {

    for (int j = 0; j < marks[i].length; j++) {

        System.out.print(marks[i][j] + " ");

    }

    System.out.println();

}
```

---

# Advantages

- Stores data in rows and columns.
- Suitable for matrix operations.
- Easy to represent tabular data.

---

# Limitations

- Fixed number of rows and columns.
- Can consume more memory for large datasets.

---

# Interview Questions

### 1. What is a Two-Dimensional Array?

**Answer:** A Two-Dimensional Array is an array whose elements are themselves arrays.

---

### 2. Where is a 2D array commonly used?

**Answer:** Matrix operations, tables, seating arrangements, and game boards.

---

### 3. How do we access an element in a 2D array?

**Answer:** Using row and column indexes.

Example:

```java
marks[1][2]
```

---

# Summary

A Two-Dimensional Array stores data in rows and columns. It is useful for representing matrices and other tabular data in Java.

---

## Related Topics

- Arrays
- Jagged Arrays
- Enhanced For Loop
