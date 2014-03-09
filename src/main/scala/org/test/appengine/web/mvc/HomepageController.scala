package org.test.appengine.web.mvc

import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.apache.commons.logging.LogFactory

@Controller
@RequestMapping(Array("/"))
class HomepageController {

    @RequestMapping(method = Array(RequestMethod.GET))
    def homepage = {
        new ModelAndView("homepage")
    }

}
