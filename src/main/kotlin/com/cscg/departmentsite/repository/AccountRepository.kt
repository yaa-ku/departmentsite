package com.cscg.departmentsite.repository

import com.cscg.departmentsite.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface AccountRepository: JpaRepository<AccountEntity, Int> {
    @Transactional
    @Query("SELECT t FROM AccountEntity t  LEFT JOIN FETCH t.refAccountRolesCrossEntities where t.username = ?1")
    fun getAccountEntityByUsername(username: String): AccountEntity?
}