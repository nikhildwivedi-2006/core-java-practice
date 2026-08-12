# Object Class in Java

## Introduction

`Object` is the root class of the Java class hierarchy.

Every class in Java directly or indirectly inherits from the `Object` class.

Therefore, every Java object gets access to the methods provided by the `Object` class.

Example:

```java
class Student {

}
```

Although we did not explicitly write:

```java
extends Object
```

Java internally treats it as:

```java
class Student extends Object {

}
```

---

# Object Class Hierarchy

The basic hierarchy looks like:

```text
                    Object
                      │
              ┌───────┴───────┐
              │               │
           Student         Employee
              │
          Other Classes
```

For example:

```java
class Student {

}
```

is conceptually:

```java
class Student extends Object {

}
```

---

# Why is Object Class Important?

Because all Java classes inherit from `Object`, common methods are available to every object.

Some important methods are:

```text
Object
 │
 ├── toString()
 ├── equals()
 ├── hashCode()
 ├── getClass()
 ├── clone()
 ├── wait()
 ├── notify()
 └── notifyAll()
```

We will focus mainly on the methods commonly used in normal Java development and interviews.

---

# 1. toString()

The `toString()` method returns a string representation of an object.

Example:

```java
class Student {

    String name;

    Student(String name) {

        this.name = name;
    }
}
```

Now:

```java
Student student = new Student("Nikhil");

System.out.println(student.toString());
```

If we do not override `toString()`, the output is generally based on the object's class name and hash-related representation.

---

# Overriding toString()

We can provide a meaningful representation by overriding `toString()`.

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        return "Student{name='" + name + "', age=" + age + "}";
    }
}
```

Now:

```java
Student student = new Student("Nikhil", 20);

System.out.println(student);
```

Output:

```text
Student{name='Nikhil', age=20}
```

---

# Why Does println(student) Call toString()?

When an object is passed to:

```java
System.out.println(student);
```

Java uses the object's string representation.

Conceptually:

```java
System.out.println(student.toString());
```

Therefore, overriding `toString()` makes object output more readable.

---

# 2. equals()

The `equals()` method is used to compare objects.

Example:

```java
Student student1 = new Student("Nikhil");
Student student2 = new Student("Nikhil");
```

These are two different objects.

By default, `Object.equals()` compares object identity.

Therefore:

```java
student1.equals(student2);
```

may return:

```text
false
```

even though their data is the same.

---

# Overriding equals()

If we want two students with the same data to be considered equal, we can override `equals()`.

Example:

```java
import java.util.Objects;

class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return age == other.age &&
               Objects.equals(name, other.name);
    }
}
```

Now:

```java
Student student1 = new Student("Nikhil", 20);
Student student2 = new Student("Nikhil", 20);

System.out.println(student1.equals(student2));
```

Output:

```text
true
```

---

# 3. hashCode()

The `hashCode()` method returns an integer hash value representing the object.

Example:

```java
Student student = new Student("Nikhil", 20);

System.out.println(student.hashCode());
```

The exact integer value is not something we normally depend on.

---

# Relationship Between equals() and hashCode()

This is a very important Java rule.

If two objects are equal according to:

```java
equals()
```

then they must return the same:

```java
hashCode()
```

Example:

```text
student1.equals(student2)
        ↓
       true
        ↓
student1.hashCode()
        =
student2.hashCode()
```

However, two objects having the same hash code do not necessarily have to be equal.

---

# Why is hashCode() Important?

`hashCode()` is especially important when objects are used in hash-based collections such as:

```java
HashMap
HashSet
Hashtable
```

If we override `equals()`, we should normally override `hashCode()` consistently as well.

---

# Example of equals() and hashCode()

```java
import java.util.Objects;

class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return age == other.age &&
               Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
```

Now the `equals()` and `hashCode()` implementations are consistent.

---

# 4. getClass()

The `getClass()` method returns the runtime class of an object.

Example:

```java
Student student = new Student("Nikhil", 20);

System.out.println(student.getClass());
```

Output will contain:

```text
class Student
```

We can also get the class name:

```java
System.out.println(student.getClass().getName());
```

---

# 5. clone()

The `clone()` method is related to creating a copy of an object.

The class generally needs to implement:

```java
Cloneable
```

to support the conventional use of `Object.clone()`.

Example:

```java
class Student implements Cloneable {

    String name;

    Student(String name) {

        this.name = name;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {

        return (Student) super.clone();
    }
}
```

Usage:

```java
Student student1 = new Student("Nikhil");

Student student2 = student1.clone();
```

The details of cloning, shallow copy, and deep copy are more advanced topics and can be covered separately when needed.

---

# 6. wait(), notify(), and notifyAll()

These methods are related to **thread synchronization and inter-thread communication**.

They are inherited from `Object`.

```text
wait()
notify()
notifyAll()
```

These methods are generally used with synchronization and should not be called casually.

They will be covered in detail in the multithreading/concurrency section.

---

# Important Object Class Methods

| Method        | Purpose                                                             |
| ------------- | ------------------------------------------------------------------- |
| `toString()`  | Returns a string representation of an object                        |
| `equals()`    | Compares objects for logical equality when overridden appropriately |
| `hashCode()`  | Returns a hash value used by hash-based collections                 |
| `getClass()`  | Returns the runtime class of the object                             |
| `clone()`     | Supports object copying under the appropriate conditions            |
| `wait()`      | Causes the current thread to wait                                   |
| `notify()`    | Wakes one waiting thread                                            |
| `notifyAll()` | Wakes waiting threads                                               |

---

# == vs equals()

This is a very common interview question.

## `==`

For object references:

```java
student1 == student2
```

checks whether both references refer to the **same object**.

## equals()

```java
student1.equals(student2)
```

is used for logical equality according to the class's `equals()` implementation.

Example:

```text
student1 ──────► Student Object A
student2 ──────► Student Object B
```

If both objects contain the same data:

```java
student1 == student2
```

can still be:

```text
false
```

while an appropriately overridden:

```java
student1.equals(student2)
```

can be:

```text
true
```

---

# Example

```java
Student student1 = new Student("Nikhil", 20);
Student student2 = new Student("Nikhil", 20);

System.out.println(student1 == student2);
System.out.println(student1.equals(student2));
```

Possible output with a properly overridden `equals()`:

```text
false
true
```

Why?

Because they are two different objects, but their data is considered equal.

---

# Important Rule

Remember the relationship:

```text
equals() → logical equality

==       → same reference / same object
```

for object references.

---

# Object Class and Inheritance

Every normal Java class ultimately inherits from `Object`.

Example:

```java
class Animal {

}
```

and:

```java
class Dog extends Animal {

}
```

The hierarchy becomes:

```text
Object
   │
   ▼
Animal
   │
   ▼
Dog
```

Therefore, `Dog` also gets methods from `Object`.

---

# Common Mistakes

### Mistake 1: Thinking == compares object data

For object references:

```java
student1 == student2
```

checks whether both references point to the same object.

---

### Mistake 2: Overriding equals() but not hashCode()

If a class overrides `equals()`, it should also provide a consistent `hashCode()` implementation.

---

### Mistake 3: Thinking hashCode() is a unique ID

A hash code is not guaranteed to be unique.

Different objects can have the same hash code.

---

### Mistake 4: Thinking every class must explicitly write extends Object

This is unnecessary.

```java
class Student {

}
```

already inherits from `Object` indirectly.

---

# Interview Questions

### 1. What is the Object class?

**Answer:** `Object` is the root class of the Java class hierarchy. Every class directly or indirectly inherits from it.

### 2. Why is Object class important?

**Answer:** It provides common methods that are available to all Java objects.

### 3. What is the difference between == and equals()?

**Answer:** For object references, `==` checks whether two references refer to the same object, while `equals()` is used for logical equality according to its implementation.

### 4. Why should hashCode() be overridden when equals() is overridden?

**Answer:** Equal objects must have the same hash code, especially for correct behavior in hash-based collections.

### 5. What does toString() do?

**Answer:** It returns a string representation of an object.

### 6. What does getClass() return?

**Answer:** It returns the runtime class of the object.

### 7. Is Object the parent of every Java class?

**Answer:** Yes, every Java class directly or indirectly inherits from `Object`.

---

# Interview Tip 💡

Remember these four first:

```text
toString()
    ↓
Object → String representation

equals()
    ↓
Object → Logical equality

hashCode()
    ↓
Object → Hash value

getClass()
    ↓
Object → Runtime class
```

And the golden rule:

```text
Every Java class
      ↓
inherits from Object
      ↓
directly or indirectly
```

---

# Summary

`Object` is the root class of the Java class hierarchy. Every Java class directly or indirectly inherits from it.

Important methods include:

```text
toString()
equals()
hashCode()
getClass()
clone()
wait()
notify()
notifyAll()
```

Understanding `Object`, `equals()`, `hashCode()`, and `toString()` is especially important when working with Java collections and object-oriented programming.

---

## Related Topics

- Inheritance
- Polymorphism
- `this` and `super`
- HashMap and HashSet
- Collections Framework
- Multithreading
