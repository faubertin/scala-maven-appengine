package org.test.appengine.config

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.ViewResolver
import org.test.appengine.web.mvc.HomepageController

@Configuration
class WebConfig {

    @Bean
    def viewResolver: ViewResolver = {
        val viewResolver = new InternalResourceViewResolver
        viewResolver.setPrefix("/WEB-INF/jsp/")
        viewResolver.setSuffix(".jsp")
        viewResolver
    }

    @Bean
    def homepageController = new HomepageController

}
