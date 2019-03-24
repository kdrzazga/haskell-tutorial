module FunctionsDemo where

add :: Integer -> Integer -> Integer --  :: means 'has type'
add x y = x + y

inc x = x + 1
plus2 y = inc(inc(y))

square b = b*b
delta a b c = square(b) - 4 * a * c

describeLetter :: Char -> String
describeLetter c =
    if c >= 'a' && c <= 'z'
        then "Lower case"
        else if c >= 'A' && c <= 'Z'
            then "Upper case"
            else "Not an ASCII letter"

describeLetter2 :: Char -> String
describeLetter2 c
   | c >= 'a' && c <= 'z' = "Lower case"
   | c >= 'A' && c <= 'Z' = "Upper case"
   | otherwise            = "Not an ASCII letter"

help = print "Avaialable functions: add 2 3, inc 5, describeLetter '1'"
