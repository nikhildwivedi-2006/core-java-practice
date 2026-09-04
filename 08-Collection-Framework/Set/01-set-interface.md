# Set Interface in Java

## 1. Introduction

`Set` Java Collections Framework ka ek interface hai jo **unique elements** ko store karne ke liye use hota hai.

```java
import java.util.Set;
import java.util.HashSet;

Set<String> names = new HashSet<>();
```

Set ki sabse important property:

```text
Duplicate elements → Not allowed
```

Example:

```java
Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);

System.out.println(numbers);
```

Output mein `10` sirf ek baar hoga.

---

## 2. Why Set?

Agar hume kisi collection mein **duplicate values nahi chahiye**, toh Set useful hai.

Example:

```text
Input:
[10, 20, 10, 30, 20]

Set:
[10, 20, 30]
```

Common use cases:

- Unique usernames
- Unique IDs
- Duplicate removal
- Unique elements find karna
- Membership checking

---

## 3. Set Hierarchy

Basic hierarchy:

```text
Iterable
   ↓
Collection
   ↓
Set
   ├── HashSet
   ├── LinkedHashSet
   └── SortedSet
          ↓
       NavigableSet
          ↓
        TreeSet
```

Important:

`Set` is an interface.

`HashSet`, `LinkedHashSet` and `TreeSet` are implementations.

---

## 4. Characteristics of Set

Set generally:

- Duplicate elements allow nahi karta
- At most one occurrence of an element rakhta hai
- `null` handling implementation par depend karti hai
- Index-based access nahi deta
- `List` ki tarah `get(index)` method nahi hota
- Different implementations different ordering provide karti hain

Important:

> Set ka basic contract uniqueness hai; ordering implementation par depend karti hai.

---

## 5. Creating a Set

```java
Set<String> languages = new HashSet<>();

languages.add("Java");
languages.add("Python");
languages.add("C++");

System.out.println(languages);
```

Generally interface reference prefer karna good practice hai:

```java
Set<String> languages = new HashSet<>();
```

Instead of:

```java
HashSet<String> languages = new HashSet<>();
```

Lekin agar implementation-specific methods chahiye, toh concrete type use kar sakte hain.

---

## 6. Important Methods

Set ko `Collection` se inherited methods milte hain.

| Method          | Purpose                            |
| --------------- | ---------------------------------- |
| `add()`         | Element add karta hai              |
| `remove()`      | Element remove karta hai           |
| `contains()`    | Element present hai ya nahi        |
| `size()`        | Number of elements                 |
| `isEmpty()`     | Set empty hai ya nahi              |
| `clear()`       | Saare elements remove              |
| `iterator()`    | Elements traverse karne ke liye    |
| `addAll()`      | Another collection ke elements add |
| `removeAll()`   | Matching elements remove           |
| `retainAll()`   | Common elements retain             |
| `containsAll()` | Check all elements present         |

---

## 7. add()

```java
Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
```

Duplicate add karne par:

```java
numbers.add(10);
```

Set mein second `10` add nahi hoga.

`add()` boolean return karta hai:

```java
System.out.println(numbers.add(40)); // true
System.out.println(numbers.add(10)); // false
```

Meaning:

```text
true  → element successfully added
false → element already present tha
```

---

## 8. contains()

Set mein element search karne ke liye:

```java
System.out.println(numbers.contains(20));
```

Output:

```text
true
```

Ye membership checking ke liye commonly useful hai.

---

## 9. remove()

```java
numbers.remove(20);
```

`20` set se remove ho jayega.

---

## 10. size()

```java
System.out.println(numbers.size());
```

Set mein currently kitne unique elements hain, ye return karega.

---

## 11. Traversing a Set

Set mein index nahi hota, isliye:

```java
numbers.get(0);
```

valid nahi hai.

Traversal ke liye enhanced for loop use kar sakte hain:

```java
for (Integer number : numbers) {
    System.out.println(number);
}
```

Ya iterator:

```java
Iterator<Integer> iterator = numbers.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

---

## 12. Set vs List

| Feature         | List               | Set                       |
| --------------- | ------------------ | ------------------------- |
| Duplicate       | Allowed            | Not allowed               |
| Index           | Yes                | No                        |
| `get(index)`    | Yes                | No                        |
| Insertion order | List maintains it  | Depends on implementation |
| Main purpose    | Ordered collection | Unique elements           |

Example:

```text
List:
[10, 20, 10, 30]

Set:
[10, 20, 30]
```

---

## 13. Types of Set

### HashSet

```java
Set<Integer> set = new HashSet<>();
```

Characteristics:

- Hash table based
- Generally no guaranteed iteration order
- Fast average-case basic operations
- Allows one `null` element

---

### LinkedHashSet

```java
Set<Integer> set = new LinkedHashSet<>();
```

Characteristics:

- Maintains insertion order
- Hash table + linked list based
- Allows one `null` element

Example:

```text
Input:
30, 10, 20

Output:
30, 10, 20
```

---

### TreeSet

```java
Set<Integer> set = new TreeSet<>();
```

Characteristics:

- Elements sorted order mein maintain karta hai
- Generally Red-Black Tree based
- Basic operations generally O(log n)
- `null` normally allow nahi karta

Example:

```text
Input:
30, 10, 20

Output:
10, 20, 30
```

---

## 14. HashSet vs LinkedHashSet vs TreeSet

| Feature            | HashSet             | LinkedHashSet            | TreeSet               |
| ------------------ | ------------------- | ------------------------ | --------------------- |
| Duplicate          | No                  | No                       | No                    |
| Ordering           | No guaranteed order | Insertion order          | Sorted order          |
| Internal Structure | Hash table          | Hash table + linked list | Tree                  |
| Performance        | Generally fastest   | Slightly more overhead   | Generally slower      |
| Null               | One `null` allowed  | One `null` allowed       | Normally not allowed  |
| Use When           | Unique elements     | Unique + insertion order | Unique + sorted order |

Simple rule:

```text
Only uniqueness
      ↓
   HashSet

Uniqueness + insertion order
      ↓
 LinkedHashSet

Uniqueness + sorted order
      ↓
   TreeSet
```

---

## 15. Set and Generics

Set ko generic type ke saath use karna recommended hai:

```java
Set<String> names = new HashSet<>();
```

Isse sirf `String` values store kar sakte hain.

```java
names.add("Nikhil");
names.add("Java");
```

Wrong type:

```java
names.add(100); // Compile-time error
```

---

## 16. Removing Duplicates Using Set

Set ka ek common practical use duplicate removal hai.

```java
List<Integer> numbers =
        Arrays.asList(10, 20, 10, 30, 20, 40);

Set<Integer> uniqueNumbers = new HashSet<>(numbers);

System.out.println(uniqueNumbers);
```

Duplicates automatically remove ho jayenge.

Concept:

```text
List
 ↓
[10, 20, 10, 30, 20]
 ↓
HashSet
 ↓
[10, 20, 30]
```

---

## 17. Important Interview Questions

### Q1. What is Set?

`Set` is an interface in Java Collections Framework used to store unique elements.

### Q2. Does Set allow duplicates?

No. A Set does not allow duplicate elements.

### Q3. Does Set maintain insertion order?

Set interface itself ordering guarantee nahi karta.

Implementation par depend karta hai:

```text
HashSet       → No guaranteed order
LinkedHashSet → Insertion order
TreeSet       → Sorted order
```

### Q4. Can we access Set elements using index?

No.

```java
set.get(0); // Invalid
```

### Q5. Difference between List and Set?

```text
List → duplicates allowed + index-based access

Set → duplicates not allowed + no index-based access
```

### Q6. Which Set should we use for sorted unique elements?

`TreeSet`.

### Q7. Which Set maintains insertion order?

`LinkedHashSet`.

### Q8. Which Set is generally preferred when only uniqueness is required?

`HashSet`.

### Q9. Can Set contain null?

Depends on implementation:

```text
HashSet       → one null
LinkedHashSet → one null
TreeSet       → normally no null
```

### Q10. Is Set synchronized?

Standard `HashSet`, `LinkedHashSet` and `TreeSet` are not synchronized.

---

## 18. Quick Revision

```text
Set
 ↓
Unique elements
 ↓
No index-based access
 ↓
No duplicate elements
```

Implementations:

```text
HashSet
   ↓
Unique + no guaranteed order

LinkedHashSet
   ↓
Unique + insertion order

TreeSet
   ↓
Unique + sorted order
```

### One-Line Memory Trick

```text
HashSet       → Unique
LinkedHashSet → Unique + Order
TreeSet       → Unique + Sorted
```

---

## Summary

`Set` is an interface used when duplicate elements are not allowed.

The three most important implementations are:

- **HashSet** → uniqueness
- **LinkedHashSet** → uniqueness + insertion order
- **TreeSet** → uniqueness + sorted order

For interviews, remember:

```text
List → Duplicate allowed
Set  → Duplicate not allowed

HashSet       → No guaranteed order
LinkedHashSet → Insertion order
TreeSet       → Sorted order
```
