# Type Casting in Java

## Introduction

Type Casting is the process of manually converting a value from one data type to another. It is required when converting a larger data type into a smaller compatible data type.

Type Casting is also known as **Explicit Type Conversion** or **Narrowing Conversion** because it is performed explicitly by the programmer.

---

# Why Do We Need Type Casting?

Sometimes, we need to store the value of a larger data type into a smaller data type.

For example:

- Converting `double` to `int`
- Converting `long` to `short`

Since this conversion may cause data loss, Java does not perform it automatically. The programmer must explicitly specify the target data type.

---

# Syntax

```java
smallerDataType variable = (smallerDataType) largerDataTypeVariable;
```

Example:

```java
double price = 99.99;
int amount = (int) price;
```

---

# How Type Casting Works

```text
double
   ↓
float
   ↓
long
   ↓
int
   ↓
short
   ↓
byte
```

Java converts data manually from a larger data type to a smaller data type.

---

# Example 1

```java
public class TypeCastingExample {

    public static void main(String[] args) {

        double price = 99.99;

        int amount = (int) price;

        System.out.println("Price  : " + price);
        System.out.println("Amount : " + amount);

    }

}
```

### Output

```text
Price  : 99.99
Amount : 99
```

**Explanation:**  
The decimal part (`.99`) is removed because an `int` can store only whole numbers.

---

# Example 2

```java
public class TypeCastingExample {

    public static void main(String[] args) {

        long population = 1400000000L;

        int value = (int) population;

        System.out.println("Population : " + population);
        System.out.println("Value      : " + value);

    }

}
```

> **Note:** If the value exceeds the range of the target data type, unexpected results may occur.

---

# Rules of Type Casting

- Type Casting is performed manually.
- Explicit casting syntax is required.
- It converts a larger data type into a smaller compatible data type.
- Data loss may occur during conversion.
- The programmer is responsible for the conversion.

---

# Advantages

- Allows conversion between compatible data types.
- Gives more control to the programmer.
- Useful when a specific data type is required.

---

# Disadvantages

- Data loss may occur.
- Precision may be lost.
- Incorrect casting can produce unexpected results.

---

# Type Conversion vs Type Casting

| Type Conversion       | Type Casting              |
| --------------------- | ------------------------- |
| Automatic             | Manual                    |
| Performed by Compiler | Performed by Programmer   |
| Widening Conversion   | Narrowing Conversion      |
| No Data Loss          | Data Loss May Occur       |
| No Casting Required   | Casting Operator Required |

---

# Interview Questions

### 1. What is Type Casting?

**Answer:** Type Casting is the manual conversion of a larger data type into a smaller compatible data type using the casting operator.

---

### 2. Why is Type Casting called Explicit Conversion?

**Answer:** Because the programmer explicitly specifies the target data type using the casting operator.

---

### 3. Can Type Casting cause data loss?

**Answer:** Yes. When converting from a larger data type to a smaller data type, precision or value may be lost.

---

### 4. Give one example of Type Casting.

```java
double price = 99.99;
int amount = (int) price;
```

---

### 5. What is another name for Type Casting?

**Answer:** Explicit Conversion or Narrowing Conversion.

---

# Summary

Type Casting is the manual conversion of a larger data type into a smaller compatible data type. It requires the use of the casting operator and may result in data loss. Therefore, it should be used carefully whenever narrowing conversion is required.

---

## Related Topics

- Data Types
- Variables
- Type Conversion
- Operators
