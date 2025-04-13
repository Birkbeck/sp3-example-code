
module Optree 
where

data Op = Add | Mul | Sub | Div
    deriving (Show)
data Expr a = Operand a | Branch Op (Expr a) (Expr a)
    deriving (Show)

instance Functor Expr where
    fmap f (Operand x) =
        Operand (f x)
    fmap f (Branch x left right) = 
        Branch x (fmap f left) (fmap f right)
