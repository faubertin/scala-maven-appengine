package org.test.appengine.web

import org.springframework.web.bind.annotation.{ExceptionHandler, ControllerAdvice}
import org.slf4j.{LoggerFactory, Logger}

@ControllerAdvice
class ControllerExceptionHandler {

    private val logger: Logger = LoggerFactory.getLogger(classOf[ControllerExceptionHandler])

    @ExceptionHandler
    def handleException(e: Exception) {
        logger.error("Unexpected error.", e)
        throw e
    }

}
