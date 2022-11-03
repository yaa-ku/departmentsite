package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.EventsCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventsCategoryRepository: JpaRepository<EventsCategoryEntity, String> {
}