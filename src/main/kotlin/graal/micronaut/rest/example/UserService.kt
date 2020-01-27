package graal.micronaut.rest.example

import java.util.*

interface UserService {

    fun findAll(): Map<UUID, User>
    fun findById(id: UUID): User
    fun delete(id: UUID)
    fun save(id: UUID, user: User): User
}