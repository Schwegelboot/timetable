#Prerequisites Local MongoDB
###The following Items will be need to be installed

-Docker
https://www.docker.com/products/docker-desktop

-mongodb client(Compass)
https://www.mongodb.com/products/compass

...console
#verify that Docker is installed
$ docker --version
...

...console
#pull latest docker image
$ docker pull mongo

...console
#create mongo container from image
$ docker create mongo

###Run MongoDB

...console
$ docker run -d -p 27017-27019:27017-27019 --name mongodb2 mongo


#verify that mongodb is set up
$ docker ps -a
...

###connect mongodb to mongodb client
Hostname=localhost
port=27017
