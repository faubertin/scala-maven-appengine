package org.test.appengine.repository.entity

import javax.jdo.annotations.{IdGeneratorStrategy, PrimaryKey, Persistent, PersistenceCapable}
import com.google.appengine.api.datastore.{KeyFactory, Key}
import scala.reflect._
import scala.annotation.meta.field
import org.test.appengine.domain.User

object EUser {

    def fromDomain(user: User) = {
        new EUser(
                user.id.map(KeyFactory.createKey(classOf[EUser].getSimpleName, _)).orNull,
                user.username,
                user.email)
    }

}

@PersistenceCapable
class EUser(
        @(PrimaryKey @field)
        @(Persistent @field)(valueStrategy = IdGeneratorStrategy.IDENTITY)
        @BeanProperty
        var id: Key,
        @BeanProperty
        var username: String,
        @BeanProperty
        var email: String) {

    def this() = this(null, null, null)

    def toDomain = User(
            Option(id).map(KeyFactory.keyToString(_)),
            username,
            email)

}
