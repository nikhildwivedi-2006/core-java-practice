# TreeSet in Java

## 1. Introduction

`TreeSet` is a class in the Java Collections Framework that implements the `NavigableSet` interface.

It stores **unique elements in sorted order**.

```java
import java.util.Set;
import java.util.TreeSet;

Set<Integer> numbers = new TreeSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);

System.out.println(numbers);
```

Output:

```text
[10, 20, 30]
```

The elements are automatically arranged in sorted order.

---

## 2. Hierarchy

```text
Iterable
   ↓
Collection
   ↓
Set
   ↓
SortedSet
   ↓
NavigableSet
   ↓
TreeSet
```

Package:

```java
java.util.TreeSet
```

---

## 3. Characteristics

`TreeSet`:

- Does not allow duplicate elements
- Stores elements in sorted order
- Does not provide index-based access
- Implements `NavigableSet`
- Uses a tree-based data structure
- Provides O(log n) time for basic operations
- Does not normally allow `null`
- Is not synchronized
- Can store elements according to their natural ordering or a provided `Comparator`

Main idea:

```text
TreeSet
   ↓
Unique Elements
      +
Sorted Order
```

---

## 4. Creating a TreeSet

```java
Set<Integer> numbers = new TreeSet<>();

numbers.add(50);
numbers.add(20);
numbers.add(40);
numbers.add(10);

System.out.println(numbers);
```

Output:

```text
[10, 20, 40, 50]
```

The elements are automatically sorted.

---

## 5. Natural Ordering

By default, `TreeSet` uses the **natural ordering** of its elements.

For numbers:

```text
10 < 20 < 30 < 40
```

For strings, natural ordering is based on their comparison rules.

Example:

```java
TreeSet<String> names = new TreeSet<>();

names.add("Nikhil");
names.add("Aman");
names.add("Rahul");

System.out.println(names);
```

Output:

```text
[Aman, Nikhil, Rahul]
```

---

## 6. Duplicate Elements

`TreeSet` does not allow duplicate elements.

```java
Set<Integer> numbers = new TreeSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);

System.out.println(numbers);
```

Output:

```text
[10, 20]
```

The second `10` is not added.

The `add()` method returns a boolean:

```java
System.out.println(numbers.add(20)); // false
System.out.println(numbers.add(30)); // true
```

---

## 7. How TreeSet Maintains Sorted Order

`TreeSet` is generally implemented using a **Red-Black Tree**, which is a self-balancing binary search tree.

Conceptually:

```text
        20
       /  \
     10    30
          /
         25
```

The tree remains balanced as elements are added or removed.

This allows TreeSet to maintain sorted order efficiently.

---

## 8. Time Complexity

The main operations generally take O(log n):

| Operation    | Complexity |
| ------------ | ---------: |
| `add()`      |   O(log n) |
| `remove()`   |   O(log n) |
| `contains()` |   O(log n) |
| `first()`    |   O(log n) |
| `last()`     |   O(log n) |

Iteration through all elements takes O(n).

---

## 9. Important Methods

`TreeSet` provides methods from `Set`, `SortedSet`, and `NavigableSet`.

| Method        | Purpose                                                             |
| ------------- | ------------------------------------------------------------------- |
| `add()`       | Adds an element                                                     |
| `remove()`    | Removes an element                                                  |
| `contains()`  | Checks whether an element exists                                    |
| `first()`     | Returns the smallest element                                        |
| `last()`      | Returns the largest element                                         |
| `lower()`     | Returns the greatest element strictly less than given element       |
| `floor()`     | Returns the greatest element less than or equal to given element    |
| `higher()`    | Returns the smallest element strictly greater than given element    |
| `ceiling()`   | Returns the smallest element greater than or equal to given element |
| `pollFirst()` | Removes and returns the first element                               |
| `pollLast()`  | Removes and returns the last element                                |
| `headSet()`   | Returns elements before a given element                             |
| `tailSet()`   | Returns elements from a given element onward                        |
| `subSet()`    | Returns a range of elements                                         |

---

## 10. first() and last()

```java
TreeSet<Integer> numbers = new TreeSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);

System.out.println(numbers.first());
System.out.println(numbers.last());
```

Output:

```text
10
30
```

---

## 11. lower() and higher()

`lower(x)` returns the greatest element strictly smaller than `x`.

```java
TreeSet<Integer> numbers =
        new TreeSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);

System.out.println(numbers.lower(30));
```

Output:

```text
20
```

`higher(x)` returns the smallest element strictly greater than `x`.

```java
System.out.println(numbers.higher(30));
```

Output:

```text
40
```

---

## 12. floor() and ceiling()

`floor(x)` returns the greatest element less than or equal to `x`.

```java
System.out.println(numbers.floor(25));
```

Output:

```text
20
```

`ceiling(x)` returns the smallest element greater than or equal to `x`.

```java
System.out.println(numbers.ceiling(25));
```

Output:

```text
30
```

Example:

```text
Set:
[10, 20, 30, 40]

floor(25)   → 20
ceiling(25) → 30
```

---

## 13. pollFirst() and pollLast()

`pollFirst()` removes and returns the smallest element.

```java
System.out.println(numbers.pollFirst());
```

`pollLast()` removes and returns the largest element.

```java
System.out.println(numbers.pollLast());
```

Example:

```text
Before:
[10, 20, 30, 40]

pollFirst() → 10
pollLast()  → 40

After:
[20, 30]
```

---

## 14. headSet()

`headSet()` returns elements that come before a specified element.

```java
TreeSet<Integer> numbers =
        new TreeSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);
numbers.add(50);

System.out.println(numbers.headSet(30));
```

Output:

```text
[10, 20]
```

By default, `30` is excluded.

An overload can include the boundary:

```java
System.out.println(numbers.headSet(30, true));
```

Output:

```text
[10, 20, 30]
```

---

## 15. tailSet()

`tailSet()` returns elements from a specified element onward.

```java
System.out.println(numbers.tailSet(30));
```

Output:

```text
[30, 40, 50]
```

By default, the starting element is included.

---

## 16. subSet()

`subSet()` returns elements within a specified range.

```java
System.out.println(
    numbers.subSet(20, 50)
);
```

Output:

```text
[20, 30, 40]
```

The lower bound is included and the upper bound is excluded by default.

You can control both boundaries:

```java
System.out.println(
    numbers.subSet(20, true, 50, true)
);
```

Output:

```text
[20, 30, 40, 50]
```

---

## 17. Custom Sorting with Comparator

TreeSet can also use a custom `Comparator`.

Example: descending order.

```java
TreeSet<Integer> numbers =
        new TreeSet<>(Comparator.reverseOrder());

numbers.add(10);
numbers.add(30);
numbers.add(20);

System.out.println(numbers);
```

Output:

```text
[30, 20, 10]
```

Here, the elements are sorted in descending order.

---

## 18. TreeSet with Custom Objects

When using custom objects, TreeSet needs a way to determine their ordering.

This can be done using:

1. `Comparable`
2. `Comparator`

Example using `Comparator`:

```java
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

Create TreeSet:

```java
TreeSet<Student> students =
    new TreeSet<>(
        Comparator.comparingInt(student -> student.id)
    );
```

Now students will be ordered by `id`.

---

## 19. Comparable vs Comparator

### Comparable

Used when the class itself defines its natural ordering.

```java
class Student implements Comparable<Student> {

    int id;

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}
```

### Comparator

Used when ordering is defined externally.

```java
Comparator<Student> byId =
    Comparator.comparingInt(student -> student.id);
```

Simple difference:

```text
Comparable
→ Defines natural ordering inside the class

Comparator
→ Defines custom ordering outside the class
```

---

## 20. Important: compareTo() and Duplicate Detection

For a `TreeSet`, ordering comparisons are important for determining whether an element is considered distinct within the set.

If comparison returns:

```java
compareTo() == 0
```

or the comparator returns `0`, TreeSet treats the elements as equivalent for set purposes.

Example:

```text
Student A
id = 101

Student B
id = 101

Comparator result:
0
```

TreeSet will treat them as the same set element even if they are different objects.

Therefore, the ordering used by a TreeSet should be consistent with the equality concept when possible.

---

## 21. Null in TreeSet

A `TreeSet` generally does not allow `null` when using natural ordering.

```java
TreeSet<Integer> numbers =
        new TreeSet<>();

numbers.add(null);
```

This normally results in a `NullPointerException`.

The reason is that TreeSet needs to compare elements to maintain sorted order, and `null` does not have a natural ordering.

---

## 22. TreeSet vs HashSet

| Feature            | HashSet                  | TreeSet                |
| ------------------ | ------------------------ | ---------------------- |
| Duplicates         | Not allowed              | Not allowed            |
| Ordering           | No guaranteed order      | Sorted order           |
| Internal Structure | Hash table based         | Tree based             |
| Basic Operations   | O(1) average             | O(log n)               |
| `null`             | One allowed              | Normally not allowed   |
| Main Use           | Fast uniqueness checking | Sorted unique elements |

---

## 23. TreeSet vs LinkedHashSet

| Feature          | LinkedHashSet            | TreeSet               |
| ---------------- | ------------------------ | --------------------- |
| Duplicates       | Not allowed              | Not allowed           |
| Ordering         | Insertion order          | Sorted order          |
| Basic Operations | O(1) average             | O(log n)              |
| `null`           | One allowed              | Normally not allowed  |
| Main Use         | Unique + insertion order | Unique + sorted order |

---

## 24. TreeSet vs ArrayList

| Feature      | ArrayList                | TreeSet            |
| ------------ | ------------------------ | ------------------ |
| Duplicates   | Allowed                  | Not allowed        |
| Index access | Yes                      | No                 |
| Ordering     | Insertion order          | Sorted order       |
| Search       | O(n)                     | O(log n)           |
| Main Use     | Ordered/index-based data | Sorted unique data |

---

## 25. When Should We Use TreeSet?

Use `TreeSet` when you need:

```text
Unique Elements
       +
Sorted Order
```

Examples:

- Maintaining unique sorted IDs
- Maintaining unique sorted numbers
- Finding smallest/largest elements
- Finding nearest lower/higher values
- Range-based queries

If you only need uniqueness:

```text
HashSet
```

If you need uniqueness + insertion order:

```text
LinkedHashSet
```

If you need uniqueness + sorted order:

```text
TreeSet
```

---

## 26. Complete Example

```java
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {

        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(10);

        System.out.println("Set: " + numbers);

        System.out.println("First: "
                + numbers.first());

        System.out.println("Last: "
                + numbers.last());

        System.out.println("Lower than 30: "
                + numbers.lower(30));

        System.out.println("Higher than 30: "
                + numbers.higher(30));

        System.out.println("Floor of 25: "
                + numbers.floor(25));

        System.out.println("Ceiling of 25: "
                + numbers.ceiling(25));
    }
}
```

Possible output:

```text
Set: [10, 20, 30, 40]
First: 10
Last: 40
Lower than 30: 20
Higher than 30: 40
Floor of 25: 20
Ceiling of 25: 30
```

---

## 27. Important Interview Questions

### Q1. What is TreeSet?

`TreeSet` is a `NavigableSet` implementation that stores unique elements in sorted order.

### Q2. What data structure does TreeSet use?

It is generally implemented using a self-balancing Red-Black Tree.

### Q3. Does TreeSet allow duplicates?

No.

### Q4. Does TreeSet maintain insertion order?

No. It maintains sorted order.

### Q5. What is the time complexity of TreeSet operations?

Basic operations such as `add()`, `remove()`, and `contains()` generally take O(log n).

### Q6. Does TreeSet allow null?

Normally, no when using natural ordering.

### Q7. How does TreeSet sort elements?

It uses natural ordering or a supplied `Comparator`.

### Q8. What is the difference between Comparable and Comparator?

```text
Comparable
→ Natural ordering
→ Implemented by the class

Comparator
→ Custom ordering
→ Defined externally
```

### Q9. What does `first()` return?

The smallest element according to the set's ordering.

### Q10. What does `last()` return?

The largest element according to the set's ordering.

### Q11. What does `floor()` do?

Returns the greatest element less than or equal to the given element.

### Q12. What does `ceiling()` do?

Returns the smallest element greater than or equal to the given element.

### Q13. What does `lower()` do?

Returns the greatest element strictly less than the given element.

### Q14. What does `higher()` do?

Returns the smallest element strictly greater than the given element.

---

## 28. Quick Revision

```text
TreeSet
   ↓
NavigableSet
   ↓
Unique Elements
   ↓
Sorted Order
   ↓
Tree-based structure
   ↓
O(log n) basic operations
```

Important methods:

```text
first()    → Smallest
last()     → Largest

lower(x)   → < x
floor(x)   → <= x

higher(x)  → > x
ceiling(x) → >= x
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

`TreeSet` is useful when you need **unique elements in sorted order**.

Key points:

- Implements `NavigableSet`
- Does not allow duplicates
- Maintains sorted order
- Generally uses a Red-Black Tree
- Basic operations are O(log n)
- Does not provide index-based access
- Normally does not allow `null`
- Supports natural ordering and custom `Comparator`
- Provides useful navigation methods such as `lower()`, `floor()`, `higher()`, and `ceiling()`

The key comparison is:

```text
HashSet
→ Unique elements

LinkedHashSet
→ Unique elements + Insertion order

TreeSet
→ Unique elements + Sorted order
```
