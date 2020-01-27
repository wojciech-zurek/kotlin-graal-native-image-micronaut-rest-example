package graal.micronaut.rest.example

import java.util.*
import javax.inject.Singleton

@Singleton
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findAll(): Map<UUID, User> = userRepository.findAll()

    override fun findById(id: UUID): User = userRepository.findById(id)

    override fun delete(id: UUID) = userRepository.delete(id)

    override fun save(id: UUID, user: User): User = userRepository.save(id, user)
}