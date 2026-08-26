# Abstract Classes in Java

## Introduction

An abstract class is a class that is declared using the `abstract` keyword.

An abstract class can contain:

- Abstract methods
- Concrete methods
- Variables
- Constructors
- Static methods
- Final methods

An abstract class is mainly used when we want to provide a common base for related classes while leaving some behavior for child classes to implement.

---

# Syntax

```java
abstract class ClassName {

    abstract void method();

    void normalMethod() {

        System.out.println("Concrete method");
    }
}
```

---

# What is an Abstract Method?

An abstract method is a method that has a declaration but no implementation.

Example:

```java
abstract void sound();
```

There is no method body.

A child class must provide the implementation of an abstract method unless the child class is also abstract.

---

# Simple Example

```java
abstract class Animal {

    abstract void sound();
}
```

Now a child class can implement it:

```java
class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

Usage:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Dog barks
```

This also demonstrates runtime polymorphism.

---

# Abstract Class Can Have Concrete Methods

An abstract class can contain normal methods with implementations.

Example:

```java
abstract class Animal {

    abstract void sound();

    void eat() {

        System.out.println("Animal eats");
    }
}
```

Child class:

```java
class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

Now:

```java
Dog dog = new Dog();

dog.sound();
dog.eat();
```

Output:

```text
Dog barks
Animal eats
```

Therefore:

```text
Abstract Class
      │
      ├── Abstract methods
      │
      └── Concrete methods
```

---

# Why Do We Need Abstract Classes?

Suppose we have different types of vehicles.

Every vehicle should have a `start()` operation, but the implementation can be different.

```java
abstract class Vehicle {

    abstract void start();

    void stop() {

        System.out.println("Vehicle stopped");
    }
}
```

Now:

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts with key/button");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {

        System.out.println("Bike starts with ignition");
    }
}
```

The parent class defines the common structure, while child classes provide specific implementations.

---

# Cannot Create Object of Abstract Class

We cannot directly create an object of an abstract class.

Example:

```java
abstract class Animal {

    abstract void sound();
}
```

This is invalid:

```java
Animal animal = new Animal();
```

It causes a compilation error because `Animal` is abstract.

---

# But Abstract Class Can Have a Reference

Although we cannot create an object directly from an abstract class, we can create a reference of the abstract class.

Example:

```java
Animal animal = new Dog();
```

This is valid.

Here:

```text
Reference Type → Animal

Object Type → Dog
```

This is commonly used with runtime polymorphism.

---

# Abstract Class Constructor

An abstract class can have a constructor.

Example:

```java
abstract class Animal {

    Animal() {

        System.out.println("Animal constructor");
    }

    abstract void sound();
}
```

Child class:

```java
class Dog extends Animal {

    Dog() {

        System.out.println("Dog constructor");
    }

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

Now:

```java
Dog dog = new Dog();
```

Output:

```text
Animal constructor
Dog constructor
```

The abstract class constructor executes when the child object is created.

---

# Why Does an Abstract Class Need a Constructor?

Even though we cannot directly create an object of an abstract class, its constructor can initialize the part of the object that belongs to the abstract parent class.

When a child object is created:

```text
Dog Object
   ↓
Animal constructor
   ↓
Dog constructor
```

The parent portion is initialized first.

---

# Abstract Class with Variables

An abstract class can contain instance variables.

Example:

```java
abstract class Animal {

    String name = "Animal";

    abstract void sound();
}
```

Child class:

```java
class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

Now:

```java
Dog dog = new Dog();

System.out.println(dog.name);
```

Output:

```text
Animal
```

---

# Abstract Class with Static Methods

An abstract class can contain static methods.

Example:

```java
abstract class Animal {

    static void info() {

        System.out.println("Animals are living organisms");
    }

    abstract void sound();
}
```

The static method can be accessed using the class name:

```java
Animal.info();
```

An abstract class does not need to be instantiated to access its static method.

---

# Abstract Class with Final Methods

An abstract class can contain final methods.

Example:

```java
abstract class Animal {

    final void breathe() {

        System.out.println("Animal breathes");
    }

    abstract void sound();
}
```

A child class cannot override:

```java
breathe()
```

because it is final.

---

# Abstract Class Can Have No Abstract Methods

An abstract class does not necessarily have to contain an abstract method.

Example:

```java
abstract class Animal {

    void eat() {

        System.out.println("Animal eats");
    }
}
```

This is valid.

However, because the class is declared `abstract`, we still cannot directly create its object.

---

# Abstract Class Can Have Both Methods

Example:

```java
abstract class Animal {

    abstract void sound();

    void eat() {

        System.out.println("Animal eats");
    }
}
```

Here:

```text
sound()
 ↓
Abstract method

eat()
 ↓
Concrete method
```

This is one of the main advantages of abstract classes.

They can provide:

```text
Common implementation
+
Required implementation
```

---

# Child Class Must Implement Abstract Methods

Suppose:

```java
abstract class Animal {

    abstract void sound();
}
```

Then:

```java
class Dog extends Animal {

}
```

This is invalid because `Dog` has not implemented `sound()`.

Correct:

```java
class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

---

# Abstract Child Class

A child class can also remain abstract.

Example:

```java
abstract class Animal {

    abstract void sound();
}

abstract class Dog extends Animal {

}
```

This is valid.

Because `Dog` is also abstract, it does not have to implement `sound()` immediately.

A concrete subclass can implement it later:

```java
class Puppy extends Dog {

    @Override
    void sound() {

        System.out.println("Puppy barks");
    }
}
```

---

# Abstract Class and Inheritance

Abstract classes are commonly used as base classes.

Example:

```text
        Animal
       abstract
        /    \
       /      \
     Dog      Cat
```

`Animal` provides common behavior and defines methods that children must implement.

---

# Abstract Class and Runtime Polymorphism

Consider:

```java
abstract class Animal {

    abstract void sound();
}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {

        System.out.println("Cat meows");
    }
}
```

Now:

```java
Animal animal;

animal = new Dog();
animal.sound();

animal = new Cat();
animal.sound();
```

Output:

```text
Dog barks
Cat meows
```

The same abstract parent reference can refer to different child objects.

---

# Abstract Class vs Concrete Class

| Abstract Class                  | Concrete Class                  |
| ------------------------------- | ------------------------------- |
| Declared using `abstract`       | Normal class                    |
| Cannot be directly instantiated | Can be instantiated             |
| Can contain abstract methods    | Cannot contain abstract methods |
| Can contain concrete methods    | Contains concrete methods       |
| Can have constructors           | Can have constructors           |
| Can have variables              | Can have variables              |

---

# Abstract Class vs Interface

This is an important interview topic.

| Abstract Class                     | Interface                                   |
| ---------------------------------- | ------------------------------------------- |
| Declared using `abstract class`    | Declared using `interface`                  |
| Can have constructors              | Cannot have constructors                    |
| Can have instance variables        | Fields are implicitly `public static final` |
| Can have abstract methods          | Can declare abstract methods                |
| Can have concrete methods          | Can have default/static methods             |
| A class extends one abstract class | A class can implement multiple interfaces   |
| Supports single class inheritance  | Supports multiple interface implementation  |

---

# When Should We Use an Abstract Class?

Use an abstract class when:

- Classes have a strong IS-A relationship.
- They share common state.
- They share common implementation.
- Some methods should be common while others should be implemented by child classes.
- You want to provide a base class for related objects.

Example:

```text
Animal
  ↓
Dog
Cat
Lion
```

All are animals and may share common properties and behavior.

---

# Real-World Example

Consider a payment system.

```java
abstract class Payment {

    void validate() {

        System.out.println("Payment validated");
    }

    abstract void pay();
}
```

Different payment types can implement `pay()` differently.

```java
class UPI extends Payment {

    @Override
    void pay() {

        System.out.println("Payment through UPI");
    }
}

class CardPayment extends Payment {

    @Override
    void pay() {

        System.out.println("Payment through Card");
    }
}
```

Usage:

```java
Payment payment = new UPI();

payment.validate();
payment.pay();
```

Output:

```text
Payment validated
Payment through UPI
```

---

# Important Rules

### Rule 1

An abstract class cannot be instantiated directly.

```java
new Animal(); // Error
```

### Rule 2

An abstract class can have constructors.

### Rule 3

An abstract class can have abstract and concrete methods.

### Rule 4

An abstract method cannot have a body.

```java
abstract void sound();
```

### Rule 5

A concrete child class must implement all inherited abstract methods.

### Rule 6

An abstract child class does not have to implement all abstract methods.

### Rule 7

An abstract class can contain static and final members.

### Rule 8

An abstract class can be used as a reference type.

```java
Animal animal = new Dog();
```

---

# Common Mistakes

### Mistake 1

Trying to create an object of an abstract class.

```java
Animal animal = new Animal();
```

❌ Not allowed.

---

### Mistake 2

Thinking an abstract class can contain only abstract methods.

❌ Incorrect.

It can contain both:

```text
Abstract methods
Concrete methods
```

---

### Mistake 3

Thinking an abstract class cannot have a constructor.

❌ Incorrect.

Abstract classes can have constructors.

---

### Mistake 4

Thinking every abstract class must contain an abstract method.

❌ Incorrect.

An abstract class may contain zero abstract methods.

---

# Interview Questions

### 1. What is an abstract class?

**Answer:** An abstract class is a class declared using the `abstract` keyword that cannot be directly instantiated and can contain both abstract and concrete methods.

### 2. Can we create an object of an abstract class?

**Answer:** No, an abstract class cannot be directly instantiated.

### 3. Can an abstract class have a constructor?

**Answer:** Yes. Its constructor executes when an object of a concrete child class is created.

### 4. Can an abstract class contain concrete methods?

**Answer:** Yes.

### 5. Can an abstract class contain static methods?

**Answer:** Yes.

### 6. Can an abstract class contain final methods?

**Answer:** Yes.

### 7. Can an abstract class have no abstract methods?

**Answer:** Yes.

### 8. What happens if a child class doesn't implement an abstract method?

**Answer:** The child class must also be declared abstract; otherwise compilation fails.

### 9. Can we use an abstract class as a reference?

**Answer:** Yes.

Example:

```java
Animal animal = new Dog();
```

### 10. What is the main difference between an abstract class and an interface?

**Answer:** An abstract class is a class that can contain state, constructors, abstract methods, and concrete implementations, while an interface primarily defines a contract and allows a class to implement multiple interfaces.

---

# Interview Quick Revision

```text
Abstract Class
      │
      ├── Cannot create object directly
      │
      ├── Can have constructor
      │
      ├── Can have variables
      │
      ├── Can have abstract methods
      │
      ├── Can have concrete methods
      │
      ├── Can have static methods
      │
      └── Can have final methods
```

Remember:

```text
abstract class → cannot instantiate

abstract method → child must implement
                  (unless child is abstract)
```

---

# Summary

An abstract class provides a common base for related classes.

It can contain:

```text
Abstract methods
Concrete methods
Variables
Constructors
Static methods
Final methods
```

It cannot be instantiated directly.

Abstract classes are useful when we want to share common implementation while forcing child classes to provide specific behavior.

They are also commonly used with runtime polymorphism:

```java
Animal animal = new Dog();
```

The next related concept is **Interfaces**, which provide another way to achieve abstraction and support multiple interface implementation.
