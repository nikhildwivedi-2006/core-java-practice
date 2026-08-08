# Method Overloading in Java

## Introduction

Method Overloading is a feature of Java that allows a class to have multiple methods with the **same name but different parameter lists**.

It is an example of **Compile-Time Polymorphism**.

---

# Why Do We Need Method Overloading?

Sometimes we want to perform the same type of operation with different inputs.

Instead of creating different method names:

```java
addTwoNumbers()
addThreeNumbers()
addNumbersWithDouble()
```

we can use the same method name:

```java
add()
```

with different parameters.

This makes the code easier to understand and use.

---

# Real-Life Analogy

Suppose a calculator has an `add()` operation.

It may accept:

```text
add(10, 20)
add(10, 20, 30)
add(10.5, 20.5)
```

The operation is the same — **addition** — but the inputs are different.

This is the basic idea behind method overloading.

---

# Syntax

```java
class Calculator {

    void add(int a, int b) {
        // code
    }

    void add(int a, int b, int c) {
        // code
    }

}
```

Both methods have the same name but different parameter lists.

---

# Example 1: Different Number of Parameters

```java
class Calculator {

    int add(int a, int b) {

        return a + b;

    }

    int add(int a, int b, int c) {

        return a + b + c;

    }

}
```

Usage:

```java
Calculator calculator = new Calculator();

System.out.println(calculator.add(10, 20));
System.out.println(calculator.add(10, 20, 30));
```

Output:

```text
30
60
```

---

# Example 2: Different Data Types

Methods can also be overloaded using different parameter types.

```java
class Calculator {

    int add(int a, int b) {

        return a + b;

    }

    double add(double a, double b) {

        return a + b;

    }

}
```

Usage:

```java
Calculator calculator = new Calculator();

System.out.println(calculator.add(10, 20));
System.out.println(calculator.add(10.5, 20.5));
```

---

# Ways to Achieve Method Overloading

Methods can be overloaded by changing:

### 1. Number of Parameters

```java
add(int a, int b)

add(int a, int b, int c)
```

### 2. Data Types of Parameters

```java
add(int a, int b)

add(double a, double b)
```

### 3. Order of Parameters

```java
display(int age, String name)

display(String name, int age)
```

---

# Important Rule

Changing **only the return type** does NOT create method overloading.

Invalid:

```java
int add(int a, int b) {
    return a + b;
}

double add(int a, int b) {
    return a + b;
}
```

❌ This causes a compilation error.

The parameter list must be different.

---

# Method Overloading and Compile-Time Polymorphism

Method overloading is called **Compile-Time Polymorphism** because the compiler determines which overloaded method should be called during compilation.

Example:

```java
calculator.add(10, 20);
```

The compiler identifies:

```java
add(int, int)
```

---

# Method Overloading vs Method Overriding

| Method Overloading            | Method Overriding            |
| ----------------------------- | ---------------------------- |
| Same class usually.           | Requires inheritance.        |
| Same method name.             | Same method name.            |
| Parameters must be different. | Parameters must be the same. |
| Compile-time polymorphism.    | Runtime polymorphism.        |
| Inheritance is not required.  | Inheritance is required.     |

---

# Advantages

- Improves code readability.
- Allows the same operation to use different inputs.
- Reduces unnecessary method names.
- Supports compile-time polymorphism.

---

# Common Mistakes

### Mistake 1: Changing Only Return Type

```java
int calculate(int a) {
    return a;
}

double calculate(int a) {
    return a;
}
```

❌ Not valid overloading.

---

### Mistake 2: Same Parameters

```java
void display(int a) {

}

void display(int a) {

}
```

❌ Duplicate method.

---

# Best Practices

- Use overloading when methods perform logically similar operations.
- Keep overloaded methods easy to understand.
- Avoid excessive overloading that makes code confusing.
- Use meaningful parameter types.

---

# Interview Questions

### 1. What is Method Overloading?

**Answer:** Method overloading allows multiple methods in a class to have the same name but different parameter lists.

### 2. Is Method Overloading compile-time or runtime polymorphism?

**Answer:** Compile-time polymorphism.

### 3. Can we overload a method by changing only its return type?

**Answer:** No.

### 4. Can methods be overloaded by changing the order of parameters?

**Answer:** Yes, if the parameter types are different.

Example:

```java
display(int age, String name)

display(String name, int age)
```

### 5. Does Method Overloading require inheritance?

**Answer:** No.

---

# Interview Tip 💡

A very common question is:

**Can we overload a method by changing only the return type?**

Answer:

> No. Method overloading requires a different parameter list. Changing only the return type is not sufficient.

---

# Summary

Method Overloading allows multiple methods with the same name but different parameter lists. It improves readability and flexibility and is an important example of compile-time polymorphism.

---

## Related Topics

- Methods
- Constructor Overloading
- Polymorphism
- Method Overriding
