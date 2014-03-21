package org.test.appengine.service

import org.test.appengine.domain.User

trait UserService {

    def save(user: User)

    def findById(id: String): User

}
