# Passing Array to a Method in Java

## Introduction

An array in Java is an **object**.

When an array is passed to a method, the **value of the array reference is passed by value**.

Therefore, the method receives a copy of the reference that points to the same array object.

---

# Basic Example

```java
class ArrayExample {

    static void display(int[] numbers) {

        for (int number : numbers) {
            System.out.println(number);
        }

    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40};

        display(numbers);

    }
}
```

The array reference is passed to the method.

---

# Modifying an Array Inside a Method

Because the copied reference points to the same array object, changes made to array elements are visible outside the method.

Example:

```java
class ArrayExample {

    static void changeArray(int[] numbers) {

        numbers[0] = 100;

    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        changeArray(numbers);

        System.out.println(numbers[0]);

    }
}
```

### Output

```text
100
```

The original array is modified.

---

# Why Does This Happen?

Consider:

```java
int[] numbers = {10, 20, 30};
```

The variable `numbers` stores a reference to the array object.

When we call:

```java
changeArray(numbers);
```

Java passes a copy of that reference.

Both references point to the same array.

```text
Stack

main()
numbers ─────────┐
                 │
changeArray()    │
numbers ─────────┘
                 │
                 ▼

Heap

Array Object
[10, 20, 30]
```

Therefore:

```java
numbers[0] = 100;
```

changes the same array object.

---

# Reassigning the Array Reference

Changing an array element and reassigning the array reference are different.

Example:

```java
class ArrayExample {

    static void changeArray(int[] numbers) {

        numbers = new int[]{100, 200, 300};

    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        changeArray(numbers);

        System.out.println(numbers[0]);

    }
}
```

### Output

```text
10
```

Why?

The method receives a copy of the reference.

When we write:

```java
numbers = new int[]{100, 200, 300};
```

only the local copy of the reference is changed.

The original reference in `main()` still points to the original array.

---

# Important Difference

### Modifying Array Elements

```java
numbers[0] = 100;
```

✅ Original array is affected.

### Reassigning Array Reference

```java
numbers = new int[]{100, 200, 300};
```

❌ Original reference is not changed.

---

# Complete Example

```java
public class PassingArrayExample {

    static void modifyArray(int[] numbers) {

        numbers[0] = 100;

    }

    static void reassignArray(int[] numbers) {

        numbers = new int[]{500, 600, 700};

    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        modifyArray(numbers);

        System.out.println("After modification: " + numbers[0]);

        reassignArray(numbers);

        System.out.println("After reassignment: " + numbers[0]);

    }
}
```

### Output

```text
After modification: 100
After reassignment: 100
```

---

# Key Concept

Remember:

```text
Java
  │
  └── Always Pass-by-Value
            │
            ▼
      Array Reference
            │
            ▼
    Reference value copied
            │
            ▼
      Same Array Object
```

So:

```java
numbers[0] = 100;
```

changes the shared array object.

But:

```java
numbers = new int[]{1, 2, 3};
```

only changes the local reference.

---

# Array vs Primitive Argument Passing

| Primitive                                             | Array                                                  |
| ----------------------------------------------------- | ------------------------------------------------------ |
| Value is passed by value.                             | Reference value is passed by value.                    |
| Copy contains the actual primitive value.             | Copy contains the reference value.                     |
| Changing parameter does not affect original variable. | Changing array elements affects the same array object. |
| Example: `int`, `double`                              | Example: `int[]`, `String[]`                           |

---

# Common Mistake

❌ Incorrect:

> Arrays are passed by reference in Java.

✅ Correct:

> Arrays are objects in Java, and the value of their reference is passed by value.

---

# Best Practice

When explaining arrays in an interview, remember:

> **"Java passes the array reference by value. Both the original and copied reference can point to the same array object."**

---

# Interview Questions

### 1. Is an array an object in Java?

**Answer:** Yes. Arrays are objects in Java.

### 2. How is an array passed to a method?

**Answer:** The value of the array reference is passed by value.

### 3. Can a method modify the original array?

**Answer:** Yes. It can modify array elements because the copied reference points to the same array object.

### 4. Does reassigning the array parameter change the original array reference?

**Answer:** No. Reassignment only changes the local copy of the reference.

### 5. Is Java pass-by-reference for arrays?

**Answer:** No. Java is always pass-by-value. The value of the array reference is copied.

---

# Summary

Arrays are objects in Java. When an array is passed to a method, Java passes the value of its reference by value. Therefore, modifying array elements affects the original array, while reassigning the array reference inside the method does not affect the original reference.

---

## Related Topics

- Arrays
- Class and Object
- Reference Variables
- Argument Passing
- Pass-by-Value
