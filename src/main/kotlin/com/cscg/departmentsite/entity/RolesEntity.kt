package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "roles", schema = "public", catalog = "department")
open class RolesEntity {
    @Id
    @Column(name = "role_name", nullable = false, insertable = false, updatable = false)
    open var roleName: String? = null


    @ManyToMany
    @JoinTable(
        name = "account_roles_cross",
        joinColumns = [JoinColumn(name = "role_id")],
        inverseJoinColumns = [JoinColumn(name="account_id")]
    )
    open var accountEntities: MutableList<AccountEntity> = mutableListOf()
    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "roleName = $roleName " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as RolesEntity

        if (roleName != other.roleName) return false

        return true
    }

}

