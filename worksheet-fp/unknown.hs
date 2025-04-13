
module Unknown (
    unknown
) where

unknown :: [a] -> [[a]]
unknown [] = [[]]
unknown (x:xs) = (unknown xs) ++ (map (x:) (unknown xs))
