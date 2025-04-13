module Main where

readNumbers = do
    putStrLn "Input a number (0 to end): "
    num <- getLine
    if ((read num)::Int) == 0 then
        return []
    else do
        rest <- readNumbers
        return (((read num)::Int):rest)
    
main = do
    list <- readNumbers
    let lsum = foldl (\sum x -> sum + x) 0 list
    let sumtext = "Sum =     " ++ show(lsum)
    putStrLn sumtext
    let lprod = foldl (\sum x -> sum * x) 1 list
    let prodtext = "Product = " ++ show(lprod)
    putStrLn prodtext