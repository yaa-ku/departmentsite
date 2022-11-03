package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.AcademicDegreesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AcademicDegreeRepository: JpaRepository<AcademicDegreesEntity, String>{
}