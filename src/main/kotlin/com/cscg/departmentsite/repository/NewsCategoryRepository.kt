package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.NewsCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsCategoryRepository: JpaRepository<NewsCategoryEntity, String> {
}