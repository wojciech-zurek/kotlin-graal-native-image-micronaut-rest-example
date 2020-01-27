package graal.micronaut.rest.example

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("graal.micronaut.rest.example")
                .mainClass(Application.javaClass)
                .start()
    }
}