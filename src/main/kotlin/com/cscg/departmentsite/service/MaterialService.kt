package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.*
import com.cscg.departmentsite.repository.MaterialCategoryRepository
import com.cscg.departmentsite.repository.MaterialRepository
import com.cscg.departmentsite.repository.TeacherRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.ceil

@Service
class MaterialService(private val materialRepository: MaterialRepository,
                      private val materialCategoryRepository: MaterialCategoryRepository,
                      private val teacherRepository: TeacherRepository) {
    fun getMaterials():List<MaterialsEntity> = materialRepository.findAll()

    fun getPage(page: Int, size: Int): List<MaterialsEntity> = materialRepository.findAll(PageRequest.of(page, size)).toList()

    fun getPageCount(size:Int):Double = ceil((materialRepository.count()/size).toDouble())
    fun getMaterialById(id: Int): Optional<MaterialsEntity> = materialRepository.findById(id)

    fun getCategories():List<MaterialCategoryEntity> = materialCategoryRepository.findAll()
    fun getTeachers(): List<TeachersEntity> = teacherRepository.findAll()
    fun getByCategory(materialCategory: MaterialCategoryEntity): List<MaterialsEntity> =
        materialRepository.getAllByRefMaterialCrossCategoryEntitiesContains(materialCategory)
    fun getByTeacher(teachersEntity: TeachersEntity): MutableList<MaterialsEntity> =
        materialRepository.getAllByRefMaterialCrossTeacherEntitiesContains(teachersEntity)
}