# Constructor Chaining in Java

## Introduction

Constructor chaining is the process of calling one constructor from another constructor.

It helps us reuse constructor code and ensures that constructors execute in a proper sequence.

Constructor chaining can happen in two ways:

```text
Same Class
    ↓
this()

Parent Class
    ↓
super()
```

---

# Why Do We Need Constructor Chaining?

Suppose a class has multiple constructors:

```java
class Student {

    Student() {
        System.out.println("Default constructor");
    }

    Student(String name) {
        System.out.println("Name: " + name);
    }
}
```

There may be repeated initialization logic.

Constructor chaining allows one constructor to call another instead of duplicating code.

---

# Constructor Chaining Using this()

`this()` is used to call another constructor of the **same class**.

Example:

```java
class Student {

    Student() {

        this("Unknown");
        System.out.println("Default constructor");
    }

    Student(String name) {

        System.out.println("Name: " + name);
    }
}
```

When:

```java
Student student = new Student();
```

is executed:

```text
new Student()
      ↓
Student()
      ↓
this("Unknown")
      ↓
Student(String)
      ↓
back to Student()
```

Output:

```text
Name: Unknown
Default constructor
```

---

# Important Rule of this()

When using `this()` inside a constructor:

```text
this()
must be the first statement
```

Correct:

```java
Student() {

    this("Unknown");

    System.out.println("Constructor");
}
```

Incorrect:

```java
Student() {

    System.out.println("Constructor");

    this("Unknown");
}
```

The second example causes a compilation error.

---

# Constructor Chaining with Multiple Constructors

Constructor chaining can involve multiple constructors.

Example:

```java
class Student {

    String name;
    int age;
    String course;

    Student() {

        this("Unknown");
    }

    Student(String name) {

        this(name, 0);
    }

    Student(String name, int age) {

        this(name, age, "Not Assigned");
    }

    Student(String name, int age, String course) {

        this.name = name;
        this.age = age;
        this.course = course;
    }
}
```

Now:

```java
Student student = new Student();
```

creates the following chain:

```text
Student()
   ↓
this("Unknown")
   ↓
Student(String)
   ↓
this(name, 0)
   ↓
Student(String, int)
   ↓
this(name, age, "Not Assigned")
   ↓
Student(String, int, String)
```

This avoids repeating initialization code.

---

# Constructor Chaining Using super()

`super()` is used to call the constructor of the **immediate parent class**.

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

When:

```java
Dog dog = new Dog();
```

is executed:

```text
Dog()
 ↓
super()
 ↓
Animal()
```

Output:

```text
Animal constructor
Dog constructor
```

---

# Why Does Parent Constructor Execute First?

When an object of a child class is created, the parent part of the object must be initialized before the child-specific part.

Therefore:

```text
Child Object Creation
        ↓
Parent Constructor
        ↓
Child Constructor
```

This ensures that parent class initialization happens before child class initialization.

---

# Implicit super()

If a child constructor does not explicitly call `super()`, Java automatically inserts a call to the no-argument constructor of the immediate parent class.

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

Java conceptually treats the child constructor as:

```java
Dog() {

    super();

    System.out.println("Dog constructor");
}
```

Output:

```text
Animal constructor
Dog constructor
```

---

# Important Condition for Implicit super()

Implicit `super()` works only when the parent class has an accessible no-argument constructor.

Example:

```java
class Animal {

    Animal(String name) {

        System.out.println(name);
    }
}
```

Now:

```java
class Dog extends Animal {

    Dog() {

        System.out.println("Dog");
    }
}
```

This causes a compilation error because Java tries to insert:

```java
super();
```

but `Animal` does not have a no-argument constructor.

---

# Correct Way

The child constructor must explicitly call the available parent constructor.

```java
class Animal {

    Animal(String name) {

        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {

    Dog() {

        super("Animal");

        System.out.println("Dog constructor");
    }
}
```

Output:

```text
Animal: Animal
Dog constructor
```

---

# this() vs super()

| `this()`                                     | `super()`                                        |
| -------------------------------------------- | ------------------------------------------------ |
| Calls another constructor of the same class. | Calls constructor of the immediate parent class. |
| Used for same-class constructor chaining.    | Used for parent-child constructor chaining.      |
| Must be the first statement.                 | Must be the first statement.                     |
| Helps reuse constructor logic.               | Helps initialize the parent class.               |

Remember:

```text
this()
 ↓
Same Class

super()
 ↓
Parent Class
```

---

# Can this() and super() Be Used Together?

No, they cannot both be used as constructor-invocation statements in the same constructor.

Reason:

Both must be the **first statement**.

For example:

```java
Student() {

    this("Unknown");

    super();
}
```

This is invalid.

A constructor can directly start with either:

```java
this();
```

or:

```java
super();
```

but not both.

---

# Constructor Chaining in Inheritance

Consider:

```java
class Animal {

    Animal() {

        System.out.println("Animal");
    }
}

class Dog extends Animal {

    Dog() {

        System.out.println("Dog");
    }
}

class Puppy extends Dog {

    Puppy() {

        System.out.println("Puppy");
    }
}
```

Now:

```java
Puppy puppy = new Puppy();
```

The constructor execution order is:

```text
Puppy()
   ↓
Dog()
   ↓
Animal()
```

Output:

```text
Animal
Dog
Puppy
```

The constructors execute from the topmost parent toward the child.

---

# Constructor Execution Order

For:

```text
Object
   ↓
Animal
   ↓
Dog
   ↓
Puppy
```

When:

```java
new Puppy();
```

is executed:

```text
Object constructor
       ↓
Animal constructor
       ↓
Dog constructor
       ↓
Puppy constructor
```

So initialization proceeds from **parent to child**.

---

# Constructor Chaining Example

```java
class Person {

    String name;

    Person(String name) {

        this.name = name;

        System.out.println("Person constructor");
    }
}

class Student extends Person {

    int rollNo;

    Student(String name, int rollNo) {

        super(name);

        this.rollNo = rollNo;

        System.out.println("Student constructor");
    }
}

public class ConstructorChainingExample {

    public static void main(String[] args) {

        Student student = new Student("Nikhil", 101);

        System.out.println("Name: " + student.name);
        System.out.println("Roll No: " + student.rollNo);
    }
}
```

Output:

```text
Person constructor
Student constructor
Name: Nikhil
Roll No: 101
```

---

# Constructor Chaining Flow

For:

```java
new Student("Nikhil", 101);
```

the flow is:

```text
Student constructor
       ↓
super("Nikhil")
       ↓
Person constructor
       ↓
return to Student constructor
       ↓
initialize rollNo
       ↓
Student constructor completes
```

---

# Important Rules

### Rule 1

`this()` calls another constructor of the same class.

### Rule 2

`super()` calls the constructor of the immediate parent class.

### Rule 3

`this()` must be the first statement of a constructor.

### Rule 4

`super()` must be the first statement of a constructor.

### Rule 5

If neither `this()` nor `super()` is explicitly written, Java attempts to insert:

```java
super();
```

### Rule 6

Implicit `super()` requires an accessible no-argument parent constructor.

### Rule 7

A constructor cannot directly use both `this()` and `super()`.

---

# Common Mistakes

### Mistake 1

Thinking `this()` calls a method.

❌ Incorrect.

```java
this();
```

calls another constructor of the same class.

---

### Mistake 2

Thinking `super()` calls any parent method.

❌ Incorrect.

```java
super();
```

calls the parent constructor.

For a parent method:

```java
super.methodName();
```

is used.

---

### Mistake 3

Putting this() after another statement.

```java
Student() {

    System.out.println("Hello");

    this("Nikhil");
}
```

❌ Compilation error.

---

### Mistake 4

Assuming child constructor executes before parent constructor.

❌ Incorrect.

Parent constructor executes first.

---

# Interview Questions

### 1. What is constructor chaining?

**Answer:** Constructor chaining is the process of calling one constructor from another constructor to reuse initialization logic and maintain a proper constructor execution sequence.

### 2. How can constructor chaining happen?

**Answer:**

```text
Same class → this()

Parent class → super()
```

### 3. What is the difference between this() and super()?

**Answer:** `this()` calls another constructor of the same class, while `super()` calls the constructor of the immediate parent class.

### 4. Why must this() and super() be the first statement?

**Answer:** Java requires constructor invocation to occur before any other constructor statements so that the object initialization chain starts correctly.

### 5. What happens if we don't write super()?

**Answer:** Java implicitly inserts `super()` if possible.

### 6. What happens if the parent has no no-argument constructor?

**Answer:** The child must explicitly call one of the available parent constructors using `super(arguments)`. Otherwise, compilation fails.

### 7. Can this() and super() be used together in one constructor?

**Answer:** No. Both must be the first statement, so they cannot both be used directly in the same constructor.

---

# Interview Tip 💡

Remember:

```text
Constructor Chaining
        │
        ├── Same Class
        │      ↓
        │    this()
        │
        └── Parent Class
               ↓
             super()
```

And constructor execution in inheritance:

```text
Parent
  ↓
Child
  ↓
Grandchild
```

---

# Summary

Constructor chaining allows constructors to call other constructors and reuse initialization logic.

The two important mechanisms are:

```text
this()
 ↓
Calls another constructor in the same class.

super()
 ↓
Calls the constructor of the immediate parent class.
```

In inheritance, parent constructors execute before child constructors.

Constructor chaining helps reduce duplicate code and provides a clean initialization flow.
