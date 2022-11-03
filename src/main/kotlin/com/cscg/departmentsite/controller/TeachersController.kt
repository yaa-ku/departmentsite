package com.cscg.departmentsite.controller

import com.cscg.departmentsite.service.TeacherService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import kotlin.math.abs

@Controller
class TeachersController(private val teacherService: TeacherService) {
    @GetMapping("/teachers")
    fun getTeachers(@RequestParam(required = false) page: Int?, @RequestParam(required = false) size: Int?, model: Model):String{
        page?.let {
            size?.let {
                model.addAttribute("teachers", teacherService.getPage(abs(page), abs(size)))
                model.addAttribute("pages", teacherService.getPageCount(size))
                return "news"
            }
        }
        model.addAttribute("head",teacherService.getHead())
        model.addAttribute("teachers", teacherService.getTeachers())
        return "teachers"
    }
    @GetMapping("/teachers/{id}")
    fun getTeacherById(@PathVariable("id")id: Int, model: Model):String{
        val entity = teacherService.getTeacherById(id)
        if(entity.isPresent){
            println(entity.get())
            model.addAttribute("teacher",entity.get())
            return "teacher"
        }
        else return "404"
    }
}