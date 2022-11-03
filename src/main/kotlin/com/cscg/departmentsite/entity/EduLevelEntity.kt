package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "edu_level", schema = "public", catalog = "department")
open class EduLevelEntity {
    @Id
    @Column(name = "level", nullable = false, insertable = false, updatable = false)
    open var level: String? = null

    @OneToMany(mappedBy = "refEduLevelEntity")
    open var refEduDirEntities: MutableList<EduDirEntity> = mutableListOf()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "level = $level " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EduLevelEntity

        if (level != other.level) return false

        return true
    }

}

