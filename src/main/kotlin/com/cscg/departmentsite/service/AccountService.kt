package com.cscg.departmentsite.service

import com.cscg.departmentsite.entity.AccountEntity
import com.cscg.departmentsite.repository.AccountRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository): UserDetailsService {

    fun getAllAccounts(): MutableList<AccountEntity> {
        return accountRepository.findAll()
    }

    override fun loadUserByUsername(username: String): UserDetails? {
        accountRepository.getAccountEntityByUsername(username)?.let {
            println("HERE "+it.refAccountRolesCrossEntities.toString())
            return AccountDetails(it) }

        return AccountDetails(AccountEntity())
    }
}