# take the 'id' of each movie
# and put the movie document in a file 
# by that name
#
grep '"adult"' $1 | while read line ; do
 m=$(echo $line | jq -r '. | .id')
 if [ ! -z $m ] ; then
   if [ ! -f ../../files/$m ] ; then
 	echo $line > ../../files/$m
   fi
 fi
done
	
