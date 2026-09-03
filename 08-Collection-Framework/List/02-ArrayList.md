# ArrayList in Java

## Introduction

`ArrayList` is a resizable-array implementation of the `List` interface.

It is available in:

```java
java.util.ArrayList
```

Example:

```java
List<String> names = new ArrayList<>();
```

Unlike a normal array, an `ArrayList` can **grow and shrink dynamically**.

---

# ArrayList Hierarchy

```text
Iterable
   ↓
Collection
   ↓
List
   ↓
ArrayList
```

`ArrayList` implements the `List` interface.

---

# Creating an ArrayList

```java
ArrayList<String> names = new ArrayList<>();
```

Preferred way:

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

Using the interface as the reference provides more flexibility.

---

# Basic Example

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        List<String> languages = new ArrayList<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        System.out.println(languages);
    }
}
```

Output:

```text
[Java, Python, C++]
```

---

# Main Characteristics

`ArrayList`:

- Maintains insertion order
- Allows duplicate elements
- Allows `null`
- Provides index-based access
- Has dynamic size
- Is not synchronized
- Allows fast random access

Example:

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");
list.add("Java");
list.add(null);

System.out.println(list);
```

Output:

```text
[Java, Java, null]
```

---

# Internal Working of ArrayList

The most important concept of `ArrayList` is its internal storage.

Conceptually:

```text
ArrayList
    ↓
Object[] array
```

An ArrayList internally uses an array to store elements.

For example:

```text
ArrayList

Internal Array:

[Java] [Python] [C++] [null] [null] ...
```

When more space is required, a larger array is created and elements are copied into it.

Therefore:

```text
ArrayList
    ↓
Dynamic array
```

It is called a **resizable array**.

---

# Size vs Capacity

This is an important interview concept.

## Size

Size means:

> Number of elements currently stored in the ArrayList.

Example:

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");
list.add("C++");
```

Now:

```text
Size = 3
```

---

## Capacity

Capacity means:

> Number of elements the internal array can currently hold before resizing is required.

For example, conceptually:

```text
Capacity = 10
Size = 3
```

The remaining capacity is available for future elements.

Remember:

```text
Size     → elements currently stored

Capacity → storage available internally
```

---

# Dynamic Resizing

Suppose the internal array becomes full.

```text
Before:

[A] [B] [C] [D] [E]
 ↑
Array is full
```

If another element needs to be added:

```text
F
```

ArrayList needs more space.

Conceptually:

```text
Old Array
[A] [B] [C] [D] [E]

       ↓

Create larger array

[A] [B] [C] [D] [E] [F] ...
```

The old elements are copied into the new internal array.

This process is called **resizing** or **growing**.

---

# Why Is Resizing Needed?

A normal array has fixed size:

```java
String[] names = new String[5];
```

After creating it, its capacity cannot be increased.

ArrayList solves this limitation by internally creating a larger array when required.

Therefore:

```text
Array
→ Fixed size

ArrayList
→ Resizable
```

---

# Default Capacity

In modern Java implementations, a newly created `ArrayList` does not necessarily allocate the backing array immediately.

For example:

```java
ArrayList<String> list = new ArrayList<>();
```

The internal storage is lazily initialized when elements are first added.

When the backing array is first allocated, its typical initial capacity is **10** in the standard OpenJDK implementation.

However, you should avoid relying on implementation details when writing general Java code.

You can explicitly provide an initial capacity:

```java
ArrayList<String> list = new ArrayList<>(100);
```

This tells the ArrayList to prepare storage for approximately 100 elements before growth is required.

---

# Initial Capacity

If we already know that a large number of elements will be stored, we can provide an initial capacity.

```java
ArrayList<Integer> numbers = new ArrayList<>(1000);
```

This can reduce the number of resizing operations.

Important:

```text
Initial capacity ≠ size
```

Example:

```java
ArrayList<Integer> numbers = new ArrayList<>(100);
```

Initially:

```text
Size = 0
Capacity = 100
```

No elements have been added yet.

---

# Important Methods

| Method                | Purpose                    |
| --------------------- | -------------------------- |
| `add()`               | Adds an element            |
| `add(index, element)` | Inserts at an index        |
| `get(index)`          | Gets an element            |
| `set(index, element)` | Replaces an element        |
| `remove(index)`       | Removes by index           |
| `remove(object)`      | Removes an object          |
| `contains()`          | Checks for an element      |
| `size()`              | Returns number of elements |
| `isEmpty()`           | Checks whether empty       |
| `clear()`             | Removes all elements       |
| `indexOf()`           | Finds first occurrence     |
| `lastIndexOf()`       | Finds last occurrence      |
| `ensureCapacity()`    | Requests minimum capacity  |

---

# Adding Elements

## `add(element)`

Adds an element at the end.

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");
list.add("C++");
```

Result:

```text
[Java, Python, C++]
```

---

## `add(index, element)`

Adds an element at a specific index.

```java
list.add(1, "JavaScript");
```

Result:

```text
[Java, JavaScript, Python, C++]
```

Existing elements may need to be shifted.

---

# Accessing Elements

Use:

```java
get(index)
```

Example:

```java
String language = list.get(0);

System.out.println(language);
```

Output:

```text
Java
```

ArrayList provides efficient index-based access.

---

# Updating Elements

Use:

```java
set(index, element)
```

Example:

```java
list.set(0, "Spring Boot");
```

Before:

```text
[Java, Python, C++]
```

After:

```text
[Spring Boot, Python, C++]
```

Remember:

```text
get() → read
set() → replace
```

---

# Removing Elements

## Remove by index

```java
list.remove(1);
```

Removes the element at index `1`.

---

## Remove by object

```java
list.remove("Java");
```

Removes the first matching object.

For `Integer`, remember the overloaded method issue:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.remove(1);
```

This removes the element at index `1`:

```text
[10, 30]
```

To remove the value `10`:

```java
numbers.remove(Integer.valueOf(10));
```

Result:

```text
[20, 30]
```

---

# Searching

Use:

```java
contains()
```

Example:

```java
if (list.contains("Java")) {
    System.out.println("Java found");
}
```

Other useful methods:

```java
list.indexOf("Java");

list.lastIndexOf("Java");
```

---

# Size

Use:

```java
list.size();
```

Example:

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");

System.out.println(list.size());
```

Output:

```text
2
```

Remember:

```text
ArrayList → size()
Array      → length
```

---

# `ensureCapacity()`

`ensureCapacity()` can be used to request a minimum capacity for the ArrayList.

Example:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.ensureCapacity(1000);
```

This can help reduce repeated growth when we know that many elements are going to be added.

It does **not** change the number of elements.

```text
ensureCapacity()
        ↓
Changes/prepares capacity

size()
        ↓
Number of actual elements
```

---

# Time Complexity

For an ArrayList, common operations are approximately:

| Operation             | Average / Typical Complexity |
| --------------------- | ---------------------------: |
| `get(index)`          |                         O(1) |
| `set(index)`          |                         O(1) |
| `add(element)` at end |               O(1) amortized |
| `add(index, element)` |                         O(n) |
| `remove(index)`       |                         O(n) |
| `contains()`          |                         O(n) |
| `indexOf()`           |                         O(n) |

Why is `add(element)` at the end considered **amortized O(1)**?

Most additions do not require resizing.

Occasionally, resizing requires copying elements, which takes O(n), but that cost is spread across many insertions.

---

# Why `get()` Is O(1)

ArrayList uses an array internally.

If we need:

```java
list.get(500);
```

the required array position can be accessed directly using its index.

Conceptually:

```text
Index
  ↓
Direct access
  ↓
Element
```

Therefore:

```text
get(index) → O(1)
```

---

# Why Insertion in the Middle Is O(n)

Suppose:

```text
[A] [B] [C] [D]
```

We insert `X` at index `1`.

Elements may need to shift:

```text
[A] [X] [B] [C] [D]
```

Therefore, insertion at an arbitrary position can require shifting multiple elements.

```text
add(index, element) → O(n)
```

---

# Why Removal Is O(n)

Suppose:

```text
[A] [B] [C] [D]
```

Remove `B`:

```text
[A] [C] [D]
```

Elements after the removed element may need to shift left.

Therefore:

```text
remove(index) → O(n)
```

---

# ArrayList vs Array

| Feature                       | Array   | ArrayList                         |
| ----------------------------- | ------- | --------------------------------- |
| Size                          | Fixed   | Dynamic                           |
| Stores primitives             | Yes     | Uses wrapper objects for generics |
| Index access                  | O(1)    | O(1)                              |
| Add/Remove methods            | No      | Yes                               |
| Generics                      | No      | Yes                               |
| Built-in collection methods   | Limited | Many                              |
| Part of Collections Framework | No      | Yes                               |
| Resizing                      | No      | Yes                               |

Example:

```java
int[] numbers = new int[5];
```

vs

```java
ArrayList<Integer> numbers = new ArrayList<>();
```

---

# ArrayList vs LinkedList

| Feature                     | ArrayList                | LinkedList                                       |
| --------------------------- | ------------------------ | ------------------------------------------------ |
| Internal structure          | Dynamic array            | Doubly linked list                               |
| Random access               | Fast                     | Slow                                             |
| `get(index)`                | O(1)                     | O(n)                                             |
| Memory                      | Generally lower overhead | Higher node overhead                             |
| Insertion/removal in middle | Shifting required        | Node links change, but locating position matters |
| Best for                    | Frequent access          | Certain insertion/removal patterns               |

The choice depends on the actual operation pattern.

---

# Is ArrayList Thread-Safe?

No.

`ArrayList` is **not synchronized** by default.

If multiple threads modify the same ArrayList concurrently, external synchronization or a suitable concurrent collection may be required.

Example of synchronization wrapper:

```java
List<String> list =
        Collections.synchronizedList(new ArrayList<>());
```

For modern concurrent applications, choose the collection according to the actual concurrency requirement.

---

# ArrayList and Generics

ArrayList commonly uses generics to provide type safety.

```java
ArrayList<String> names = new ArrayList<>();
```

Now the list is intended to contain `String` objects.

```java
names.add("Nikhil");
names.add("Java");
```

This is not allowed:

```java
names.add(100); // Compile-time error
```

For primitive values, wrapper classes are used:

```java
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<Double> prices = new ArrayList<>();
ArrayList<Character> letters = new ArrayList<>();
```

---

# Complete Example

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        List<String> languages = new ArrayList<>();

        // Add
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        System.out.println(languages);

        // Add at index
        languages.add(1, "JavaScript");

        // Get
        System.out.println(languages.get(0));

        // Update
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

# Important Interview Questions

### 1. What is ArrayList?

`ArrayList` is a resizable-array implementation of the `List` interface.

---

### 2. Is ArrayList synchronized?

No. ArrayList is not synchronized by default.

---

### 3. Does ArrayList allow duplicates?

Yes.

---

### 4. Does ArrayList maintain insertion order?

Yes.

---

### 5. Does ArrayList allow null?

Yes, it can store `null` elements.

---

### 6. What is the difference between size and capacity?

```text
Size
→ Number of elements currently stored

Capacity
→ Storage available in the internal array
```

---

### 7. What happens when ArrayList becomes full?

It creates a larger backing array and copies the existing elements into it.

---

### 8. Why is `get(index)` O(1)?

Because ArrayList uses an array internally and supports direct index-based access.

---

### 9. Why is insertion in the middle O(n)?

Because existing elements may need to be shifted.

---

### 10. Is `add()` always O(1)?

Adding at the end is **O(1) amortized**.

Occasionally, resizing and copying can make an individual operation O(n).

---

### 11. Can ArrayList store primitive types?

No. Generics require reference types.

So we use wrapper classes:

```java
ArrayList<Integer>
ArrayList<Double>
```

---

### 12. Why use `List` instead of `ArrayList` as the reference?

```java
List<String> list = new ArrayList<>();
```

This programs to the interface and allows the implementation to be changed more easily.

---

# Quick Revision

```text
ArrayList
    ↓
List implementation
    ↓
Resizable array
    ↓
Maintains insertion order
    ↓
Allows duplicates
    ↓
Allows null
    ↓
Fast index access
```

Important complexities:

```text
get(index)              → O(1)
set(index, element)     → O(1)
add(element)            → O(1) amortized
add(index, element)     → O(n)
remove(index)           → O(n)
contains(element)       → O(n)
```

Most important concept:

```text
ArrayList
    ↓
Internal array
    ↓
Array becomes full
    ↓
Larger array created
    ↓
Elements copied
    ↓
New element added
```

---

# Summary

`ArrayList` is one of the most commonly used implementations of the `List` interface.

It provides:

- Dynamic resizing
- Index-based access
- Insertion-order maintenance
- Duplicate elements
- `null` support
- Generic type safety
- Many useful List operations

Its biggest strength is **fast random/index-based access**, while insertion and removal in the middle can require shifting elements.

A common declaration is:

```java
List<String> names = new ArrayList<>();
```

Remember:

```text
ArrayList → Resizable Array
```
