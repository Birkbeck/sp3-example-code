
module Optree where

data Expr a = Operand a | Op (Expr a) (Expr a)
    deriving (Show)

instance Functor Expr where
    fmap f (Operand x) =
        Operand (f x)
    fmap f (Op left right) = 
        Op (fmap f left) (fmap f right)
