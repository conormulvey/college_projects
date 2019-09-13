#!/bin/bash

#first function mulitpies two variables
multi(){
res=$(($1*$2))
echo $res
}

#second function adds two variables  
add(){
	res=$(($1+$2))
	echo $res
}

#third function checks if a variable is a multiple of five then either adds or mulipies it and another variable
multi_of_five(){
#if 'variable is a mulitple of five' = true then multiply
if [ $1%5 ]
then
	res=$(($1*$2))
	echo $res
#otherwise add
else
	res=$(($1+$2))
	echo $res
fi
}

#loops commands 4 times
for num in 1 2 3 4
do
    #ask user for variables
	echo "please type a number"
	read num1
	echo "please type another number!"
	read num2

    #call functions
	multi $num1 $num2
	add $num1 $num2
	multi_of_five $num1 $num2
#close loop
done

