#!/bin/bash

#open newFile to write to
exec 3> newFile.txt
echo "Opening File"

#print processes running on user into newFile.txt
ps -ef | sort -d | grep $USER >&3
echo "printing contents"

#close file
exec 3>&-
echo "close file" 

#open file to read
exec 3< newFile.txt

#show file contents on terminal
cat <&3

#show no of lines in terminal
wc -l < newFile.txt

#close file
exec 3<&-
