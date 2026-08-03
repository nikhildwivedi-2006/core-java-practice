# String Class in Java

## Introduction

A String is a sequence of characters used to store and manipulate text.

In Java, a String is **not a primitive data type**. It is an object of the `String` class, which is available in the `java.lang` package.

Example:

```java
String language = "Java";
```

Here:

- `String` → Class Name
- `language` → Reference Variable
- `"Java"` → String Object

---

# Why Do We Need Strings?

Strings are used whenever we need to work with textual data.

Examples:

- Person Name
- Address
- Email
- Password
- City Name
- Product Name

---

# Ways to Create a String

## 1. Using String Literal (Recommended)

```java
String name = "Nikhil";
```

This creates the String inside the **String Pool**.

---

## 2. Using the new Keyword

```java
String name = new String("Nikhil");
```

This creates a new String object in the Heap Memory.

---

# String Pool

Java maintains a special memory area called the **String Pool**.

If two String literals have the same value, Java stores only one object and reuses it.

Example:

```java
String s1 = "Java";
String s2 = "Java";
```

Both `s1` and `s2` refer to the same String object in the String Pool.

---

# Common String Methods

| Method             | Description                               |
| ------------------ | ----------------------------------------- |
| length()           | Returns the length of the String          |
| charAt()           | Returns the character at a specific index |
| toUpperCase()      | Converts the String to uppercase          |
| toLowerCase()      | Converts the String to lowercase          |
| substring()        | Returns a part of the String              |
| contains()         | Checks if a value exists                  |
| equals()           | Compares String values                    |
| equalsIgnoreCase() | Compares ignoring case                    |
| replace()          | Replaces characters                       |
| trim()             | Removes leading and trailing spaces       |

---

# Example

```java
public class StringExample {

    public static void main(String[] args) {

        String name = "Nikhil";

        System.out.println("Length      : " + name.length());
        System.out.println("Upper Case  : " + name.toUpperCase());
        System.out.println("Lower Case  : " + name.toLowerCase());
        System.out.println("Character   : " + name.charAt(2));
        System.out.println("Contains hi : " + name.contains("hi"));

    }

}
```

### Output

```text
Length      : 6
Upper Case  : NIKHIL
Lower Case  : nikhil
Character   : k
Contains hi : true
```

---

# String Comparison

Use `equals()` to compare String values.

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1.equals(s2));
```

Output:

```text
true
```

---

# Important Note

Do **not** use `==` to compare String values.

- `==` compares object references.
- `equals()` compares the actual content of the Strings.

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);      // false
System.out.println(s1.equals(s2)); // true
```

---

# Advantages

- Easy to use.
- Rich set of built-in methods.
- Supports text processing efficiently.
- Immutable, making it secure and thread-safe.

---

# Interview Questions

### 1. Is String a primitive data type?

**Answer:** No. It is an object of the `String` class.

---

### 2. Which package contains the String class?

**Answer:** `java.lang`

---

### 3. What is the difference between `==` and `equals()`?

**Answer:**

- `==` compares object references.
- `equals()` compares String values.

---

### 4. What is the String Pool?

**Answer:** A special memory area where Java stores String literals to improve memory efficiency.

---

### 5. Is String mutable or immutable?

**Answer:** Immutable.

---

# Summary

The String class is used to store and manipulate textual data in Java. It provides many built-in methods for string processing and uses the String Pool to optimize memory usage. Since Strings are immutable, they are secure, efficient, and widely used in Java applications.

---

## Related Topics

- Scanner Class
- String Immutability
- StringBuffer
- StringBuilder
