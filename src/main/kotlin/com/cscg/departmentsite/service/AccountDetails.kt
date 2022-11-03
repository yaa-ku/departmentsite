package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.AccountEntity
import com.cscg.departmentsite.model.Authority
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AccountDetails(private val account: AccountEntity): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        account.refAccountRolesCrossEntities.map {
            Authority(it)
        }.toMutableList()


    override fun getPassword(): String {
        return account.password
    }

    override fun getUsername(): String {
        return account.username
    }

    override fun isAccountNonExpired(): Boolean {
        return !account.expired
    }

    override fun isAccountNonLocked(): Boolean {
        return !account.blocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return !account.passwordExpired
    }

    override fun isEnabled(): Boolean {
        return !account.enabled
    }
}