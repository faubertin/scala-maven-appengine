package org.test.appengine.repository.inmemory

import org.test.appengine.repository.UserRepository
import org.test.appengine.domain.User
import java.util.concurrent.{ConcurrentHashMap, ConcurrentMap}
import java.util.UUID

class InMemoryUserRepository extends UserRepository {

    private val users: ConcurrentMap[String, User] = new ConcurrentHashMap[String, User]()

    override def saveUser(user: User) {
        val id = UUID.randomUUID().toString()
        user.copy(
            Some(id),
            user.username,
            user.email)
        users.put(id, user)
    }

}
