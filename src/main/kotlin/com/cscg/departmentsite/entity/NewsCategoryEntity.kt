package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "news_category", schema = "public", catalog = "department")
open class NewsCategoryEntity {
    @Id
    @Column(name = "title", nullable = false, insertable = false, updatable = false)
    open var title: String? = null

    @Basic
    @Column(name = "description", nullable = false)
    open var description: String? = null

    @OneToMany(mappedBy = "refNewsCategoryEntity")
    open var refNewsCategoryCrossEntities: MutableList<NewsCategoryCrossEntity> = mutableListOf()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "title = $title " +
                "description = $description " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NewsCategoryEntity

        if (title != other.title) return false
        if (description != other.description) return false

        return true
    }

}

