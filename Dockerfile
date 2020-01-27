FROM oracle/graalvm-ce:19.3.0-java8 as graalvm
#FROM oracle/graalvm-ce:19.3.0-java11 as graalvm # For JDK 11
COPY . /home/app/graal-micronaut-rest-example
WORKDIR /home/app/graal-micronaut-rest-example
RUN gu install native-image
RUN native-image --no-server --static -cp build/libs/graal-micronaut-rest-example-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/graal-micronaut-rest-example/graal-micronaut-rest-example /app/graal-micronaut-rest-example
ENTRYPOINT ["/app/graal-micronaut-rest-example", "-Djava.library.path=/app"]
