package org.test.appengine.web.mvc

import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(Array("/info.html"))
class InfoController {

    @RequestMapping(method = Array(RequestMethod.GET))
    def homepage = {
        new ModelAndView("info")
    }

}
