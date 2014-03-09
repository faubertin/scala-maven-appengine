package org.test.appengine.service.impl

import org.test.appengine.service.UserService
import org.test.appengine.domain.User
import org.test.appengine.repository.UserRepository

class UserServiceImpl(
        val userRepository: UserRepository
    ) extends UserService {


    override def saveUser(user: User) {
        userRepository.saveUser(user)
    }

}
