# Functional Programming exercises in Haskell

This worksheet is intended to familiarise you with the functional programming language Haskell.

1. Load the file `fac.hs` into the interactive shell `ghci`. You can load a file into the shell with `:l <filename>`. Once it has loaded successfully, i.e., there are no errors in the module, the shell's prompt changes to the module's name. You are now ready to run any functions included in the module. So try running the function `fac` with different parameters. You can leave the shell with the command `:quit`.

1. List Manipulation: Implement functions to `reverse` a list, `filter` a list based on a predicate, and `find` the maximum element in a list 

2. Recursive Functions: Write a function to compute the `n`th Fibonacci number using recursion.

2. Using the Euclidean algorithm, Write a program that computes the greatest common divisor of two numbers, `x` and `y`. The Euclidean algorithm is defined as follows: 
```
if x = y, then return x (or y), otherwise gcdea(x, y) = gcdea(x − y, y) where x > y.
```
2. Run and analyse the following function `unknown` from the module `Unknown`:
```haskell
module Unknown (
	unknown
) where
unknown :: [a] -> [[a]]
unknown 0] = [0]]
unknown (x:xs) = (unknown xs) ++ (map (x:) (unknown xs))
```
What does the program do?

4. Write a function `innerprod` that takes two vectors, `v` and `w`, represented by lists and returns the inner product. For example, if `v = [3,5,0,2]` and `w = [2,3,1,4]`, then the product of `v` and `w` is equal to `3 · 2 + 5 · 3 + 0 · 1 + 2 · 4 = 6 + 15 + 0 + 8 = 29`.

5. Write a function `noOfElem` that counts the number of elements in a list. Your function should return the same result as the function `length`. Do not use the function `length` for implementing `noOfElem`. You may use other functions, though.

6. Write a function `orderIt` that sorts a list. You can use the following functions:
	+ `minimum`, which returns the minimum element of a list, e.g. `minimum [3,5,2,4]` would return `2`
	+ `delete`, which deletes the first occurrence of an item from a list, e.g. `delete 2 [3,5,2,4]` would return `[3,5,4]`
	
	Please note: to use `delete`, you must import the module `Data.List`.
	Alternatively, you can implement any other sorting algorithm you want to program in Haskell.

7. Write a function `insertall` that takes an element `x` and a list `y` as input parameters. It will insert the element `x` into all possible positions of `y`. The result should contain all the lists with `x` inserted into different positions. For example, the input `2` and `[3,5]` should return `[[2,3,5],[3,2,5],[3,5,2]]`.

------

End of worksheet