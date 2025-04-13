module CountList
where

countlist :: [a] -> Int
countlist x = foldl (\sum y -> sum + 1) 0 x
