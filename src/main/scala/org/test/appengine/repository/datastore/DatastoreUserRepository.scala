package org.test.appengine.repository.datastore

import org.test.appengine.repository.UserRepository
import javax.jdo.PersistenceManagerFactory
import org.test.appengine.domain.User
import org.test.appengine.repository.entity.EUser
import com.google.appengine.api.datastore.KeyFactory
import org.slf4j.LoggerFactory
import scala.collection.JavaConversions

class DatastoreUserRepository(
        val pmf: PersistenceManagerFactory
     ) extends UserRepository {

    private val logger = LoggerFactory.getLogger(classOf[DatastoreUserRepository])

    override def save(user: User) = {
        val pm = pmf.getPersistenceManager
        try {
            pm.makePersistent(EUser.fromDomain(user))
                .toDomain
        } finally {
            pm.close
        }
    }

    override def findById(id: String) = {
        val pm = pmf.getPersistenceManager
        try {
            pm.getObjectById(
                        classOf[EUser],
                        KeyFactory.stringToKey(id))
                .asInstanceOf[EUser]
                .toDomain
        } finally {
            pm.close
        }
    }

    override def findByUsername(username: String): Option[User] = {
        val pm = pmf.getPersistenceManager
        try {
            val query = pm.newQuery(classOf[EUser], "username == usernameParam")
            query.declareParameters("String usernameParam")
            val userEntities = query.execute(username).asInstanceOf[java.util.List[EUser]]
            if (userEntities.isEmpty) {
                None
            } else {
                Some(userEntities.get(0)).map(_.toDomain)
            }
        } finally {
            pm.close
        }
    }

}
