# this and super Keywords in Java

## Introduction

Java provides two important keywords for working with objects and inheritance:

```text
this
super
```

- `this` refers to the **current object**.
- `super` refers to the **immediate parent class object/member**.

They are especially useful when working with constructors, inheritance, variables, and methods.

---

# 1. this Keyword

The `this` keyword refers to the **current object**.

Example:

```java
class Student {

    String name;

    void display() {

        System.out.println(this.name);
    }
}
```

Here:

```java
this.name
```

refers to the `name` variable of the current object.

---

# Why Do We Need this?

One of the most common uses of `this` is to distinguish between an instance variable and a local variable or parameter having the same name.

Example:

```java
class Student {

    String name;

    Student(String name) {

        this.name = name;
    }
}
```

Here there are two `name` variables:

```text
name
 ↓
Constructor parameter

this.name
 ↓
Instance variable
```

Therefore:

```java
this.name = name;
```

means:

```text
current object's name = parameter name
```

---

# Example Without this

Consider:

```java
class Student {

    String name;

    Student(String name) {

        name = name;
    }
}
```

This does not correctly assign the parameter to the instance variable.

Both sides refer to the parameter.

Therefore, the instance variable remains unchanged.

---

# Example With this

```java
class Student {

    String name;

    Student(String name) {

        this.name = name;
    }
}
```

Now:

```text
this.name
     ↓
Instance variable

name
     ↓
Parameter
```

---

# this Refers to Current Object

Consider:

```java
Student student1 = new Student("Nikhil");
Student student2 = new Student("Rahul");
```

When a method is called:

```java
student1.display();
```

inside the method:

```java
this
```

refers to:

```text
student1
```

When:

```java
student2.display();
```

is called:

```text
this
 ↓
student2
```

So `this` changes depending on which object calls the method.

---

# Example

```java
class Student {

    String name;

    Student(String name) {

        this.name = name;
    }

    void display() {

        System.out.println("Name: " + this.name);
    }
}
```

Usage:

```java
Student student1 = new Student("Nikhil");
Student student2 = new Student("Rahul");

student1.display();
student2.display();
```

Output:

```text
Name: Nikhil
Name: Rahul
```

---

# Main Uses of this

The `this` keyword is commonly used for:

1. Referring to the current object's instance variable.
2. Calling the current object's method.
3. Calling another constructor of the same class using `this()`.
4. Passing the current object as an argument.
5. Returning the current object from a method.

---

# 1. this for Instance Variables

```java
class Student {

    String name;

    Student(String name) {

        this.name = name;
    }
}
```

This is the most common use of `this`.

---

# 2. this for Calling Methods

We can use `this` to call the current object's method.

```java
class Student {

    void display() {

        System.out.println("Student");
    }

    void show() {

        this.display();
    }
}
```

Here:

```java
this.display();
```

means:

```text
Call display() using the current object.
```

In many cases, `this` can be omitted:

```java
display();
```

Both can work inside an instance method.

---

# 3. this() Constructor Call

`this()` is used to call another constructor of the **same class**.

Example:

```java
class Student {

    String name;
    int age;

    Student() {

        this("Unknown", 0);
    }

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

Here:

```java
this("Unknown", 0);
```

calls another constructor of the same class.

---

# Important Rule of this()

When using `this()` inside a constructor:

```text
this()
 ↓
must be the first statement
```

Correct:

```java
Student() {

    this("Unknown", 0);

    System.out.println("Constructor");
}
```

Incorrect:

```java
Student() {

    System.out.println("Constructor");

    this("Unknown", 0);
}
```

The second version causes a compilation error.

---

# 4. Passing this as an Argument

The current object can be passed to another method using `this`.

Example:

```java
class Student {

    void display(Student student) {

        System.out.println("Student object received");
    }

    void send() {

        display(this);
    }
}
```

Here:

```java
display(this);
```

passes the current object.

---

# 5. Returning this

A method can return the current object using `this`.

Example:

```java
class Student {

    Student getStudent() {

        return this;
    }
}
```

This technique is commonly used in method chaining.

---

# this Keyword Summary

```text
this
 │
 ├── current object's instance variable
 ├── current object's method
 ├── another constructor of same class → this()
 ├── current object as argument
 └── current object as return value
```

---

# 2. super Keyword

The `super` keyword is used to refer to members of the **immediate parent class**.

It is mainly used in inheritance.

Example:

```java
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";

    void display() {

        System.out.println(name);
        System.out.println(super.name);
    }
}
```

Output:

```text
Dog
Animal
```

Here:

```java
name
```

refers to the child class variable.

```java
super.name
```

refers to the parent class variable.

---

# Why Do We Need super?

Suppose parent and child classes contain variables or methods with the same name.

`super` allows us to explicitly access the parent class member.

```text
Parent
  │
  └── name = "Animal"

Child
  │
  └── name = "Dog"
```

Then:

```java
name
```

means child variable.

And:

```java
super.name
```

means parent variable.

---

# Main Uses of super

The `super` keyword is commonly used for:

1. Accessing parent class variables.
2. Calling parent class methods.
3. Calling parent class constructor using `super()`.

---

# 1. super for Parent Variables

```java
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";

    void display() {

        System.out.println("Child : " + name);
        System.out.println("Parent: " + super.name);
    }
}
```

Output:

```text
Child : Dog
Parent: Animal
```

---

# 2. super for Parent Methods

Suppose the parent class has a method:

```java
class Animal {

    void sound() {

        System.out.println("Animal sound");
    }
}
```

The child overrides it:

```java
class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

Now we can call the parent implementation using:

```java
super.sound();
```

Example:

```java
class Dog extends Animal {

    @Override
    void sound() {

        super.sound();

        System.out.println("Dog barks");
    }
}
```

Output:

```text
Animal sound
Dog barks
```

This is useful when we want to extend parent behavior rather than completely replace it.

---

# 3. super() Constructor Call

`super()` is used to call the constructor of the immediate parent class.

Example:

```java
class Animal {

    Animal() {

        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {

        super();

        System.out.println("Dog constructor");
    }
}
```

Output:

```text
Animal constructor
Dog constructor
```

---

# Important Rule of super()

Like `this()`, `super()` must be the **first statement** inside a constructor.

Correct:

```java
Dog() {

    super();

    System.out.println("Dog constructor");
}
```

Incorrect:

```java
Dog() {

    System.out.println("Dog constructor");

    super();
}
```

---

# this vs super

| this                                              | super                                        |
| ------------------------------------------------- | -------------------------------------------- |
| Refers to current object.                         | Refers to immediate parent class members.    |
| Used in current class.                            | Used mainly with inheritance.                |
| `this.name` accesses current class variable.      | `super.name` accesses parent class variable. |
| `this()` calls another constructor of same class. | `super()` calls parent constructor.          |
| `this.method()` calls current class method.       | `super.method()` calls parent class method.  |

---

# this() vs super()

```text
this()
 ↓
Calls constructor of same class

super()
 ↓
Calls constructor of parent class
```

Example:

```java
class Student {

    Student() {

        this("Unknown");
    }

    Student(String name) {

        System.out.println(name);
    }
}
```

Here:

```java
this("Unknown");
```

calls another constructor in the same class.

---

Parent example:

```java
class Animal {

    Animal() {

        System.out.println("Animal");
    }
}

class Dog extends Animal {

    Dog() {

        super();
    }
}
```

Here:

```java
super();
```

calls the parent constructor.

---

# Constructor Call Chain

Suppose:

```java
class Animal {

    Animal() {

        System.out.println("Animal");
    }
}

class Dog extends Animal {

    Dog() {

        super();

        System.out.println("Dog");
    }
}
```

When:

```java
new Dog();
```

is executed:

```text
new Dog()
   ↓
Dog constructor
   ↓
super()
   ↓
Animal constructor
   ↓
back to Dog constructor
```

Output:

```text
Animal
Dog
```

---

# Important: this and super Cannot Be Used Together as First Constructor Statement

A constructor can call either:

```java
this();
```

or:

```java
super();
```

as its first statement.

It cannot directly call both because both must be the first statement.

Example:

```java
Student() {

    this("Unknown");
    super();       // Error
}
```

This is invalid.

---

# Common Mistakes

### Mistake 1

Thinking:

```java
this
```

means the class.

❌ Incorrect.

`this` refers to the **current object**.

---

### Mistake 2

Thinking:

```java
super
```

means any ancestor class.

Not exactly.

`super` directly refers to the **immediate parent class**.

---

### Mistake 3

Using `this()` in the middle of a constructor.

```java
Student() {

    System.out.println("Hello");

    this("Nikhil");
}
```

❌ Compilation error.

`this()` must be the first statement.

---

### Mistake 4

Using `super()` in the middle of a constructor.

```java
Dog() {

    System.out.println("Dog");

    super();
}
```

❌ Compilation error.

`super()` must be the first statement.

---

# Interview Questions

### 1. What is this keyword?

**Answer:** `this` is a reference to the current object.

### 2. What is super keyword?

**Answer:** `super` is used to access members of the immediate parent class.

### 3. What is the difference between this() and super()?

**Answer:**

```text
this()
   → same class constructor

super()
   → parent class constructor
```

### 4. Can this() and super() be used together in the same constructor?

**Answer:** They cannot both appear as constructor-invocation statements because both must be the first statement.

### 5. Can this be used in a static method?

**Answer:** No.

A static method does not belong to a particular object, so there is no current object for `this` to refer to.

### 6. What does super.method() do?

**Answer:** It calls the implementation of the method from the immediate parent class.

---

# Interview Tip 💡

Remember this simple rule:

```text
this
 ↓
CURRENT OBJECT

super
 ↓
PARENT CLASS
```

And:

```text
this()
 ↓
Same class constructor

super()
 ↓
Parent class constructor
```

---

# Summary

The `this` keyword refers to the current object and is commonly used to access instance variables, call methods, invoke another constructor, pass the current object, and return the current object.

The `super` keyword is used in inheritance to access parent class variables, methods, and constructors.

Understanding `this` and `super` is essential for understanding constructors and inheritance in Java.

---

## Related Topics

- Constructor Chaining
- Inheritance
- Method Overriding
- Polymorphism
- Encapsulation
