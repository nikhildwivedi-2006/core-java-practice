# ArrayDeque

`ArrayDeque` is a class in the Java Collections Framework that implements the `Deque` interface.

`Deque` stands for **Double-Ended Queue**, which means elements can be inserted and removed from both ends.

```java
Deque<Integer> deque = new ArrayDeque<>();
```

---

## 1. Import

```java
import java.util.ArrayDeque;
import java.util.Deque;
```

---

## 2. Basic Example

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        System.out.println(deque);
    }
}
```

Output:

```text
[10, 20, 30]
```

---

## 3. How ArrayDeque Works

An `ArrayDeque` allows operations from both ends:

```text
        Front                 Rear
          ↓                    ↓
       [10] [20] [30] [40]
          ↑                    ↑
       remove               remove
       add                   add
```

Therefore, it can be used as:

- Queue
- Deque
- Stack replacement

---

## 4. Adding Elements

### `addFirst()`

Adds an element at the front.

```java
deque.addFirst(10);
```

Example:

```text
Before:
[20, 30]

After:
[10, 20, 30]
```

### `addLast()`

Adds an element at the end.

```java
deque.addLast(40);
```

Example:

```text
Before:
[10, 20, 30]

After:
[10, 20, 30, 40]
```

---

## 5. `offerFirst()` and `offerLast()`

These methods also add elements from either end.

```java
deque.offerFirst(10);
deque.offerLast(20);
```

They return a boolean indicating whether insertion succeeded.

---

## 6. Removing Elements

### `removeFirst()`

Removes and returns the first element.

```java
deque.removeFirst();
```

### `removeLast()`

Removes and returns the last element.

```java
deque.removeLast();
```

---

## 7. `pollFirst()` and `pollLast()`

These methods also remove elements from either end.

```java
deque.pollFirst();
deque.pollLast();
```

If the deque is empty, they return `null`.

This makes them safer than `removeFirst()` and `removeLast()` when an empty deque is possible.

---

## 8. Viewing Elements

### `getFirst()`

Returns the first element without removing it.

```java
deque.getFirst();
```

Throws an exception if the deque is empty.

### `getLast()`

Returns the last element without removing it.

```java
deque.getLast();
```

### `peekFirst()`

Returns the first element without removing it.

```java
deque.peekFirst();
```

Returns `null` if empty.

### `peekLast()`

Returns the last element without removing it.

```java
deque.peekLast();
```

Returns `null` if empty.

---

## 9. Important Method Pairs

| Operation    | Exception Version | Safe Version   |
| ------------ | ----------------- | -------------- |
| Add first    | `addFirst()`      | `offerFirst()` |
| Add last     | `addLast()`       | `offerLast()`  |
| Remove first | `removeFirst()`   | `pollFirst()`  |
| Remove last  | `removeLast()`    | `pollLast()`   |
| View first   | `getFirst()`      | `peekFirst()`  |
| View last    | `getLast()`       | `peekLast()`   |

The safe versions return a special value such as `null` or `false` instead of throwing an exception when the operation cannot be completed.

---

## 10. Using ArrayDeque as a Queue

A queue normally inserts at the rear and removes from the front.

```java
Deque<Integer> queue = new ArrayDeque<>();

queue.offerLast(10);
queue.offerLast(20);
queue.offerLast(30);

System.out.println(queue.pollFirst());
```

Output:

```text
10
```

So:

```text
offerLast() → Insert
pollFirst() → Remove
peekFirst()  → View
```

This gives normal FIFO behavior.

---

## 11. Using ArrayDeque as a Stack

`ArrayDeque` can also be used as a stack.

```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop());
```

Output:

```text
30
```

This gives LIFO behavior.

```text
push() → Add
pop()  → Remove
peek() → View
```

For modern Java code, `ArrayDeque` is generally preferred over the legacy `Stack` class for stack behavior.

---

## 12. Complete Example

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(20);
        deque.addLast(30);
        deque.addFirst(10);

        System.out.println(deque);

        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());

        System.out.println("Removed First: " + deque.pollFirst());
        System.out.println("Removed Last: " + deque.pollLast());

        System.out.println(deque);
    }
}
```

Output:

```text
[10, 20, 30]
First: 10
Last: 30
Removed First: 10
Removed Last: 30
[20]
```

---

## 13. Null Elements

`ArrayDeque` **does not allow `null` elements**.

```java
Deque<Integer> deque = new ArrayDeque<>();

deque.add(null); // NullPointerException
```

This is an important difference from `LinkedList`, which can store `null`.

---

## 14. ArrayDeque vs LinkedList

Both can implement `Deque`.

| Feature             | ArrayDeque                                     | LinkedList         |
| ------------------- | ---------------------------------------------- | ------------------ |
| Internal structure  | Resizable array                                | Doubly linked list |
| Queue operations    | Yes                                            | Yes                |
| Deque operations    | Yes                                            | Yes                |
| Allows `null`       | No                                             | Yes                |
| Random index access | No                                             | Yes, but O(n)      |
| Memory overhead     | Generally lower                                | Generally higher   |
| Stack replacement   | Recommended                                    | Possible           |
| Performance         | Generally preferred for queue/deque operations | More overhead      |

For a typical queue, deque, or stack use case, `ArrayDeque` is usually the better choice.

---

## 15. ArrayDeque vs Stack

| Feature               | ArrayDeque             | Stack        |
| --------------------- | ---------------------- | ------------ |
| Type                  | `Deque` implementation | Legacy class |
| LIFO operations       | Yes                    | Yes          |
| Modern recommendation | Yes                    | Generally no |
| Allows `null`         | No                     | Yes          |
| Synchronization       | Not synchronized       | Synchronized |

For modern Java code:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

is generally preferred over:

```java
Stack<Integer> stack = new Stack<>();
```

---

## 16. Time Complexity

Typical operations are:

| Operation       |     Complexity |
| --------------- | -------------: |
| `addFirst()`    | O(1) amortized |
| `addLast()`     | O(1) amortized |
| `removeFirst()` |           O(1) |
| `removeLast()`  |           O(1) |
| `peekFirst()`   |           O(1) |
| `peekLast()`    |           O(1) |
| Search          |           O(n) |

---

## 17. Common Use Cases

`ArrayDeque` is commonly used for:

- Queue implementation
- Stack implementation
- BFS
- Sliding window problems
- Monotonic queue/deque problems
- Undo/redo style operations
- Processing elements from both ends

---

## 18. Important Interview Questions

### Q1. What is ArrayDeque?

`ArrayDeque` is a resizable-array implementation of the `Deque` interface that supports insertion and removal from both ends.

### Q2. Can ArrayDeque contain null?

No. `ArrayDeque` does not allow `null` elements.

### Q3. Can ArrayDeque be used as a Queue?

Yes.

```java
Deque<Integer> queue = new ArrayDeque<>();
```

### Q4. Can ArrayDeque be used as a Stack?

Yes.

```java
Deque<Integer> stack = new ArrayDeque<>();
```

### Q5. Why is ArrayDeque preferred over Stack?

`Stack` is a legacy class. `ArrayDeque` provides stack operations through the modern `Deque` interface and is generally preferred for non-concurrent stack usage.

### Q6. What is Deque?

`Deque` means **Double-Ended Queue**. It allows insertion and removal from both the front and rear.

---

## 19. Memory Trick

```text
ArrayDeque
     ↓
   Deque
     ↓
Two Ends
 ↙       ↘
Front    Rear
```

As Queue:

```text
offerLast()
     ↓
pollFirst()
```

As Stack:

```text
push()
  ↓
pop()
```

---

## 20. Summary

```text
ArrayDeque
→ Implements Deque
→ Supports both ends
→ Can work as Queue
→ Can work as Stack
→ Does not allow null
→ Fast end operations
→ Usually preferred for Queue/Deque/Stack use cases
```

### One-Line Interview Answer

> `ArrayDeque` is a resizable-array implementation of `Deque` that supports efficient insertion and removal from both ends and can be used as both a queue and a stack.
