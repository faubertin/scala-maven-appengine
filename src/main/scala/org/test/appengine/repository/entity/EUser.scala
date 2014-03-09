package org.test.appengine.repository.entity

import javax.jdo.annotations._
import org.test.appengine.domain.User
import scala.reflect._
import org.test.appengine.domain.User

object EUser {

    def fromDomain(user: User) = {
        new EUser(
                user.id.orNull,
                user.username,
                user.email)
    }

}

@PersistenceCapable
class EUser(
        @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
        @BeanProperty
        var id: String,
        @BeanProperty
        var username: String,
        @BeanProperty
        var email: String) {

    def this() = this(null, null, null)

}
