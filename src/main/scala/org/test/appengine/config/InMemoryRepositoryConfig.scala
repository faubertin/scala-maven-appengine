package org.test.appengine.config

import org.springframework.context.annotation.{Profile, Bean, Configuration}
import org.test.appengine.repository.UserRepository
import org.test.appengine.repository.inmemory.InMemoryUserRepository

@Configuration
@Profile(Array("dev"))
class InMemoryRepositoryConfig {

    @Bean
    def userRepository: UserRepository = new InMemoryUserRepository

}
