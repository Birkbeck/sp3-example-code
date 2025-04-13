module Sequence (
prefix,
subseq
) where

prefix :: Eq a => [a] -> [a] -> Bool
prefix [] y = True
prefix x [] = False
prefix (x:xs) (y:ys) = 
    if x /= y then
        False
    else
        prefix xs ys
            

subseq :: Eq a => [a] -> [a] -> Bool
subseq [] y = True
subseq x [] = False
subseq x y = 
    if prefix x y then
        True
    else
        subseq x (tail y)
