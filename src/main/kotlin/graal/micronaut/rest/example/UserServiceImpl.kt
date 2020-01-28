package graal.micronaut.rest.example

import graal.micronaut.rest.example.api.UserRequest
import graal.micronaut.rest.example.api.UserResponse
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import java.util.*
import javax.inject.Singleton

@Singleton
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findAll(): Flowable<UserResponse> =
            Flowable.just(userRepository.findAll())
                    .flatMapIterable { it.entries }
                    .map { UserResponse.from(it.key, it.value) }

    override fun findById(id: Single<String>): Single<UserResponse> = id
            .map { UUID.fromString(it) }
            .map { Pair(it, userRepository.findById(it)) }
            .map { UserResponse.from(it.first, it.second) }

    override fun delete(id: Single<String>): Single<User?> = id
            .map { UUID.fromString(it) }
            .map { userRepository.delete(it) }

    override fun save(user: Single<UserRequest>): Single<UserResponse> = user
            .map { User(it.name, it.age) }
            .map {
                val id = UUID.randomUUID()
                Pair(id, userRepository.save(id, it))
            }.map { UserResponse.from(it.first, it.second) }

    override fun update(id: Single<String>, user: Single<UserRequest>): Single<UserResponse> =
            id.map { UUID.fromString(it) }
                    .zipWith(user, BiFunction { t1: UUID, t2: UserRequest -> Pair(t1, t2) })
                    .map { Pair(it.first, User(it.second.name, it.second.age)) }
                    .map { Pair(it.first, userRepository.save(it.first, it.second)) }
                    .map { UserResponse.from(it.first, it.second) }
}