package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.StatusEntity
import com.cscg.departmentsite.entity.TeachersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface TeacherRepository: JpaRepository<TeachersEntity, Int>{

    fun getByRefStatusEntity(status: StatusEntity):Optional<TeachersEntity>
}