package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.EventsCategoryEntity
import com.cscg.departmentsite.entity.EventsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository: JpaRepository<EventsEntity, Int> {
    fun getAllByCategoriesContaining(eventsCategoryEntity: EventsCategoryEntity): MutableList<EventsEntity>
}