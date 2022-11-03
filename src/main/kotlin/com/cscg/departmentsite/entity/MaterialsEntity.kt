package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "materials", schema = "public", catalog = "department")
open class MaterialsEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    open var id: Int? = null

    @Basic
    @Column(name = "title", nullable = false)
    open var title: String? = null

    @Basic
    @Column(name = "description", nullable = false)
    open var description: String? = null

    @Basic
    @Column(name = "material_image_path", nullable = false)
    open var materialImagePath: String? = null

    @ManyToMany
    @JoinTable(
        name = "material_block_cross",
        joinColumns = [JoinColumn(name = "material_id")],
        inverseJoinColumns = [JoinColumn(name="block_id")]
    )
    open var blocks: MutableList<BlockEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "material_cross",
        joinColumns = [JoinColumn(name = "material_id")],
        inverseJoinColumns = [JoinColumn(name="material_category_id")]
    )
    open var refMaterialCrossCategoryEntities: MutableList<MaterialCategoryEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "material_cross",
        joinColumns = [JoinColumn(name = "material_id")],
        inverseJoinColumns = [JoinColumn(name="teacher_id")]
    )
    open var refMaterialCrossTeacherEntities: MutableList<TeachersEntity> = mutableListOf()
    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "title = $title " +
                "description = $description " +
                "materialImagePath = $materialImagePath " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MaterialsEntity

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (materialImagePath != other.materialImagePath) return false

        return true
    }

}

