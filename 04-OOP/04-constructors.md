# Constructors in Java

## Introduction

A constructor is a special member of a class that is used to initialize an object.

A constructor is automatically called when an object is created.

Example:

```java
Student student = new Student();
```

When `new Student()` executes, the constructor of the `Student` class is called.

---

# Why Do We Need Constructors?

Suppose we create an object:

```java
Student student = new Student();
```

We may want the object to have meaningful values immediately.

Instead of:

```java
student.name = "Nikhil";
student.age = 20;
```

We can initialize the object directly using a constructor:

```java
Student student = new Student("Nikhil", 20);
```

This makes object creation and initialization easier.

---

# Syntax

```java
class ClassName {

    ClassName() {

        // Initialization code

    }

}
```

The constructor name must be exactly the same as the class name.

---

# Example

```java
class Student {

    String name;
    int age;

    Student() {

        name = "Nikhil";
        age = 20;

    }

}
```

Creating the object:

```java
Student student = new Student();
```

The constructor automatically initializes the object.

---

# Important Characteristics of Constructors

A constructor:

- Has the same name as the class.
- Does not have a return type.
- Is automatically called when an object is created.
- Is mainly used for object initialization.
- Can be overloaded.
- Cannot be inherited.
- Cannot be overridden.

---

# Constructor vs Method

| Constructor                                  | Method                        |
| -------------------------------------------- | ----------------------------- |
| Used mainly for object initialization.       | Used to perform an operation. |
| Same name as the class.                      | Can have any valid name.      |
| Has no return type.                          | Can have a return type.       |
| Called automatically during object creation. | Called explicitly.            |
| Cannot be overridden.                        | Can be overridden.            |

---

# Types of Constructors

Constructors can broadly be divided into:

1. No-Argument Constructor
2. Parameterized Constructor

---

# 1. No-Argument Constructor

A constructor that does not accept any parameters is called a no-argument constructor.

Example:

```java
class Student {

    String name;
    int age;

    Student() {

        name = "Nikhil";
        age = 20;

    }

}
```

Usage:

```java
Student student = new Student();
```

---

# 2. Parameterized Constructor

A constructor that accepts parameters is called a parameterized constructor.

Example:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;

    }

}
```

Usage:

```java
Student student = new Student("Nikhil", 20);
```

This allows different objects to be initialized with different values.

---

# Multiple Objects Using Parameterized Constructor

```java
Student student1 = new Student("Nikhil", 20);
Student student2 = new Student("Rahul", 21);
Student student3 = new Student("Aman", 19);
```

Each object receives its own values.

---

# What Happens If We Don't Write a Constructor?

If a class does not contain any constructor, the Java compiler provides a default constructor automatically.

Example:

```java
class Student {

    String name;
    int age;

}
```

The compiler provides a default constructor internally.

We can create an object using:

```java
Student student = new Student();
```

---

# Important Note About Default Constructor

If we define our own constructor, the compiler does **not** automatically provide a no-argument constructor.

Example:

```java
class Student {

    Student(String name) {

    }

}
```

Now this is invalid:

```java
Student student = new Student();
```

because there is no no-argument constructor.

---

# Constructor Overloading

A class can have multiple constructors with different parameter lists.

Example:

```java
class Student {

    String name;
    int age;

    Student() {

        name = "Unknown";
        age = 0;

    }

    Student(String name, int age) {

        this.name = name;
        this.age = age;

    }

}
```

This is called **Constructor Overloading**.

Constructor overloading will be covered separately in detail.

---

# Constructor Chaining

One constructor can call another constructor using:

```java
this()
```

Example:

```java
class Student {

    Student() {

        this("Unknown", 0);

    }

    Student(String name, int age) {

        System.out.println(name);
        System.out.println(age);

    }

}
```

Constructor chaining will be covered in detail in the Advanced OOP section.

---

# Common Mistakes

### Mistake 1: Giving a return type

```java
void Student() {

}
```

This is **not a constructor**.

It is a method named `Student`.

Correct:

```java
Student() {

}
```

---

### Mistake 2: Different name from class

```java
class Student {

    Students() {

    }

}
```

This is not a constructor because the names are different.

Correct:

```java
class Student {

    Student() {

    }

}
```

---

# Best Practices

- Use constructors to initialize objects properly.
- Keep constructor parameters meaningful.
- Use `this` when parameter names are the same as instance variables.
- Avoid putting unnecessary complex logic inside constructors.

---

# Interview Questions

### 1. What is a constructor?

**Answer:** A constructor is a special member of a class used to initialize objects. It is automatically called when an object is created.

### 2. Does a constructor have a return type?

**Answer:** No. A constructor does not have a return type, not even `void`.

### 3. Can constructors be overloaded?

**Answer:** Yes. A class can have multiple constructors with different parameter lists.

### 4. Can constructors be inherited?

**Answer:** No. Constructors are not inherited by child classes.

### 5. Can constructors be overridden?

**Answer:** No. Constructors cannot be overridden.

### 6. What happens if no constructor is written?

**Answer:** The compiler provides a default constructor, provided that no constructor has been explicitly defined.

---

# Interview Tip 💡

Very common questions:

- What is a constructor?
- Constructor vs method?
- Default constructor vs parameterized constructor?
- What happens if we define a parameterized constructor?
- Can a constructor be overloaded?
- Can a constructor be inherited or overridden?

---

# Summary

A constructor is a special member of a class that is automatically invoked when an object is created. It is primarily used to initialize object state. Constructors have the same name as the class and do not have a return type.

---

## Related Topics

- Class and Object
- Object Initialization
- Constructor Overloading
- `this` Keyword
- Inheritance
