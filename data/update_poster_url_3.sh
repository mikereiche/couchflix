# get the new movie document into ../../movies/<id>
# get the post url from the new movie
# update the poster url in the old movie
# append to outfile which can be cb-imported
outfile=$1
shift
echo '[' > $outfile
shift
find files -name '[1-9][0-9]**' | awk -F/ '{print $2}'| while read m ; do
 	if [ ! -f ../../movies/$m ] ; then
 		curl -s  "http://api.themoviedb.org/3/movie/$m?api_key=823f084511dbc582b3a362ab2ad49962" -o ../../movies/$m
 	fi
	poster=$(jq ". | .poster_path" ../../movies/$m)
        if [ ! -z $poster ] ; then
		jq ".posterPath = ${poster}"  ../../files/$m >> $outfile
	else
		cat ../../files/$m >> outfile
	fi
       	echo ",\c" >> $outfile
done
echo '{} ]\c' >> $outfile
