package com.cscg.departmentsite.controller

import com.cscg.departmentsite.entity.MaterialCategoryEntity
import com.cscg.departmentsite.entity.MaterialsEntity
import com.cscg.departmentsite.entity.ProjectEntity
import com.cscg.departmentsite.entity.TeachersEntity
import com.cscg.departmentsite.model.Filter
import com.cscg.departmentsite.model.TeacherModel
import com.cscg.departmentsite.service.MaterialService
import com.cscg.departmentsite.service.TeacherService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.math.abs

@Controller
class MaterialController(private val materialService: MaterialService, private val teacherService: TeacherService) {


    @GetMapping("/materials")
    fun getMaterials(@RequestParam(required = false) page: Int?, @RequestParam(required = false) size: Int?, model: Model):String{
//        page?.let {
//            size?.let {
//                model.addAttribute("materials", materialService.getPage(abs(page), abs(size)))
//                model.addAttribute("pages", materialService.getPageCount(size))
//                return "materials"
//            }
//        }
        val materials: MutableList<Pair<MaterialCategoryEntity, List<MaterialsEntity>>> = mutableListOf()
        for(x in materialService.getCategories()){
            materials.add(Pair(x,materialService.getByCategory(x)))
        }
        model.addAttribute("materials",materials)
        model.addAttribute("teachers", materialService.getTeachers())
        model.addAttribute("categories", materialService.getCategories())
        return "materials"
    }
    @PostMapping("/materials")
    fun getByCategories(@RequestBody(required = true) teacher:TeacherModel, model: Model):String {
        val teachersEntity = teacherService.getTeacherById(teacher.teacher)
        var list: MutableList<MaterialsEntity> = mutableListOf()
        if(teachersEntity.isPresent){
            list = materialService.getByTeacher(teachersEntity.get())
        }
        val materials: MutableList<Pair<MaterialCategoryEntity, List<MaterialsEntity>>> = mutableListOf()
        val categories = materialService.getCategories()
        for(x in categories){
            val c = list.filter { it.refMaterialCrossCategoryEntities.contains(x) }.toList()
            if(c.isNotEmpty())
                materials.add(Pair(x,c))
        }

        model.addAttribute("materials",materials)
        model.addAttribute("teachers", materialService.getTeachers())
        model.addAttribute("categories", categories)
        return "materialsbody"
    }

    @GetMapping("/materials/{id}")
    fun getProjectById(@PathVariable("id")id: Int, model: Model): String{
        val entity = materialService.getMaterialById(id)
        if(entity.isPresent){
            model.addAttribute("news",entity.get())
            return "newsentity"
        }
        else return "404"
    }
    @GetMapping("/materials/all")
    fun getAllNews(model: Model): String{
        val materials: MutableList<Pair<MaterialCategoryEntity, List<MaterialsEntity>>> = mutableListOf()
        for(x in materialService.getCategories()){
            materials.add(Pair(x,materialService.getByCategory(x)))
        }
        model.addAttribute("materials",materials)
        model.addAttribute("teachers", materialService.getTeachers())
        model.addAttribute("categories", materialService.getCategories())
        return "materialsbody"
    }

}