package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.RolesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<RolesEntity, Int> {
}