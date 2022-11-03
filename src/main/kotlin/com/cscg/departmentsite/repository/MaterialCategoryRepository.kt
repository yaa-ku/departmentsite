package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.MaterialCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MaterialCategoryRepository: JpaRepository<MaterialCategoryEntity, String>{
}