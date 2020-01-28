package graal.micronaut.rest.example

import graal.micronaut.rest.example.api.UserRequest
import graal.micronaut.rest.example.api.UserResponse
import io.reactivex.Flowable
import io.reactivex.Single

interface UserService {

    fun findAll(): Flowable<UserResponse>
    fun findById(id: Single<String>): Single<UserResponse>
    fun delete(id: Single<String>): Single<User?>
    fun save(user: Single<UserRequest>): Single<UserResponse>
    fun update(id: Single<String>, user: Single<UserRequest>): Single<UserResponse>
}