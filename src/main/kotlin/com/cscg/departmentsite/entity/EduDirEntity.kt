package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "edu_dir", schema = "public", catalog = "department")
open class EduDirEntity {
    @Id
    @Column(name = "code", nullable = false, insertable = false, updatable = false)
    open var code: String? = null

    @Basic
    @Column(name = "title", nullable = true)
    open var title: String? = null

    @Basic
    @Column(name = "level_id", nullable = false, insertable = false, updatable = false)
    open var levelId: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", referencedColumnName = "level")
    open var refEduLevelEntity: EduLevelEntity? = null

    @OneToMany(mappedBy = "refEduDirEntity")
    open var refEducationEntities: MutableList<EducationEntity> = mutableListOf()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "code = $code " +
                "title = $title " +
                "levelId = $levelId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EduDirEntity

        if (code != other.code) return false
        if (title != other.title) return false
        if (levelId != other.levelId) return false

        return true
    }

}

