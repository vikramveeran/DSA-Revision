package LL;

import java.util.PriorityQueue;
     class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
            );

        for (ListNode node : lists) {

            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            current.next = node;

            current = current.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    ListNode[] lists = new ListNode[] {
            buildList(new int[] { 1, 4, 5 }),
            buildList(new int[] { 1, 3, 4 }),
            buildList(new int[] { 2, 6 })
        };
    
    }
    
}

//pattern -> priority-queue/min-heap

/*I solve this problem using a Min Heap, implemented with Java PriorityQueue.

First, I insert the first node of every non-empty linked list into the PriorityQueue.

Then I repeatedly remove the smallest node and attach it to the result linked list.

After removing a node, I insert its next node into the PriorityQueue, if it exists.

This ensures that the smallest available node is always selected.

I use a dummy node to simplify the construction of the result.

The time complexity is O(N log K), and the auxiliary space complexity is O(K), where N is the total number of nodes and K is the number of linked lists. */


/*Time and Space Complexity
Let:
- K = number of linked lists.
- N = total number of nodes across all lists.
Time Complexity: O(N log K)

Why?
- We process all N nodes.
- Each poll() takes O(log K).
- Each add() takes O(log K).
Therefore, O(N log K).

Space Complexity: O(K) */



/*1. Input
We have 3 sorted linked lists:
List 1:  1 → 4 → 5

List 2:  1 → 3 → 4

List 3:  2 → 6

Our target:
1 → 1 → 2 → 3 → 4 → 4 → 5 → 6

2. Create PriorityQueue
PriorityQueue<ListNode> pq =
    new PriorityQueue<>(
        (a, b) -> Integer.compare(a.val, b.val)
    );

What does this mean?
- PriorityQueue<ListNode> stores ListNode objects.
- a.val compares the values of two nodes.
- Smallest value gets the highest priority.
3. Insert the first node of every list
for (ListNode node : lists) {
    if (node != null) {
        pq.add(node);
    }
}

Let's execute this loop.

First iteration:
node = lists[0];
pq.add(node);

List 1:  1 → 4 → 5
         ↑
        node

PriorityQueue:
[1]

Second iteration:
node = lists[1];
pq.add(node);

List 2:  1 → 3 → 4
         ↑
        node

PriorityQueue:
[1, 1]

Third iteration:
node = lists[2];
pq.add(node);

List 3:  2 → 6
         ↑
        node

PriorityQueue:
[1, 1, 2]

Important: We have inserted only 3 nodes, not all 8 nodes.
4. Create Dummy Node
ListNode dummy = new ListNode(0);
ListNode current = dummy;

Initially:
dummy
  |
  v
  0 → null
  ↑
current

Now let's enter the while loop.
5. Main Dry Run
Our code:
while (!pq.isEmpty()) {

    ListNode node = pq.poll();

    current.next = node;

    current = current.next;

    if (node.next != null) {
        pq.add(node.next);
    }
}

ITERATION 1
A. Remove the smallest node
ListNode node = pq.poll();

PriorityQueue:
[1, 1, 2]

We remove the first 1 from List 1.
List 1: 1 → 4 → 5
        ↑
       node

Now:
node.val = 1

B. Connect it to the answer
current.next = node;
current = current.next;

dummy → 1
         ↑
       current

C. Find the next node
node.next

Remember:
List 1: 1 → 4 → 5
        ↑   ↑
       node node.next

So:
pq.add(node.next);

Adds 4 to the PriorityQueue.

Now:
pq = [1, 2, 4]

Our answer:
1

ITERATION 2
A. Remove the smallest node
node = pq.poll();

PriorityQueue:
[1, 2, 4]

We remove 1 from List 2.
List 2: 1 → 3 → 4
        ↑
       node

B. Connect it
current.next = node;
current = current.next;

Answer:
dummy → 1 → 1
             ↑
           current

C. Add its next node
pq.add(node.next);

In List 2:
1 → 3 → 4
    ↑
 node.next

We add 3.

PriorityQueue:
[2, 3, 4]

Answer:
1 → 1

ITERATION 3
Remove the smallest node:
node = pq.poll();

We get 2 from List 3.
List 3: 2 → 6
        ↑
       node

Connect:
current.next = node;
current = current.next;

Answer:
1 → 1 → 2
         ↑
       current

Add its next node:
pq.add(node.next);

2 → 6
    ↑
 node.next

PriorityQueue:
[3, 4, 6]

ITERATION 4
Remove 3 from List 2.
List 2: 1 → 3 → 4
            ↑
           node

Connect it:
1 → 1 → 2 → 3
             ↑
           current

Now:
pq.add(node.next);

node.next is 4.

PriorityQueue:
[4, 4, 6]

ITERATION 5
Remove 4 from List 1.
List 1: 1 → 4 → 5
            ↑
           node

Connect:
1 → 1 → 2 → 3 → 4

Add node.next, which is 5.

PriorityQueue:
[4, 5, 6]

ITERATION 6
Remove 4 from List 2.
List 2: 1 → 3 → 4
                ↑
               node

Connect:
1 → 1 → 2 → 3 → 4 → 4

Now:
node.next

Returns null because 4 is the last node.

Therefore, nothing is added.

PriorityQueue:
[5, 6]

ITERATION 7
Remove 5 from List 1.

Connect:
1 → 1 → 2 → 3 → 4 → 4 → 5

node.next is null.

PriorityQueue:
[6]

ITERATION 8
Remove 6 from List 3.

Connect:
1 → 1 → 2 → 3 → 4 → 4 → 5 → 6

node.next is null.

PriorityQueue:
[]

The while loop stops! */