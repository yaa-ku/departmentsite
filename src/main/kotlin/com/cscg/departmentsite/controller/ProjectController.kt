package com.cscg.departmentsite.controller

import com.cscg.departmentsite.entity.ProjectEntity
import com.cscg.departmentsite.model.Filter
import com.cscg.departmentsite.service.ProjectService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.math.abs

@Controller
class ProjectController(private val projectService: ProjectService) {
    @GetMapping("/projects")
    fun getNews(@RequestParam(required = false) page: Int?, @RequestParam(required = false) size: Int?, model: Model): String{
        model.addAttribute("filters", projectService.getCategories())
        model.addAttribute("pages", size?.let { projectService.getPageCount(it) })
        if(page!=null && size!=null){
            model.addAttribute("projects", projectService.getPage(abs(page), abs(size)))
            model.addAttribute("pages", projectService.getPageCount(size))
        }
        else
            model.addAttribute("projects", projectService.getProjects())
        return "projects"
    }


    @GetMapping("/projects/{id}")
    fun getProjectById(@PathVariable("id")id: Int, model: Model): String{
        val entity = projectService.getProjectById(id)
        if(entity.isPresent){
            model.addAttribute("news",entity.get())
            return "newsentity"
        }
        else return "404"
    }
    @PostMapping("/projects")
    fun getByCategories(@RequestBody(required = true) filters:MutableList<Filter>, model: Model):String {
        println(filters.size)
        var list: MutableList<ProjectEntity> = mutableListOf()
        var flag = false
        filters.forEach {
            it.name?.let {x->
                it.checked?.let {y->
                    if(y)
                    {
                        if(projectService.getCategoryById(x).isPresent) {
                            list.addAll(projectService.getProjectsByCategory(projectService.getCategoryById(x).get()))
                            flag = true
                        }
                    }
                }
            }
        }
        println("res ${list.size}")
        if(!flag)
            list = projectService.getProjects()
        list.forEach {
            println("${it.title} ${it.categories[0]}")
        }
        model.addAttribute("projects", list)
        return "projectsbody"
    }
}