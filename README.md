# Couchflix

This is a sample project shows how to build a search feature using Bleve/Couchbase FTS

# Demo
https://youtu.be/FYnke4o9aLw

## How to run this project

1) Download and Install Couchbase https://www.couchbase.com/downloads
2) Unzip the file datasets.zip under the "data" folder
3) Go to the "bin" directory of you Couchbase installation( on mac: "/Applications/Couchbase\ Server.app/Contents/Resources/couchbase-core/bin/")
4) Load the movies dataset with the following command:
```
./cbimport json -c couchbase://127.0.0.1 -u <USER> -p <PASSWORD> -b movies -d file:///PATH-TO-FILE/the-movies-dataset/cb-movies-dataset2.json  -f list -g key::%id% -t 4
```

5) Load the actors dataset with the following command:
```
./cbimport json -c couchbase://127.0.0.1 -u <USER> -p <PASSWORD> -b movies -d file:///PATH-TO-FILE/the-movies-dataset/cb-movies-actors.json  -f list -g %id% -t 4 -v
```
6) Create index with
```
curl -XPUT -H "Content-type:application/json" http://<USER>:<PASSWORD>@<IP_ADDRESSES>:8094/api/index/movies_shingle -d @movies_shingle.json
```

7) Run the following command on the root folder of this project:
```
mvn clean install
```

8) Then run this command to start de application:
```
mvn spring-boot:run
```

9) Copy the content of the "front" folder in a web server (Ex: NGINX) and access the couchflix.html

10) OPTIONAL: If you want to enable the image cover (the image that appears when you click over a movie) you will need to install a chrome driver:
```
brew cask install chromedriver //on mac
```

And then update the path to your chrome driver in the class "ImageService.java"
