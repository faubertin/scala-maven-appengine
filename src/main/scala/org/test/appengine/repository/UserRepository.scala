package org.test.appengine.repository

import org.test.appengine.domain.User

trait UserRepository {

    def save(user: User): User

    def findById(id: String): User

    def findByUsername(username: String): Option[User]

}
