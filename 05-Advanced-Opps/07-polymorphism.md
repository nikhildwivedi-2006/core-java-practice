# Polymorphism in Java

## Introduction

Polymorphism is an important Object-Oriented Programming concept.

The word polymorphism means:

```text
Poly → Many
Morph → Forms
```

Therefore:

```text
Polymorphism → One thing having many forms
```

In Java, polymorphism allows the same method name or reference to behave differently in different situations.

Java mainly supports two types of polymorphism:

```text
1. Compile-Time Polymorphism
2. Runtime Polymorphism
```

---

# Types of Polymorphism

```text
Polymorphism
     │
     ├── Compile-Time Polymorphism
     │       ↓
     │    Method Overloading
     │
     └── Runtime Polymorphism
             ↓
        Method Overriding
```

---

# 1. Compile-Time Polymorphism

Compile-time polymorphism is achieved mainly through **method overloading**.

Method overloading means having multiple methods with the same name but different parameter lists.

Example:

```java
class Calculator {

    int add(int a, int b) {

        return a + b;
    }

    int add(int a, int b, int c) {

        return a + b + c;
    }

    double add(double a, double b) {

        return a + b;
    }
}
```

Now:

```java
Calculator calculator = new Calculator();

calculator.add(10, 20);
calculator.add(10, 20, 30);
calculator.add(10.5, 20.5);
```

The compiler determines which method should be called based on the arguments.

Therefore it is called:

```text
Compile-Time Polymorphism
```

---

# Why is Method Overloading Compile-Time Polymorphism?

Consider:

```java
calculator.add(10, 20);
```

The compiler can determine during compilation that the following method should be used:

```java
add(int, int)
```

Similarly:

```java
calculator.add(10, 20, 30);
```

selects:

```java
add(int, int, int)
```

Therefore the method call is resolved at compile time.

---

# 2. Runtime Polymorphism

Runtime polymorphism is achieved through **method overriding**.

Method overriding occurs when a child class provides its own implementation of a method already defined in the parent class.

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

Now:

```java
Dog dog = new Dog();

dog.sound();
```

Output:

```text
Dog barks
```

---

# Runtime Polymorphism Using Parent Reference

The most important part of runtime polymorphism is:

```java
Parent reference = new Child();
```

Example:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Dog barks
```

Although the reference type is:

```text
Animal
```

the actual object is:

```text
Dog
```

Therefore, the overridden method in `Dog` executes.

---

# How Runtime Method Dispatch Works

Consider:

```java
Animal animal = new Dog();

animal.sound();
```

The JVM looks at the actual object:

```text
Reference Type
      ↓
    Animal

Object Type
      ↓
      Dog
```

For an overridden instance method, the JVM selects the implementation based on the actual object.

Therefore:

```text
animal.sound()
      ↓
Actual object = Dog
      ↓
Dog.sound()
```

This is called:

```text
Dynamic Method Dispatch
```

or:

```text
Runtime Method Dispatch
```

---

# Upcasting

When a child object is assigned to a parent reference, it is called **upcasting**.

Example:

```java
Animal animal = new Dog();
```

Here:

```text
Dog
 ↓
Animal
```

The child object is treated as a parent type.

Upcasting is commonly used to achieve runtime polymorphism.

---

# Example of Upcasting

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

public class PolymorphismExample {

    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.sound();
    }
}
```

Output:

```text
Dog barks
```

---

# Important Rule of Runtime Polymorphism

Remember:

```text
Reference Type
      ↓
Determines what members are accessible

Object Type
      ↓
Determines which overridden instance method executes
```

Example:

```java
Animal animal = new Dog();
```

The reference is `Animal`, so only members available through `Animal` can be accessed directly.

But for an overridden instance method:

```java
animal.sound();
```

the `Dog` implementation runs.

---

# Example: Parent Reference and Child-Specific Method

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

    void bark() {

        System.out.println("Bark");
    }
}
```

Now:

```java
Animal animal = new Dog();

animal.sound();   // Valid
animal.bark();    // Compile-time error
```

Why?

Because `animal` is an `Animal` reference.

The compiler only allows members available in the `Animal` type.

---

# Parent Reference with Child Object

```text
Animal animal = new Dog();
```

Think of it as:

```text
Reference
   ↓
Animal
   │
   └──────────► Dog Object
```

The reference controls accessibility.

The actual object controls overridden instance method execution.

---

# Static Methods and Polymorphism

This is a very important interview concept.

Static methods are associated with the **class**, not with an individual object.

Therefore:

```text
Static methods are NOT overridden.
```

If a child class defines a static method with the same signature as the parent class, it is called:

```text
Method Hiding
```

not method overriding.

---

# Static Method Example

```java
class Parent {

    static void show() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void show() {

        System.out.println("Child");
    }
}
```

Now:

```java
Parent obj = new Child();

obj.show();
```

Output:

```text
Parent
```

Why?

Because static method calls are resolved using the **reference type**, not the actual object type.

Here:

```text
Reference Type → Parent
Object Type    → Child
```

Therefore:

```text
Parent.show()
```

is called.

---

# Static Method Hiding

Consider:

```java
Parent obj = new Child();

obj.show();
```

For static methods:

```text
Reference Type
      ↓
    Parent
      ↓
Parent.show()
```

The child object does not cause dynamic dispatch for static methods.

---

# Compare Instance Method and Static Method

## Instance Method

```java
class Parent {

    void show() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void show() {

        System.out.println("Child");
    }
}
```

Then:

```java
Parent obj = new Child();

obj.show();
```

Output:

```text
Child
```

Because instance methods support runtime overriding.

---

## Static Method

```java
class Parent {

    static void show() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void show() {

        System.out.println("Child");
    }
}
```

Then:

```java
Parent obj = new Child();

obj.show();
```

Output:

```text
Parent
```

Because static methods are hidden, not overridden.

---

# Golden Rule

Remember this:

```text
Instance Method
       ↓
Overridden
       ↓
Object decides
       ↓
Runtime Polymorphism
```

Whereas:

```text
Static Method
       ↓
Method Hiding
       ↓
Reference/Class decides
```

---

# Fields and Polymorphism

Instance variables/fields are also not overridden like methods.

Consider:

```java
class Parent {

    int value = 10;
}

class Child extends Parent {

    int value = 20;
}
```

Now:

```java
Parent obj = new Child();

System.out.println(obj.value);
```

Output:

```text
10
```

The field is accessed according to the reference type.

Therefore:

```text
Parent obj
   ↓
Parent.value
```

---

# Instance Method vs Field

Consider:

```java
class Parent {

    int value = 10;

    void show() {

        System.out.println("Parent method");
    }
}

class Child extends Parent {

    int value = 20;

    @Override
    void show() {

        System.out.println("Child method");
    }
}
```

Now:

```java
Parent obj = new Child();

System.out.println(obj.value);
obj.show();
```

Output:

```text
10
Child method
```

This is a very important difference.

```text
Field
 ↓
Reference type

Overridden instance method
 ↓
Actual object type
```

---

# Polymorphism and final Methods

A `final` method cannot be overridden.

Example:

```java
class Parent {

    final void show() {

        System.out.println("Parent");
    }
}
```

The child cannot do:

```java
@Override
void show() {

}
```

because the method is final.

Therefore runtime overriding is not possible for a final method.

---

# Polymorphism and Private Methods

Private methods are not inherited in the normal overriding sense.

Therefore, a child class cannot override a parent's private method.

Example:

```java
class Parent {

    private void show() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    void show() {

        System.out.println("Child");
    }
}
```

The `show()` method in `Child` is not an override of the parent's private method.

---

# Method Overloading vs Method Overriding

| Method Overloading        | Method Overriding                  |
| ------------------------- | ---------------------------------- |
| Compile-time polymorphism | Runtime polymorphism               |
| Same class commonly used  | Parent-child relationship required |
| Same method name          | Same method signature              |
| Parameters must differ    | Parameters must match              |
| Resolved at compile time  | Resolved at runtime                |
| Inheritance not required  | Inheritance required               |

---

# Example: Both Together

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

    void eat() {

        System.out.println("Dog eats");
    }

    void eat(String food) {

        System.out.println("Dog eats " + food);
    }
}
```

Here:

```text
sound()
 ↓
Overriding
 ↓
Runtime Polymorphism
```

And:

```text
eat()
eat(String)
 ↓
Overloading
 ↓
Compile-Time Polymorphism
```

---

# Real-World Example

Suppose we have:

```java
class Payment {

    void pay() {

        System.out.println("Payment");
    }
}

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
Payment through UPI
Payment through Card
```

The same reference type:

```java
Payment
```

can refer to different objects and produce different behavior.

This is polymorphism.

---

# Advantages of Polymorphism

- Provides flexibility.
- Supports loose coupling.
- Makes code extensible.
- Allows common parent references for different child objects.
- Helps implement clean object-oriented designs.
- Runtime polymorphism makes it easier to add new child implementations.

---

# Common Mistakes

### Mistake 1

Thinking static methods are overridden.

❌ Static methods are hidden, not overridden.

---

### Mistake 2

Thinking fields participate in runtime polymorphism.

❌ Fields are accessed based on the reference type.

---

### Mistake 3

Thinking every method call uses the object type.

Not always.

For overridden instance methods:

```text
Object type
```

matters.

For static methods:

```text
Reference/class type
```

matters.

---

### Mistake 4

Thinking method overloading is runtime polymorphism.

❌ Overloading is compile-time polymorphism.

---

# Interview Questions

### 1. What is polymorphism?

**Answer:** Polymorphism is the ability of one interface/reference or method name to represent different forms of behavior.

### 2. What are the types of polymorphism in Java?

**Answer:**

```text
Compile-time polymorphism → Method overloading

Runtime polymorphism → Method overriding
```

### 3. What is runtime polymorphism?

**Answer:** Runtime polymorphism occurs when an overridden instance method is selected based on the actual object at runtime.

### 4. What is dynamic method dispatch?

**Answer:** It is the mechanism by which Java determines at runtime which overridden instance method implementation should execute.

### 5. What is upcasting?

**Answer:** Assigning a child object to a parent reference is called upcasting.

Example:

```java
Animal animal = new Dog();
```

### 6. Can static methods be overridden?

**Answer:** No. Static methods are hidden when a child defines a static method with the same signature.

### 7. What happens with a static method in `Parent obj = new Child()`?

**Answer:** The static method is resolved using the reference type, so the parent's static method is called.

### 8. Are fields polymorphic?

**Answer:** No. Fields are accessed according to the reference type.

### 9. Can final methods be overridden?

**Answer:** No. A final method cannot be overridden.

### 10. Can private methods be overridden?

**Answer:** No. Private methods are not inherited in the normal overriding sense and therefore cannot be overridden.

---

# Interview Quick Revision

```text
POLYMORPHISM
     │
     ├── Compile Time
     │      ↓
     │   Overloading
     │
     └── Runtime
            ↓
        Overriding
```

### Most Important:

```text
Parent obj = new Child();
```

For an overridden **instance method**:

```text
Child method → runs
```

For a **static method**:

```text
Parent static method → runs
```

For a **field**:

```text
Parent field → accessed
```

So remember:

```text
Overridden Instance Method
        ↓
Actual Object

Static Method
        ↓
Reference/Class

Field
        ↓
Reference Type
```

---

# Summary

Polymorphism allows the same method name or reference to behave differently in different situations.

Java mainly provides:

```text
Compile-Time Polymorphism
        ↓
Method Overloading

Runtime Polymorphism
        ↓
Method Overriding
```

Runtime polymorphism commonly uses:

```java
Parent reference = new Child();
```

For overridden instance methods, Java uses the actual object to determine which implementation executes.

However, static methods are not overridden; they are hidden and resolved according to the reference/class type.

Fields also do not participate in runtime method dispatch and are accessed according to the reference type.
