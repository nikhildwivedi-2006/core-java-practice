# Arrays vs Collection vs Collections in Java

## Introduction

In Java, these three terms often create confusion:

```text
Arrays
Collection
Collections
```

Although their names are similar, they are completely different.

---

# 1. Arrays Class

`Arrays` is a utility class available in:

```java
java.util.Arrays
```

It provides static methods to perform operations on arrays.

Some important methods are:

```text
sort()
binarySearch()
fill()
equals()
toString()
copyOf()
asList()
```

Example:

```java
import java.util.Arrays;

public class ArraysExample {

    public static void main(String[] args) {

        int[] numbers = {30, 10, 20};

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
```

Output:

```text
[10, 20, 30]
```

---

# 2. Collection Interface

`Collection` is an interface available in:

```java
java.util.Collection
```

It is the root interface for most collection types.

```text
Collection
    │
    ├── List
    ├── Set
    └── Queue
```

It provides common methods for working with groups of objects.

Important methods:

```text
add()
remove()
size()
contains()
clear()
isEmpty()
```

Example:

```java
import java.util.ArrayList;
import java.util.Collection;

public class CollectionExample {

    public static void main(String[] args) {

        Collection<String> names = new ArrayList<>();

        names.add("Java");
        names.add("Python");

        System.out.println(names);
    }
}
```

Note:

> `Map` is part of the Java Collections Framework, but it does not extend the `Collection` interface.

---

# 3. Collections Class

`Collections` is a utility class available in:

```java
java.util.Collections
```

It is a `final` utility class that provides static methods for performing operations on collection objects.

Important methods:

```text
sort()
reverse()
shuffle()
max()
min()
binarySearch()
frequency()
```

Example:

```java
import java.util.ArrayList;
import java.util.Collections;

public class CollectionsExample {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(30);
        numbers.add(10);
        numbers.add(20);

        Collections.sort(numbers);

        System.out.println(numbers);
    }
}
```

Output:

```text
[10, 20, 30]
```

---

# Why Are Arrays and Collections Classes final?

Both `Arrays` and `Collections` are utility classes.

They mainly provide:

```text
Static utility methods
```

They are not designed to be extended or inherited.

Examples:

```java
Arrays.sort(array);

Collections.sort(list);
```

Because their purpose is to provide utility methods, Java declares them as `final` classes.

---

# Comparison

| Feature        | Arrays           | Collection                     | Collections                   |
| -------------- | ---------------- | ------------------------------ | ----------------------------- |
| Type           | Utility Class    | Interface                      | Utility Class                 |
| Package        | `java.util`      | `java.util`                    | `java.util`                   |
| Works With     | Arrays           | Groups of objects              | Collection objects            |
| Main Purpose   | Array operations | Common collection architecture | Collection utility operations |
| Examples       | `sort()`         | `add()`                        | `reverse()`                   |
| Static Methods | Yes              | No                             | Yes                           |
| Final Class    | Yes              | No                             | Yes                           |

---

# Quick Revision

```text
Arrays
   ↓
Utility Class
   ↓
Works with Arrays
   ↓
Arrays.sort()
```

```text
Collection
   ↓
Interface
   ↓
Parent of List, Set and Queue
   ↓
Common collection methods
```

```text
Collections
   ↓
Final Utility Class
   ↓
Works with Collections
   ↓
Collections.sort()
```

---

# Important Difference

```text
Arrays
    ↓
Utility methods for Arrays

Collection
    ↓
Interface representing a group of objects

Collections
    ↓
Utility methods for Collection objects
```

---

# Summary

Although `Arrays`, `Collection`, and `Collections` have similar names, they serve different purposes.

```text
Arrays
→ Utility class for array operations

Collection
→ Root interface for List, Set and Queue

Collections
→ Final utility class for collection operations
```

Remember:

```text
Arrays.sort(array)

Collection<String> collection

Collections.sort(list)
```
