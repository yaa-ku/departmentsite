package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.ProjectCategoryEntity
import com.cscg.departmentsite.entity.ProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository: JpaRepository<ProjectEntity, Int> {
    fun getAllByCategoriesContaining(categoryEntity: ProjectCategoryEntity):MutableList<ProjectEntity>

}