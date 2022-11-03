package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "projects_block_cross", schema = "public", catalog = "department")
@IdClass(ProjectsBlockCrossEntityPK::class)
open class ProjectsBlockCrossEntity {
    @Id
    @Column(name = "project_id", nullable = false, insertable = false, updatable = false)
    open var projectId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    open var refProjectEntity: ProjectEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    open var refBlockEntity: BlockEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "projectId = $projectId " +
                "blockId = $blockId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ProjectsBlockCrossEntity

        if (projectId != other.projectId) return false
        if (blockId != other.blockId) return false

        return true
    }

}

class ProjectsBlockCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "project_id", nullable = false, insertable = false, updatable = false)
    open var projectId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ProjectsBlockCrossEntityPK

        if (projectId != other.projectId) return false
        if (blockId != other.blockId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
