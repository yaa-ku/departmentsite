package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.MaterialCategoryEntity
import com.cscg.departmentsite.entity.MaterialsEntity
import com.cscg.departmentsite.entity.TeachersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MaterialRepository: JpaRepository<MaterialsEntity, Int> {
    fun getAllByRefMaterialCrossCategoryEntitiesContains(materialCategoryEntity: MaterialCategoryEntity): List<MaterialsEntity>
    fun getAllByRefMaterialCrossTeacherEntitiesContains(teachersEntity: TeachersEntity):MutableList<MaterialsEntity>
}