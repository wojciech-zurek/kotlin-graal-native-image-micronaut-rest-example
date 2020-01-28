package graal.micronaut.rest.example

import graal.micronaut.rest.example.api.UserRequest
import graal.micronaut.rest.example.api.UserResponse
import io.micronaut.http.annotation.*
import io.reactivex.Flowable
import io.reactivex.Single


@Controller("/users")
class UserController(private val userService: UserService) {

    @Post
    fun save(@Body user: Single<UserRequest>): Single<UserResponse> = userService.save(user)

    @Put("/{id}")
    fun update(id: Single<String>, @Body user: Single<UserRequest>): Single<UserResponse> = userService.update(id, user)

    @Get("/{id}")
    fun getById(id: Single<String>): Single<UserResponse> = userService.findById(id)

    @Get
    fun getAll(): Flowable<UserResponse> = userService.findAll()

    @Delete("/{id}")
    fun deleteById(id: Single<String>): Single<User?> = userService.delete(id)
}