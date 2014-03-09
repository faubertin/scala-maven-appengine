package org.test.appengine.repository.entity

import javax.jdo.annotations.PersistenceCapable
import org.test.appengine.domain.User
import scala.reflect._

object EUser {

    def fromDomain(user: User) = {
        new EUser(user.username, user.email)
    }

}

@PersistenceCapable
class EUser(
        @BeanProperty
        var username: String,
        @BeanProperty
        var email: String) {

    def this() = this(null, null)

}
