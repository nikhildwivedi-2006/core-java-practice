# Object-Oriented Programming (OOP) in Java

## Introduction

Object-Oriented Programming (OOP) is a programming paradigm that organizes software around **objects** rather than functions or procedures.

An object represents a real-world entity that contains both **data (attributes)** and **behavior (methods)**.

Java is known as an Object-Oriented Programming language because almost everything in Java revolves around classes and objects.

---

# Why Do We Need Object-Oriented Programming?

As software applications grow larger, writing everything in a single file or using only functions becomes difficult to manage.

Object-Oriented Programming solves this problem by dividing a program into small, reusable objects.

It helps developers write code that is:

- Easy to understand
- Easy to maintain
- Easy to reuse
- Easy to extend

---

# Real-Life Analogy

Imagine a **Car**.

A car has:

### Properties (Data)

- Color
- Brand
- Model
- Speed

### Behaviors (Functions)

- Start()
- Stop()
- Accelerate()
- Brake()

In Java,

- **Car** is an Object.
- **Color, Brand, Speed** are Data Members (Variables).
- **Start(), Stop()** are Methods.

This is the basic idea behind Object-Oriented Programming.

---

# What is an Object?

An **Object** is a real-world entity that has:

- State (Data)
- Behavior (Methods)
- Identity (Unique existence)

Example:

```text
Object : Student

State
------
Name = Nikhil
Age = 20

Behavior
---------
Study()
AttendClass()
WriteExam()

Identity
---------
Student ID = 101
```

---

# What is a Class?

A **Class** is a blueprint or template used to create objects.

It defines what data an object will store and what operations it can perform.

Example:

```text
Blueprint of House
        │
        ▼
      Class

Actual Houses
        │
        ▼
     Objects
```

---

                  Class
                    │
          (Blueprint / Template)
                    │
        ┌───────────┴───────────┐
        │                       │
     Object 1               Object 2
     (Advik)                (Shivam)

---

# Four Pillars of OOP

Object-Oriented Programming is based on four major principles.

### 1. Encapsulation

Wrapping data and methods into a single unit (Class).

---

### 2. Inheritance

Acquiring properties and behaviors from another class.

---

### 3. Polymorphism

One interface, multiple implementations.

---

### 4. Abstraction

Showing only essential information while hiding implementation details.

---

                    Object-Oriented Programming
                               │
        ┌──────────────┬──────────────┬──────────────┬
        │              │              │              │

Encapsulation Inheritance Polymorphism Abstraction

---

# Advantages of OOP

- Improves code reusability.
- Makes programs modular.
- Easier maintenance.
- Better security through encapsulation.
- Simplifies debugging.
- Supports real-world modeling.

---

# Applications of OOP

Object-Oriented Programming is widely used in:

- Desktop Applications
- Web Applications
- Android Applications
- Banking Systems
- E-Commerce Platforms
- Hospital Management Systems
- Game Development

---

# Why Java is Called an Object-Oriented Language?

Java is called an Object-Oriented language because programs are designed using classes and objects.

It supports all four OOP principles:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction

---

# Common Mistakes

### Mistake 1

Thinking that **Class** and **Object** are the same.

❌ Incorrect

They are different concepts.

✔ Correct

A **Class** is a blueprint.

An **Object** is an instance of that blueprint.

---

### Mistake 2

Thinking everything in Java is purely object-oriented.

Actually,

Primitive data types like:

```java
int
char
double
boolean
```

are **not objects**.

Therefore, Java is considered **mostly object-oriented**, not 100% purely object-oriented.

---

# Best Practices

- Keep each class responsible for one task.
- Use meaningful class names.
- Follow proper naming conventions.
- Design classes to be reusable.
- Avoid writing everything inside one class.

---

# Interview Questions

### 1. What is Object-Oriented Programming?

**Answer:** OOP is a programming paradigm that organizes software around objects instead of functions.

---

### 2. What are the four pillars of OOP?

**Answer:**

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction

---

### 3. Why is Java called an Object-Oriented language?

**Answer:** Because Java uses classes and objects to organize programs and supports the four principles of OOP.

---

### 4. Is Java 100% Object-Oriented?

**Answer:** No.

Java contains primitive data types such as `int`, `char`, `boolean`, etc., which are not objects.

---

### 5. What is the difference between a Class and an Object?

**Answer:**

A Class is a blueprint.

An Object is an instance of that class.

---

# Interview Tip 💡

Very common interview questions:

✔ Explain OOP in simple words.

✔ What are the advantages of OOP?

✔ Is Java purely object-oriented?

✔ What are the four pillars of OOP?

---

# Summary

Object-Oriented Programming is a programming paradigm that uses classes and objects to model real-world entities. It improves code organization, reusability, security, and maintainability. Java heavily relies on OOP concepts, making it one of the most important topics for Java developers.

---

## Related Topics

- Class
- Object
- Constructors
- Inheritance
- Polymorphism
