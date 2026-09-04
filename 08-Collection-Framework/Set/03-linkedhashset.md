# LinkedHashSet in Java

## 1. Introduction

`LinkedHashSet` is a class in the Java Collections Framework that implements the `Set` interface.

It stores **unique elements** while maintaining their **insertion order**.

```java
import java.util.LinkedHashSet;
import java.util.Set;

Set<String> names = new LinkedHashSet<>();

names.add("Nikhil");
names.add("Rahul");
names.add("Aman");

System.out.println(names);
```

Output:

```text
[Nikhil, Rahul, Aman]
```

The elements are returned in the same order in which they were inserted.

---

## 2. Hierarchy

```text
Iterable
   ↓
Collection
   ↓
Set
   ↓
HashSet
   ↓
LinkedHashSet
```

Package:

```java
java.util.LinkedHashSet
```

`LinkedHashSet` extends `HashSet` and maintains insertion order using additional linked ordering information.

---

## 3. Characteristics

`LinkedHashSet`:

- Does not allow duplicate elements
- Maintains insertion order
- Does not provide index-based access
- Allows one `null` element
- Uses hashing for efficient basic operations
- Requires more memory than `HashSet`
- Is not synchronized
- Provides average O(1) time for basic operations

The main idea is:

```text
LinkedHashSet
      ↓
Unique Elements
      +
Insertion Order
```

---

## 4. Creating a LinkedHashSet

```java
Set<Integer> numbers = new LinkedHashSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);

System.out.println(numbers);
```

Output:

```text
[30, 10, 20]
```

Using the interface reference is generally preferred:

```java
Set<Integer> numbers = new LinkedHashSet<>();
```

---

## 5. Adding Elements

```java
Set<String> languages = new LinkedHashSet<>();

languages.add("Java");
languages.add("Python");
languages.add("C++");
```

Adding a duplicate:

```java
languages.add("Java");
```

The duplicate element will not be added.

The `add()` method returns a boolean:

```java
System.out.println(languages.add("JavaScript")); // true
System.out.println(languages.add("Java"));       // false
```

```text
true  → Element was added
false → Element was already present
```

---

## 6. Maintaining Insertion Order

Insertion order is the main feature of `LinkedHashSet`.

```java
Set<String> languages = new LinkedHashSet<>();

languages.add("Java");
languages.add("Python");
languages.add("C++");
languages.add("JavaScript");

System.out.println(languages);
```

Output:

```text
[Java, Python, C++, JavaScript]
```

The iteration order follows the insertion order.

---

## 7. Internal Working

`LinkedHashSet` combines hashing with a linked structure that maintains insertion order.

Conceptually:

```text
Hashing
   ↓
Efficient lookup

Linked structure
   ↓
Maintains insertion order
```

For example:

```text
Insertion Order:

30 → 10 → 20
```

The hash-based structure helps with efficient lookup, while the linked structure keeps track of the insertion order.

Because of this additional ordering information, `LinkedHashSet` generally requires more memory than `HashSet`.

---

## 8. Important Methods

| Method        | Purpose                               |
| ------------- | ------------------------------------- |
| `add()`       | Adds an element                       |
| `remove()`    | Removes an element                    |
| `contains()`  | Checks whether an element exists      |
| `size()`      | Returns the number of elements        |
| `isEmpty()`   | Checks whether the set is empty       |
| `clear()`     | Removes all elements                  |
| `iterator()`  | Returns an iterator                   |
| `addAll()`    | Adds elements from another collection |
| `removeAll()` | Removes matching elements             |
| `retainAll()` | Retains only common elements          |

---

## 9. contains()

```java
Set<String> names = new LinkedHashSet<>();

names.add("Nikhil");
names.add("Rahul");

System.out.println(names.contains("Nikhil"));
```

Output:

```text
true
```

`contains()` generally provides O(1) average-time performance.

---

## 10. remove()

```java
names.remove("Rahul");
```

The specified element is removed from the set.

---

## 11. size()

```java
System.out.println(names.size());
```

Returns the number of unique elements currently stored in the set.

---

## 12. Traversing LinkedHashSet

Since `LinkedHashSet` does not support index-based access, elements can be traversed using an enhanced `for` loop:

```java
for (String name : names) {
    System.out.println(name);
}
```

The elements will be visited in insertion order.

An `Iterator` can also be used:

```java
Iterator<String> iterator = names.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

---

## 13. Null Element

`LinkedHashSet` allows one `null` element.

```java
Set<String> set = new LinkedHashSet<>();

set.add(null);
set.add(null);

System.out.println(set);
```

Only one `null` will be stored.

---

## 14. Time Complexity

Average-case complexity:

| Operation    | Complexity |
| ------------ | ---------: |
| `add()`      |       O(1) |
| `remove()`   |       O(1) |
| `contains()` |       O(1) |
| `size()`     |       O(1) |

The exact performance can depend on hashing behavior and implementation details.

---

## 15. LinkedHashSet vs HashSet

| Feature          | HashSet             | LinkedHashSet   |
| ---------------- | ------------------- | --------------- |
| Duplicates       | Not allowed         | Not allowed     |
| Ordering         | No guaranteed order | Insertion order |
| Hashing          | Yes                 | Yes             |
| Memory           | Lower               | Higher          |
| Basic Operations | O(1) average        | O(1) average    |
| `null`           | One allowed         | One allowed     |

Simple rule:

```text
HashSet
→ Unique elements

LinkedHashSet
→ Unique elements + insertion order
```

---

## 16. LinkedHashSet vs ArrayList

| Feature            | ArrayList          | LinkedHashSet             |
| ------------------ | ------------------ | ------------------------- |
| Duplicates         | Allowed            | Not allowed               |
| Index-based access | Yes                | No                        |
| Insertion order    | Yes                | Yes                       |
| Random access      | Fast               | Not supported by index    |
| Main Purpose       | Ordered collection | Unique + ordered elements |

---

## 17. LinkedHashSet vs TreeSet

| Feature            | LinkedHashSet             | TreeSet              |
| ------------------ | ------------------------- | -------------------- |
| Duplicates         | Not allowed               | Not allowed          |
| Ordering           | Insertion order           | Sorted order         |
| Internal Structure | Hashing + linked ordering | Tree-based           |
| Basic Operations   | O(1) average              | O(log n)             |
| `null`             | One allowed               | Normally not allowed |

Remember:

```text
LinkedHashSet → Insertion Order
TreeSet       → Sorted Order
```

---

## 18. Removing Duplicates While Preserving Order

A common use case of `LinkedHashSet` is removing duplicates while preserving the original order.

Consider:

```text
[10, 20, 10, 30, 20, 40]
```

We can use:

```java
List<Integer> numbers =
        Arrays.asList(10, 20, 10, 30, 20, 40);

Set<Integer> uniqueNumbers =
        new LinkedHashSet<>(numbers);

System.out.println(uniqueNumbers);
```

Output:

```text
[10, 20, 30, 40]
```

The duplicates are removed while the first occurrence of each element remains in its original order.

---

## 19. When to Use LinkedHashSet?

Use `LinkedHashSet` when you need:

```text
Unique Elements
       +
Insertion Order
```

Examples:

- Removing duplicates while preserving order
- Maintaining unique user IDs in insertion order
- Maintaining unique product IDs
- Tracking unique visited items in the order they were encountered

If insertion order is not important:

```text
HashSet
```

If sorted order is required:

```text
TreeSet
```

---

## 20. Complete Example

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {

    public static void main(String[] args) {

        Set<String> languages = new LinkedHashSet<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Java");

        System.out.println("Set: " + languages);

        System.out.println(
                "Contains Java: " +
                languages.contains("Java")
        );

        languages.remove("Python");

        System.out.println(
                "After remove: " +
                languages
        );

        System.out.println(
                "Size: " +
                languages.size()
        );
    }
}
```

---

## 21. Important Interview Questions

### Q1. What is LinkedHashSet?

`LinkedHashSet` is a `Set` implementation that stores unique elements while maintaining insertion order.

### Q2. Does LinkedHashSet allow duplicates?

No.

### Q3. Does LinkedHashSet maintain insertion order?

Yes. Its iteration order follows the insertion order.

### Q4. How does LinkedHashSet maintain insertion order?

It uses additional linked ordering information along with its hash-based storage.

### Q5. Does LinkedHashSet allow null?

Yes, one `null` element.

### Q6. Is LinkedHashSet synchronized?

No.

### Q7. What is the difference between HashSet and LinkedHashSet?

```text
HashSet       → Unique elements + no guaranteed order
LinkedHashSet → Unique elements + insertion order
```

### Q8. When should LinkedHashSet be used?

When both uniqueness and insertion order are required.

### Q9. Why does LinkedHashSet use more memory than HashSet?

Because it maintains additional information to preserve insertion order.

### Q10. Can LinkedHashSet be used to remove duplicates while preserving order?

Yes.

```java
Set<Integer> unique =
        new LinkedHashSet<>(numbers);
```

---

## 22. Quick Revision

```text
LinkedHashSet
      ↓
Set Implementation
      ↓
No Duplicates
      ↓
Insertion Order Maintained
      ↓
Hashing + Linked Ordering
```

Complexity:

```text
add()      → O(1) average
remove()   → O(1) average
contains() → O(1) average
```

### Memory Trick

```text
HashSet
→ Unique

LinkedHashSet
→ Unique + Insertion Order

TreeSet
→ Unique + Sorted Order
```

---

## Summary

`LinkedHashSet` is useful when you need **unique elements while preserving insertion order**.

The key points are:

```text
→ Implements Set
→ Does not allow duplicates
→ Maintains insertion order
→ Allows one null element
→ Does not support index-based access
→ Uses hashing
→ Basic operations are O(1) average
→ Uses more memory than HashSet
→ Is not synchronized
```

The most important comparison:

```text
HashSet       → Unique
LinkedHashSet → Unique + Insertion Order
TreeSet       → Unique + Sorted Order
```
