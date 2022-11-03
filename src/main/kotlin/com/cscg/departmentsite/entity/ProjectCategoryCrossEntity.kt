package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "project_category_cross", schema = "public", catalog = "department")
@IdClass(ProjectCategoryCrossEntityPK::class)
open class ProjectCategoryCrossEntity {
    @Id
    @Column(name = "project_id", nullable = false, insertable = false, updatable = false)
    open var projectId: Int? = null

    @Id
    @Column(name = "project_category_id", nullable = false, insertable = false, updatable = false)
    open var projectCategoryId: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    open var refProjectEntity: ProjectEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_category_id", referencedColumnName = "title")
    open var refProjectCategoryEntity: ProjectCategoryEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "projectId = $projectId " +
                "projectCategoryId = $projectCategoryId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ProjectCategoryCrossEntity

        if (projectId != other.projectId) return false
        if (projectCategoryId != other.projectCategoryId) return false

        return true
    }

}

class ProjectCategoryCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "project_id", nullable = false, insertable = false, updatable = false)
    open var projectId: Int? = null

    @Id
    @Column(name = "project_category_id", nullable = false, insertable = false, updatable = false)
    open var projectCategoryId: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ProjectCategoryCrossEntityPK

        if (projectId != other.projectId) return false
        if (projectCategoryId != other.projectCategoryId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
