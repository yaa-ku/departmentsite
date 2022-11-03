package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.EventsCategoryEntity
import com.cscg.departmentsite.entity.EventsEntity
import com.cscg.departmentsite.entity.NewsCategoryEntity
import com.cscg.departmentsite.entity.NewsEntity
import com.cscg.departmentsite.repository.EventRepository
import com.cscg.departmentsite.repository.EventsCategoryRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.abs
import kotlin.math.ceil

@Service
class EventService(private val eventRepository: EventRepository,private val eventsCategoryRepository: EventsCategoryRepository) {
    fun getEventsById(id: Int): Optional<EventsEntity> = eventRepository.findById(id)

    fun getEvents(): MutableList<EventsEntity> = eventRepository.findAll()
    fun getPage(page: Int, size: Int): List<EventsEntity> = eventRepository.findAll(PageRequest.of(page, size)).toList()
    fun getPageCount(size:Int):Double = ceil((eventRepository.count()/size).toDouble())
    fun getCategories():List<EventsCategoryEntity> = eventsCategoryRepository.findAll()

    fun getCategoryById(id:String):Optional<EventsCategoryEntity> = eventsCategoryRepository.findById(id)
    fun getEventsByCategory(category: EventsCategoryEntity):MutableList<EventsEntity> = eventRepository.getAllByCategoriesContaining(category)
}