# kotlin-graal-native-image-micronaut-rest-example

kotlin graal native image micronaut reactive rest example

## More info
Kotlin: https://kotlinlang.org/
Micronaut: https://micronaut.io/
GraalVm https://www.graalvm.org/
Native image: https://www.graalvm.org/docs/reference-manual/native-image/
RxJava2: https://github.com/ReactiveX/RxJava

## Download

```bash
    git clone git@github.com:wojciech-zurek/kotlin-graal-native-image-micronaut-rest-example.git
```

## Run with gradle

```bash
    cd kotlin-graal-native-image-micronaut-rest-example/
    ./gradlew run
```

## Run as jar file

```bash
    cd kotlin-graal-native-image-micronaut-rest-example/
    ./gradlew clean assemble
    java -jar build/libs/graal-micronaut-rest-example-0.1-all.jar
```

## Run as native image

#### Requirements

##### Docker

```bash
    cd kotlin-graal-native-image-micronaut-rest-example/
    ./gradlew clean assemble
    ./docker-build.sh 
    docker run -p 8080:8080 graal-micronaut-rest-example
```
