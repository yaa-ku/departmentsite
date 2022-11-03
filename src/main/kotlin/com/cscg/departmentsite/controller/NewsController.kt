package com.cscg.departmentsite.controller

import com.cscg.departmentsite.entity.NewsEntity
import com.cscg.departmentsite.entity.ProjectEntity
import com.cscg.departmentsite.model.Filter
import com.cscg.departmentsite.model.NewsModel
import com.cscg.departmentsite.service.EventService
import com.cscg.departmentsite.service.NewsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.math.abs

@Controller
class NewsController(private val newsService: NewsService, private val eventService: EventService) {
    @GetMapping("/", "index")
    fun getNews(model: Model):String{
        val news = newsService.getPage(0,3)
        val events = eventService.getPage(0,3)
        model.addAttribute("news", news)
        model.addAttribute("events", events)
        return "index"
    }

    @GetMapping("/news")
    fun getNews(@RequestParam(required = false) page: Int?,@RequestParam(required = false) size: Int?, model: Model): String{
        page?.let {
            size?.let {
                model.addAttribute("news", newsService.getPage(abs(page), abs(size)))
                model.addAttribute("pages", newsService.getPageCount(size))
                return "news"
            }
        }
        model.addAttribute("filters", newsService.getCategories())
        model.addAttribute("news", newsService.getNews())
        return "news"
    }
    @GetMapping("/news/{id}")
    fun getNewsById(@PathVariable("id")id: Int, model: Model): String{
        val entity = newsService.getNewsById(id)
        entity.get().blocks.forEach { println(it.title) }
        if(entity.isPresent){
            model.addAttribute("news",entity.get())
            return "newsentity"
        }
        else return "404"
    }
    @PostMapping("/news/add")
    fun addNews(@ModelAttribute(value = "news") news: NewsModel, model: Model):String{
        model.addAttribute("news", news)
        news.title.forEach { println(it) }
        news.content.forEach { println(it) }
        news.photo.forEach { println(it.originalFilename) }
        return "admin"
    }

    @PostMapping("/news")
    fun getByCategories(@RequestBody(required = true) filters:MutableList<Filter>, model: Model):String {
        println(filters.size)
        var list: MutableList<NewsEntity> = mutableListOf()
        var flag = false
        filters.forEach {
            it.name?.let {x->
                it.checked?.let {y->
                    if(y)
                    {
                        if(newsService.getCategoryById(x).isPresent) {
                            list.addAll(newsService.getNewsByCategory(newsService.getCategoryById(x).get()))
                            flag = true
                        }
                    }
                }
            }
        }
        println("res ${list.size}")
        if(!flag)
            list = newsService.getNews()
        list.forEach {
            println("${it.title} ${it.categories[0]}")
        }
        model.addAttribute("news", list)
        return "newsbody"
    }


}
