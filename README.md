# Cracking Code Interview

## Arrays and Strings

### 1.1 - Is Unique

Implement an algorithm to determine if a string has all unique 
characters. What if you cannot use additional data structures?  
[Solution](src/main/java/zinjvi/arrays_strings/IsUnique.java) 

## Bit manipulations

[Get Bit]()  
[Set Bit]()  
[Clear Bit]()  
[Clear Bit, before and including 'i']()  
[Clear Bit, after and including 'i']()  
[Update Bit]()

### 5.1 Insertion

You are given two 32-bit numbers, Nand M, and two bit positions, i and j. 
Write a method to insert Minto N such that M starts at bit j and ends at bit i. 
You can assume that the bits j through i have enough space to fit all of M. 
That is, if M= 10011, you can assume that there are at least 5 bits between j and i. 
You would not, for example, have j = 3 and i = 2, because M could not fully fit
between bit 3 and bit 2.

EXAMPLE  
Input: N 10011, i 2, j 6  
Output: N 10001001100

[Solution](src/main/java/zinjvi/bit_manipulations/Insertion.java)

### 5.2 Binary to String

Given a real number between 0 and 1 (e.g., 0.72) that is 
passed in as a double, print the binary representation.
If the number cannot be represented accurately in binary 
with at most 32 characters, print "ERROR"

[Solution](src/main/java/zinjvi/bit_manipulations/BinaryToString.java)

### 5.3 Flip Bit to Win

You have an integer and you can flip exactly one bit from a 13 to a 1.
Write code to find the length of the longest sequence of ls you could create.

EXAMPLE  
Input: 1775 ( o r : 1113111131111)  
Output: 8

[Solution](src/main/java/zinjvi/bit_manipulations/FlipBitToWin.java)