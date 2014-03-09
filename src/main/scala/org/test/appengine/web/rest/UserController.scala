package org.test.appengine.web.rest

import org.springframework.web.bind.annotation.{RequestBody, RequestMethod, RequestMapping, RestController}
import org.test.appengine.service.UserService
import org.test.appengine.domain.User

import scala.beans.BeanProperty

@RestController
@RequestMapping(Array("/users"))
class UserController(
        val userService: UserService
    ) {

    @RequestMapping(method = Array(RequestMethod.POST))
    def saveUser(@RequestBody user: UserDto) {
        userService.saveUser(user.toDomain)
    }

}

class UserDto(
        @BeanProperty var id: String,
        @BeanProperty var username: String,
        @BeanProperty var email: String) {

    def this() = this(null, null, null)

    def toDomain = new User(
        Option(id),
        username,
        email)

}
