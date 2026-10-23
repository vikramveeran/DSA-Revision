Two Pointers — DSA Theory
1. What is the Two Pointer Technique?

The Two Pointer Technique is an approach in which we use two variables (pointers) to keep track of positions in a data structure, usually an array or string.

These pointers can move through the data to help us process elements efficiently.

Intuition: Imagine you're standing at the beginning of a line, and your friend is standing at the end. Both of you move through the line to examine different positions.

Instead of repeatedly checking every possible combination, you can use two pointers to process the data more efficiently in suitable situations.

Important: In Java, these pointers are usually integer variables representing indices. They are not necessarily actual memory pointers.

2. Why Do We Use Two Pointers?

The main purpose is to reduce unnecessary operations and improve time complexity.

For example, an approach that checks every pair of elements in an array may take O(n²) time.

In suitable problems, the two-pointer technique can reduce the time complexity to O(n).

However, this improvement depends on the problem and how the pointers move. Two pointers do not automatically make every solution faster.

3. Types of Two Pointer Approaches

There are several ways to use two pointers.

A. Opposite-direction pointers

One pointer starts at the beginning, and the other starts at the end.

Conceptually:

Array:  [10, 20, 30, 40, 50]

         L              R
         ↓              ↓
        10  20  30  40  50

Here:

L represents the left pointer.
R represents the right pointer.
The pointers can move toward each other.

This approach is often used with arrays or strings when examining elements from opposite ends.

B. Same-direction pointers

Both pointers move in the same direction, but they may move at different speeds or maintain different positions.

Conceptually:

Array:  [10, 20, 30, 40, 50]

         L      R
         ↓      ↓
        10  20  30  40  50

One pointer may track a position while the other explores the data.

This approach is commonly used when processing arrays or linked lists.

C. Fast and slow pointers

Both pointers move in the same direction, but at different speeds.

For example:

The slow pointer advances one step at a time.
The fast pointer advances two steps at a time.

This variation is particularly useful when working with linked lists.

4. Two Pointers vs. Brute Force
Feature	Brute Force	Two Pointers
Basic idea	Examine many or all possible combinations	Use two positions to process the data
Time complexity	Can be O(n²) or higher	Can be O(n) in suitable problems
Extra space	Depends on the approach	Often O(1) auxiliary space
Implementation	Often straightforward	Requires careful pointer movement
Applicability	Broad	Depends on the problem's properties

Note: These are general comparisons, not guarantees. Actual time and space complexity depend on the implementation.

5. Two Pointers in Arrays and Strings

Two pointers are frequently used with arrays and strings because both allow us to access elements by position.

In arrays, the pointers usually represent indices.

In strings, they can represent character positions.

The technique can help process data without creating another array or string, depending on the task.

6. Two Pointers in Linked Lists

Two pointers are also important in linked lists.

Unlike arrays, linked lists do not generally provide direct index-based access. Instead, pointers usually refer to nodes.

The fast-and-slow variation is particularly useful because the pointers can traverse the list at different speeds.

7. Time and Space Complexity

The complexity depends on how the pointers move.

Situation	Time Complexity	Auxiliary Space
Both pointers traverse the collection a constant number of times	Often O(n)	Often O(1)
One pointer moves through the collection for every position of the other	May be O(n²)	Depends on the implementation
Two pointers traverse a linked list	Often O(n)	Often O(1)

Auxiliary space means the additional memory used by the algorithm, excluding the input itself.