package com.cscg.departmentsite.controller

import com.cscg.departmentsite.service.AccountService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class AccountController(private val accountService: AccountService) {
    @GetMapping("/account")
    fun getAll(): String{
        return accountService.getAllAccounts().toString()
    }
    @GetMapping("/admin")
    fun admin(): String{
        return "add"
    }
}