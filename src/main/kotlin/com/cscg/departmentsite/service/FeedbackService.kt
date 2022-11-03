package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.FeedbacksEntity
import com.cscg.departmentsite.repository.FeedbackRepository
import org.springframework.stereotype.Service

@Service
class FeedbackService(private val feedbackRepository: FeedbackRepository) {
    fun save(feedback: FeedbacksEntity) {
        feedbackRepository.save(feedback)
    }
}