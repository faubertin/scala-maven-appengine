package org.test.appengine.config

import org.springframework.context.annotation.{Bean, Configuration}
import javax.jdo.JDOHelper
import org.test.appengine.repository.datastore.DatastoreUserRepository
import org.test.appengine.repository.UserRepository

@Configuration
class RepositoryConfig {

    @Bean
    def pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional")

    @Bean
    def userRepository: UserRepository = new DatastoreUserRepository(pmf)

}
