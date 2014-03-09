package org.test.appengine.config

import org.springframework.context.annotation.{Profile, Bean, Configuration}
import javax.jdo.JDOHelper
import org.test.appengine.repository.datastore.DatastoreUserRepository
import org.test.appengine.repository.UserRepository

@Configuration
@Profile(Array("production"))
class DatastoreRepositoryConfig {

    @Bean
    def pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional")

    @Bean
    def userRepository: UserRepository = new DatastoreUserRepository(pmf)

}
