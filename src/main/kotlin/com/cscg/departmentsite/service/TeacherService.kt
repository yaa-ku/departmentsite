package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.*
import com.cscg.departmentsite.repository.AcademicDegreeRepository
import com.cscg.departmentsite.repository.AcademicStatusRepository
import com.cscg.departmentsite.repository.StatusRepository
import com.cscg.departmentsite.repository.TeacherRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.ceil

@Service
class TeacherService(private val teacherRepository: TeacherRepository,
                     private val academicDegreeRepository: AcademicDegreeRepository,
                     private val academicStatusRepository: AcademicStatusRepository,
                     private val statusRepository: StatusRepository) {
    fun getTeachers(): MutableList<TeachersEntity> = teacherRepository.findAll()
    fun getPage(page: Int, size: Int): List<TeachersEntity> = teacherRepository.findAll(PageRequest.of(page, size)).toList()
    fun getPageCount(size:Int):Double = ceil((teacherRepository.count()/size).toDouble())
    fun getDegrees():List<AcademicDegreesEntity> = academicDegreeRepository.findAll()
    fun getAcademicStatus():List<AcademicStatusEntity> = academicStatusRepository.findAll()
    fun getStatus():List<StatusEntity> = statusRepository.findAll()
    fun getTeacherById(id: Int): Optional<TeachersEntity> = teacherRepository.findById(id)

    fun getHead() = teacherRepository.getByRefStatusEntity(statusRepository.findById("зав. каф.").get())
}