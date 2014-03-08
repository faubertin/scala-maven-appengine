package org.test.appengine.repository.entity

import javax.jdo.annotations.PersistenceCapable
import scala.beans.BeanProperty

@PersistenceCapable
class UserEntity(
        @BeanProperty
        var username: String,
        @BeanProperty
        var email: String) {

    def this() = this(null, null)

}
