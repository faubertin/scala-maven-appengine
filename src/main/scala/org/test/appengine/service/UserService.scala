package org.test.appengine.service

import org.test.appengine.domain.User

trait UserService {

    def saveUser(user: User)

}
