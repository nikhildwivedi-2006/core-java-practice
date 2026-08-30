# String Class in Java

## Introduction

`String` is one of the most commonly used classes in Java.

It is used to represent a sequence of characters.

Example:

```java
String name = "Nikhil";
```

Here:

```text
String → Class
name   → Reference variable
"Nikhil" → String object
```

`String` belongs to the:

```java
java.lang
```

package.

Therefore, we do not need to explicitly import it.

---

# Creating String Objects

There are two common ways to create a String.

## 1. Using String Literal

```java
String name = "Nikhil";
```

This is the most commonly used approach.

Java stores string literals in a special memory area called the:

```text
String Constant Pool
```

---

## 2. Using new Keyword

```java
String name = new String("Nikhil");
```

This explicitly creates a new String object.

The object is created in the heap, even if the same string already exists in the String Constant Pool.

---

# String Constant Pool

The String Constant Pool is a special area associated with the heap where Java stores String literals.

Example:

```java
String s1 = "Java";
String s2 = "Java";
```

Java does not normally create two separate String objects for the same literal.

Instead:

```text
String Pool

+---------+
| "Java"  |
+---------+
    ↑
    |
s1  |
s2  |
```

Both references point to the same String object.

Therefore:

```java
System.out.println(s1 == s2);
```

Output:

```text
true
```

---

# String Literal vs new String()

Consider:

```java
String s1 = "Java";
String s2 = "Java";

String s3 = new String("Java");
```

Memory concept:

```text
String Constant Pool
+---------+
| "Java"  |
+---------+
   ↑   ↑
   |   |
  s1  s2


Heap
+---------+
| "Java"  |
+---------+
    ↑
    |
   s3
```

Therefore:

```java
System.out.println(s1 == s2);
```

Output:

```text
true
```

But:

```java
System.out.println(s1 == s3);
```

Output:

```text
false
```

Because `s1` and `s3` refer to different objects.

---

# == vs equals()

This is one of the most important String concepts.

## == Operator

For objects, `==` compares references.

Example:

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
```

Output:

```text
true
```

Both references point to the same pooled object.

---

## equals()

The `equals()` method compares the contents of Strings.

Example:

```java
String s1 = "Java";
String s2 = new String("Java");

System.out.println(s1.equals(s2));
```

Output:

```text
true
```

Even though the objects are different, their content is the same.

---

# Important Comparison

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
```

| Expression      |  Result | Reason             |
| --------------- | ------: | ------------------ |
| `s1 == s2`      |  `true` | Same pooled object |
| `s1 == s3`      | `false` | Different objects  |
| `s1.equals(s2)` |  `true` | Same content       |
| `s1.equals(s3)` |  `true` | Same content       |

Remember:

```text
==       → Reference comparison
equals() → Content comparison
```

---

# String Immutability

Strings in Java are immutable.

Immutable means:

> Once a String object is created, its content cannot be changed.

Example:

```java
String name = "Java";

name.concat(" Programming");

System.out.println(name);
```

Output:

```text
Java
```

Why?

Because:

```java
name.concat(" Programming");
```

creates a new String object.

It does not modify the original String.

---

# Correct Way to Store the New String

```java
String name = "Java";

name = name.concat(" Programming");

System.out.println(name);
```

Output:

```text
Java Programming
```

Now the reference `name` points to the newly created String.

Conceptually:

```text
Before:

name
 ↓
"Java"


After concat:

name
 ↓
"Java Programming"

"Java" remains unchanged.
```

---

# Why is String Immutable?

String immutability provides several advantages.

## 1. Security

Strings are widely used for:

```text
File paths
URLs
Database connections
Class names
Passwords
Network information
```

If Strings could be modified after creation, it could create security problems.

---

## 2. String Pooling

Because Strings cannot be modified, the same String object can safely be shared.

Example:

```java
String s1 = "Java";
String s2 = "Java";
```

Both can safely refer to the same pooled object.

---

## 3. Thread Safety

Immutable objects are naturally safer to share between multiple threads because their state cannot be changed.

---

## 4. Hashing

Strings are frequently used as keys in collections such as:

```java
HashMap
HashSet
```

Because their content does not change, their hash code remains stable.

---

# String Concatenation

Strings can be concatenated using:

```text
+
```

Example:

```java
String firstName = "Nikhil";
String lastName = "Dwivedi";

String fullName = firstName + " " + lastName;

System.out.println(fullName);
```

Output:

```text
Nikhil Dwivedi
```

---

# Concatenation with Numbers

Example:

```java
int age = 20;

String result = "Age: " + age;

System.out.println(result);
```

Output:

```text
Age: 20
```

Java converts the numeric value into its String representation during concatenation.

---

# Important Concatenation Rule

Consider:

```java
System.out.println(10 + 20 + "Java");
```

Output:

```text
30Java
```

Because evaluation happens from left to right:

```text
10 + 20
   ↓
30
   ↓
30 + "Java"
   ↓
"30Java"
```

Now consider:

```java
System.out.println("Java" + 10 + 20);
```

Output:

```text
Java1020
```

Once String concatenation starts, the remaining values are concatenated as Strings.

---

# Common String Methods

The `String` class provides many useful methods.

---

## length()

Returns the number of characters.

```java
String name = "Java";

System.out.println(name.length());
```

Output:

```text
4
```

---

## charAt()

Returns the character at a given index.

```java
String name = "Java";

System.out.println(name.charAt(1));
```

Output:

```text
a
```

Indexing starts from:

```text
0
```

So:

```text
J → 0
a → 1
v → 2
a → 3
```

---

## substring()

Returns a part of a String.

```java
String text = "JavaProgramming";

System.out.println(text.substring(4));
```

Output:

```text
Programming
```

Another form:

```java
System.out.println(text.substring(0, 4));
```

Output:

```text
Java
```

Important:

```text
start index → inclusive
end index   → exclusive
```

---

## toUpperCase()

Converts String to uppercase.

```java
String text = "java";

System.out.println(text.toUpperCase());
```

Output:

```text
JAVA
```

---

## toLowerCase()

Converts String to lowercase.

```java
String text = "JAVA";

System.out.println(text.toLowerCase());
```

Output:

```text
java
```

---

## trim()

Removes leading and trailing whitespace.

```java
String text = "   Java   ";

System.out.println(text.trim());
```

Output:

```text
Java
```

Important:

`trim()` does not remove spaces between words.

Example:

```java
"Java   Programming"
```

The spaces between the words remain.

---

## isEmpty()

Checks whether the String length is zero.

```java
String text = "";

System.out.println(text.isEmpty());
```

Output:

```text
true
```

---

## isBlank()

Checks whether the String is empty or contains only whitespace.

```java
String text = "   ";

System.out.println(text.isBlank());
```

Output:

```text
true
```

`isBlank()` was introduced in Java 11.

---

## contains()

Checks whether a String contains a particular sequence.

```java
String text = "Java Programming";

System.out.println(text.contains("Java"));
```

Output:

```text
true
```

---

## startsWith()

Checks whether a String starts with a particular value.

```java
String text = "Java Programming";

System.out.println(text.startsWith("Java"));
```

Output:

```text
true
```

---

## endsWith()

Checks whether a String ends with a particular value.

```java
String text = "Java Programming";

System.out.println(text.endsWith("Programming"));
```

Output:

```text
true
```

---

## equalsIgnoreCase()

Compares two Strings ignoring case.

```java
String s1 = "Java";
String s2 = "JAVA";

System.out.println(s1.equalsIgnoreCase(s2));
```

Output:

```text
true
```

---

## compareTo()

Compares two Strings lexicographically.

Example:

```java
String s1 = "Apple";
String s2 = "Banana";

System.out.println(s1.compareTo(s2));
```

A negative value means:

```text
s1 comes before s2
```

General rule:

```text
negative → first String is smaller
0        → Strings are equal
positive → first String is greater
```

---

## replace()

Replaces characters or sequences.

```java
String text = "Java";

String result = text.replace('a', 'o');

System.out.println(result);
```

Output:

```text
Jovo
```

Remember that the original String is not modified because String is immutable.

---

## split()

Splits a String into an array.

Example:

```java
String text = "Java Python C++";

String[] languages = text.split(" ");

for (String language : languages) {

    System.out.println(language);
}
```

Output:

```text
Java
Python
C++
```

---

# String Immutability with Methods

Most String methods return a new String rather than modifying the original.

Example:

```java
String text = "java";

text.toUpperCase();

System.out.println(text);
```

Output:

```text
java
```

Correct:

```java
text = text.toUpperCase();

System.out.println(text);
```

Output:

```text
JAVA
```

---

# intern() Method

The `intern()` method returns the canonical representation of a String from the String Pool.

Example:

```java
String s1 = new String("Java");

String s2 = s1.intern();

String s3 = "Java";

System.out.println(s2 == s3);
```

Output:

```text
true
```

Why?

Because:

```java
s2 = s1.intern();
```

returns the pooled `"Java"` object.

---

# String Pool Example

Consider:

```java
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");
String s4 = new String("Hello");
```

Conceptually:

```text
String Pool
+---------+
| "Hello" |
+---------+
   ↑   ↑
   |   |
  s1  s2


Heap
+---------+      +---------+
| "Hello" |      | "Hello" |
+---------+      +---------+
    ↑                ↑
    |                |
   s3               s4
```

Therefore:

```java
s1 == s2
```

is:

```text
true
```

But:

```java
s3 == s4
```

is:

```text
false
```

And:

```java
s1.equals(s3)
```

is:

```text
true
```

---

# String and Memory

Example:

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
```

Conceptually:

```text
                JVM Memory

       String Constant Pool
       +---------------+
       |    "Java"     |
       +---------------+
          ↑       ↑
          |       |
         s1      s2


              Heap
       +---------------+
       |    "Java"     |
       +---------------+
              ↑
              |
             s3
```

Important:

```text
String literal
    ↓
String Pool

new String()
    ↓
New object in Heap
```

---

# String and final

A common misconception is:

> String is immutable because it is final.

This is not the complete reason.

`String` is declared as a final class:

```java
public final class String
```

This prevents other classes from inheriting from it.

But immutability is achieved through the internal design of the class.

The important idea is:

```text
String object state cannot be changed after creation.
```

---

# String is Immutable vs Reference is Mutable

Consider:

```java
String name = "Java";

name = "Python";
```

Did the original `"Java"` String change?

No.

A new String `"Python"` is assigned to the reference.

Conceptually:

```text
Before:

name → "Java"


After:

name → "Python"
```

The reference changed.

The String object itself did not.

This distinction is very important.

---

# String Class and Thread Safety

Because String objects are immutable, they are inherently safe to share between multiple threads.

For example:

```java
String message = "Hello";
```

Multiple threads can safely access the same String because no thread can modify the String object.

However, this does not mean every operation involving String references is automatically thread-safe.

---

# Common Interview Questions

## 1. Is String a class or data type?

`String` is a class in Java.

It belongs to:

```java
java.lang.String
```

---

## 2. Is String mutable or immutable?

String is immutable.

---

## 3. Why is String immutable?

Important reasons include:

```text
Security
String Pooling
Thread Safety
Stable Hashing
```

---

## 4. What is String Constant Pool?

It is a special area associated with the heap used to store String literals and reuse identical literals.

---

## 5. Difference between == and equals()?

```text
==       → compares references
equals() → compares content
```

---

## 6. What happens when we concatenate Strings?

A new String is created because String is immutable.

Example:

```java
String s = "Java";

s = s + " Programming";
```

The original `"Java"` object remains unchanged.

---

## 7. Why is String final?

To prevent inheritance and preserve the intended behavior and immutability of the class.

---

## 8. What is intern()?

`intern()` returns the canonical pooled representation of a String.

---

## 9. Can String be used as a HashMap key?

Yes.

String is immutable, so its content and hash code remain stable while it is used as a key.

---

# Quick Revision

```text
String
  ↓
Class in java.lang
  ↓
Immutable
  ↓
String Pool
  ↓
String literals are reused
```

Creation:

```java
String s1 = "Java";
String s2 = new String("Java");
```

Comparison:

```text
==       → Reference
equals() → Content
```

Important methods:

```text
length()
charAt()
substring()
toUpperCase()
toLowerCase()
trim()
isEmpty()
isBlank()
contains()
startsWith()
endsWith()
equalsIgnoreCase()
compareTo()
replace()
split()
intern()
```

---

# Summary

The `String` class is one of the most important classes in Java.

Key concepts:

- String is a class.
- It belongs to `java.lang`.
- String objects are immutable.
- String literals are stored in the String Constant Pool.
- `new String()` creates a new object.
- `==` compares references.
- `equals()` compares content.
- String methods generally return new Strings.
- `intern()` provides the pooled representation.
- String immutability provides benefits such as security, pooling, thread safety, and stable hashing.

Most important interview rule:

```text
==       → Reference comparison
equals() → Content comparison
```

And:

```text
String = Immutable
```
