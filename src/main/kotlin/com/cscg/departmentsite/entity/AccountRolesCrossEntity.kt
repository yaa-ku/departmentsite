package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "account_roles_cross", schema = "public", catalog = "department")
@IdClass(AccountRolesCrossEntityPK::class)
open class AccountRolesCrossEntity {
    @Id
    @Column(name = "account_id", nullable = false, insertable = false, updatable = false)
    open var accountId: Int? = null

    @Id
    @Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    open var roleId: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    open var refAccountEntity: AccountEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "role_name")
    open var refRolesEntity: RolesEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "accountId = $accountId " +
                "roleId = $roleId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as AccountRolesCrossEntity

        if (accountId != other.accountId) return false
        if (roleId != other.roleId) return false

        return true
    }

}

class AccountRolesCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "account_id", nullable = false, insertable = false, updatable = false)
    open var accountId: Int? = null

    @Id
    @Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    open var roleId: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as AccountRolesCrossEntityPK

        if (accountId != other.accountId) return false
        if (roleId != other.roleId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
