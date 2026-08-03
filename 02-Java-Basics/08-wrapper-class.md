# Wrapper Classes in Java

## Introduction

Wrapper Classes are classes that convert primitive data types into objects.

In Java, every primitive data type has a corresponding Wrapper Class.

Wrapper Classes are available in the `java.lang` package.

---

# Why Do We Need Wrapper Classes?

Primitive data types are not objects.

However, some Java features such as the Collections Framework work only with objects.

Wrapper Classes allow primitive values to be used as objects.

---

# Primitive Data Types and Wrapper Classes

| Primitive Data Type | Wrapper Class |
| ------------------- | ------------- |
| byte                | Byte          |
| short               | Short         |
| int                 | Integer       |
| long                | Long          |
| float               | Float         |
| double              | Double        |
| char                | Character     |
| boolean             | Boolean       |

---

# Creating Wrapper Objects

### Example 1

```java
Integer number = Integer.valueOf(100);

System.out.println(number);
```

Output:

```text
100
```

---

### Example 2

```java
Double price = Double.valueOf(99.99);

System.out.println(price);
```

Output:

```text
99.99
```

---

# Autoboxing

Autoboxing is the automatic conversion of a primitive data type into its corresponding Wrapper Class object.

Example:

```java
int number = 100;

Integer value = number;
```

Here, Java automatically converts the `int` value into an `Integer` object.

---

# Unboxing

Unboxing is the automatic conversion of a Wrapper Class object into its corresponding primitive data type.

Example:

```java
Integer value = 100;

int number = value;
```

Here, Java automatically converts the `Integer` object into an `int` value.

---

# Advantages of Wrapper Classes

- Allows primitive values to be treated as objects.
- Required while working with Collections.
- Provides useful utility methods.
- Supports Autoboxing and Unboxing.

---

# Interview Questions

### 1. What is a Wrapper Class?

**Answer:** A Wrapper Class is a class that converts a primitive data type into an object.

---

### 2. Which package contains Wrapper Classes?

**Answer:** `java.lang`

---

### 3. What is Autoboxing?

**Answer:** Automatic conversion of a primitive data type into its corresponding Wrapper Class object.

---

### 4. What is Unboxing?

**Answer:** Automatic conversion of a Wrapper Class object into its corresponding primitive data type.

---

### 5. Why do we use Wrapper Classes?

**Answer:** They allow primitive values to be used as objects and are required in features like the Collections Framework.

---

# Summary

Wrapper Classes provide object representations of primitive data types. They make it possible to use primitive values in object-oriented features of Java and support automatic conversion through Autoboxing and Unboxing.

---

## Related Topics

- Data Types
- Type Conversion
- Type Casting
- String Class
- Collections Framework
