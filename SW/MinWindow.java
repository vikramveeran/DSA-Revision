import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("x","xy"));
    }
    public static String minWindow(String s, String t){
         if (t.isEmpty()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
          for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
       int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
         for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}

/*⏱️ Time Complexity: O(n + m)
n = length of string s
m = ength of string t
Why?
Building countT takes O(m).
The right pointer r traverses s once → O(n).
The left pointer l also traverses s at most once → O(n).
Therefore, O(m + n + n) = O(n + m).

Space complexity: 
O(k)
Where 
k is the total number of unique characters in s and t
*/

/*
**The most important sliding-window pattern**

Bro, remember these four steps. They are the heart of this algorithm.

Step 1: Expand the window

for (int r = 0; r < s.length(); r++)

Move the right pointer forward and add the new character to window.

Step 2: Check whether the window is valid

if (countT.containsKey(c) &&
    window.get(c).equals(countT.get(c))) {
    have++;
}

Increase have when a required character's frequency reaches the required frequency.

Step 3: Shrink the window while it's valid

while (have == need)

Record the best window, then remove characters from the left to see whether a smaller valid window exists.

Step 4: Update the answer when a smaller window is found

if ((r - l + 1) < resLen) {
    resLen = r - l + 1;
    res[0] = l;
    res[1] = r;
}
 */



/*
Dry run step by step 🔥

Our string is:

s = A D O B E C O D E B A N C
    0 1 2 3 4 5 6 7 8 9 10 11 12

Initially, l = 0.

We move r from left to right, adding characters to the window.

Step 1: r = 0, character = A
char c = s.charAt(r);
window.put(c, window.getOrDefault(c, 0) + 1);

We add A to the window.

Current window: A

window = {A=1}

Now check:

if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
    have++;
}

A is required, and its current frequency equals the required frequency.

Therefore:

have = 1
need = 3

Since have != need, we cannot shrink the window yet.

Step 2: r = 1, character = D
Current window: AD

window = {A=1, D=1}
have = 1
need = 3

D is not required, so have doesn't change.

Move r forward.

Step 3: r = 2, character = O
Current window: ADO

window = {A=1, D=1, O=1}
have = 1
need = 3

O is not required.

Move r forward.

Step 4: r = 3, character = B
Current window: ADOB

window = {A=1, D=1, O=1, B=1}

B is required, and its frequency matches.

have = 2
need = 3

Still missing C.

Continue.

Step 5: r = 4, character = E
Current window: ADOBE

have = 2
need = 3

E is not required.

Continue.

Step 6: r = 5, character = C
Current window: ADOBEC

Now:

window = {A=1, D=1, O=1, B=1, E=1, C=1}

have = 3
need = 3

🎯 We have found our first valid window!

Our current window contains A, B, and C.

Now this condition becomes true:

while (have == need)

This means we should try to make the window smaller while keeping it valid.

Inside the while loop

Our current window is:

ADOBEC

Its length is:

r - l + 1
= 5 - 0 + 1
= 6

Compare it with resLen:

if ((r - l + 1) < resLen)

Since 6 < Integer.MAX_VALUE, update the result:

resLen = 6
res = [0, 5]

Our best window so far is "ADOBEC".

But can we make it smaller?

Remove the leftmost character
char leftChar = s.charAt(l);
window.put(leftChar, window.get(leftChar) - 1);

Currently:

l = 0
leftChar = A

Remove A from the window's frequency count.

window[A] = 0

Now check:

if (countT.containsKey(leftChar) &&
    window.get(leftChar) < countT.get(leftChar)) {
    have--;
}

A is required, but we now have zero A characters.

Therefore:

have = 2
l = 1

The window is no longer valid, so the while loop stops.

Important: We removed A from the window, but res still remembers the previous valid window "ADOBEC".

Step 7: r = 6, character = O

Add O.

Current window: DOBECO
l = 1
r = 6

have = 2
need = 3

We still have B and C, but we no longer have A.

Continue.

Step 8: r = 7, character = D
Current window: DOBECOD

have = 2
need = 3

Continue.

Step 9: r = 8, character = E
Current window: DOBECODE

have = 2
need = 3

Continue.

Step 10: r = 9, character = B

The window gets another B.

Current window: DOBECODEB

window[B] = 2
have = 2
need = 3

Notice that have doesn't increase.

Why?

Because this condition checks whether the frequency has just reached the required frequency:

window.get(c).equals(countT.get(c))

For B:

Required B = 1
Current B = 2

Since 2 != 1, have remains 2.

This is correct because B was already satisfied.

Continue.

Step 11: r = 10, character = A

We add A back.

Current window: DOBECODEBA

window[A] = 1
have = 3
need = 3

🎯 We have another valid window!

Now the while loop runs again.

First shrinking attempt

Current boundaries:

l = 1
r = 10

Window length:

10 - 1 + 1 = 10

Our best length is already 6.

Since 10 < 6 is false, we don't update res.

Remove the leftmost character, D.

window[D] = 0
have = 3
l = 2

D isn't required, so have stays 3.

The window remains valid.

Second shrinking attempt

Now:

l = 2
r = 10

Current window:

OBECODEBA

Length:

10 - 2 + 1 = 9

Again, 9 is greater than 6.

Remove O.

O isn't required, so have remains 3.

l = 3
Third shrinking attempt

Current window:

BECODEBA

Length:

10 - 3 + 1 = 8

Still not smaller than 6.

Remove B.

Before removal:

window[B] = 2

After removal:

window[B] = 1

B is still present in the required quantity.

Therefore:

have = 3
l = 4

The window remains valid.

Fourth shrinking attempt

Current window:

ECODEBA

Length:

10 - 4 + 1 = 7

Still not smaller than 6.

Remove E. Since E isn't required:

have = 3
l = 5

The window remains valid.

Fifth shrinking attempt

Current window:

CODEBA

Length:

10 - 5 + 1 = 6

This equals resLen, so this condition is false:

if ((r - l + 1) < resLen)

We don't update the result because we only want a strictly shorter window.

Now remove C.

Before removal:

window[C] = 1

After removal:

window[C] = 0

C is required, but we've removed it.

Therefore:

have = 2
l = 6

The window is no longer valid, and the while loop stops.

Our best result is still:

resLen = 6
res = [0, 5]
Step 12: r = 11, character = N

Add N.

have = 2
need = 3

N isn't required.

Continue.

Step 13: r = 12, character = C

Add C.

window[C] = 1
have = 3
need = 3

We've found another valid window!

The current boundaries are:

l = 6
r = 12

Current window:

ODEBANC

Length:

12 - 6 + 1 = 7

Seven is greater than our best length of 6, so we don't update res.

Now shrink the window.

First shrinking attempt

Remove O.

O isn't required.

l = 7
have = 3

Window:

DEBANC

Length:

12 - 7 + 1 = 6

The length equals 6, so we don't update the result.

Remove D.

l = 8
have = 3
Second shrinking attempt

Window:

EBANC

Length:

12 - 8 + 1 = 5

🔥 Now we've found a smaller valid window!

Since 5 < 6, update:

resLen = 5
res[0] = 8
res[1] = 12

Our best window is now:

EBANC

Can we shrink further?

Remove E.

E isn't required, so:

l = 9
have = 3
Third shrinking attempt

Current window:

BANC

Length:

12 - 9 + 1 = 4

Since 4 < 5, update:

resLen = 4
res[0] = 9
res[1] = 12

Our best window is now "BANC".

Can we shrink further?

Remove B.

window[B] = 0
have = 2
l = 10

Now have != need, so the while loop stops.

The outer loop finishes because r = 12 is the final index.

4. Final result

At the end:

resLen = 4
res = [9, 12]

Your final statement is:

return resLen == Integer.MAX_VALUE
       ? ""
       : s.substring(res[0], res[1] + 1);

Substitute the values:

s.substring(9, 13)

Remember that Java's substring(start, end) includes the start index but excludes the end index.

Therefore:

Index 9  = B
Index 10 = A
Index 11 = N
Index 12 = C

Output:

BANC

✅ Final answer: "BANC"
 */