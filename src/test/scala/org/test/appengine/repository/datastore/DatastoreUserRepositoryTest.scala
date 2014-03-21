package org.test.appengine.repository.datastore

import org.junit._
import com.google.appengine.tools.development.testing.{LocalDatastoreServiceTestConfig, LocalServiceTestHelper}
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.{ActiveProfiles, ContextConfiguration}
import org.test.appengine.config.DatastoreRepositoryConfig
import org.springframework.beans.factory.annotation.Autowired
import org.test.appengine.repository.UserRepository
import org.test.appengine.domain.User
import org.hamcrest.MatcherAssert._
import org.hamcrest.CoreMatchers._

object DatastoreUserRepositoryTest {

    private val helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @BeforeClass
    def init {
        helper.setUp()
    }

    @AfterClass
    def cleanup() {
        helper.tearDown()
    }

}

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(classes = Array(classOf[DatastoreRepositoryConfig]))
@ActiveProfiles(Array("production"))
class DatastoreUserRepositoryTest {

    @Autowired
    private var userRepository: UserRepository = _

    @Test
    def crud {
        var user = User(None, "username", "email")

        user = userRepository.save(user)

        val retrievedUser = userRepository.findById(user.id.get)

        assertThat(retrievedUser, equalTo(user))
    }

    @Test
    def findByUsername {
        val username = "username"
        var user = User(None, username, "email")

        assertThat(userRepository.findByUsername(username).isDefined, is(false))

        user = userRepository.save(user)

        val retrievedUser = userRepository.findByUsername(username)

        assertThat(retrievedUser.get, equalTo(user))

    }

}
