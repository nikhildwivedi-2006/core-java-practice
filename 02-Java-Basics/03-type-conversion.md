# Type Conversion in Java

## Introduction

Type Conversion is the process of automatically converting a value from one data type to another compatible data type. It is performed by the Java compiler whenever there is no risk of data loss.

Type Conversion is also known as **Implicit Type Conversion** or **Widening Conversion**.

---

# Why Do We Need Type Conversion?

In Java, different variables can have different data types. Sometimes, we need to store the value of a smaller data type into a larger data type.

For example:

- Storing an `int` value into a `long`
- Storing a `float` value into a `double`

Instead of manually converting the value, Java performs the conversion automatically.

---

# Syntax

```java
largerDataType variable = smallerDataTypeVariable;
```

Example:

```java
int number = 100;
long value = number;
```

Here, the `int` value is automatically converted into a `long`.

---

# How Type Conversion Works

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

Java automatically converts data only from a smaller type to a larger compatible type.

---

# Example 1

```java
public class TypeConversionExample {

    public static void main(String[] args) {

        int number = 100;

        long value = number;

        System.out.println("Integer Value : " + number);
        System.out.println("Long Value    : " + value);

    }

}
```

### Output

```text
Integer Value : 100
Long Value    : 100
```

---

# Example 2

```java
public class TypeConversionExample {

    public static void main(String[] args) {

        float marks = 89.5f;

        double result = marks;

        System.out.println("Marks  : " + marks);
        System.out.println("Result : " + result);

    }

}
```

### Output

```text
Marks  : 89.5
Result : 89.5
```

---

# Rules of Type Conversion

- Conversion is performed automatically by Java.
- It happens only between compatible data types.
- Data is converted from a smaller type to a larger type.
- There is no explicit casting required.
- No data loss occurs during widening conversion.

---

# Advantages

- No manual conversion required.
- Prevents unnecessary code.
- Safe conversion without data loss.
- Improves code readability.

---

# Type Conversion vs Type Casting

| Type Conversion       | Type Casting            |
| --------------------- | ----------------------- |
| Automatic             | Manual                  |
| Performed by Compiler | Performed by Programmer |
| No Data Loss          | Data Loss May Occur     |
| Widening Conversion   | Narrowing Conversion    |

---

# Interview Questions

### 1. What is Type Conversion?

**Answer:** Type Conversion is the automatic conversion of a smaller data type into a larger compatible data type.

---

### 2. Is Type Conversion automatic or manual?

**Answer:** Automatic.

---

### 3. Is another name for Type Conversion?

**Answer:** Implicit Conversion or Widening Conversion.

---

### 4. Does Type Conversion cause data loss?

**Answer:** No.

---

### 5. Give one example of Type Conversion.

```java
int number = 100;
long value = number;
```

---

# Summary

Type Conversion is the automatic conversion of one data type to another compatible data type. It is performed by the Java compiler without requiring explicit casting. Since the conversion occurs from a smaller data type to a larger data type, there is no loss of data.
