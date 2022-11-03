package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "material_cross", schema = "public", catalog = "department")
@IdClass(MaterialCrossEntityPK::class)
open class MaterialCrossEntity {
    @Id
    @Column(name = "material_id", nullable = false, insertable = false, updatable = false)
    open var materialId: Int? = null

    @Id
    @Column(name = "material_category_id", nullable = false, insertable = false, updatable = false)
    open var materialCategoryId: String? = null

    @Id
    @Column(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    open var teacherId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    open var refMaterialsEntity: MaterialsEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_category_id", referencedColumnName = "title")
    open var refMaterialCategoryEntity: MaterialCategoryEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    open var refTeachersEntity: TeachersEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "materialId = $materialId " +
                "materialCategoryId = $materialCategoryId " +
                "teacherId = $teacherId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MaterialCrossEntity

        if (materialId != other.materialId) return false
        if (materialCategoryId != other.materialCategoryId) return false
        if (teacherId != other.teacherId) return false

        return true
    }

}

class MaterialCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "material_id", nullable = false, insertable = false, updatable = false)
    open var materialId: Int? = null

    @Id
    @Column(name = "material_category_id", nullable = false, insertable = false, updatable = false)
    open var materialCategoryId: String? = null

    @Id
    @Column(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    open var teacherId: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MaterialCrossEntityPK

        if (materialId != other.materialId) return false
        if (materialCategoryId != other.materialCategoryId) return false
        if (teacherId != other.teacherId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
