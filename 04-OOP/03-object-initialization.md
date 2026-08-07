# Object Initialization in Java

## Introduction

Object Initialization means assigning values to the variables of an object after creating it.

When an object is created using the `new` keyword, it gets default values. We initialize the object to provide meaningful values.

Example:

```java
Student student = new Student();
```

After creation:

```text
name = null
age = 0
```

After initialization:

```text
name = Nikhil
age = 20
```

---

# Why Do We Need Object Initialization?

Without initialization, every object contains default values.

Object initialization helps us:

- Store meaningful data.
- Create objects with different values.
- Make objects ready to use.

---

# Ways to Initialize an Object

There are mainly three ways to initialize an object in Java:

1. Using Reference Variable
2. Using Method
3. Using Constructor

---

# 1. Using Reference Variable

In this approach, we directly assign values using the object reference.

Example:

```java
class Student {

    String name;
    int age;

}

public class ObjectInitialization {

    public static void main(String[] args) {

        Student student = new Student();

        student.name = "Nikhil";
        student.age = 20;

        System.out.println(student.name);
        System.out.println(student.age);

    }

}
```

Output:

```text
Nikhil
20
```

---

# 2. Using Method

In this approach, we create a method that assigns values to object variables.

Example:

```java
class Student {

    String name;
    int age;

    void setData(String n, int a) {

        name = n;
        age = a;

    }

}

public class ObjectInitialization {

    public static void main(String[] args) {

        Student student = new Student();

        student.setData("Nikhil", 20);

        System.out.println(student.name);
        System.out.println(student.age);

    }

}
```

---

# 3. Using Constructor

A constructor is a special method that is automatically called when an object is created.

Example:

```java
class Student {

    String name;
    int age;

    Student(String n, int a) {

        name = n;
        age = a;

    }

}
```

Constructor initialization will be covered in detail in the next topic.

---

# Default Values of Object Variables

When an object is created, instance variables get default values.

| Data Type        | Default Value |
| ---------------- | ------------- |
| int              | 0             |
| double           | 0.0           |
| boolean          | false         |
| Object Reference | null          |

---

# Important Points

- Object creation and object initialization are different concepts.
- Creating an object allocates memory.
- Initialization assigns values to the object.
- Constructors are the most commonly used way of initialization.

---

# Interview Questions

### 1. What is object initialization?

**Answer:** Object initialization is the process of assigning values to object variables.

---

### 2. What are different ways to initialize an object?

**Answer:**

- Using reference variable
- Using method
- Using constructor

---

### 3. What are default values of instance variables?

**Answer:** Instance variables get default values automatically when an object is created.

---

# Summary

Object initialization is the process of assigning values to an object after its creation. Java provides multiple ways to initialize objects, with constructors being the most commonly used approach.

---

## Related Topics

- Class and Object
- Constructors
- this Keyword
