# List Interface in Java

## Introduction

`List` is an interface in the Java Collections Framework that represents an **ordered collection of elements**.

It is available in:

```java
java.util.List
```

A `List` allows us to store multiple elements while maintaining their order.

```text
Collection
    │
    └── List
```

Common implementations of `List` are:

```text
ArrayList
LinkedList
Vector
Stack
```

---

# Main Characteristics of List

## 1. Maintains Insertion Order

A List maintains the order in which elements are added.

```java
List<String> names = new ArrayList<>();

names.add("Nikhil");
names.add("Rahul");
names.add("Aman");

System.out.println(names);
```

Output:

```text
[Nikhil, Rahul, Aman]
```

The elements appear in the same order in which they were inserted.

---

## 2. Allows Duplicate Elements

A List can contain duplicate values.

```java
List<String> names = new ArrayList<>();

names.add("Java");
names.add("Python");
names.add("Java");

System.out.println(names);
```

Output:

```text
[Java, Python, Java]
```

Unlike a `Set`, duplicates are allowed.

---

## 3. Index-Based Access

List elements are stored using indexes.

The first element has index:

```text
0
```

Example:

```java
List<String> languages = new ArrayList<>();

languages.add("Java");
languages.add("Python");
languages.add("C++");

System.out.println(languages.get(0));
```

Output:

```text
Java
```

Indexes:

```text
Java    → 0
Python  → 1
C++     → 2
```

---

## 4. Allows `null`

Most List implementations allow `null` elements.

Example:

```java
List<String> names = new ArrayList<>();

names.add("Nikhil");
names.add(null);
names.add("Rahul");

System.out.println(names);
```

Output:

```text
[Nikhil, null, Rahul]
```

The exact behavior can depend on the implementation, but common List implementations such as `ArrayList` allow `null`.

---

# Creating a List

Since `List` is an interface, we cannot directly create its object.

This is invalid:

```java
List<String> names = new List<>();
```

Instead, we use an implementation:

```java
List<String> names = new ArrayList<>();
```

Here:

```text
List
 ↓
Reference type

ArrayList
 ↓
Actual object
```

This is an example of **programming to an interface**.

---

# Common List Implementations

## ArrayList

```java
List<String> names = new ArrayList<>();
```

Uses a dynamic array internally.

Generally preferred when:

```text
Fast random/index-based access is required
```

---

## LinkedList

```java
List<String> names = new LinkedList<>();
```

Uses a linked-node structure.

It can be useful when frequent insertion/removal operations are performed at appropriate positions.

---

## Vector

```java
List<String> names = new Vector<>();
```

`Vector` is a legacy synchronized List implementation.

It is generally not the first choice for new code.

---

## Stack

```java
Stack<Integer> stack = new Stack<>();
```

`Stack` is a legacy class that extends `Vector`.

It represents a LIFO structure:

```text
Last In
First Out
```

For modern stack-like usage, `Deque`/`ArrayDeque` is generally preferred.

---

# Important List Methods

| Method                | Purpose                          |
| --------------------- | -------------------------------- |
| `add()`               | Adds an element                  |
| `add(index, element)` | Adds at a specific index         |
| `get(index)`          | Returns element at index         |
| `set(index, element)` | Replaces an element              |
| `remove(index)`       | Removes element at index         |
| `remove(object)`      | Removes a matching element       |
| `contains()`          | Checks whether an element exists |
| `indexOf()`           | Returns first matching index     |
| `lastIndexOf()`       | Returns last matching index      |
| `size()`              | Returns number of elements       |
| `isEmpty()`           | Checks whether list is empty     |
| `clear()`             | Removes all elements             |

---

# Example of List Methods

```java
import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List<String> languages = new ArrayList<>();

        // Add
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        // Add at index
        languages.add(1, "JavaScript");

        System.out.println(languages);

        // Get
        System.out.println(languages.get(0));

        // Replace
        languages.set(0, "Spring Boot");

        // Check
        System.out.println(languages.contains("Python"));

        // Size
        System.out.println(languages.size());

        // Remove
        languages.remove("C++");

        System.out.println(languages);
    }
}
```

---

# `add()` vs `add(index, element)`

### Add at the end

```java
list.add("Java");
```

Adds the element at the end.

### Add at a specific position

```java
list.add(1, "Python");
```

Inserts `"Python"` at index `1`.

Existing elements may be shifted depending on the implementation.

---

# `get()` vs `set()`

### `get()`

Used to retrieve an element.

```java
String name = list.get(0);
```

### `set()`

Used to replace an existing element.

```java
list.set(0, "Rahul");
```

Remember:

```text
get() → read
set() → replace
```

---

# `remove()` Overloading

`List` provides two important forms:

```java
remove(int index)
```

and

```java
remove(Object object)
```

Example:

```java
List<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
```

If we write:

```java
numbers.remove(1);
```

It removes the element at index `1`.

Result:

```text
[10, 30]
```

If we want to remove the value `10`:

```java
numbers.remove(Integer.valueOf(10));
```

Result:

```text
[20, 30]
```

This is an important interview concept because of method overloading with `int` and `Object`.

---

# List vs Set

| Feature      | List                            | Set                       |
| ------------ | ------------------------------- | ------------------------- |
| Order        | Maintains insertion order       | Depends on implementation |
| Duplicates   | Allowed                         | Not allowed               |
| Index access | Yes                             | No                        |
| `null`       | Common implementations allow it | Depends on implementation |
| Examples     | ArrayList, LinkedList           | HashSet, TreeSet          |

Example:

```text
List
[Java, Python, Java]
```

```text
Set
[Java, Python]
```

---

# Why Use List Reference?

Instead of:

```java
ArrayList<String> names = new ArrayList<>();
```

we can write:

```java
List<String> names = new ArrayList<>();
```

The second approach is generally preferred because it depends on the interface rather than a specific implementation.

Later, we can change:

```java
List<String> names = new LinkedList<>();
```

without changing code that only depends on List operations.

This provides flexibility.

---

# List Hierarchy

```text
                Collection
                     │
                    List
                     │
       ┌─────────────┼─────────────┐
       │             │             │
  ArrayList      LinkedList      Vector
                                   │
                                  Stack
```

Note:

`Stack` extends `Vector`, while `ArrayList` and `LinkedList` directly implement `List`.

---

# Important Interview Questions

### 1. Is List an interface or class?

`List` is an interface.

---

### 2. Does List allow duplicates?

Yes.

---

### 3. Does List maintain order?

Yes. A List is an ordered collection and maintains element order.

---

### 4. Can we create an object of List directly?

No.

We create an object of a concrete implementation:

```java
List<String> list = new ArrayList<>();
```

---

### 5. Which classes implement List?

Common implementations include:

```text
ArrayList
LinkedList
Vector
```

`Stack` extends `Vector` and therefore is also a List.

---

### 6. Does List support index-based access?

Yes.

```java
list.get(0);
```

---

### 7. What is the difference between `get()` and `set()`?

```text
get() → retrieves an element
set() → replaces an existing element
```

---

# Quick Revision

```text
List
 ↓
Interface
 ↓
Ordered collection
 ↓
Duplicates allowed
 ↓
Index-based access
 ↓
Common implementations:
ArrayList
LinkedList
Vector
Stack
```

Most important points:

```text
List → ordered
List → duplicates allowed
List → index-based
List → interface
```

---

# Summary

`List` is an interface in the Java Collections Framework used to represent an ordered collection of elements.

Its main characteristics are:

- Maintains insertion order
- Allows duplicate elements
- Supports index-based access
- Common implementations allow `null`
- Provides methods such as `add()`, `get()`, `set()`, `remove()`, and `contains()`

Common implementations are:

```text
ArrayList
LinkedList
Vector
Stack
```

A common and flexible way to declare a List is:

```java
List<String> names = new ArrayList<>();
```

The next important topic is **ArrayList**, where we will study its internal working, dynamic resizing, time complexity, capacity vs size, and important interview questions.
