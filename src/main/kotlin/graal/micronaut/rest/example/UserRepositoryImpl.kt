package graal.micronaut.rest.example

import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl : UserRepository {

    private val db = ConcurrentHashMap<UUID, User>()

    override fun findById(id: UUID): User = db.getValue(id)

    override fun findAll(): Map<UUID, User> = db

    override fun save(id: UUID, user: User): User {
        db[id] = user
        return user
    }

    override fun delete(id: UUID): User? = db.remove(id)

    @EventListener
    fun onStartup(event: StartupEvent) {
        db[UUID.randomUUID()] = User("Wojtek", 38)
        db[UUID.randomUUID()] = User("Ola", 35)
    }
}