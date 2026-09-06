# Queue Interface

`Queue` is an interface in the Java Collections Framework used to represent a collection designed for holding elements before they are processed.

A queue generally follows the **FIFO (First-In, First-Out)** principle.

```text
First element added → First element removed
```

## 1. Queue Hierarchy

```text
Iterable
   ↓
Collection
   ↓
Queue
   ├── PriorityQueue
   └── Deque
        └── ArrayDeque
```

`LinkedList` also implements `Queue` and `Deque`.

```text
Queue
  ├── PriorityQueue
  ├── LinkedList
  └── Deque
       └── ArrayDeque
```

---

## 2. FIFO Principle

FIFO means:

> The element inserted first is normally removed first.

Example:

```text
Queue:

10 → 20 → 30

Remove
  ↓
10

Remaining:

20 → 30
```

This is similar to a real-world queue where the person who arrives first is served first.

---

## 3. Creating a Queue

`Queue` is an interface, so we cannot create its object directly.

```java
Queue<Integer> queue = new LinkedList<>();
```

Or:

```java
Queue<Integer> queue = new ArrayDeque<>();
```

---

## 4. Important Queue Methods

### `add()`

Adds an element to the queue.

```java
queue.add(10);
queue.add(20);
queue.add(30);
```

If the element cannot be added, `add()` may throw an exception.

---

### `offer()`

Adds an element to the queue.

```java
queue.offer(10);
queue.offer(20);
queue.offer(30);
```

Unlike `add()`, `offer()` is designed to indicate failure by returning `false` when insertion is not possible.

For most common unbounded queues, both usually succeed.

---

### `remove()`

Removes and returns the head of the queue.

```java
queue.remove();
```

If the queue is empty, it throws `NoSuchElementException`.

---

### `poll()`

Removes and returns the head of the queue.

```java
queue.poll();
```

If the queue is empty, it returns `null`.

---

### `element()`

Returns the head without removing it.

```java
queue.element();
```

If the queue is empty, it throws `NoSuchElementException`.

---

### `peek()`

Returns the head without removing it.

```java
queue.peek();
```

If the queue is empty, it returns `null`.

---

## 5. `add()` vs `offer()`

| Method    | Purpose        | Failure behavior    |
| --------- | -------------- | ------------------- |
| `add()`   | Insert element | May throw exception |
| `offer()` | Insert element | Returns `false`     |

For normal unbounded queues, there is usually no practical difference.

---

## 6. `remove()` vs `poll()`

| Method     | Purpose     | Empty Queue      |
| ---------- | ----------- | ---------------- |
| `remove()` | Remove head | Throws exception |
| `poll()`   | Remove head | Returns `null`   |

Example:

```java
Queue<Integer> queue = new LinkedList<>();

queue.poll();    // null
queue.remove();  // NoSuchElementException
```

---

## 7. `element()` vs `peek()`

| Method      | Purpose   | Empty Queue      |
| ----------- | --------- | ---------------- |
| `element()` | View head | Throws exception |
| `peek()`    | View head | Returns `null`   |

---

## 8. Complete Example

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue);

        System.out.println("Head: " + queue.peek());

        System.out.println("Removed: " + queue.poll());

        System.out.println(queue);
    }
}
```

Output:

```text
[10, 20, 30]
Head: 10
Removed: 10
[20, 30]
```

---

## 9. Queue vs Stack

| Queue                               | Stack        |
| ----------------------------------- | ------------ |
| Usually FIFO                        | LIFO         |
| Insert at rear                      | Push at top  |
| Remove from front                   | Pop from top |
| `offer()` / `add()`                 | `push()`     |
| `poll()` / `remove()`               | `pop()`      |
| `peek()`                            | `peek()`     |
| Common implementation: `ArrayDeque` | `ArrayDeque` |

For modern Java code, `ArrayDeque` is generally preferred over the legacy `Stack` class.

---

## 10. Queue vs Deque

### Queue

Primarily designed for processing elements from one end.

```text
Insert → [10 20 30] → Remove
          front
```

### Deque

`Deque` means **Double-Ended Queue**.

It allows insertion and removal from both ends.

```text
        add/remove
             ↓
10 ← [20 30] → 40
        ↑
   add/remove
```

`Deque` extends `Queue`.

---

## 11. Important Interview Point

A common question is:

**Why does Queue have both `add/offer`, `remove/poll`, and `element/peek`?**

Because each pair provides a different behavior when the operation cannot be completed:

```text
add()     → exception
offer()   → special return value

remove()  → exception
poll()    → null

element() → exception
peek()    → null
```

### Easy Memory Trick

```text
Exception versions:
add
remove
element

Safe-return versions:
offer
poll
peek
```

---

## 12. Queue Implementations

### LinkedList

```java
Queue<Integer> queue = new LinkedList<>();
```

- Supports Queue and Deque operations
- Allows `null`
- Good general-purpose option
- More memory overhead because of linked nodes

### PriorityQueue

```java
Queue<Integer> queue = new PriorityQueue<>();
```

- Elements are processed according to priority
- Does **not** follow normal insertion-order FIFO behavior
- Does not allow `null`
- Commonly implemented using a heap

### ArrayDeque

```java
Queue<Integer> queue = new ArrayDeque<>();
```

- Resizable-array based
- Supports Queue and Deque operations
- Does not allow `null`
- Usually preferred when you need a fast general-purpose queue/deque

---

## 13. Important Note About FIFO

FIFO is the normal behavior of a queue, but **not every class implementing `Queue` processes elements according to insertion order**.

For example:

```java
Queue<Integer> queue = new PriorityQueue<>();
```

A `PriorityQueue` processes elements according to their priority/natural ordering rather than simple insertion order.

Therefore:

```text
Queue → Interface

FIFO → General queue behavior

PriorityQueue → Priority-based processing
```

---

## 14. Time Complexity

For a typical queue implementation such as `ArrayDeque`:

| Operation         |     Complexity |
| ----------------- | -------------: |
| Add at end        | O(1) amortized |
| Remove from front |           O(1) |
| Peek              |           O(1) |
| Search            |           O(n) |

The exact complexity can depend on the implementation.

---

## 15. Common Use Cases

Queues are commonly used for:

- Task processing
- Job scheduling
- Request handling
- Breadth-First Search (BFS)
- Producer-consumer systems
- Message processing
- CPU/task scheduling
- Buffering

---

## 16. Interview Questions

### Q1. Is Queue an interface?

Yes.

```java
Queue<Integer> queue = new LinkedList<>();
```

---

### Q2. What principle does a normal Queue follow?

**FIFO — First-In, First-Out.**

---

### Q3. Difference between `poll()` and `remove()`?

`poll()` returns `null` when the queue is empty, while `remove()` throws `NoSuchElementException`.

---

### Q4. Difference between `peek()` and `element()`?

`peek()` returns `null` when empty, while `element()` throws `NoSuchElementException`.

---

### Q5. Difference between `add()` and `offer()`?

`add()` may throw an exception when insertion fails, while `offer()` returns `false`.

---

### Q6. Can Queue contain `null`?

It depends on the implementation.

For example:

- `LinkedList` allows `null`
- `PriorityQueue` does not allow `null`
- `ArrayDeque` does not allow `null`

---

## 17. Summary

```text
Queue
 ↓
Usually FIFO
 ↓
Insert → offer() / add()
Remove → poll() / remove()
View   → peek() / element()
```

### Memory Trick

```text
Queue
→ FIFO

offer()
→ Add safely

poll()
→ Remove safely

peek()
→ View safely
```
