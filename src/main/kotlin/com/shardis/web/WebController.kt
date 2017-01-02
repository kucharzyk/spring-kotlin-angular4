package com.shardis.web


import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.ModelAndView

/**
 * Created by Tomasz Kucharzyk
 */

@Controller
@RequestMapping(path = arrayOf("/"))
class WebController {

  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = arrayOf("/"))
  fun mainPage(): ModelAndView {
    return ModelAndView("forward://index.html")
  }
}
