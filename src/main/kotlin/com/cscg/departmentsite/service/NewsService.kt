package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.NewsCategoryEntity
import com.cscg.departmentsite.entity.NewsEntity
import com.cscg.departmentsite.repository.NewsCategoryRepository
import com.cscg.departmentsite.repository.NewsRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.math.ceil

@Service
class NewsService(private val newsRepository: NewsRepository, private val newsCategoryRepository: NewsCategoryRepository) {

    fun getNews():MutableList<NewsEntity> = newsRepository.findAll()

    fun getPage(page: Int, size: Int): List<NewsEntity> = newsRepository.findAll(PageRequest.of(page, size)).toList()

    fun getPageCount(size:Int):Double = ceil((newsRepository.count()/size).toDouble())
    fun getNewsById(id: Int): Optional<NewsEntity> = newsRepository.findById(id)
    fun getCategories():List<NewsCategoryEntity> = newsCategoryRepository.findAll()
    fun getCategoryById(id: String):Optional<NewsCategoryEntity> = newsCategoryRepository.findById(id)
    fun getNewsByCategory(category:NewsCategoryEntity):MutableList<NewsEntity> = newsRepository.getAllByCategoriesContaining(category)
}