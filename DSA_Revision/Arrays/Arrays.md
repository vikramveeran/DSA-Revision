What is an Array?

An array is a data structure that stores multiple values of the same data type in contiguous memory locations.

Example:

int[] arr = {10, 20, 30, 40, 50};

Here,

arr is a reference variable.
The array object is created in the heap.
Elements are stored one after another.

Memory (conceptually):

Index:   0    1    2    3    4
Value:  10   20   30   40   50
Why Arrays?

Without arrays:

int a = 10;
int b = 20;
int c = 30;
int d = 40;

Imagine storing 10,000 numbers.

Instead:

int[] arr = new int[10000];

Arrays allow:

Storing many values under one variable
Easy traversal using loops
Fast random access
Characteristics of Arrays
1. Fixed Size

Once created, the size cannot change.

int[] arr = new int[5];

You cannot make it size 10 later.

Need dynamic size?

Use:

ArrayList
LinkedList
etc.
2. Same Data Type

All elements must be of one type.

Valid:

int[] arr = {1,2,3};

Invalid:

{1,"hello",5}
3. Contiguous Memory

Elements are stored continuously.

1000
1004
1008
1012
1016

Because of this,
access by index is very fast.

4. Indexed

Index starts from 0.

0 1 2 3 4

Last index:

length - 1

Example

Size = 5

Last index = 4

5. Random Access

You can access any element directly.

arr[4]

No need to traverse.

Time Complexity:

O(1)
Declaration

Method 1

int[] arr;

Method 2

int arr[];

Preferred:

int[] arr;
Initialization
Method 1
int[] arr = new int[5];

Creates

0 0 0 0 0
Method 2
int[] arr = {10,20,30,40};

Size becomes 4 automatically.

Method 3
int[] arr = new int[]{1,2,3};

Less commonly used.

Default Values

When using

new int[5]

Java initializes automatically.

Data Type	Default Value
int	0
long	0L
float	0.0
double	0.0
boolean	false
char	'\u0000'
String	null
Objects	null
Array Length

Every array has a property

arr.length

Example

System.out.println(arr.length);

Not

arr.length()

because it's a field, not a method.

Accessing Elements
arr[0]
arr[1]
arr[2]

General form

arr[index]
Updating Elements
arr[2] = 100;

Old value is replaced.

Traversing Arrays

Usually done using loops.

for loop
for(int i=0;i<arr.length;i++)
Enhanced for loop
for(int num : arr)

Difference:

Enhanced loop

Read only
Cannot access index easily

Normal loop

Can modify elements
Index available
Types of Arrays
1. One-Dimensional Array
int[] arr = {1,2,3};

Looks like

1 2 3
2. Two-Dimensional Array
int[][] matrix = new int[3][4];

Looks like

1 2 3 4

5 6 7 8

9 10 11 12

Actually, in Java, a 2D array is an array of arrays.

3. Jagged Array

Rows can have different sizes.

int[][] arr = {
    {1,2},
    {3,4,5},
    {6}
};

Very common in Java.

Memory Representation

Suppose

int[] arr = {5,10,15};

Memory

arr
 |
 V

+----+----+----+
| 5  |10  |15  |
+----+----+----+

arr stores the reference (address) of the array object.

Arrays are Objects

Many beginners think arrays are primitive types.

Actually,

int[] arr = new int[5];

creates an object.

Therefore,

arr == null

is possible.

Array Index Out of Bounds

Suppose

int[] arr = new int[5];

Valid

0
1
2
3
4

Invalid

5
6
-1

Results in

ArrayIndexOutOfBoundsException
Advantages
Fast access (O(1))
Simple implementation
Less memory overhead
Cache friendly because memory is contiguous
Easy traversal
Disadvantages
Fixed size
Insertion in the middle is expensive
Deletion is expensive
Wastes memory if not fully used
Can store only one data type
Time Complexity
Operation	Complexity
Access by index	O(1)
Update	O(1)
Search (unsorted)	O(n)
Search (sorted with binary search)	O(log n)
Insert at end (if space exists)	O(1)
Insert at beginning	O(n)
Insert in middle	O(n)
Delete	O(n)
Traverse	O(n)
Common Java Array Utility Methods

The java.util.Arrays class provides many useful methods:

Arrays.sort() – sort an array
Arrays.binarySearch() – binary search on a sorted array
Arrays.fill() – fill all elements with a value
Arrays.equals() – compare arrays
Arrays.copyOf() – create a copy
Arrays.toString() – print a 1D array
Arrays.deepToString() – print multidimensional arrays