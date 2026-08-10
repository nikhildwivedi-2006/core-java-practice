# Static Keyword in Java

## Introduction

The `static` keyword in Java is used to create members that belong to the **class rather than individual objects**.

A static member is shared among all objects of the class.

The `static` keyword can be used with:

- Variables
- Methods
- Blocks
- Nested Classes

In this chapter, we will focus mainly on static variables, static methods, and static blocks.

---

# Why Do We Need `static`?

Suppose we have a `Student` class and every student belongs to the same college.

Without `static`:

```java
class Student {

    String name;
    String college;

}
```

Every object stores its own copy of `college`.

```text
Student 1 → college = "SIRT"
Student 2 → college = "SIRT"
Student 3 → college = "SIRT"
```

This is unnecessary because the college is common to all students.

Using `static`:

```java
class Student {

    String name;
    static String college = "SIRT";

}
```

Now only one shared copy of `college` exists for the class.

---

# Static Variable

A variable declared using the `static` keyword is called a **static variable** or **class variable**.

Example:

```java
class Student {

    String name;
    static String college = "SIRT";

}
```

Here:

```java
name
```

is an instance variable.

```java
college
```

is a static variable.

---

# Real-Life Analogy

Suppose there are 100 students in a college.

Each student has different:

```text
Name
Roll Number
Age
```

But all students have the same:

```text
College = SIRT
```

Therefore:

```text
Student-specific data
        ↓
Instance Variables

Common data
        ↓
Static Variable
```

---

# Memory Representation

```text
Student Objects

Object 1
name = "Nikhil"

Object 2
name = "Rahul"

Object 3
name = "Aman"


        │
        │
        ▼

Shared Class Data

static college = "SIRT"
```

The static variable belongs to the class and is shared among its objects.

---

# Accessing a Static Variable

The preferred way to access a static variable is through the class name.

```java
Student.college
```

Example:

```java
System.out.println(Student.college);
```

We can also access it through an object:

```java
Student student = new Student();

System.out.println(student.college);
```

However, accessing a static member using the class name is clearer and recommended.

---

# Example

```java
class Student {

    String name;
    static String college = "SIRT";

    void display() {

        System.out.println("Name    : " + name);
        System.out.println("College : " + college);

    }
}

public class StaticVariableExample {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "Nikhil";

        Student student2 = new Student();
        student2.name = "Rahul";

        student1.display();
        student2.display();

    }
}
```

### Output

```text
Name    : Nikhil
College : SIRT

Name    : Rahul
College : SIRT
```

Both objects use the same static `college` variable.

---

# Changing a Static Variable

Because the static variable is shared, changing it affects all objects.

```java
class Student {

    String name;
    static String college = "SIRT";

}

public class StaticExample {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student();

        Student.college = "ABC College";

        System.out.println(student1.college);
        System.out.println(student2.college);

    }
}
```

### Output

```text
ABC College
ABC College
```

Both objects see the updated value.

---

# Static Method

A method declared using the `static` keyword is called a **static method**.

Example:

```java
class Calculator {

    static int add(int a, int b) {

        return a + b;

    }
}
```

It can be called using the class name:

```java
Calculator.add(10, 20);
```

No object is required.

---

# Why Don't We Need an Object for Static Methods?

Static methods belong to the class rather than an individual object.

Therefore, we can directly access them using:

```java
ClassName.methodName();
```

Example:

```java
Math.max(10, 20);
```

`max()` is a static method of the `Math` class.

---

# Important Rule of Static Methods

A static method cannot directly access instance variables or instance methods.

Example:

```java
class Student {

    String name;

    static void display() {

        System.out.println(name);

    }
}
```

❌ This causes a compilation error.

Why?

Because `name` belongs to an object, while `display()` belongs to the class.

There is no specific object associated with the static method.

---

# Correct Approach

A static method can directly access static members.

```java
class Student {

    static String college = "SIRT";

    static void displayCollege() {

        System.out.println(college);

    }
}
```

Usage:

```java
Student.displayCollege();
```

---

# Static Block

A static block is a block of code declared using the `static` keyword.

It is executed when the class is loaded.

Example:

```java
class Demo {

    static {

        System.out.println("Static block executed");

    }

}
```

---

# Example of Static Block

```java
public class StaticBlockExample {

    static {

        System.out.println("Static block executed");

    }

    public static void main(String[] args) {

        System.out.println("Main method executed");

    }
}
```

### Output

```text
Static block executed
Main method executed
```

The static block executes before the `main()` method.

---

# Static Block with Static Variable

Static blocks are often used to initialize static data.

```java
class Database {

    static String url;

    static {

        url = "jdbc:mysql://localhost:3306/student";

    }

}
```

The static block initializes the static variable when the class is initialized.

---

# Static vs Instance Members

| Static Member                                          | Instance Member                          |
| ------------------------------------------------------ | ---------------------------------------- |
| Belongs to the class.                                  | Belongs to an object.                    |
| Shared among objects.                                  | Each object has its own copy.            |
| Can be accessed using class name.                      | Usually accessed using object reference. |
| Object is not required for access.                     | Object is required.                      |
| Created once per class loading/initialization context. | Associated with each object.             |

---

# Static Variable vs Instance Variable

Consider:

```java
class Student {

    String name;
    static String college = "SIRT";

}
```

Here:

```text
name
 ↓
Different for every object

college
 ↓
Common for all objects
```

---

# Static Method vs Instance Method

```java
class Student {

    static void staticMethod() {

        System.out.println("Static method");

    }

    void instanceMethod() {

        System.out.println("Instance method");

    }

}
```

Static method:

```java
Student.staticMethod();
```

Instance method:

```java
Student student = new Student();

student.instanceMethod();
```

---

# Important Rules

### Rule 1

A static method can directly access static members.

```java
static int count;

static void display() {

    System.out.println(count);

}
```

---

### Rule 2

A static method cannot directly access instance members.

```java
int age;

static void display() {

    System.out.println(age); // Error

}
```

---

### Rule 3

An instance method can access both static and instance members.

```java
class Student {

    String name;
    static String college = "SIRT";

    void display() {

        System.out.println(name);
        System.out.println(college);

    }
}
```

---

# Static Members and Objects

A static member can be accessed without creating an object:

```java
Student.college
```

However, an instance member requires an object:

```java
Student student = new Student();

student.name
```

---

# Common Mistakes

### Mistake 1: Creating Objects for Static Methods Unnecessarily

Instead of:

```java
Calculator calculator = new Calculator();

calculator.add(10, 20);
```

Prefer:

```java
Calculator.add(10, 20);
```

when the method is designed as static.

---

### Mistake 2: Accessing Instance Variables from Static Methods

```java
class Student {

    String name;

    static void display() {

        System.out.println(name);

    }
}
```

❌ This is not allowed directly.

---

### Mistake 3: Thinking Static Means Constant

`static` does **not** mean the value cannot change.

```java
static int count = 0;
```

The value can still be modified.

For a constant, we generally use:

```java
static final int MAX = 100;
```

---

# Best Practices

- Use static variables for data shared by all objects.
- Use static methods when behavior does not depend on object state.
- Prefer class-name access for static members.
- Do not use static just to avoid creating objects.
- Use `static final` for class-level constants.

---

# Interview Questions

### 1. What is the `static` keyword?

**Answer:** `static` is used to create class-level members that belong to the class rather than individual objects.

### 2. What is a static variable?

**Answer:** A static variable is a class-level variable shared by all objects of the class.

### 3. Can we access a static variable without creating an object?

**Answer:** Yes.

```java
Student.college
```

### 4. Can a static method access an instance variable directly?

**Answer:** No.

A static method does not belong to a particular object.

### 5. Can an instance method access a static variable?

**Answer:** Yes.

### 6. What is a static block?

**Answer:** A static block is a block of code executed when the class is initialized.

### 7. Is `static` the same as `final`?

**Answer:** No.

`static` means class-level, while `final` prevents reassignment after initialization for variables.

---

# Interview Tip 💡

Remember this simple rule:

```text
STATIC
  ↓
Belongs to CLASS

INSTANCE
  ↓
Belongs to OBJECT
```

And for static methods:

```text
Static Method
      ↓
Can directly access
      ↓
Static Members

Cannot directly access
      ↓
Instance Members
```

---

# Summary

The `static` keyword is used for members that belong to the class rather than individual objects. Static variables are shared among objects, static methods can be called using the class name, and static blocks execute during class initialization.

Static members are especially useful when data or behavior is common to all objects.

---

## Related Topics

- Class and Object
- Instance Variables
- `final` Keyword
- Static Methods
- Static Blocks
- Object Class
