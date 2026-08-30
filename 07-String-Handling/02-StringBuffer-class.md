# StringBuffer Class in Java

## Introduction

`StringBuffer` is a mutable sequence of characters.

Unlike `String`, a `StringBuffer` object can be modified after it is created.

```java
StringBuffer sb = new StringBuffer("Java");
```

We can change the same object using methods such as:

```text
append()
insert()
delete()
replace()
reverse()
```

`StringBuffer` belongs to:

```java
java.lang
```

So no import is required.

---

# String vs StringBuffer

## String

`String` is immutable.

```java
String s = "Java";

s = s + " Programming";
```

A new String object is created.

---

## StringBuffer

`StringBuffer` is mutable.

```java
StringBuffer sb = new StringBuffer("Java");

sb.append(" Programming");
```

The existing `StringBuffer` object is modified.

Conceptually:

```text
String:

"Java" → "Java Programming"
  ↓            ↓
old object   new object


StringBuffer:

"Java"
  ↓
same object modified
  ↓
"Java Programming"
```

---

# Creating StringBuffer

## Default Constructor

```java
StringBuffer sb = new StringBuffer();
```

Creates an empty StringBuffer with a default initial capacity of:

```text
16 characters
```

---

## Constructor with String

```java
StringBuffer sb =
        new StringBuffer("Java");
```

The initial capacity is:

```text
16 + length of String
```

For `"Java"`:

```text
16 + 4 = 20
```

---

## Constructor with Capacity

```java
StringBuffer sb =
        new StringBuffer(50);
```

This creates a StringBuffer with an initial capacity of:

```text
50 characters
```

---

# append()

`append()` adds data at the end.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

Different data types can also be appended:

```java
sb.append(10);
sb.append(20.5);
sb.append(true);
```

---

# insert()

`insert()` adds data at a specified index.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.insert(4, " Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

Example:

```java
StringBuffer sb =
        new StringBuffer("Jav");

sb.insert(3, "a");

System.out.println(sb);
```

Output:

```text
Java
```

---

# delete()

`delete()` removes characters between two indexes.

Syntax:

```java
delete(start, end)
```

The start index is inclusive and the end index is exclusive.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java Programming");

sb.delete(4, 15);

System.out.println(sb);
```

Output:

```text
Java
```

---

# deleteCharAt()

Removes a single character.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.deleteCharAt(3);

System.out.println(sb);
```

Output:

```text
Jav
```

---

# replace()

Replaces characters within a specified range.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java Programming");

sb.replace(5, 16, "Language");

System.out.println(sb);
```

Output:

```text
Java Language
```

Remember:

```text
start → inclusive
end   → exclusive
```

---

# reverse()

Reverses the characters.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.reverse();

System.out.println(sb);
```

Output:

```text
avaJ
```

---

# length()

Returns the number of characters currently stored.

```java
StringBuffer sb =
        new StringBuffer("Java");

System.out.println(sb.length());
```

Output:

```text
4
```

---

# capacity()

Returns the current capacity of the StringBuffer.

Example:

```java
StringBuffer sb =
        new StringBuffer();

System.out.println(sb.capacity());
```

Output:

```text
16
```

For:

```java
StringBuffer sb =
        new StringBuffer("Java");
```

Capacity is:

```text
20
```

because:

```text
16 + 4 = 20
```

---

# Capacity vs Length

This is an important distinction.

```text
length
   ↓
Number of characters currently stored

capacity
   ↓
Amount of character storage currently available
```

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");
```

Then:

```text
length   = 4
capacity = 20
```

---

# Automatic Capacity Growth

When the current capacity is insufficient, StringBuffer automatically increases its capacity.

The commonly used growth rule is:

```text
new capacity = old capacity × 2 + 2
```

Example:

```text
Old capacity = 16

New capacity:
16 × 2 + 2
= 34
```

The implementation may ensure enough capacity for the requested minimum capacity.

---

# setLength()

`setLength()` changes the length of the StringBuffer.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.setLength(2);

System.out.println(sb);
```

Output:

```text
Ja
```

If the new length is greater than the current length, additional positions are filled with null characters (`\u0000`).

---

# charAt()

Returns the character at a given index.

```java
StringBuffer sb =
        new StringBuffer("Java");

System.out.println(sb.charAt(1));
```

Output:

```text
a
```

---

# setCharAt()

Changes the character at a particular index.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.setCharAt(0, 'K');

System.out.println(sb);
```

Output:

```text
Kava
```

This demonstrates mutability.

---

# toString()

Converts StringBuffer into a String.

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

String s = sb.toString();

System.out.println(s);
```

Output:

```text
Java
```

---

# StringBuffer is Mutable

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

The same StringBuffer object is modified.

This is different from String.

---

# StringBuffer is Synchronized

`StringBuffer` is synchronized.

This means its methods are designed for thread-safe access when the same StringBuffer object is shared among multiple threads.

Because synchronization introduces overhead, StringBuffer is generally slower than StringBuilder in single-threaded scenarios.

---

# StringBuilder vs StringBuffer

Both are mutable character sequences.

Main difference:

```text
StringBuffer  → synchronized
StringBuilder → not synchronized
```

Therefore:

```text
StringBuffer
→ Better when synchronization/thread-safe shared access is needed

StringBuilder
→ Better for normal single-threaded string manipulation
```

---

# String vs StringBuffer vs StringBuilder

| Feature                                | String                 | StringBuffer                          | StringBuilder                                |
| -------------------------------------- | ---------------------- | ------------------------------------- | -------------------------------------------- |
| Mutability                             | Immutable              | Mutable                               | Mutable                                      |
| Thread-safe                            | Yes, because immutable | Synchronized                          | Not synchronized                             |
| Performance for repeated modifications | Generally slower       | Generally slower than StringBuilder   | Generally faster                             |
| Synchronization                        | Not applicable         | Yes                                   | No                                           |
| Introduced                             | Java 1.0               | Java 1.0                              | Java 5                                       |
| Best use                               | Fixed text             | Mutable text with synchronized access | Mutable text in typical single-threaded code |

---

# When Should We Use String?

Use `String` when the value should not change.

Example:

```java
String country = "India";
```

For fixed or mostly unchanged text, String is the natural choice.

---

# When Should We Use StringBuffer?

Use `StringBuffer` when:

```text
String content changes frequently
AND
the same mutable object may be shared across threads
AND
synchronized methods are useful
```

Example:

```java
StringBuffer sb =
        new StringBuffer();

sb.append("Java");
sb.append(" Programming");
```

---

# When Should We Use StringBuilder?

For normal string manipulation in a single-threaded context, `StringBuilder` is generally preferred over `StringBuffer`.

Example:

```java
StringBuilder sb =
        new StringBuilder();

sb.append("Java");
sb.append(" Programming");
```

---

# Important Interview Question

## Why is StringBuffer slower than StringBuilder?

Because StringBuffer methods are synchronized.

Synchronization provides thread-safety but can introduce additional overhead.

StringBuilder does not synchronize its methods, so it is generally faster in single-threaded situations.

---

# Common StringBuffer Methods

| Method           | Purpose                    |
| ---------------- | -------------------------- |
| `append()`       | Adds data at the end       |
| `insert()`       | Inserts data at an index   |
| `delete()`       | Deletes a range            |
| `deleteCharAt()` | Deletes one character      |
| `replace()`      | Replaces a range           |
| `reverse()`      | Reverses the sequence      |
| `length()`       | Returns current length     |
| `capacity()`     | Returns current capacity   |
| `charAt()`       | Returns character at index |
| `setCharAt()`    | Changes a character        |
| `setLength()`    | Changes current length     |
| `toString()`     | Converts to String         |

---

# Example

```java
public class StringBufferExample {

    public static void main(String[] args) {

        StringBuffer sb =
                new StringBuffer("Java");

        System.out.println("Original: " + sb);

        sb.append(" Programming");

        System.out.println("After append: " + sb);

        sb.insert(5, "Core ");

        System.out.println("After insert: " + sb);

        sb.reverse();

        System.out.println("After reverse: " + sb);
    }
}
```

---

# Important Interview Questions

## 1. Is StringBuffer mutable?

Yes.

---

## 2. Is StringBuffer thread-safe?

Its methods are synchronized, making it suitable for synchronized shared access.

---

## 3. Difference between StringBuffer and StringBuilder?

```text
StringBuffer  → synchronized
StringBuilder → not synchronized
```

---

## 4. Which is faster: StringBuffer or StringBuilder?

Generally, `StringBuilder` is faster in single-threaded code because it does not have synchronization overhead.

---

## 5. What is the default capacity of StringBuffer?

```text
16 characters
```

---

## 6. What is the capacity when created using a String?

For:

```java
new StringBuffer("Java")
```

the initial capacity is:

```text
16 + String length
```

So:

```text
20
```

---

## 7. What happens when capacity is exceeded?

StringBuffer automatically expands its capacity to accommodate additional characters.

---

## 8. Can StringBuffer be converted into String?

Yes.

Using:

```java
toString()
```

Example:

```java
StringBuffer sb =
        new StringBuffer("Java");

String s = sb.toString();
```

---

# Quick Revision

```text
String
  ↓
Immutable
  ↓
Best for fixed text
```

```text
StringBuffer
  ↓
Mutable
  ↓
Synchronized
  ↓
Thread-safe shared access
```

```text
StringBuilder
  ↓
Mutable
  ↓
Not synchronized
  ↓
Generally faster for single-threaded operations
```

Remember:

```text
String
   → Immutable

StringBuffer
   → Mutable + Synchronized

StringBuilder
   → Mutable + Not Synchronized
```

---

# Summary

`StringBuffer` is a mutable sequence of characters.

Important characteristics:

- It is mutable.
- It belongs to `java.lang`.
- Its methods are synchronized.
- It is useful when mutable character data is shared with synchronization requirements.
- It provides methods such as `append()`, `insert()`, `delete()`, `replace()`, and `reverse()`.
- Its default capacity is 16.
- Its capacity can automatically grow.
- `StringBuilder` is generally preferred for single-threaded mutable string operations.

The most important comparison is:

```text
String
    ↓
Immutable

StringBuffer
    ↓
Mutable + Synchronized

StringBuilder
    ↓
Mutable + Not Synchronized
```
