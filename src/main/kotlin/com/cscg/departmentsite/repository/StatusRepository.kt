package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.StatusEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StatusRepository: JpaRepository<StatusEntity, String> {
}