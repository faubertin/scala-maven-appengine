package org.test.appengine.repository.datastore

import org.test.appengine.repository.UserRepository
import javax.jdo.PersistenceManagerFactory
import org.test.appengine.domain.User
import org.test.appengine.repository.entity.EUser

class DatastoreUserRepository(
        val pmf: PersistenceManagerFactory
     ) extends UserRepository {

    override def saveUser(user: User) {
        val pm = pmf.getPersistenceManager
        try {
            pm.makePersistent(EUser.fromDomain(user))
        } finally {
            pm.close
        }

    }

}
