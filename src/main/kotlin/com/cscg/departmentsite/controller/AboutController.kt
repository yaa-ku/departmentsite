package com.cscg.departmentsite.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AboutController {
    @GetMapping("/about")
    fun getAbout():String =  "about"

    @GetMapping("/contacts")
    fun getContacts():String = "contacts"

}