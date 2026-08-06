# Class and Object in Java

## Introduction

Class and Object are the fundamental building blocks of Object-Oriented Programming (OOP).

A **Class** defines the structure of an object, while an **Object** is the actual instance created from that class.

In simple words:

- A **Class** is a blueprint or template.
- An **Object** is the real entity created using that blueprint.

---

# Why Do We Need Classes and Objects?

Suppose we want to store information about multiple students.

Without using classes, we need separate variables for every student.

```java
String student1Name = "Nikhil";
int student1Age = 20;

String student2Name = "Rahul";
int student2Age = 21;
```

As the number of students increases, the code becomes difficult to manage.

Using classes and objects, we can organize data efficiently and create multiple objects from a single class.

---

# Real-Life Analogy

Imagine a blueprint of a house.

```text
Blueprint
     │
     ▼
   Class

Actual House
     │
     ▼
   Object
```

One blueprint can be used to build many houses.

Similarly,

One class can be used to create many objects.

---

# What is a Class?

A **Class** is a user-defined blueprint that defines:

- Data (Variables)
- Behavior (Methods)

It does not occupy memory until an object is created.

---

# Syntax of a Class

```java
class Student {

    String name;
    int age;

    void display() {

        System.out.println(name);
        System.out.println(age);

    }

}
```

---

# What is an Object?

An **Object** is an instance of a class.

It occupies memory and contains actual values for the variables defined in the class.

Objects are created using the `new` keyword.

---

# Syntax of Object Creation

```java
Student student = new Student();
```

Here,

- `Student` → Class Name
- `student` → Reference Variable
- `new` → Creates the object in memory
- `Student()` → Calls the constructor

---

# How Object Creation Works

```text
Step 1

Class Created
      │
      ▼

Student

----------------------------

Step 2

Student student;

Reference variable created.

No object exists yet.

----------------------------

Step 3

student = new Student();

Object is created in Heap Memory.

Reference variable stores its address.
```

---

# Memory Representation

```text
Stack Memory

student
   │
   │
   ▼

----------------------------

Heap Memory

Student Object

name = null
age = 0
```

The reference variable (`student`) is stored in **Stack Memory**, while the actual object is stored in **Heap Memory**.

---

# Example

```java
class Student {

    String name;
    int age;

    void display() {

        System.out.println(name);
        System.out.println(age);

    }

}

public class ClassObjectExample {

    public static void main(String[] args) {

        Student student = new Student();

        student.name = "Nikhil";
        student.age = 20;

        student.display();

    }

}
```

### Output

```text
Nikhil
20
```

---

# Multiple Objects

A single class can create multiple objects.

```java
Student s1 = new Student();
Student s2 = new Student();
Student s3 = new Student();
```

Each object has its own separate data.

---

# Difference Between Class and Object

| Class                                     | Object                                               |
| ----------------------------------------- | ---------------------------------------------------- |
| A class is a blueprint or template.       | An object is an instance of a class.                 |
| It is a logical entity.                   | It is a physical entity.                             |
| It does not occupy memory by itself.      | It occupies memory when created.                     |
| It defines variables and methods.         | It stores actual data and uses methods.              |
| It is declared using the `class` keyword. | It is created using the `new` keyword.               |
| One class can create multiple objects.    | Multiple objects can be created from the same class. |

---

# Key Points

- A class is a blueprint.
- An object is an instance of a class.
- Objects are created using the `new` keyword.
- Every object has its own copy of instance variables.
- Multiple objects can be created from the same class.

---

# Advantages

- Code becomes modular.
- Easy to maintain.
- Supports code reusability.
- Represents real-world entities.

---

# Common Mistakes

### Mistake 1

```java
Student student;
```

❌ This creates only a reference variable.

No object is created.

---

### Correct

```java
Student student = new Student();
```

---

### Mistake 2

```java
Student student = null;

student.display();
```

❌ This throws a **NullPointerException** because the reference variable does not point to any object.

---

# Best Practices

- Use meaningful class names (Student, Employee, Product).
- Create objects only when required.
- Follow PascalCase for class names.
- Follow camelCase for object names.

Example:

```java
Student student = new Student();
Employee employee = new Employee();
```

---

# Interview Questions

### 1. What is a Class?

**Answer:** A class is a blueprint or template that defines the properties and behaviors of objects.

---

### 2. What is an Object?

**Answer:** An object is an instance of a class that occupies memory and contains actual data.

---

### 3. What is the purpose of the `new` keyword?

**Answer:** It creates an object in heap memory and returns its reference.

---

### 4. Where is the object stored?

**Answer:** In Heap Memory.

---

### 5. Where is the reference variable stored?

**Answer:** In Stack Memory.

---

### 6. Can we create multiple objects from one class?

**Answer:** Yes. A single class can be used to create any number of objects.

---

# Interview Tip 💡

Interviewers often ask:

- Difference between Class and Object.
- What does the `new` keyword do?
- Where is an object stored?
- What is a reference variable?
- Explain Stack and Heap memory during object creation.

---

# Summary

A class acts as a blueprint that defines the structure and behavior of objects. An object is the actual instance created from the class using the `new` keyword. Objects are stored in heap memory, while reference variables are stored in stack memory. Understanding classes and objects is the foundation of Java and Object-Oriented Programming.

---

## Related Topics

- Object Initialization
- Constructors
- this Keyword
- Inheritance
