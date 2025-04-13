
module GCDiv (
gcdiv
) where

gcdiv :: Integer -> Integer -> Integer
gcdiv x y
    | x == y = x
    | otherwise = gcdiv (min x y) ((max x y) - (min x y))

