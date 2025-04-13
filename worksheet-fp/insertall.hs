
module Insertall
where

insertall :: a -> [a] -> [[a]]
insertall x y = insertaux x [] y

insertaux :: a -> [a] -> [a] -> [[a]]
insertaux x pre [] =
    [pre ++ [x]]
insertaux x pre (p:ps) =
    [(pre ++ [x] ++ (p:ps))] ++ insertaux x (pre ++ [p]) (ps)
