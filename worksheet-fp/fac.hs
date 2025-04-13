
module Fac (
fac
) where

fac :: Integer -> Integer
fac x
    | x <= 1 = 1
    | otherwise = x * fac (x-1)

