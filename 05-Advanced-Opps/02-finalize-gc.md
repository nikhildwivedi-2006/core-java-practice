# Garbage Collection and finalize() in Java

## Introduction

Java provides **automatic memory management** through Garbage Collection (GC).

When objects are no longer reachable by a program, they become eligible for garbage collection.

The Garbage Collector automatically identifies and removes such objects from memory.

---

# What is Garbage Collection?

Garbage Collection is the process of automatically reclaiming memory occupied by objects that are no longer reachable.

Java does not require the programmer to manually free object memory like languages such as C or C++.

Example:

```java
Student student = new Student();

student = null;
```

After:

```java
student = null;
```

the previously referenced `Student` object may become eligible for Garbage Collection, assuming there are no other references to it.

---

# Reachable and Unreachable Objects

Consider:

```java
Student student = new Student();
```

The object is reachable through the `student` reference.

```text
student
   │
   ▼
Student Object
```

Now:

```java
student = null;
```

The reference is removed.

```text
student → null

Student Object
     ↑
     │
   No reference
```

If no other references point to that object, it becomes **eligible for Garbage Collection**.

---

# Important Point

Be careful with the word **eligible**.

When an object becomes unreachable:

```text
Object → Eligible for GC
```

It does **not** mean:

```text
Object → Immediately removed
```

The JVM decides when Garbage Collection actually runs.

---

# How Can an Object Become Eligible for GC?

An object can become eligible for Garbage Collection in several situations.

## 1. Assigning null

```java
Student student = new Student();

student = null;
```

The object may become eligible for GC.

---

## 2. Reassigning a Reference

```java
Student student1 = new Student();
Student student2 = new Student();

student1 = student2;
```

The first `Student` object may become eligible for GC if no other references point to it.

---

## 3. Objects Created Inside a Method

```java
static void createObject() {

    Student student = new Student();

}
```

After the method finishes, the local reference is no longer accessible from that method.

If no other references exist, the object may become eligible for GC.

---

# What is the Garbage Collector?

The **Garbage Collector** is a part of the JVM responsible for automatic memory management.

Its main purpose is to identify objects that are no longer reachable and reclaim their memory.

Conceptually:

```text
Java Program
     │
     ▼
Objects Created
     │
     ▼
Objects Become Unreachable
     │
     ▼
Eligible for GC
     │
     ▼
Garbage Collector
     │
     ▼
Memory Reclaimed
```

---

# Can We Force Garbage Collection?

Java provides:

```java
System.gc();
```

and:

```java
Runtime.getRuntime().gc();
```

These methods only **request** Garbage Collection.

They do not guarantee that GC will run immediately.

Example:

```java
public class GarbageCollectionExample {

    public static void main(String[] args) {

        GarbageCollectionExample object =
                new GarbageCollectionExample();

        object = null;

        System.gc();

        System.out.println("Program continues...");

    }
}
```

The JVM may decide whether and when to perform Garbage Collection.

---

# What is finalize()?

`finalize()` was a method associated with an object before its memory was reclaimed by the Garbage Collector.

Historically, it was used for cleanup-related operations.

Example of the old style:

```java
@Override
protected void finalize() throws Throwable {

    System.out.println("finalize() called");

}
```

However, this approach is **not recommended in modern Java**.

---

# Important Modern Java Note

The `finalize()` method has been **deprecated** in modern Java and should not be used for resource management.

Reasons include:

- Unpredictable execution time.
- No guarantee that it will run promptly.
- Performance problems.
- Possible resource-management issues.
- It can make program behavior difficult to predict.

Therefore:

> Do not use `finalize()` in new Java applications.

---

# finalize() vs Garbage Collection

These concepts should not be confused.

### Garbage Collection

Garbage Collection is the JVM's automatic memory-reclamation mechanism.

### finalize()

`finalize()` was an old cleanup mechanism associated with an object before garbage collection.

They are not the same thing.

---

# Modern Alternative

For resources such as:

- Files
- Database connections
- Network connections
- Streams

use explicit resource management.

A common approach is **try-with-resources**.

Example:

```java
try (FileInputStream input =
         new FileInputStream("data.txt")) {

    // Use the resource

}
```

The resource is automatically closed when the `try` block finishes.

---

# Why Should We Not Depend on finalize()?

Consider:

```java
protected void finalize() throws Throwable {

    closeDatabaseConnection();

}
```

This is not reliable resource management.

The programmer does not control exactly when the Garbage Collector runs.

Therefore, the database connection might remain open longer than expected.

Instead, resources should be explicitly managed.

---

# Important Difference: final, finally, finalize()

These three terms are completely different.

| Keyword / Method | Purpose |
|------------------|---------|
| `final` | Prevents reassignment, overriding, or inheritance depending on usage. |
| `finally` | Block used with exception handling that generally executes after try/catch processing. |
| `finalize()` | Old object-cleanup mechanism, deprecated in modern Java. |

Remember:

```text
final
  ↓
Keyword

finally
  ↓
Exception Handling Block

finalize()
  ↓
Old Cleanup Mechanism
```

---

# Common Misconceptions

### Misconception 1

> Setting an object to null immediately deletes it.

❌ Incorrect.

```java
student = null;
```

only removes that particular reference.

The object becomes eligible for GC if no other references exist.

---

### Misconception 2

> `System.gc()` guarantees Garbage Collection.

❌ Incorrect.

It only requests GC.

---

### Misconception 3

> Garbage Collection happens immediately when an object becomes unreachable.

❌ Incorrect.

The JVM decides when GC occurs.

---

### Misconception 4

> finalize() should be used to close files and database connections.

❌ Incorrect.

Use explicit resource management such as try-with-resources.

---

# Example

```java
class Student {

    String name;

    Student(String name) {

        this.name = name;
    }
}

public class GarbageCollectionExample {

    public static void main(String[] args) {

        Student student = new Student("Nikhil");

        student = null;

        System.gc();

        System.out.println("Program continues...");

    }
}
```

Here:

```java
student = null;
```

removes the reference from the variable.

If no other reference points to the object, the object becomes eligible for GC.

```java
System.gc();
```

requests garbage collection, but does not guarantee immediate execution.

---

# Interview Questions

### 1. What is Garbage Collection?

**Answer:** Garbage Collection is the JVM's automatic process of reclaiming memory occupied by unreachable objects.

### 2. When does an object become eligible for GC?

**Answer:** When it becomes unreachable and no live reference can access it.

### 3. Can we force Garbage Collection?

**Answer:** No. We can request it using `System.gc()`, but the JVM decides whether and when GC actually occurs.

### 4. What is finalize()?

**Answer:** `finalize()` was an old mechanism associated with object cleanup before garbage collection. It is deprecated in modern Java and should not be used for resource management.

### 5. Should finalize() be used in new Java code?

**Answer:** No.

### 6. What should be used instead of finalize() for resources?

**Answer:** Explicit resource management, especially try-with-resources for `AutoCloseable` resources.

---

# Key Takeaways

```text
Object becomes unreachable
          ↓
Object becomes eligible for GC
          ↓
JVM decides when GC runs
          ↓
Memory may be reclaimed
```

Remember:

- Java provides automatic memory management.
- Unreachable objects become eligible for GC.
- `System.gc()` only requests GC.
- Garbage Collection is controlled by the JVM.
- `finalize()` is deprecated and should not be used in new code.
- Use explicit resource management for files, database connections, streams, etc.

---

# Summary

Garbage Collection is an important feature of Java's automatic memory management system. It allows the JVM to reclaim memory occupied by unreachable objects.

The old `finalize()` mechanism should not be relied upon for cleanup because its execution is unpredictable and it is deprecated in modern Java.

For resource management, prefer explicit cleanup and try-with-resources.