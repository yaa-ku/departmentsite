package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.ProjectCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProjectCategoryRepository: JpaRepository<ProjectCategoryEntity, String> {
}