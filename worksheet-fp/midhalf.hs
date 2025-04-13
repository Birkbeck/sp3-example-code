module Sequence
where

import Data.List

midhalf :: [a] -> [a]
midhalf x = take (div (length x) 2) (drop (div (length x) 4) x)

unfold :: (a -> Bool) -> (a -> a) -> (a -> a) -> a -> [a]
unfold fin nextItem nextX x 
    | fin x = []
    | otherwise = nextItem x : unfold fin nextItem nextX (nextX x)

int2bin :: (Eq a, Integral a, Num a) => a -> [a]
int2bin = unfold (== 0) (`mod` 2) (`div` 2)



