# Inheritance in Java

## Introduction

Inheritance is an Object-Oriented Programming concept in which one class acquires the properties and behaviors of another class.

It allows us to:

- Reuse existing code.
- Create a parent-child relationship between classes.
- Reduce code duplication.
- Support method overriding.
- Implement runtime polymorphism.

Inheritance is represented using the:

```java
extends
```

keyword.

---

# Basic Syntax

```java
class Parent {

    // Parent members
}

class Child extends Parent {

    // Child members
}
```

Here:

```text
Parent
   ↑
   │
Child
```

The `Child` class inherits accessible members of the `Parent` class.

---

# Simple Example

```java
class Animal {

    void eat() {

        System.out.println("Animal eats");
    }
}

class Dog extends Animal {

    void bark() {

        System.out.println("Dog barks");
    }
}
```

Now:

```java
Dog dog = new Dog();

dog.eat();
dog.bark();
```

Output:

```text
Animal eats
Dog barks
```

The `Dog` object can use the inherited `eat()` method.

---

# Why Do We Need Inheritance?

Suppose multiple classes have common behavior.

Without inheritance:

```java
class Dog {

    void eat() {

        System.out.println("Eating");
    }

    void bark() {

        System.out.println("Barking");
    }
}

class Cat {

    void eat() {

        System.out.println("Eating");
    }

    void meow() {

        System.out.println("Meowing");
    }
}
```

The `eat()` method is duplicated.

With inheritance:

```java
class Animal {

    void eat() {

        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {

        System.out.println("Barking");
    }
}

class Cat extends Animal {

    void meow() {

        System.out.println("Meowing");
    }
}
```

Now the common behavior is written once.

---

# Parent Class and Child Class

The class being inherited from is called the:

```text
Parent Class
Super Class
Base Class
```

The class that inherits is called the:

```text
Child Class
Sub Class
Derived Class
```

Example:

```java
class Animal {

}

class Dog extends Animal {

}
```

Here:

```text
Animal → Parent / Super / Base class

Dog → Child / Sub / Derived class
```

---

# What Does a Child Class Inherit?

A child class can access accessible members of its parent class.

For example:

```java
class Animal {

    String name;

    void eat() {

        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {

        System.out.println("Barking");
    }
}
```

`Dog` can access:

```java
name
eat()
bark()
```

subject to Java's access-control rules.

---

# Inheritance and Access Modifiers

Inheritance does not mean that every parent member is directly accessible.

Consider:

```java
class Parent {

    private int privateValue = 10;

    protected int protectedValue = 20;

    public int publicValue = 30;
}
```

A child class:

```java
class Child extends Parent {

}
```

can directly access:

```text
protectedValue
publicValue
```

but cannot directly access:

```text
privateValue
```

---

# Important Point About private Members

Private members belong to the parent class and are not directly accessible from the child class.

Example:

```java
class Parent {

    private int age = 20;
}

class Child extends Parent {

    void display() {

        System.out.println(age); // Error
    }
}
```

This causes a compilation error.

The child can access the parent's private data indirectly through accessible methods such as getters/setters.

---

# Types of Inheritance in Java

Java supports:

```text
1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance
```

Java does **not** support multiple inheritance through classes.

---

# 1. Single Inheritance

One child class inherits from one parent class.

```text
Parent
   ↓
Child
```

Example:

```java
class Animal {

    void eat() {

        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {

        System.out.println("Barking");
    }
}
```

---

# 2. Multilevel Inheritance

A class inherits from another child class, creating a chain.

```text
Grandparent
     ↓
   Parent
     ↓
   Child
```

Example:

```java
class Animal {

    void eat() {

        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {

        System.out.println("Barking");
    }
}

class Puppy extends Dog {

    void play() {

        System.out.println("Playing");
    }
}
```

Now:

```java
Puppy puppy = new Puppy();

puppy.eat();
puppy.bark();
puppy.play();
```

The `Puppy` class can access accessible inherited behavior from both `Dog` and `Animal`.

---

# 3. Hierarchical Inheritance

Multiple child classes inherit from the same parent class.

```text
        Animal
        /    \
       /      \
     Dog      Cat
```

Example:

```java
class Animal {

    void eat() {

        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {

        System.out.println("Barking");
    }
}

class Cat extends Animal {

    void meow() {

        System.out.println("Meowing");
    }
}
```

Both `Dog` and `Cat` inherit `eat()`.

---

# Multiple Inheritance

Multiple inheritance means one class inherits from multiple classes.

Conceptually:

```text
Class A      Class B
    \          /
     \        /
       Class C
```

Java does **not** support this using classes.

The following is invalid:

```java
class A {

}

class B {

}

class C extends A, B {

}
```

This causes a compilation error.

---

# Why Doesn't Java Support Multiple Inheritance Through Classes?

One major reason is the **diamond problem**.

Consider:

```text
        A
       / \
      B   C
       \ /
        D
```

Suppose `A` has:

```java
void show()
```

and both `B` and `C` provide their own implementation.

If `D` inherits from both `B` and `C`, Java would have an ambiguity about which `show()` implementation should be used.

Java avoids this ambiguity by not allowing multiple inheritance through classes.

---

# Multiple Inheritance Through Interfaces

Java can achieve multiple inheritance of type/behavior through interfaces.

Example:

```java
interface A {

    void show();
}

interface B {

    void display();
}

class C implements A, B {

    @Override
    public void show() {

        System.out.println("Show");
    }

    @Override
    public void display() {

        System.out.println("Display");
    }
}
```

A class can implement multiple interfaces:

```java
class C implements A, B
```

Detailed interface behavior will be covered in:

```text
interfaces.md
```

---

# Inheritance and Constructors

Constructors are **not inherited** by child classes.

However, when a child object is created, a parent constructor is executed first.

Example:

```java
class Animal {

    Animal() {

        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {

        System.out.println("Dog constructor");
    }
}
```

When:

```java
new Dog();
```

is executed:

```text
Animal constructor
       ↓
Dog constructor
```

This happens because the child constructor invokes the parent constructor through `super()` either explicitly or implicitly when applicable.

---

# Inheritance and Method Overriding

A child class can provide its own implementation of an inherited method.

Example:

```java
class Animal {

    void sound() {

        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

This is called **method overriding**.

Method overriding is important for:

```text
Runtime Polymorphism
```

which we will cover in the next topic.

---

# Inheritance and super

The `super` keyword can be used to access parent class members.

Example:

```java
class Animal {

    void sound() {

        System.out.println("Animal sound");
    }
}

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

---

# Inheritance and final

A class declared as `final` cannot be inherited.

Example:

```java
final class Animal {

}
```

The following is invalid:

```java
class Dog extends Animal {

}
```

because `Animal` is final.

Similarly, a `final` method cannot be overridden.

Example:

```java
class Animal {

    final void sound() {

        System.out.println("Sound");
    }
}
```

A child class cannot override `sound()`.

---

# IS-A Relationship

Inheritance represents an **IS-A relationship**.

Example:

```text
Dog IS-A Animal
Car IS-A Vehicle
Student IS-A Person
```

Therefore:

```java
class Dog extends Animal
```

makes sense because a dog is an animal.

---

# IS-A vs HAS-A

These relationships are important in OOP.

### IS-A

Represents inheritance.

```java
class Dog extends Animal
```

```text
Dog IS-A Animal
```

### HAS-A

Represents composition/association.

```java
class Car {

    Engine engine;
}
```

```text
Car HAS-A Engine
```

Not every relationship should be implemented using inheritance.

---

# Inheritance vs Composition

Inheritance:

```text
Dog IS-A Animal
```

Composition:

```text
Car HAS-A Engine
```

Use inheritance when there is a genuine **IS-A** relationship.

Use composition when one object contains or uses another object.

---

# Advantages of Inheritance

- Code reusability.
- Reduces duplicate code.
- Supports method overriding.
- Enables runtime polymorphism.
- Creates a clear class hierarchy.
- Improves maintainability when the hierarchy is well designed.

---

# Disadvantages of Inheritance

- Creates tight coupling between parent and child classes.
- Changes in the parent can affect child classes.
- Deep inheritance hierarchies can become difficult to understand.
- Inheritance should not be used when there is no genuine IS-A relationship.

---

# Common Mistakes

### Mistake 1: Thinking constructors are inherited

❌ Constructors are not inherited.

Parent constructors are invoked during child object creation.

---

### Mistake 2: Thinking private members are directly accessible

❌ Private members cannot be directly accessed from the child class.

---

### Mistake 3: Using inheritance for every relationship

Inheritance should represent a genuine:

```text
IS-A
```

relationship.

---

### Mistake 4: Thinking Java supports multiple inheritance through classes

❌ Java does not support multiple inheritance through classes.

It supports multiple interface implementation.

---

# Interview Questions

### 1. What is inheritance?

**Answer:** Inheritance is an OOP mechanism where a child class acquires accessible properties and behaviors of a parent class using the `extends` keyword.

### 2. What is the purpose of inheritance?

**Answer:** It promotes code reuse, reduces duplication, and supports method overriding and runtime polymorphism.

### 3. Which keyword is used for inheritance?

**Answer:**

```java
extends
```

### 4. Does Java support multiple inheritance?

**Answer:** Java does not support multiple inheritance through classes, but a class can implement multiple interfaces.

### 5. Are constructors inherited?

**Answer:** No. Constructors are not inherited, but the parent constructor is invoked when a child object is created.

### 6. Can a child class directly access private members of the parent?

**Answer:** No. Private members are not directly accessible in the child class.

### 7. What is an IS-A relationship?

**Answer:** An IS-A relationship represents inheritance.

Example:

```text
Dog IS-A Animal
```

### 8. What is the difference between inheritance and composition?

**Answer:**

```text
Inheritance → IS-A

Composition → HAS-A
```

---

# Interview Tip 💡

Remember the basic inheritance picture:

```text
           Parent
             ↑
             │
           Child
```

And the three class inheritance types supported by Java:

```text
Single

Parent
  ↓
Child


Multilevel

Grandparent
     ↓
   Parent
     ↓
   Child


Hierarchical

       Parent
       /    \
      ↓      ↓
   Child1  Child2
```

Java does not support:

```text
Multiple inheritance through classes
```

but supports:

```java
class C implements A, B
```

through interfaces.

---

# Summary

Inheritance allows one class to acquire accessible members of another class.

Java uses:

```java
extends
```

for class inheritance.

Java supports:

```text
Single
Multilevel
Hierarchical
```

class inheritance.

Java does not support multiple inheritance through classes because of ambiguity such as the diamond problem.

Inheritance represents an **IS-A relationship** and plays an important role in method overriding and runtime polymorphism.
