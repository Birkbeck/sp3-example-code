
module Set
where

data Eq a => Settype a = Set [a] deriving (Show)

isElement :: Eq a => a -> Settype a -> Bool
isElement x (Set []) = False
isElement x (Set (y:ys)) = 
    (x == y) || isElement x (Set ys)

insertElement :: Eq a => a -> Settype a -> Settype a
insertElement x (Set y) 
    | (isElement x (Set y)) = Set y
    | otherwise = (Set (x:y))

