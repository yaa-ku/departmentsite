package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "education", schema = "public", catalog = "department")
open class EducationEntity {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Basic
    @Column(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    open var teacherId: Int  = 0

    @Basic
    @Column(name = "edu_dir", nullable = false, insertable = false, updatable = false)
    open var eduDir: String  = ""

    @Basic
    @Column(name = "edu_year", nullable = false)
    open var eduYear: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    open var refTeachersEntity: TeachersEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edu_dir", referencedColumnName = "code")
    open var refEduDirEntity: EduDirEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "teacherId = $teacherId " +
                "eduDir = $eduDir " +
                "eduYear = $eduYear " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EducationEntity

        if (id != other.id) return false
        if (teacherId != other.teacherId) return false
        if (eduDir != other.eduDir) return false
        if (eduYear != other.eduYear) return false

        return true
    }

}

