# HashSet in Java

## 1. Introduction

`HashSet` Java Collections Framework ka ek class hai jo `Set` interface ko implement karta hai.

Iska main purpose **unique elements store karna** hai.

```java
import java.util.HashSet;
import java.util.Set;

Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);

System.out.println(numbers);
```

Output mein `10` sirf ek baar hoga.

---

## 2. Hierarchy

```text
Iterable
   ↓
Collection
   ↓
Set
   ↓
HashSet
```

Package:

```java
java.util.HashSet
```

---

## 3. Characteristics

`HashSet`:

- Duplicate elements allow nahi karta
- Insertion order maintain nahi karta
- `null` ka maximum ek element allow karta hai
- Index-based access nahi deta
- Generally fast `add()`, `remove()` aur `contains()` provide karta hai
- Hash table based implementation hai
- Not synchronized hai
- Generic types support karta hai

Example:

```text
Input:
20, 10, 30, 10, 20

HashSet:
10, 20, 30
```

> Output order guaranteed nahi hai, isliye exact order assume nahi karna chahiye.

---

## 4. Creating HashSet

```java
HashSet<String> names = new HashSet<>();
```

Generally interface reference prefer karna better hai:

```java
Set<String> names = new HashSet<>();
```

---

## 5. Adding Elements

```java
Set<String> languages = new HashSet<>();

languages.add("Java");
languages.add("Python");
languages.add("C++");

System.out.println(languages);
```

Duplicate:

```java
languages.add("Java");
```

Second `"Java"` add nahi hoga.

### add() ka return value

```java
System.out.println(languages.add("JavaScript"));
System.out.println(languages.add("Java"));
```

Possible output:

```text
true
false
```

```text
true  → element add hua
false → element already present tha
```

---

## 6. How HashSet Works Internally

Ye HashSet ka sabse important interview concept hai.

HashSet internally hashing mechanism use karta hai.

Simplified flow:

```text
Element
   ↓
hashCode()
   ↓
Hash value
   ↓
Bucket
   ↓
equals()
   ↓
Element stored / duplicate rejected
```

Example:

```java
Set<String> names = new HashSet<>();

names.add("Nikhil");
```

Conceptually:

```text
"Nikhil"
   ↓
hashCode()
   ↓
hash value
   ↓
bucket/index
   ↓
stored
```

---

## 7. hashCode()

Java mein har object ko `hashCode()` method milta hai.

```java
String name = "Java";

System.out.println(name.hashCode());
```

HashSet element ko store/search karne ke liye hash code ka use karta hai.

Important:

> Same object/value ke liye `hashCode()` consistent hona chahiye jab tak equality-relevant information change nahi hoti.

---

## 8. equals() and hashCode()

HashSet uniqueness determine karne mein `hashCode()` aur `equals()` dono important hain.

Simplified process:

```text
Add element
    ↓
hashCode()
    ↓
Bucket identify
    ↓
Existing element?
    ↓
equals()
    ↓
Equal → Duplicate
Not Equal → Store
```

Example:

```java
Set<String> set = new HashSet<>();

set.add("Java");
set.add(new String("Java"));
```

Dono String objects alag ho sakte hain, lekin:

```java
"Java".equals(new String("Java"))
```

`true` hoga.

Isliye HashSet duplicate `"Java"` ko store nahi karega.

---

## 9. Important hashCode() Contract

Agar:

```java
a.equals(b) == true
```

toh:

```java
a.hashCode() == b.hashCode()
```

hona chahiye.

Lekin reverse necessarily true nahi hai:

```text
Same hashCode
     ↓
Does NOT guarantee
equals() == true
```

Is situation ko **hash collision** kaha jata hai.

---

## 10. Hash Collision

Kabhi-kabhi different objects ka hash code same ho sakta hai.

```text
Object A ──→ hash ──→ Bucket 5
Object B ──→ hash ──→ Bucket 5
```

Ye **collision** hai.

HashSet collision ko internally handle karta hai.

Conceptually:

```text
Bucket
  ↓
Element A
Element B
```

Modern Java implementations mein heavily-collided buckets ke liye internal structure tree-based ho sakta hai, but implementation details ko basic usage ke liye depend nahi karna chahiye.

---

## 11. contains()

```java
Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers.contains(20));
```

Output:

```text
true
```

HashSet mein `contains()` generally average-case O(1) hota hai.

---

## 12. Removing Elements

```java
numbers.remove(20);
```

Check:

```java
System.out.println(numbers);
```

Specific element remove hoga.

---

## 13. size()

```java
System.out.println(numbers.size());
```

Number of unique elements return karega.

---

## 14. Traversing HashSet

HashSet mein index nahi hota.

Wrong:

```java
numbers.get(0);
```

Correct:

```java
for (Integer number : numbers) {
    System.out.println(number);
}
```

Or:

```java
Iterator<Integer> iterator = numbers.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

---

## 15. Null Element

HashSet maximum **one `null` element** allow karta hai.

```java
Set<String> set = new HashSet<>();

set.add(null);
set.add(null);

System.out.println(set);
```

`null` ek hi baar present hoga.

---

## 16. Time Complexity

Average-case complexity:

| Operation    |      HashSet |
| ------------ | -----------: |
| `add()`      | O(1) average |
| `remove()`   | O(1) average |
| `contains()` | O(1) average |
| `size()`     |         O(1) |

Worst-case behavior implementation aur collision pattern par depend karta hai.

Interview mein generally remember:

```text
HashSet
add()      → O(1) average
remove()   → O(1) average
contains() → O(1) average
```

---

## 17. HashSet vs ArrayList

| Feature      | ArrayList       | HashSet             |
| ------------ | --------------- | ------------------- |
| Duplicates   | Allowed         | Not allowed         |
| Index        | Yes             | No                  |
| Ordering     | Insertion order | No guaranteed order |
| `get(index)` | Yes             | No                  |
| Search       | O(n)            | O(1) average        |
| Main Use     | Ordered data    | Unique data         |

---

## 18. HashSet vs LinkedHashSet

| Feature     | HashSet                   | LinkedHashSet            |
| ----------- | ------------------------- | ------------------------ |
| Duplicates  | No                        | No                       |
| Ordering    | No guaranteed order       | Insertion order          |
| Performance | Generally slightly better | Slightly more overhead   |
| Null        | One allowed               | One allowed              |
| Use         | Unique elements           | Unique + insertion order |

Simple rule:

```text
Unique only
    ↓
HashSet

Unique + insertion order
    ↓
LinkedHashSet
```

---

## 19. HashSet vs TreeSet

| Feature            | HashSet                  | TreeSet              |
| ------------------ | ------------------------ | -------------------- |
| Duplicates         | No                       | No                   |
| Ordering           | No guaranteed order      | Sorted               |
| Basic operations   | O(1) average             | O(log n)             |
| Internal structure | Hash table based         | Tree based           |
| Null               | One allowed              | Normally not allowed |
| Use                | Fast uniqueness checking | Sorted unique data   |

---

## 20. Custom Objects in HashSet

HashSet ke saath custom objects use karte waqt `equals()` aur `hashCode()` important ho jate hain.

Example:

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Student))
            return false;

        Student other = (Student) obj;

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
```

Now:

```java
Set<Student> students = new HashSet<>();

students.add(new Student(101, "Nikhil"));
students.add(new Student(101, "Rahul"));

System.out.println(students.size());
```

Output:

```text
1
```

Because both objects have the same `id`, and our `equals()` defines them as equal.

---

## 21. Important Rule for Custom Objects

If two objects are logically equal:

```java
a.equals(b)
```

then their hash codes must also be equal:

```java
a.hashCode() == b.hashCode()
```

Otherwise HashSet ka behavior incorrect ho sakta hai.

### Remember

```text
equals() → Objects logically equal hain?

hashCode() → Hashing ke liye bucket identify karne mein help
```

---

## 22. Mutable Objects Warning

HashSet mein object add karne ke baad agar us field ko modify kar diya jo `equals()` / `hashCode()` mein use hoti hai, toh problems aa sakti hain.

Example concept:

```text
Object
  ↓
HashSet mein add
  ↓
hashCode calculated
  ↓
Object ki important field change
  ↓
New hashCode
  ↓
Object ko find/remove karna problematic ho sakta hai
```

Isliye HashSet ke elements ke liye equality/hash-related fields ko unnecessarily mutate nahi karna chahiye.

---

## 23. Removing Duplicates

HashSet ka common real-world use duplicate removal hai.

```java
List<Integer> numbers =
        Arrays.asList(10, 20, 10, 30, 20, 40);

Set<Integer> uniqueNumbers =
        new HashSet<>(numbers);

System.out.println(uniqueNumbers);
```

Result mein duplicate values nahi hongi.

---

## 24. Complete Example

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(10);

        System.out.println(numbers);

        System.out.println("Contains 20: "
                + numbers.contains(20));

        numbers.remove(20);

        System.out.println("After remove: "
                + numbers);

        System.out.println("Size: "
                + numbers.size());
    }
}
```

---

## 25. Important Interview Questions

### Q1. What is HashSet?

`HashSet` is a `Set` implementation that stores unique elements using a hash-table-based mechanism.

### Q2. Does HashSet allow duplicates?

No.

### Q3. Does HashSet maintain insertion order?

No guaranteed iteration order.

### Q4. Does HashSet allow null?

Yes, one `null` element.

### Q5. Why is HashSet fast?

Because hashing allows elements to be located efficiently, giving average O(1) time for basic operations.

### Q6. How does HashSet identify duplicates?

It uses `hashCode()` to locate the relevant hash area and `equals()` to determine equality when necessary.

### Q7. What is hash collision?

When different objects produce the same hash value.

### Q8. What is the relation between equals() and hashCode()?

If two objects are equal according to `equals()`, they must have the same hash code.

### Q9. Can two unequal objects have the same hashCode()?

Yes.

This is called a hash collision.

### Q10. Why override both equals() and hashCode()?

When custom objects are used in hash-based collections, both methods should follow the contract so logically equal objects are treated correctly.

---

## 26. Quick Revision

```text
HashSet
   ↓
Set implementation
   ↓
Unique elements
   ↓
No guaranteed order
   ↓
Hashing
   ↓
hashCode() + equals()
```

Complexity:

```text
add()      → O(1) average
remove()   → O(1) average
contains() → O(1) average
```

### Most Important Interview Point

```text
hashCode()
    ↓
Find relevant bucket/hash area

equals()
    ↓
Check actual equality
```

And:

```text
a.equals(b) == true
        ↓
a.hashCode() == b.hashCode()
```

---

## Summary

`HashSet` is used when we need **unique elements** and generally fast insertion, removal and lookup.

Remember:

```text
HashSet
→ Unique elements
→ No guaranteed order
→ One null allowed
→ No index access
→ O(1) average basic operations
→ hashCode() + equals() important
```

Most important comparison:

```text
HashSet       → Unique
LinkedHashSet → Unique + Insertion Order
TreeSet       → Unique + Sorted Order
```
