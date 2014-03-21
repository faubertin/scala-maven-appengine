package org.test.appengine.repository.inmemory

import org.test.appengine.repository.UserRepository
import org.test.appengine.domain.User
import java.util.concurrent.{ConcurrentHashMap, ConcurrentMap}
import java.util.UUID
import scala.collection.JavaConversions._

class InMemoryUserRepository extends UserRepository {

    private val users: ConcurrentMap[String, User] = new ConcurrentHashMap[String, User]()

    override def save(user: User) = {
        val id = UUID.randomUUID().toString()
        val userWithId = user.copy(
            Some(id),
            user.username,
            user.email)
        users.put(id, userWithId)
        userWithId
    }

    override def findById(id: String) = {
        users.get(id)
    }

    override def findByUsername(username: String): Option[User] = {
        users.find((entry: (String, User)) => username.equals(entry._2.username))
            .map(_._2)
    }

}
