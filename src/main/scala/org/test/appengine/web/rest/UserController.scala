package org.test.appengine.web.rest

import org.springframework.web.bind.annotation._
import org.test.appengine.service.UserService

import scala.beans.BeanProperty
import org.slf4j.LoggerFactory
import org.test.appengine.domain.User

@RestController
@RequestMapping(Array("/users"))
class UserController(
        val userService: UserService
    ) {

    private val logger = LoggerFactory.getLogger(classOf[UserController])

    @RequestMapping(method = Array(RequestMethod.POST))
    def save(@RequestBody user: UserDto) {
        userService.save(user.toDomain)
    }

    @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.GET))
    def findById(@PathVariable id: String) = {
        val dto = UserDto.fromDomain(userService.findById(id))
        logger.info("{}", dto)
        dto
    }

}

object UserDto {

    def fromDomain(user: User) = new UserDto(
            user.id.orNull,
            user.username,
            user.email)

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
