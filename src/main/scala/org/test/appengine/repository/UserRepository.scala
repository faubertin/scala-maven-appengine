package org.test.appengine.repository

import org.test.appengine.domain.User

trait UserRepository {

    def saveUser(user: User)

}
