module Fibonacci (
lazyFib,
fib
) where

lazyFib :: Integer -> Integer -> [Integer]
lazyFib x y = x:(lazyFib y (x + y))

fib :: Int -> Integer
fib x = (head.drop (x-1)) (lazyFib 1 1)

