package com.cscg.departmentsite.model

import org.springframework.web.multipart.MultipartFile

data class NewsModel (
    val name:String,
    val description:String,
    val image_title: MultipartFile,
    val title:Array<String>,
    val content:Array<String>,
    val photo: Array<MultipartFile>
)