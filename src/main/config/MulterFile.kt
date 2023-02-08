package com.cscg.departmentsite.config

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize
import javax.servlet.MultipartConfigElement

@Configuration
class MulterFile {

    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory();
        //The largest file
        factory.setMaxFileSize(DataSize.ofMegabytes(50)); //KB,MB
        /// Set the total size of the total uploaded data
        factory.setMaxRequestSize(DataSize.ofMegabytes(500));
        return factory.createMultipartConfig();
    }
}