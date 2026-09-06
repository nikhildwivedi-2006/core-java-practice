# PriorityQueue

`PriorityQueue` is a class in the Java Collections Framework that implements the `Queue` interface.

Unlike a normal FIFO queue, a `PriorityQueue` processes elements according to their **priority**.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

For integers, the smallest element has the highest priority by default.

---

## 1. Import

```java
import java.util.PriorityQueue;
```

---

## 2. Basic Example

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println(pq);

        System.out.println(pq.peek());
        System.out.println(pq.poll());
    }
}
```

Output:

```text
10
10
```

The smallest element is returned first because the default priority is **natural ordering**.

---

## 3. How PriorityQueue Works

`PriorityQueue` is internally based on a **heap data structure**.

By default, it behaves as a **min-heap**.

```text
             10
           /    \
         30      20
        /  \
      40    50
```

The smallest element is kept at the head.

Therefore:

```java
pq.peek();
```

returns the smallest element.

And:

```java
pq.poll();
```

removes the smallest element.

---

## 4. Important Point About Ordering

A `PriorityQueue` does **not** guarantee that iterating through it will produce elements in sorted order.

For example:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(30);
pq.offer(10);
pq.offer(20);
pq.offer(5);

System.out.println(pq);
```

The printed representation should **not** be treated as a sorted list.

The important guarantee is:

```text
peek() → highest-priority element
poll() → removes highest-priority element
```

---

## 5. Important Methods

### `offer()`

Adds an element.

```java
pq.offer(10);
```

---

### `add()`

Also adds an element.

```java
pq.add(20);
```

For an ordinary unbounded `PriorityQueue`, both normally succeed.

---

### `peek()`

Returns the highest-priority element without removing it.

```java
pq.peek();
```

Returns `null` if the queue is empty.

---

### `poll()`

Removes and returns the highest-priority element.

```java
pq.poll();
```

Returns `null` if the queue is empty.

---

### `remove()`

Removes and returns the head.

```java
pq.remove();
```

Throws `NoSuchElementException` if the queue is empty.

---

### `size()`

Returns the number of elements.

```java
pq.size();
```

---

### `isEmpty()`

Checks whether the queue is empty.

```java
pq.isEmpty();
```

---

## 6. Min-Heap PriorityQueue

By default, `PriorityQueue` is a min-heap.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(40);
pq.offer(10);
pq.offer(30);
pq.offer(20);

while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}
```

Output:

```text
10
20
30
40
```

---

## 7. Max-Heap PriorityQueue

A `Comparator` can be used to create max-heap behavior.

```java
PriorityQueue<Integer> pq =
        new PriorityQueue<>((a, b) -> b - a);

pq.offer(40);
pq.offer(10);
pq.offer(30);
pq.offer(20);

while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}
```

Output:

```text
40
30
20
10
```

A safer comparator for general integer values is:

```java
PriorityQueue<Integer> pq =
        new PriorityQueue<>(Comparator.reverseOrder());
```

---

## 8. PriorityQueue with Strings

Strings use their natural ordering by default.

```java
PriorityQueue<String> pq = new PriorityQueue<>();

pq.offer("Banana");
pq.offer("Apple");
pq.offer("Mango");

while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}
```

Output:

```text
Apple
Banana
Mango
```

---

## 9. PriorityQueue with Custom Objects

For custom objects, we need to define how objects should be compared.

### Using Comparator

```java
import java.util.PriorityQueue;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentPriorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Student> pq =
                new PriorityQueue<>(
                    (s1, s2) -> Integer.compare(s2.marks, s1.marks)
                );

        pq.offer(new Student("Aman", 70));
        pq.offer(new Student("Riya", 90));
        pq.offer(new Student("Raj", 80));

        while (!pq.isEmpty()) {
            Student student = pq.poll();
            System.out.println(student.name + " " + student.marks);
        }
    }
}
```

Output:

```text
Riya 90
Raj 80
Aman 70
```

The student with the highest marks gets the highest priority.

---

## 10. Time Complexity

For a `PriorityQueue`:

| Operation        | Complexity |
| ---------------- | ---------: |
| `peek()`         |       O(1) |
| `offer()`        |   O(log n) |
| `add()`          |   O(log n) |
| `poll()`         |   O(log n) |
| `remove()` head  |   O(log n) |
| `contains()`     |       O(n) |
| `remove(Object)` |       O(n) |

The heap is adjusted after insertion or removal to maintain the heap property.

---

## 11. PriorityQueue vs Normal Queue

| Feature       | Queue                   | PriorityQueue                    |
| ------------- | ----------------------- | -------------------------------- |
| Main behavior | Usually FIFO            | Priority-based                   |
| Head          | First element           | Highest-priority element         |
| Ordering      | Insertion order concept | Priority                         |
| `peek()`      | Front element           | Highest-priority element         |
| `poll()`      | Removes front           | Removes highest-priority element |
| Common use    | Task processing         | Scheduling / DSA problems        |

---

## 12. PriorityQueue vs TreeSet

These two are sometimes confused.

| Feature            | PriorityQueue            | TreeSet                                 |
| ------------------ | ------------------------ | --------------------------------------- |
| Allows duplicates  | Yes                      | No                                      |
| Main purpose       | Priority processing      | Sorted unique elements                  |
| Internal structure | Heap                     | Tree                                    |
| `peek()`           | Highest-priority element | Smallest/largest via navigation methods |
| `poll()`           | Removes head             | Not a standard Queue operation          |
| Iteration sorted?  | No                       | Yes                                     |

For example:

```text
PriorityQueue
→ "Give me the next highest-priority element."

TreeSet
→ "Keep all unique elements sorted."
```

---

## 13. Important Characteristics

`PriorityQueue`:

- Implements `Queue`
- Allows duplicate elements
- Does not allow `null` elements
- Is not synchronized
- Uses natural ordering by default
- Can use a custom `Comparator`
- Does not guarantee sorted iteration order
- Provides O(log n) insertion and removal of the head

---

## 14. Common Use Cases

PriorityQueue is commonly used in:

- CPU/task scheduling
- Dijkstra's shortest path algorithm
- Prim's algorithm
- Top-K problems
- Kth largest/smallest problems
- Merge K sorted lists
- Event scheduling
- Huffman coding
- Job scheduling

---

## 15. DSA Example: Kth Largest Element

PriorityQueue is frequently used to solve Top-K problems efficiently.

For example, to maintain the `k` largest elements, a min-heap can be used:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

for (int num : nums) {

    pq.offer(num);

    if (pq.size() > k) {
        pq.poll();
    }
}
```

After processing all elements:

```java
pq.peek();
```

contains the kth largest element.

---

## 16. Important Interview Questions

### Q1. What is PriorityQueue?

`PriorityQueue` is a Queue implementation that processes elements according to their priority rather than simple FIFO order.

### Q2. What is the default behavior of PriorityQueue?

It uses natural ordering and behaves like a **min-heap**.

### Q3. Does PriorityQueue allow duplicates?

Yes.

### Q4. Does PriorityQueue allow null?

No.

### Q5. Does PriorityQueue maintain sorted order during iteration?

No.

Only the head is guaranteed to be the highest-priority element according to the queue's ordering.

### Q6. What is the time complexity of `offer()`?

`O(log n)`.

### Q7. What is the time complexity of `peek()`?

`O(1)`.

### Q8. How can you create a max-heap?

Using a reverse comparator:

```java
PriorityQueue<Integer> pq =
        new PriorityQueue<>(Comparator.reverseOrder());
```

### Q9. What data structure is used internally?

A heap, represented using an array.

---

## 17. Memory Trick

```text
PriorityQueue
        ↓
      Heap
        ↓
Default = Min-Heap
        ↓
peek() → Smallest
poll() → Removes Smallest
```

For max-heap:

```text
PriorityQueue + Comparator.reverseOrder()
        ↓
      Max-Heap
        ↓
peek() → Largest
poll() → Removes Largest
```

---

## 18. Summary

```text
PriorityQueue
→ Queue based on priority
→ Heap-based
→ Default = Min-Heap
→ Duplicates allowed
→ null not allowed
→ peek() = O(1)
→ offer()/poll() = O(log n)
→ Iteration is NOT sorted
```

### One-Line Interview Answer

> `PriorityQueue` is a heap-based Queue implementation that processes elements according to their priority; by default, it uses natural ordering and behaves as a min-heap.
