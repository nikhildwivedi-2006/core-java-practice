# Set Collection Comparison

This file compares the main `Set` implementations in the Java Collections Framework.

## 1. Set Implementations

| Feature            | HashSet             | LinkedHashSet                | TreeSet                |
| ------------------ | ------------------- | ---------------------------- | ---------------------- |
| Duplicate elements | Not allowed         | Not allowed                  | Not allowed            |
| Order              | No guaranteed order | Insertion order              | Sorted order           |
| Null element       | One `null` allowed  | One `null` allowed           | Normally not allowed   |
| Internal structure | Hash table          | Hash table + linked ordering | Red-Black Tree         |
| Average add        | O(1)                | O(1)                         | O(log n)               |
| Average remove     | O(1)                | O(1)                         | O(log n)               |
| Average contains   | O(1)                | O(1)                         | O(log n)               |
| Index-based access | No                  | No                           | No                     |
| Sorting            | No                  | No                           | Yes                    |
| Memory usage       | Lower               | Higher than HashSet          | Higher                 |
| Best use           | Fast uniqueness     | Uniqueness + insertion order | Sorted unique elements |

---

## 2. HashSet

Use `HashSet` when you mainly need:

- Unique elements
- Fast `add()`, `remove()`, and `contains()`
- No requirement for a specific iteration order

```java
Set<Integer> numbers = new HashSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);
numbers.add(10);

System.out.println(numbers);
```

The duplicate `10` is ignored.

---

## 3. LinkedHashSet

Use `LinkedHashSet` when you need:

- Unique elements
- Insertion order preservation

```java
Set<Integer> numbers = new LinkedHashSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);
numbers.add(10);

System.out.println(numbers);
```

Output:

```text
[30, 10, 20]
```

The duplicate is removed while insertion order is preserved.

---

## 4. TreeSet

Use `TreeSet` when you need:

- Unique elements
- Sorted order
- Navigational operations such as `lower()`, `floor()`, `higher()`, and `ceiling()`

```java
Set<Integer> numbers = new TreeSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);
numbers.add(10);

System.out.println(numbers);
```

Output:

```text
[10, 20, 30]
```

---

## 5. When to Use Which?

### Use HashSet

```text
Need unique elements
        ↓
Order does not matter
        ↓
HashSet
```

Example:

- Removing duplicates
- Fast membership checking
- Maintaining a collection of unique IDs

---

### Use LinkedHashSet

```text
Need unique elements
        ↓
Insertion order matters
        ↓
LinkedHashSet
```

Example:

- Remove duplicates while preserving original order
- Maintaining unique user inputs in the order received

---

### Use TreeSet

```text
Need unique elements
        ↓
Sorted order is required
        ↓
TreeSet
```

Example:

- Maintaining sorted numbers
- Sorted names
- Range queries
- Finding nearest/lower/higher values

---

## 6. HashSet vs LinkedHashSet vs TreeSet

### HashSet

```java
Set<String> set = new HashSet<>();
```

**Main idea:**

> Unique elements + fast operations

---

### LinkedHashSet

```java
Set<String> set = new LinkedHashSet<>();
```

**Main idea:**

> Unique elements + insertion order

---

### TreeSet

```java
Set<String> set = new TreeSet<>();
```

**Main idea:**

> Unique elements + sorted order

---

## 7. Important Interview Point

All three are implementations of the `Set` interface:

```text
Set
 ├── HashSet
 ├── LinkedHashSet
 └── SortedSet
      └── NavigableSet
           └── TreeSet
```

The main difference is how they maintain and access their elements.

```text
HashSet
    ↓
Hashing

LinkedHashSet
    ↓
Hashing + Linked ordering

TreeSet
    ↓
Tree structure + sorting
```

---

## 8. Comparable vs Comparator in TreeSet

`TreeSet` needs a way to determine the ordering of elements.

### Natural Ordering

Classes such as `Integer` and `String` already implement `Comparable`.

```java
TreeSet<Integer> numbers = new TreeSet<>();

numbers.add(50);
numbers.add(10);
numbers.add(30);

System.out.println(numbers);
```

Output:

```text
[10, 30, 50]
```

### Custom Ordering

A `Comparator` can be provided when custom sorting is required.

```java
TreeSet<Integer> numbers =
        new TreeSet<>((a, b) -> b - a);

numbers.add(10);
numbers.add(30);
numbers.add(20);

System.out.println(numbers);
```

Output:

```text
[30, 20, 10]
```

---

## 9. Quick Decision Table

| Requirement                  | Choose          |
| ---------------------------- | --------------- |
| Only uniqueness              | `HashSet`       |
| Uniqueness + insertion order | `LinkedHashSet` |
| Uniqueness + sorted order    | `TreeSet`       |
| Fast average lookup          | `HashSet`       |
| Preserve insertion order     | `LinkedHashSet` |
| Sorted data                  | `TreeSet`       |
| Range/navigation operations  | `TreeSet`       |

---

## 10. Memory Trick

Remember this:

```text
HashSet
→ Unique

LinkedHashSet
→ Unique + Insertion Order

TreeSet
→ Unique + Sorted Order
```

### One-Line Interview Answer

> `HashSet` provides unique elements with no guaranteed order, `LinkedHashSet` provides unique elements while maintaining insertion order, and `TreeSet` provides unique elements in sorted order with O(log n) basic operations.
