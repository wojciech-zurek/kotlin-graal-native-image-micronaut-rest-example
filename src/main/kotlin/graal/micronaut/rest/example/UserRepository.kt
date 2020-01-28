package graal.micronaut.rest.example

import java.util.*

interface UserRepository {
    fun findAll(): Map<UUID, User>
    fun findById(id: UUID): User
    fun delete(id: UUID): User?
    fun save(id: UUID, user: User): User
}