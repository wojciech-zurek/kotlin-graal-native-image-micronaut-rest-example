package graal.micronaut.rest.example.api

import graal.micronaut.rest.example.User
import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class UserResponse(
        val id: UUID,
        val name: String,
        val age: Int
) {
    companion object {
        fun from(id: UUID, user: User): UserResponse = UserResponse(id, user.name, user.age)
    }
}