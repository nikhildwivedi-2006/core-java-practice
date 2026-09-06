# Queue Collection Comparison

This file compares the main Queue-related implementations in the Java Collections Framework.

## 1. Main Queue Implementations

| Feature            | LinkedList           | PriorityQueue       | ArrayDeque            |
| ------------------ | -------------------- | ------------------- | --------------------- |
| Implements         | `List`, `Deque`      | `Queue`             | `Deque`               |
| Main behavior      | FIFO / Deque         | Priority-based      | FIFO / Deque          |
| Internal structure | Doubly linked list   | Heap                | Resizable array       |
| Allows duplicates  | Yes                  | Yes                 | Yes                   |
| Allows `null`      | Yes                  | No                  | No                    |
| Insertion order    | Preserved            | Not guaranteed      | Preserved             |
| Priority ordering  | No                   | Yes                 | No                    |
| Add at ends        | Yes                  | No deque-style ends | Yes                   |
| Remove at ends     | Yes                  | Head-based          | Yes                   |
| `peek()`           | O(1)                 | O(1)                | O(1)                  |
| Typical add        | O(1)                 | O(log n)            | O(1) amortized        |
| Typical remove     | O(1) at ends         | O(log n)            | O(1)                  |
| Best use           | Queue + List + Deque | Priority processing | Queue + Deque + Stack |

---

## 2. LinkedList

```java
Queue<Integer> queue = new LinkedList<>();
```

Use `LinkedList` when you need:

- Queue operations
- Deque operations
- List operations
- Support for `null`

It is based on a doubly linked list.

```text
Node ↔ Node ↔ Node
```

For a simple Queue/Deque-only use case, `ArrayDeque` is generally preferred.

---

## 3. PriorityQueue

```java
Queue<Integer> queue = new PriorityQueue<>();
```

Use `PriorityQueue` when elements need to be processed according to priority.

By default:

```text
PriorityQueue
      ↓
   Min-Heap
      ↓
Smallest element first
```

Example:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(30);
pq.offer(10);
pq.offer(20);

System.out.println(pq.poll());
```

Output:

```text
10
```

Important:

> `PriorityQueue` does not guarantee sorted iteration.

---

## 4. ArrayDeque

```java
Deque<Integer> deque = new ArrayDeque<>();
```

Use `ArrayDeque` when you need:

- Queue
- Deque
- Stack replacement
- Efficient operations at both ends

As a Queue:

```java
Deque<Integer> queue = new ArrayDeque<>();

queue.offerLast(10);
queue.offerLast(20);

System.out.println(queue.pollFirst());
```

Output:

```text
10
```

As a Stack:

```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(10);
stack.push(20);

System.out.println(stack.pop());
```

Output:

```text
20
```

---

## 5. Queue vs PriorityQueue vs ArrayDeque

### Normal FIFO Queue

```text
10 → 20 → 30
↓
10 removed first
```

Use:

```java
ArrayDeque
```

or:

```java
LinkedList
```

---

### Priority-Based Queue

```text
30
10 → Highest priority
20
```

Use:

```java
PriorityQueue
```

---

### Double-Ended Queue

```text
10 ↔ 20 ↔ 30
↑           ↑
Front       Rear
```

Use:

```java
ArrayDeque
```

---

## 6. Which One Should You Choose?

| Requirement                       | Recommended     |
| --------------------------------- | --------------- |
| Normal FIFO queue                 | `ArrayDeque`    |
| Priority-based processing         | `PriorityQueue` |
| Queue + Deque                     | `ArrayDeque`    |
| Queue + Stack                     | `ArrayDeque`    |
| Queue + List operations           | `LinkedList`    |
| Need `null` elements              | `LinkedList`    |
| Need sorted/priority removal      | `PriorityQueue` |
| Need fast operations at both ends | `ArrayDeque`    |

---

## 7. Important Interview Differences

### `ArrayDeque` vs `PriorityQueue`

```text
ArrayDeque
→ FIFO / Deque
→ No priority ordering

PriorityQueue
→ Priority-based
→ Heap
→ Default min-heap
```

---

### `ArrayDeque` vs `LinkedList`

Both can implement `Queue` and `Deque`.

```text
ArrayDeque
→ Resizable array
→ Usually lower overhead
→ Does not allow null

LinkedList
→ Doubly linked list
→ Allows null
→ Also implements List
```

For Queue/Deque-only use cases, `ArrayDeque` is generally preferred.

---

### `PriorityQueue` vs `TreeSet`

```text
PriorityQueue
→ Allows duplicates
→ Priority processing
→ Heap

TreeSet
→ No duplicates
→ Sorted set
→ Tree-based
```

---

## 8. Time Complexity Summary

| Operation               | LinkedList |             PriorityQueue |     ArrayDeque |
| ----------------------- | ---------: | ------------------------: | -------------: |
| Add at end              |       O(1) |                  O(log n) | O(1) amortized |
| Remove front/head       |       O(1) |                  O(log n) |           O(1) |
| Peek                    |       O(1) |                      O(1) |           O(1) |
| Search                  |       O(n) |                      O(n) |           O(n) |
| Add/remove at both ends |       O(1) | Not applicable as a deque |           O(1) |

---

## 9. Practical Decision Guide

```text
Need a Queue?
      ↓
Need priority-based processing?
      ↓ Yes
PriorityQueue

      ↓ No
Need operations from both ends?
      ↓ Yes
ArrayDeque

      ↓ No
ArrayDeque
```

`LinkedList` is still a valid Queue/Deque implementation, especially when its `List` behavior is also useful.

---

## 10. Memory Trick

Remember:

```text
LinkedList
→ List + Queue + Deque

PriorityQueue
→ Priority + Heap

ArrayDeque
→ Queue + Deque + Stack
```

Or simply:

```text
FIFO        → ArrayDeque
Priority    → PriorityQueue
List+Queue  → LinkedList
```

---

## 11. Interview Questions

### Q1. Which Queue implementation is generally preferred for a normal FIFO queue?

`ArrayDeque`.

### Q2. Which Queue implementation is used for priority-based processing?

`PriorityQueue`.

### Q3. Can PriorityQueue contain duplicates?

Yes.

### Q4. Can ArrayDeque contain `null`?

No.

### Q5. Can LinkedList contain `null`?

Yes.

### Q6. Can ArrayDeque be used as a Stack?

Yes. It is generally preferred over the legacy `Stack` class for non-concurrent stack usage.

### Q7. Which implementation uses a heap?

`PriorityQueue`.

### Q8. Which implementation supports operations from both ends?

`ArrayDeque` and `LinkedList` through the `Deque` interface.

---

## 12. Final Summary

```text
Queue
│
├── LinkedList
│   → List + Queue + Deque
│
├── PriorityQueue
│   → Priority-based
│   → Heap
│   → Default min-heap
│
└── ArrayDeque
    → Double-ended
    → Queue
    → Stack replacement
```

### One-Line Interview Answer

> Use `ArrayDeque` for a general-purpose Queue/Deque, `PriorityQueue` when elements must be processed by priority, and `LinkedList` when you specifically need its linked-list behavior along with Queue/Deque operations.
