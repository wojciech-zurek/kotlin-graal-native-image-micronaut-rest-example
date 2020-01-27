package graal.micronaut.rest.example

import java.util.*
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl : UserRepository {

    private val db = ConcurrentHashMap<UUID, User>()

    override fun findById(id: UUID): User {
        return db.getValue(id)
    }

    override fun findAll(): Map<UUID, User> = db

    override fun save(id: UUID, user: User): User {
        db[id] = user
        return user
    }

    override fun delete(id: UUID) {
        db.remove(id)
    }
}