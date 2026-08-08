# Argument Passing in Java

## Introduction

Argument Passing is the process of passing values to a method when the method is called.

Example:

```java
add(10, 20);
```

Here:

- `10` and `20` are **arguments**.
- The values are passed to the method parameters.

---

# Parameter vs Argument

These two terms are related but different.

### Parameter

A parameter is a variable declared in a method definition.

```java
void add(int a, int b) {

}
```

Here `a` and `b` are parameters.

### Argument

An argument is the actual value passed when calling the method.

```java
add(10, 20);
```

Here `10` and `20` are arguments.

---

# How Does Java Pass Arguments?

Java is **always Pass-by-Value**.

This means a copy of the value is passed to the method.

For primitive data types, the actual primitive value is copied.

For objects, the **value of the reference** is copied.

---

# Passing Primitive Values

Example:

```java
public class ArgumentPassingExample {

    static void changeValue(int number) {

        number = 100;

    }

    public static void main(String[] args) {

        int value = 50;

        changeValue(value);

        System.out.println(value);

    }
}
```

### Output

```text
50
```

The original variable remains unchanged because a copy of the value was passed.

---

# Passing Object References

Consider the following class:

```java
class Student {

    String name;
}
```

Now:

```java
Student student = new Student();
student.name = "Nikhil";
```

When the object is passed to a method:

```java
changeName(student);
```

Java passes a **copy of the reference value**.

Both reference variables point to the same object.

---

# Example

```java
class Student {

    String name;
}

public class ObjectArgumentExample {

    static void changeName(Student student) {

        student.name = "Rahul";

    }

    public static void main(String[] args) {

        Student student = new Student();

        student.name = "Nikhil";

        changeName(student);

        System.out.println(student.name);

    }
}
```

### Output

```text
Rahul
```

The object's data changes because both references point to the same object.

---

# Important Concept

Do not say:

> Java is pass-by-reference for objects.

That statement is incorrect.

The correct statement is:

> **Java is always pass-by-value. For objects, the value of the reference is passed by value.**

---

# Memory Representation

Before calling the method:

```text
Stack

student
   │
   ▼

Heap

Student Object
name = "Nikhil"
```

During method call:

```text
main()                    changeName()

student ───────┐          student ───────┐
               │                         │
               └────────► Same Object ◄─┘

                         Heap
                    name = "Nikhil"
```

Both references contain the value that points to the same object.

Therefore:

```java
student.name = "Rahul";
```

changes the object's state.

---

# Reassigning the Reference

Consider:

```java
class Student {

    String name;
}

public class ReferenceExample {

    static void changeReference(Student student) {

        student = new Student();
        student.name = "Rahul";

    }

    public static void main(String[] args) {

        Student student = new Student();

        student.name = "Nikhil";

        changeReference(student);

        System.out.println(student.name);

    }
}
```

### Output

```text
Nikhil
```

Why?

The method received a **copy of the reference value**.

When the copied reference is reassigned:

```java
student = new Student();
```

the original reference in `main()` is not changed.

---

# Primitive vs Object Argument Passing

| Primitive                                             | Object                                                                 |
| ----------------------------------------------------- | ---------------------------------------------------------------------- |
| Value is copied.                                      | Reference value is copied.                                             |
| Changes to parameter do not affect original variable. | Changes to object state can be visible through the original reference. |
| Example: `int`, `double`, `boolean`                   | Example: `Student`, `Employee`                                         |

---

# Key Points

- Java is always pass-by-value.
- Primitive values are passed by copying their values.
- For objects, the reference value is copied.
- A method can modify the object's state through the copied reference.
- Reassigning the copied reference does not change the original reference.

---

# Common Mistake

### Incorrect

> Java uses pass-by-reference for objects.

❌ Incorrect.

### Correct

> Java uses pass-by-value. In case of objects, the value of the reference is passed by value.

---

# Best Practice

When explaining Java argument passing in an interview, use this sentence:

> **"Java is strictly pass-by-value. For objects, the value being passed is a copy of the object's reference."**

This is the most important point to remember.

---

# Interview Questions

### 1. Is Java pass-by-value or pass-by-reference?

**Answer:** Java is always pass-by-value.

### 2. What happens when an object is passed to a method?

**Answer:** A copy of the object's reference value is passed to the method.

### 3. Can a method modify an object's state?

**Answer:** Yes. If the method changes the object's fields through the copied reference, the changes are visible through the original reference.

### 4. Can a method change the original reference?

**Answer:** No. Reassigning the copied reference does not change the original reference.

### 5. What is the difference between a parameter and an argument?

**Answer:** A parameter is declared in the method definition, while an argument is the actual value passed during the method call.

---

# Summary

Java uses pass-by-value for all method arguments. For primitive types, the actual value is copied. For objects, the value of the reference is copied. Because the copied reference can point to the same object, changes to the object's state can be visible outside the method.

---

## Related Topics

- Class and Object
- Reference Variables
- Object Initialization
- Methods
- Memory Management
