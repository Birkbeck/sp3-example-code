module GCDEA
where

gcdea :: Integer -> Integer -> Integer
gcdea x y
    | x == y = x
    | otherwise = gcdea (min x y) ((max x y) - (min x y))