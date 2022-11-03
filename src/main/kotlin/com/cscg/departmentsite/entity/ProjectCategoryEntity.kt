package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "project_category", schema = "public", catalog = "department")
open class ProjectCategoryEntity {
    @Id
    @Column(name = "title", nullable = false, insertable = false, updatable = false)
    open var title: String? = null

    @Basic
    @Column(name = "description", nullable = false)
    open var description: String? = null

    @OneToMany(mappedBy = "refProjectCategoryEntity")
    open var refProjectCategoryCrossEntities: MutableList<ProjectCategoryCrossEntity> = mutableListOf()

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
        other as ProjectCategoryEntity

        if (title != other.title) return false
        if (description != other.description) return false

        return true
    }

}

