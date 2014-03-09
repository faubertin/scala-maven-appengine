package org.test.appengine.config

import org.springframework.context.annotation.{Bean, Configuration}
import org.test.appengine.service.UserService
import org.test.appengine.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.test.appengine.repository.UserRepository

@Configuration
class ServiceConfig {

    @Autowired
    private var repositoryConfig: RepositoryConfig = _

    @Bean
    def userService: UserService = new UserServiceImpl(repositoryConfig.userRepository)

}
