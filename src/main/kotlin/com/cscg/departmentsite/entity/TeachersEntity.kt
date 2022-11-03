package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "teachers", schema = "public", catalog = "department")
open class TeachersEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    open var id: Int? = null

    @Basic
    @Column(name = "last_name", nullable = false)
    open var lastName: String? = null

    @Basic
    @Column(name = "first_name", nullable = false)
    open var firstName: String? = null

    @Basic
    @Column(name = "patronymic", nullable = true)
    open var patronymic: String? = null

    @Basic
    @Column(name = "experience", nullable = false)
    open var experience: Int? = null

    @Basic
    @Column(name = "teacher_image_path", nullable = false)
    open var teacherImagePath: String? = null

    @Basic
    @Column(name = "email", nullable = false)
    open var email: String? = null

    @ManyToMany
    @JoinTable(
        name = "material_cross",
        joinColumns = [JoinColumn(name = "teacher_id")],
        inverseJoinColumns = [JoinColumn(name="material_id")]
    )
    open var refMaterialCrossEntities: MutableList<MaterialsEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "teacher_academic_degree_cross",
        joinColumns = [JoinColumn(name = "teacher_id")],
        inverseJoinColumns = [JoinColumn(name="academic_degree_id")]
    )
    open var refAcademicDegreesEntity: MutableList<AcademicDegreesEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "teacher_academic_status_cross",
        joinColumns = [JoinColumn(name = "teacher_id")],
        inverseJoinColumns = [JoinColumn(name="academic_status_id")]
    )
    open var refAcademicStatusEntity: MutableList<AcademicStatusEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "teacher_status_cross",
        joinColumns = [JoinColumn(name = "teacher_id")],
        inverseJoinColumns = [JoinColumn(name="status_id")]
    )
    open var refStatusEntity: MutableList<StatusEntity> = mutableListOf()

    @OneToMany(mappedBy = "refTeachersEntity")
    open var refEducationEntities: MutableList<EducationEntity> = mutableListOf()

    public fun shortInfo():String = "${this.lastName} ${this.firstName} ${this.patronymic}"
    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "lastName = $lastName " +
                "firstName = $firstName " +
                "patronymic = $patronymic " +
                "experience = $experience " +
                "teacherImagePath = $teacherImagePath " +
                "education = $refEducationEntities" +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TeachersEntity

        if (id != other.id) return false
        if (lastName != other.lastName) return false
        if (firstName != other.firstName) return false
        if (patronymic != other.patronymic) return false
        if (experience != other.experience) return false
        if (teacherImagePath != other.teacherImagePath) return false
        if (email != other.email) return false
        return true
    }

}

