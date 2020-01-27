package graal.micronaut.rest.example

import io.micronaut.http.annotation.*
import java.util.*


@Controller("/users")
class UserController(private val userService: UserService) {

    @Post
    fun save(@Body user: User): Pair<UUID, User> {
        val uuid = UUID.randomUUID()
        userService.save(uuid, user)
        return uuid to user
    }

    @Get("/{id}")
    fun getById(id: String): User {
        return userService.findById(UUID.fromString(id))
    }

    @Get("/")
    fun getAll(id: String): Map<UUID, User> {
        return userService.findAll()
    }

    @Delete("/{id}")
    fun deleteById(id: String) {
        return userService.delete(UUID.fromString(id))
    }

}

