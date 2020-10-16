#
# add new-lines so that each movie is on a line of its own
#
cat cb-movies-dataset2.json  |\
sed -e 's/{ "adult"/\
{ "adult"/g' |\
sed -e 's/, $/\
&/g' |\
sed -e 's/}]$/}\
]/g' > split.$$
