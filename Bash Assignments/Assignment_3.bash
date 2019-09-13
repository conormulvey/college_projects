#/bin/bash

#ARG is the file containing the usernames to be uploaded
ARG=1

#this loop checks if an argument has been submitted
if [ $# -ne $ARG ]
then
	echo "USAGE File argument missing"
	exit 1
fi

#make an array containing usernames
usernames_content=(`cat "$1"`)

#make another array containing the users already on the system
current_users=(`awk -F: '{ print $1 }' /etc/passwd`)

# this loop checks if the username is already on the system
for i in "${usernames_content[@]}"
do
	name=`grep ^$i /etc/passwd | wc -l`
		if [ $name -ge 1 ]
		then
			echo "Username $i already in system skipping"

		else
			#if username not in the system,add it 
			sudo useradd -m $i
			
		fi
done

#display usernames to confirm it worked
cat /etc/passwd

#display home directory
ls -l /home

#give the user the option to remove the accounts
echo "Would you like to delete these accounts y/n"
read ans
if [ $ans == "y" ]
then
	for i in "${usernames_content[@]}"
	do
		sudo userdel -rf $i
		cat /etc/passwd
		ls -l /home
	done
elif [ $ans == "n" ]
	then
	echo "Script over"
else
echo "please enter y or n"
fi

