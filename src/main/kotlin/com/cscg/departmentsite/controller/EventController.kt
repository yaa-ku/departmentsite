package com.cscg.departmentsite.controller

import com.cscg.departmentsite.entity.EventsEntity
import com.cscg.departmentsite.entity.ProjectEntity
import com.cscg.departmentsite.model.Filter
import com.cscg.departmentsite.service.EventService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.math.abs


@Controller
class EventController(private val eventService: EventService) {
    @GetMapping("/events")
    fun getEvents(@RequestParam(required = false) page: Int?, @RequestParam(required = false) size: Int?, model: Model):String {
        page?.let {
            size?.let {
                model.addAttribute("events", eventService.getPage(abs(page), abs(size)))
                model.addAttribute("pages", eventService.getPageCount(size))
                return "events"
            }
        }
        model.addAttribute("filters", eventService.getCategories())
        model.addAttribute("events", eventService.getEvents())
        return "events"
    }
    @GetMapping("/events/{id}")
    fun getEventById(@PathVariable("id")id: Int, model: Model): String{
        val entity = eventService.getEventsById(id)
        entity.get().blocks.forEach { println(it.title) }
        if(entity.isPresent){
            model.addAttribute("event",entity.get())
            return "eventsentity"
        }
        else return "404"
    }

    @PostMapping("/events")
    fun getByCategories(@RequestBody(required = true) filters:MutableList<Filter>, model: Model):String {
        println(filters.size)
        var list: MutableList<EventsEntity> = mutableListOf()
        var flag = false
        filters.forEach {
            it.name?.let {x->
                it.checked?.let {y->
                    if(y)
                    {
                        if(eventService.getCategoryById(x).isPresent) {
                            list.addAll(eventService.getEventsByCategory(eventService.getCategoryById(x).get()))
                            flag = true
                        }
                    }
                }
            }
        }
        println("res ${list.size}")
        if(!flag)
            list = eventService.getEvents()
        list.forEach {
            println("${it.title} ${it.categories[0]}")
        }
        model.addAttribute("events", list)
        return "eventsbody"
    }
}