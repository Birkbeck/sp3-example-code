
module OrderIt
where

import Data.List

orderIt :: Ord a => [a] -> [a]
orderIt [] = []
orderIt x = [minimum x] ++ orderIt (delete (minimum x) x)


