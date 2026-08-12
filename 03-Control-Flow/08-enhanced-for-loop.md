# Enhanced For Loop in Java

## Introduction

The Enhanced For Loop, also known as the **For-Each Loop**, is used to iterate through elements of an array or a collection.

It simplifies the traversal process by eliminating the need for an index variable.

The Enhanced For Loop was introduced in **Java 5**.

---

# Why Do We Need the Enhanced For Loop?

When we only need to access each element of an array or collection without using its index, the Enhanced For Loop provides a simpler and cleaner approach.

Examples:

- Printing all elements of an array.
- Reading values from a collection.
- Traversing a list of objects.

---

# Syntax

```java
for (dataType variable : array) {

    // Code to be executed

}
```

### Components

- **dataType** → Type of the array elements.
- **variable** → Stores the current element.
- **array** → Array or collection being traversed.

---

# Flow of Execution

```text
Array
 │
 ▼
First Element
 │
 ▼
Execute Code
 │
 ▼
Next Element
 │
 ▼
Execute Code
 │
 ▼
Continue until all elements are visited
```

---

# Example 1

```java
public class EnhancedForLoopExample {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        for (int number : numbers) {
            System.out.println(number);
        }

    }

}
```

### Output

```text
10
20
30
40
50
```

---

# Example 2

```java
public class EnhancedForLoopExample {

    public static void main(String[] args) {

        String[] names = {"Nikhil", "Rahul", "Aman"};

        for (String name : names) {
            System.out.println(name);
        }

    }

}
```

### Output

```text
Nikhil
Rahul
Aman
```

---

# Advantages

- Simple and easy to read.
- No need for an index variable.
- Reduces the chances of index-related errors.
- Ideal for traversing arrays and collections.

---

# Limitations

- Cannot directly access the index of an element.
- Cannot traverse the array in reverse order.
- Not suitable when elements need to be modified using their index.

---

# Difference Between For Loop and Enhanced For Loop

| For Loop                                      | Enhanced For Loop                    |
| --------------------------------------------- | ------------------------------------ |
| Uses an index variable.                       | Does not use an index variable.      |
| Can access elements using their index.        | Accesses elements directly.          |
| Suitable when index manipulation is required. | Suitable when only reading elements. |
| Can traverse in forward or reverse order.     | Traverses only in forward direction. |

---

# When to Use the Enhanced For Loop?

Use the Enhanced For Loop when:

- You only need to read elements.
- Index values are not required.
- Traversing arrays or collections.

---

# Interview Questions

### 1. What is an Enhanced For Loop?

**Answer:** It is a loop used to iterate through arrays or collections without using an index variable.

---

### 2. When was the Enhanced For Loop introduced?

**Answer:** Java 5.

---

### 3. Can we access the index in an Enhanced For Loop?

**Answer:** No.

---

### 4. Can we traverse an array in reverse using an Enhanced For Loop?

**Answer:** No.

---

### 5. Where is the Enhanced For Loop commonly used?

**Answer:** Arrays and Collections.

---

# Summary

The Enhanced For Loop provides a simple and readable way to traverse arrays and collections. It is best suited when only the elements need to be accessed and index values are not required.

---

## Related Topics

- For Loop
- Arrays
- Collections Framework

