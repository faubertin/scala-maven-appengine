package org.test.appengine.config

import org.springframework.context.annotation.{Import, Bean, Configuration}
import javax.jdo.JDOHelper
import org.test.appengine.repository.datastore.DatastoreUserRepository
import org.test.appengine.repository.UserRepository

@Configuration
@Import(Array(
    classOf[DatastoreRepositoryConfig],
    classOf[InMemoryRepositoryConfig]
))
class RepositoryConfig {

}
