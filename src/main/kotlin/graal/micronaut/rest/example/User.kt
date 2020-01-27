package graal.micronaut.rest.example

import io.micronaut.core.annotation.Introspected

@Introspected
data class User(
        val name: String,
        val age: Int
)