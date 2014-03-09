package org.test.appengine.config

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.ViewResolver
import org.test.appengine.web.mvc.HomepageController
import org.springframework.beans.factory.annotation.Autowired
import org.test.appengine.web.rest.UserController
import org.springframework.web.servlet.config.annotation.{WebMvcConfigurerAdapter, EnableWebMvc}
import org.test.appengine.web.ControllerExceptionHandler
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}

@Configuration
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private var serviceConfig: ServiceConfig = _

    override def configureMessageConverters(converters: java.util.List[HttpMessageConverter[_]]) {
        val jacksonConverter = new MappingJackson2HttpMessageConverter
        val objectMapper = new ObjectMapper
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
        jacksonConverter.setObjectMapper(objectMapper)
        converters.add(jacksonConverter)
    }

    @Bean
    def viewResolver: ViewResolver = {
        val viewResolver = new InternalResourceViewResolver
        viewResolver.setPrefix("/WEB-INF/jsp/")
        viewResolver.setSuffix(".jsp")
        viewResolver
    }

    @Bean
    def exceptionHandler = new ControllerExceptionHandler

    @Bean
    def userController = new UserController(serviceConfig.userService)

    @Bean
    def homepageController = new HomepageController

}
