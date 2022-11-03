package com.cscg.departmentsite.model

import com.cscg.departmentsite.entity.RolesEntity
import org.springframework.security.core.GrantedAuthority


class Authority (private val role: RolesEntity): GrantedAuthority {
    override fun getAuthority(): String {
        return role.roleName.toString()
    }
}