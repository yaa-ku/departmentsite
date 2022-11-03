package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "material_block_cross", schema = "public", catalog = "department")
@IdClass(MaterialBlockCrossEntityPK::class)
open class MaterialBlockCrossEntity {
    @Id
    @Column(name = "material_id", nullable = false, insertable = false, updatable = false)
    open var materialId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    open var refMaterialsEntity: MaterialsEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    open var refBlockEntity: BlockEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "materialId = $materialId " +
                "blockId = $blockId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MaterialBlockCrossEntity

        if (materialId != other.materialId) return false
        if (blockId != other.blockId) return false

        return true
    }

}

class MaterialBlockCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "material_id", nullable = false, insertable = false, updatable = false)
    open var materialId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MaterialBlockCrossEntityPK

        if (materialId != other.materialId) return false
        if (blockId != other.blockId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
