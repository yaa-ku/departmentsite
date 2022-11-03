package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.AcademicStatusEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AcademicStatusRepository: JpaRepository<AcademicStatusEntity, String> {
}