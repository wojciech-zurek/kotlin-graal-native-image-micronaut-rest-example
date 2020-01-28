package graal.micronaut.rest.example.api

import io.micronaut.core.annotation.Introspected

@Introspected
data class UserRequest(
        val name: String,
        val age: Int
)