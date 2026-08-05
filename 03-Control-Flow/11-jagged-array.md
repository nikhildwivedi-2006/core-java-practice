# Jagged Array in Java

## Introduction

A Jagged Array is a two-dimensional array in which each row can have a different number of columns.

Unlike a regular two-dimensional array, all rows are **not required** to have the same length.

---

# Why Do We Need a Jagged Array?

A Jagged Array is useful when different rows require different numbers of elements.

Examples:

- Student marks with different numbers of subjects.
- Monthly sales where some months have different records.
- Variable-length datasets.

---

# Syntax

```java
dataType[][] arrayName = new dataType[rows][];
```

Example:

```java
int[][] numbers = new int[3][];
```

Each row is created separately.

---

# Initialization

```java
int[][] numbers = new int[3][];

numbers[0] = new int[]{10, 20};
numbers[1] = new int[]{30, 40, 50};
numbers[2] = new int[]{60};
```

---

# Traversing a Jagged Array

```java
for (int i = 0; i < numbers.length; i++) {

    for (int j = 0; j < numbers[i].length; j++) {

        System.out.print(numbers[i][j] + " ");

    }

    System.out.println();

}
```

---

# Output

```text
10 20
30 40 50
60
```

---

# Difference Between 2D Array and Jagged Array

| Two-Dimensional Array                     | Jagged Array                                     |
| ----------------------------------------- | ------------------------------------------------ |
| Every row has the same number of columns. | Each row can have a different number of columns. |
| Fixed structure.                          | Flexible structure.                              |

---

# Advantages

- Efficient memory usage.
- Flexible row sizes.
- Suitable for irregular data.

---

# Limitations

- Slightly more complex than a normal 2D array.
- Requires separate initialization for each row.

---

# Interview Questions

### 1. What is a Jagged Array?

**Answer:** A Jagged Array is a two-dimensional array where each row can have a different number of columns.

---

### 2. Is every row in a Jagged Array required to have the same length?

**Answer:** No.

---

### 3. When should we use a Jagged Array?

**Answer:** When different rows require different numbers of elements.

---

# Summary

A Jagged Array is a flexible form of a two-dimensional array where each row can have a different size. It is useful when working with irregular or variable-length data.

---

## Related Topics

- Arrays
- Two-Dimensional Arrays
