package com.cscg.departmentsite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
class DepartmentsiteApplication

fun main(args: Array<String>) {
    runApplication<DepartmentsiteApplication>(*args)
}
