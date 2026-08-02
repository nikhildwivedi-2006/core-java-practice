# Operators in Java

## Introduction

Operators are special symbols in Java that perform operations on one or more operands.

An operand can be a variable, value, or expression, while an operator performs a specific operation such as addition, comparison, or logical evaluation.

Example:

```java
int sum = 10 + 20;
```

Here:

- `10` and `20` are operands.
- `+` is the operator.

---

# Why Do We Need Operators?

Operators help us to:

- Perform mathematical calculations.
- Compare values.
- Make decisions.
- Combine multiple conditions.
- Assign values to variables.
- Manipulate bits.

---

# Types of Operators in Java

Java provides the following types of operators:

1. Arithmetic Operators
2. Unary Operators
3. Assignment Operators
4. Relational Operators
5. Logical Operators
6. Bitwise Operators
7. Shift Operators
8. Ternary Operator
9. instanceof Operator

---

# 1. Arithmetic Operators

Arithmetic operators are used to perform mathematical operations.

| Operator | Description    | Example |
| -------- | -------------- | ------- |
| +        | Addition       | a + b   |
| -        | Subtraction    | a - b   |
| \*       | Multiplication | a \* b  |
| /        | Division       | a / b   |
| %        | Modulus        | a % b   |

Example:

```java
int a = 20;
int b = 5;

System.out.println(a + b);
System.out.println(a - b);
System.out.println(a * b);
System.out.println(a / b);
System.out.println(a % b);
```

---

# 2. Unary Operators

Unary operators operate on a single operand.

| Operator | Description |
| -------- | ----------- |
| +        | Positive    |
| -        | Negative    |
| ++       | Increment   |
| --       | Decrement   |
| !        | Logical NOT |

Example:

```java
int a = 10;

System.out.println(++a);
System.out.println(--a);
```

---

# 3. Assignment Operators

Assignment operators are used to assign values.

| Operator | Example |
| -------- | ------- |
| =        | a = 10  |
| +=       | a += 5  |
| -=       | a -= 5  |
| \*=      | a \*= 2 |
| /=       | a /= 2  |
| %=       | a %= 2  |

---

# 4. Relational Operators

Relational operators compare two values and return a boolean result.

| Operator | Meaning               |
| -------- | --------------------- |
| ==       | Equal To              |
| !=       | Not Equal To          |
| >        | Greater Than          |
| <        | Less Than             |
| >=       | Greater Than or Equal |
| <=       | Less Than or Equal    |

Example:

```java
System.out.println(10 > 5);
System.out.println(10 == 5);
```

---

# 5. Logical Operators

Logical operators are used to combine multiple conditions.

| Operator | Description |
| -------- | ----------- | --- | ---------- |
| &&       | Logical AND |
|          |             |     | Logical OR |
| !        | Logical NOT |

Example:

```java
boolean result = (10 > 5) && (20 > 10);
System.out.println(result);
```

---

# 6. Bitwise Operators

Bitwise operators work on binary values.

| Operator | Description |
| -------- | ----------- |
| &        | AND         |
| \|       | OR          |
| ^        | XOR         |
| ~        | NOT         |

---

# 7. Shift Operators

Shift operators move bits left or right.

| Operator | Description          |
| -------- | -------------------- |
| <<       | Left Shift           |
| >>       | Right Shift          |
| >>>      | Unsigned Right Shift |

---

# 8. Ternary Operator

The ternary operator is a shorthand form of the if-else statement.

Syntax:

```java
condition ? value1 : value2;
```

Example:

```java
int age = 20;

String result = (age >= 18) ? "Eligible" : "Not Eligible";

System.out.println(result);
```

---

# 9. instanceof Operator

The instanceof operator checks whether an object belongs to a specific class.

Example:

```java
String name = "Java";

System.out.println(name instanceof String);
```

Output:

```text
true
```

---

# Operator Precedence

When multiple operators are used in the same expression, Java follows operator precedence.

Highest to Lowest:

1. Unary
2. Multiplication, Division, Modulus
3. Addition, Subtraction
4. Relational
5. Equality
6. Logical AND
7. Logical OR
8. Assignment

---

# Interview Questions

### 1. What are operators?

Operators are special symbols used to perform operations on operands.

---

### 2. How many types of operators are available in Java?

Java provides nine major categories of operators.

---

### 3. Which operator is used to compare two values?

Relational Operators.

---

### 4. Which operator is used as a shortcut for if-else?

The Ternary Operator (`?:`).

---

### 5. What does the instanceof operator do?

It checks whether an object is an instance of a particular class.

---

# Summary

Operators are symbols used to perform different operations on variables and values. Java provides arithmetic, relational, logical, assignment, unary, bitwise, shift, ternary, and instanceof operators to perform mathematical calculations, comparisons, logical operations, assignments, and object type checking efficiently.

---

## Related Topics

- Data Types
- Variables
- Type Conversion
- Type Casting
- Control Flow Statements
