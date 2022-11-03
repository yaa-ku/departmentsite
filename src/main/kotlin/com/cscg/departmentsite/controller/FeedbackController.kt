package com.cscg.departmentsite.controller

import com.cscg.departmentsite.entity.FeedbacksEntity
import com.cscg.departmentsite.service.FeedbackService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeedbackController(private val feedbackService: FeedbackService) {
    @PostMapping("/feedback")
    fun postFeedback(@ModelAttribute(value = "feedback") feedbacksEntity: FeedbacksEntity, model: Model){
        feedbackService.save(feedbacksEntity)
    }
}