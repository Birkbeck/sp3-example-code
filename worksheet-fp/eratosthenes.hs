
module Eratosthenes
where

import Data.List

sieve :: (Enum a, Num a) => a -> [a]
sieve x = sieveaux x [2..x]

sieveaux :: (Enum a, Num a) => a -> [a] -> [a]
sieveaux _ [] = []
sieveaux m (x:xs) = x : (sieveaux m (xs \\ [x,2*x..m]))
