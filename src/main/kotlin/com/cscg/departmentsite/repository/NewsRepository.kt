package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.NewsCategoryEntity
import com.cscg.departmentsite.entity.NewsEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface NewsRepository: JpaRepository<NewsEntity,Int> {

    @Transactional
    @Query("SELECT t FROM NewsEntity t LEFT JOIN FETCH t.blocks WHERE t.id = ?1 ")
    override fun findById(id: Int): Optional<NewsEntity>

    fun getAllByCategoriesContaining(category: NewsCategoryEntity): MutableList<NewsEntity>
}