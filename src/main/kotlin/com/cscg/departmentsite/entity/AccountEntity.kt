package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "account", schema = "public", catalog = "department")
open class AccountEntity {
    @Basic
    @Column(name = "username", nullable = true)
    open var username: String = ""

    @Basic
    @Column(name = "password", nullable = false)
    open var password: String = ""

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    open var id: Int? = null

    @Basic
    @Column(name = "expired", nullable = false)
    open var expired: Boolean = false

    @Basic
    @Column(name = "blocked", nullable = false)
    open var blocked: Boolean = false

    @Basic
    @Column(name = "enabled", nullable = false)
    open var enabled: Boolean = false

    @Basic
    @Column(name = "password_expired", nullable = false)
    open var passwordExpired: Boolean = false

    @ManyToMany
    @JoinTable(
        name = "account_roles_cross",
        joinColumns = [JoinColumn(name = "account_id")],
        inverseJoinColumns = [JoinColumn(name="role_id")]
    )
    open var refAccountRolesCrossEntities: MutableList<RolesEntity> = mutableListOf()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "username = $username " +
                "password = $password " +
                "id = $id " +
                "expired = $expired " +
                "blocked = $blocked " +
                "enabled = $enabled " +
                "passwordExpired = $passwordExpired " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as AccountEntity

        if (username != other.username) return false
        if (password != other.password) return false
        if (id != other.id) return false
        if (expired != other.expired) return false
        if (blocked != other.blocked) return false
        if (enabled != other.enabled) return false
        if (passwordExpired != other.passwordExpired) return false

        return true
    }

}

