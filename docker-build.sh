#!/bin/sh
docker build . -t graal-micronaut-rest-example
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 graal-micronaut-rest-example"
