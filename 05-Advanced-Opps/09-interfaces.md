# Interfaces in Java

## Introduction

An interface is a blueprint or contract that defines behavior that implementing classes must provide.

An interface is declared using the:

```java
interface
```

keyword.

A class uses the:

```java
implements
```

keyword to implement an interface.

---

# Basic Syntax

```java
interface Animal {

    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {

        System.out.println("Dog barks");
    }
}
```

Here:

```text
Animal → Interface
Dog    → Implementing class
```

---

# Why Do We Need Interfaces?

Interfaces are mainly used for:

- Abstraction
- Loose coupling
- Defining contracts
- Achieving multiple interface implementation
- Supporting flexible and extensible designs

For example, different payment methods can follow the same contract:

```text
Payment
   │
   ├── UPI
   ├── Card
   └── Net Banking
```

Each payment method can implement the `pay()` behavior differently.

---

# Simple Example

```java
interface Payment {

    void pay();
}
```

Implementation:

```java
class UPI implements Payment {

    @Override
    public void pay() {

        System.out.println("Payment through UPI");
    }
}
```

Usage:

```java
Payment payment = new UPI();

payment.pay();
```

Output:

```text
Payment through UPI
```

---

# Interface Methods

Traditionally, interface methods are abstract by default.

Example:

```java
interface Animal {

    void sound();
}
```

The method:

```java
void sound();
```

is implicitly:

```java
public abstract void sound();
```

Therefore, an implementing class must provide the implementation.

---

# public Requirement

Interface abstract methods are implicitly `public`.

Therefore, the implementing method cannot reduce the visibility.

Correct:

```java
interface Animal {

    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {

        System.out.println("Dog barks");
    }
}
```

Incorrect:

```java
class Dog implements Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

The method in `Dog` is package-private, which is weaker than `public`.

This causes a compilation error.

---

# Interface Variables

Variables declared inside an interface are implicitly:

```text
public
static
final
```

Example:

```java
interface Constants {

    int MAX_VALUE = 100;
}
```

This is effectively:

```java
public static final int MAX_VALUE = 100;
```

Therefore, interface variables are constants.

We can access them using:

```java
System.out.println(Constants.MAX_VALUE);
```

---

# Interface Variables Cannot Be Changed

Because interface fields are `final`:

```java
interface Constants {

    int MAX_VALUE = 100;
}
```

This is invalid:

```java
Constants.MAX_VALUE = 200;
```

because the variable is final.

---

# Multiple Interface Implementation

One of the biggest advantages of interfaces is that a class can implement multiple interfaces.

Example:

```java
interface Printable {

    void print();
}

interface Showable {

    void show();
}

class Document implements Printable, Showable {

    @Override
    public void print() {

        System.out.println("Printing");
    }

    @Override
    public void show() {

        System.out.println("Showing");
    }
}
```

Here:

```java
class Document implements Printable, Showable
```

The class implements two interfaces.

This is how Java supports multiple inheritance of type/behavior through interfaces.

---

# Interface Reference

An interface can be used as a reference type.

Example:

```java
interface Animal {

    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {

        System.out.println("Dog barks");
    }
}
```

Now:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Dog barks
```

This is runtime polymorphism.

---

# Interface and Runtime Polymorphism

Consider:

```java
interface Payment {

    void pay();
}

class UPI implements Payment {

    @Override
    public void pay() {

        System.out.println("UPI Payment");
    }
}

class CardPayment implements Payment {

    @Override
    public void pay() {

        System.out.println("Card Payment");
    }
}
```

Now:

```java
Payment payment;

payment = new UPI();
payment.pay();

payment = new CardPayment();
payment.pay();
```

Output:

```text
UPI Payment
Card Payment
```

The same interface reference can refer to different implementations.

---

# Default Methods

Modern Java interfaces can contain `default` methods with an implementation.

Example:

```java
interface Animal {

    void sound();

    default void eat() {

        System.out.println("Animal eats");
    }
}
```

A class implementing the interface automatically gets the default implementation.

```java
class Dog implements Animal {

    @Override
    public void sound() {

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

---

# Why Were Default Methods Introduced?

Default methods allow developers to add new behavior to existing interfaces without forcing every existing implementing class to immediately implement the new method.

This helps maintain backward compatibility.

---

# Overriding a Default Method

A class can override a default method.

Example:

```java
interface Animal {

    default void eat() {

        System.out.println("Animal eats");
    }
}

class Dog implements Animal {

    @Override
    public void eat() {

        System.out.println("Dog eats");
    }
}
```

Now:

```java
Dog dog = new Dog();

dog.eat();
```

Output:

```text
Dog eats
```

---

# Static Methods in Interfaces

Interfaces can contain static methods.

Example:

```java
interface Utility {

    static void show() {

        System.out.println("Utility method");
    }
}
```

A static interface method is accessed using the interface name:

```java
Utility.show();
```

It is not inherited by implementing classes in the same way as instance methods.

Therefore, this is not the correct way:

```java
Dog.show();
```

Use:

```java
Utility.show();
```

---

# Private Methods in Interfaces

Modern Java interfaces can also contain private methods.

Private methods can be used internally by default or static methods of the interface.

Example:

```java
interface Utility {

    default void show() {

        helper();
    }

    private void helper() {

        System.out.println("Helper method");
    }
}
```

The private method is not accessible from implementing classes.

---

# Interface Cannot Have Constructors

An interface cannot have a constructor.

Example:

```java
interface Animal {

    Animal() {

    }
}
```

This is invalid.

Why?

Because interfaces cannot be directly instantiated.

---

# Interface Cannot Be Instantiated

This is invalid:

```java
Animal animal = new Animal();
```

An interface does not have a direct object.

Instead:

```java
Animal animal = new Dog();
```

where `Dog` implements `Animal`.

---

# Interface Inheritance

An interface can extend another interface using:

```java
extends
```

Example:

```java
interface Animal {

    void eat();
}

interface Dog extends Animal {

    void bark();
}
```

Now a class implementing `Dog` must implement both methods:

```java
class Puppy implements Dog {

    @Override
    public void eat() {

        System.out.println("Eating");
    }

    @Override
    public void bark() {

        System.out.println("Barking");
    }
}
```

---

# Multiple Interface Inheritance

An interface can extend multiple interfaces.

Example:

```java
interface A {

    void methodA();
}

interface B {

    void methodB();
}

interface C extends A, B {

    void methodC();
}
```

This is valid.

Therefore:

```text
Interface C
   ↑     ↑
   A     B
```

An interface can extend multiple interfaces.

---

# Class + Interface

A class can extend one class and implement multiple interfaces.

Example:

```java
class Dog extends Animal implements Runnable, Serializable {

}
```

Conceptually:

```text
           Animal
              ↑
              |
             Dog
            /   \
           ↑     ↑
      Runnable Serializable
```

Important rule:

```text
One class → can extend only one class

One class → can implement multiple interfaces
```

---

# Interface vs Abstract Class

| Interface                              | Abstract Class                              |
| -------------------------------------- | ------------------------------------------- |
| Declared using `interface`             | Declared using `abstract class`             |
| Implemented using `implements`         | Extended using `extends`                    |
| Cannot have constructors               | Can have constructors                       |
| Fields are `public static final`       | Can have normal instance variables          |
| Can have abstract methods              | Can have abstract methods                   |
| Can have default methods               | Can have concrete methods                   |
| Can have static methods                | Can have static methods                     |
| Can have private methods               | Can have private methods                    |
| Multiple interfaces can be implemented | Only one class can be extended              |
| Mainly represents a contract           | Can provide shared state and implementation |

---

# Interface vs Inheritance

Inheritance:

```java
class Dog extends Animal
```

represents:

```text
IS-A relationship
```

Example:

```text
Dog IS-A Animal
```

Interface:

```java
class Dog implements Runnable
```

represents that the class agrees to provide the behavior defined by the interface.

For example:

```text
Dog CAN RUN
```

Interfaces are useful for defining capabilities or contracts.

---

# Real-World Example

Consider a notification system.

```java
interface Notification {

    void send();
}
```

Different implementations:

```java
class EmailNotification implements Notification {

    @Override
    public void send() {

        System.out.println("Sending Email");
    }
}

class SMSNotification implements Notification {

    @Override
    public void send() {

        System.out.println("Sending SMS");
    }
}
```

Now:

```java
Notification notification;

notification = new EmailNotification();
notification.send();

notification = new SMSNotification();
notification.send();
```

Output:

```text
Sending Email
Sending SMS
```

The application depends on the interface rather than a specific implementation.

This helps achieve loose coupling.

---

# Interface and Loose Coupling

Instead of:

```java
EmailNotification notification =
        new EmailNotification();
```

we can use:

```java
Notification notification =
        new EmailNotification();
```

Now the code depends on:

```text
Notification
```

rather than directly depending on:

```text
EmailNotification
```

Later we can replace it with:

```java
notification = new SMSNotification();
```

without changing the reference type.

---

# Functional Interface

An interface with exactly one abstract method is called a **functional interface**.

Example:

```java
@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);
}
```

It can be used with a lambda expression:

```java
Calculator calculator =
        (a, b) -> a + b;

System.out.println(calculator.calculate(10, 20));
```

Output:

```text
30
```

Functional interfaces and lambda expressions will be covered in more detail in the advanced Java section.

---

# Common Mistakes

### Mistake 1

Trying to create an interface object.

```java
new Animal();
```

❌ Not allowed.

---

### Mistake 2

Using `extends` when implementing an interface.

Incorrect:

```java
class Dog extends AnimalInterface
```

Correct:

```java
class Dog implements AnimalInterface
```

---

### Mistake 3

Forgetting `public` when implementing an interface method.

Interface methods are public by default.

Correct:

```java
public void sound() {

}
```

---

### Mistake 4

Trying to modify an interface variable.

Interface fields are:

```text
public static final
```

Therefore they cannot be changed.

---

### Mistake 5

Trying to access an interface static method through an object.

Use:

```java
InterfaceName.method();
```

---

# Interview Questions

### 1. What is an interface?

**Answer:** An interface is a contract that defines behavior that implementing classes must provide.

### 2. Which keyword is used to implement an interface?

**Answer:**

```java
implements
```

### 3. Can a class implement multiple interfaces?

**Answer:** Yes.

Example:

```java
class Dog implements A, B {

}
```

### 4. Can an interface extend another interface?

**Answer:** Yes, using `extends`.

### 5. Can an interface extend multiple interfaces?

**Answer:** Yes.

```java
interface C extends A, B {

}
```

### 6. Can an interface have a constructor?

**Answer:** No.

### 7. Can an interface have variables?

**Answer:** Yes. Interface fields are implicitly:

```text
public static final
```

### 8. Can an interface have concrete methods?

**Answer:** Yes. Modern Java interfaces can have `default` and `static` methods, and also private helper methods.

### 9. Can we create an object of an interface?

**Answer:** No, but an interface can be used as a reference type.

```java
Animal animal = new Dog();
```

### 10. Why does Java use interfaces?

**Answer:** Interfaces provide abstraction, contracts, loose coupling, and support multiple interface implementation.

---

# Important Rules

```text
Class
  ↓
extends
  ↓
One class only

Class
  ↓
implements
  ↓
Multiple interfaces

Interface
  ↓
extends
  ↓
Multiple interfaces
```

Remember:

```text
class → extends → class

class → implements → interface

interface → extends → interface
```

---

# Quick Revision

```text
INTERFACE
    │
    ├── Contract
    │
    ├── No constructor
    │
    ├── Cannot instantiate directly
    │
    ├── Fields → public static final
    │
    ├── Abstract methods
    │
    ├── default methods
    │
    ├── static methods
    │
    └── private methods
```

Most important:

```java
interface Payment {

    void pay();
}

class UPI implements Payment {

    @Override
    public void pay() {

        System.out.println("UPI Payment");
    }
}
```

And:

```java
Payment payment = new UPI();
```

This demonstrates:

```text
Interface
   ↓
Abstraction
   ↓
Runtime Polymorphism
   ↓
Loose Coupling
```

---

# Summary

An interface defines a contract that implementing classes must follow.

Interfaces are useful for:

- Abstraction
- Loose coupling
- Multiple interface implementation
- Runtime polymorphism
- Defining common capabilities

A class can implement multiple interfaces:

```java
class MyClass implements A, B, C
```

An interface can extend multiple interfaces:

```java
interface C extends A, B
```

A class can extend only one class:

```java
class Child extends Parent
```

The key rule is:

```text
extends → class inheritance

implements → class implementing interface

extends → interface inheritance
```

Interfaces are one of the most important concepts in Java and are heavily used in real-world frameworks such as Spring.
