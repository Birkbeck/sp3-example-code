
module Innerprod
where

innerprod :: Num a => [a] -> [a] -> a
innerprod [] [] = 0
innerprod (v:vs) (w:ws) = v * w + (innerprod vs ws)
