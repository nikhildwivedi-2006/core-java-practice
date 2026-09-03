# LinkedList in Java

## 1. Introduction

`LinkedList` Java Collections Framework ka ek class hai jo `List` aur `Deque` interfaces ko implement karta hai.

```java
import java.util.LinkedList;

LinkedList<String> names = new LinkedList<>();
```

Hierarchy:

```text
Iterable
   ↓
Collection
   ↓
List
   ↓
LinkedList
```

`LinkedList` internally **doubly linked list** use karta hai.

---

## 2. Internal Structure

LinkedList mein data continuous array mein store nahi hota.

Har element ek **Node** mein store hota hai:

```text
null ← [A] ⇄ [B] ⇄ [C] ⇄ [D] → null
```

Har node ke paas generally:

```text
previous | data | next
```

hota hai.

Example:

```text
Node A
prev → null
data → A
next → Node B
```

```text
Node B
prev → Node A
data → B
next → Node C
```

Isliye ise **Doubly Linked List** kaha jata hai.

---

## 3. Creating LinkedList

```java
LinkedList<Integer> numbers = new LinkedList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers);
```

Output:

```text
[10, 20, 30]
```

Interface reference use karna bhi recommended hai:

```java
List<Integer> numbers = new LinkedList<>();
```

Agar LinkedList ke special methods chahiye:

```java
LinkedList<Integer> numbers = new LinkedList<>();
```

---

## 4. Characteristics

LinkedList:

- Insertion order maintain karta hai
- Duplicate elements allow karta hai
- `null` values allow karta hai
- Dynamic size rakhta hai
- Index-based access support karta hai
- Doubly linked list internally use karta hai
- Synchronized nahi hai
- Middle mein insertion/deletion ArrayList ke comparison mein efficient ho sakta hai
- Random access slow hota hai

---

## 5. Important Methods

| Method                | Purpose                     |
| --------------------- | --------------------------- |
| `add(element)`        | End mein element add        |
| `add(index, element)` | Specific index par add      |
| `get(index)`          | Element retrieve            |
| `set(index, element)` | Element replace             |
| `remove(index)`       | Index se remove             |
| `remove(object)`      | Object se remove            |
| `contains(object)`    | Element present hai ya nahi |
| `size()`              | Number of elements          |
| `isEmpty()`           | Empty check                 |
| `clear()`             | Sab elements remove         |
| `addFirst()`          | Beginning mein add          |
| `addLast()`           | End mein add                |
| `getFirst()`          | First element               |
| `getLast()`           | Last element                |
| `removeFirst()`       | First element remove        |
| `removeLast()`        | Last element remove         |

---

## 6. Adding Elements

### add()

```java
LinkedList<String> list = new LinkedList<>();

list.add("Java");
list.add("Spring");
list.add("Docker");

System.out.println(list);
```

Output:

```text
[Java, Spring, Docker]
```

### add(index, element)

```java
list.add(1, "SQL");
```

Result:

```text
[Java, SQL, Spring, Docker]
```

---

## 7. addFirst() and addLast()

LinkedList ka special advantage hai ki beginning aur end par directly operations kar sakte hain.

```java
list.addFirst("HTML");
list.addLast("AWS");
```

Result:

```text
[HTML, Java, SQL, Spring, Docker, AWS]
```

---

## 8. Accessing Elements

```java
String value = list.get(2);

System.out.println(value);
```

Lekin LinkedList mein `get(index)` expensive ho sakta hai because node ko traverse karna pad sakta hai.

Example:

```text
[A] → [B] → [C] → [D] → [E]
```

Agar `get(4)` karna hai, nodes traverse karne pad sakte hain.

Therefore:

```text
get(index) → O(n)
```

---

## 9. Updating Elements

```java
list.set(1, "Python");
```

Example:

```text
Before:
[Java, SQL, Spring]

After:
[Java, Python, Spring]
```

---

## 10. Removing Elements

### remove(index)

```java
list.remove(1);
```

Index `1` ka element remove hoga.

### remove(object)

```java
list.remove("Java");
```

`"Java"` object remove hoga.

---

## 11. removeFirst() and removeLast()

```java
list.removeFirst();
list.removeLast();
```

Ye beginning aur end se element remove karte hain.

LinkedList mein ye operations efficient hote hain.

---

## 12. Searching

```java
list.contains("Java");
```

Returns:

```text
true / false
```

Index find karne ke liye:

```java
list.indexOf("Java");
```

Searching generally:

```text
O(n)
```

---

## 13. Time Complexity

| Operation             | LinkedList |
| --------------------- | ---------: |
| `get(index)`          |       O(n) |
| `set(index)`          |       O(n) |
| `add(element)`        |       O(1) |
| `addFirst()`          |       O(1) |
| `addLast()`           |       O(1) |
| `add(index, element)` |       O(n) |
| `removeFirst()`       |       O(1) |
| `removeLast()`        |       O(1) |
| `remove(index)`       |       O(n) |
| `contains()`          |       O(n) |
| `indexOf()`           |       O(n) |

> Note: `add(index, element)` aur `remove(index)` mein node locate karne ke liye traversal lag sakta hai. Node milne ke baad actual link adjustment O(1) hota hai.

---

## 14. ArrayList vs LinkedList

| Feature            | ArrayList               | LinkedList                         |
| ------------------ | ----------------------- | ---------------------------------- |
| Internal Structure | Dynamic Array           | Doubly Linked List                 |
| Random Access      | Fast                    | Slow                               |
| `get(index)`       | O(1)                    | O(n)                               |
| Add at end         | O(1) amortized          | O(1)                               |
| Add at beginning   | O(n)                    | O(1)                               |
| Remove first       | O(n)                    | O(1)                               |
| Memory             | Less                    | More                               |
| Extra Links        | No                      | `prev` + `next`                    |
| Best For           | Frequent reading/access | Frequent insertion/removal at ends |

### Simple Rule

```text
Frequent get(index)
        ↓
    ArrayList

Frequent add/remove at beginning/end
        ↓
    LinkedList
```

---

## 15. Why LinkedList Uses More Memory?

ArrayList mainly stores references in an array.

LinkedList ke har node mein additional references hote hain:

```text
prev
data
next
```

Therefore LinkedList generally requires more memory than ArrayList.

---

## 16. LinkedList as Queue

LinkedList `Deque` ko implement karta hai, isliye ise queue ki tarah bhi use kar sakte hain.

```java
LinkedList<String> queue = new LinkedList<>();

queue.addLast("A");
queue.addLast("B");
queue.addLast("C");

System.out.println(queue.removeFirst());
```

Output:

```text
A
```

---

## 17. LinkedList as Deque

Deque ka matlab:

```text
Double Ended Queue
```

Dono ends se insertion/removal possible hai.

```java
LinkedList<Integer> deque = new LinkedList<>();

deque.addFirst(10);
deque.addLast(20);

System.out.println(deque);

deque.removeFirst();
deque.removeLast();
```

---

## 18. Complete Example

```java
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<String> languages = new LinkedList<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        languages.addFirst("C");
        languages.addLast("JavaScript");

        System.out.println(languages);

        System.out.println("First: " + languages.getFirst());
        System.out.println("Last: " + languages.getLast());

        languages.removeFirst();
        languages.removeLast();

        System.out.println(languages);
    }
}
```

---

## 19. Important Interview Questions

### Q1. What is LinkedList?

`LinkedList` is a class in Java Collections Framework that implements `List` and `Deque` and internally uses a doubly linked list.

### Q2. ArrayList vs LinkedList?

Main difference:

```text
ArrayList → Dynamic Array
LinkedList → Doubly Linked List
```

ArrayList is better for frequent random access, while LinkedList can be useful for frequent insertion/removal at the ends.

### Q3. Why is get() slow in LinkedList?

Because LinkedList does not provide direct array-style access. The required node may need to be located by traversal.

### Q4. Why does LinkedList consume more memory?

Because each node stores the element plus links to the previous and next nodes.

### Q5. Is LinkedList synchronized?

No.

### Q6. Does LinkedList allow duplicates?

Yes.

### Q7. Does LinkedList allow null?

Yes.

### Q8. Can LinkedList be used as Queue?

Yes.

```java
LinkedList<Integer> queue = new LinkedList<>();
```

### Q9. Can LinkedList be used as Deque?

Yes. It implements `Deque`.

---

## 20. Quick Revision

```text
LinkedList
    ↓
Doubly Linked List
    ↓
Each node = prev + data + next
    ↓
get(index) → O(n)
addFirst() → O(1)
addLast() → O(1)
removeFirst() → O(1)
removeLast() → O(1)
```

### Remember

```text
ArrayList  → Fast access
LinkedList → Efficient end insertion/removal
```

---

## Summary

`LinkedList` is useful when operations at the beginning or end of a list are frequent.

Its major characteristics are:

- Doubly linked list
- Dynamic size
- Maintains insertion order
- Allows duplicates
- Allows `null`
- `get(index)` is O(n)
- `addFirst()` / `addLast()` are O(1)
- `removeFirst()` / `removeLast()` are O(1)
- Implements `List` and `Deque`
- Not synchronized
