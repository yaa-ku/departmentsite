package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.NewsEntity
import com.cscg.departmentsite.entity.ProjectCategoryEntity
import com.cscg.departmentsite.entity.ProjectEntity
import com.cscg.departmentsite.repository.ProjectCategoryRepository
import com.cscg.departmentsite.repository.ProjectRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.ceil

@Service
class ProjectService(private val projectRepository: ProjectRepository,
                     private val projectCategoryRepository: ProjectCategoryRepository) {
    fun getProjects(): MutableList<ProjectEntity> = projectRepository.findAll()
    fun getPage(page: Int, size: Int): List<ProjectEntity> = projectRepository.findAll(PageRequest.of(page, size)).toList()
    fun getPageCount(size:Int):Double = ceil((projectRepository.count()/size).toDouble())
    fun getCategories():List<ProjectCategoryEntity> = projectCategoryRepository.findAll()
    fun getProjectById(id: Int): Optional<ProjectEntity> = projectRepository.findById(id)
    fun getProjectsByCategory(category:ProjectCategoryEntity):MutableList<ProjectEntity> = projectRepository.getAllByCategoriesContaining(category)
    fun getCategoryById(title: String): Optional<ProjectCategoryEntity> = projectCategoryRepository.findById(title)

}