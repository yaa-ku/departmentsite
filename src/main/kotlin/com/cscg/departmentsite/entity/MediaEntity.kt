package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "media", schema = "public", catalog = "department")
open class MediaEntity {
    @Id
    @Basic
    @Column(name = "id", nullable = true)
    open var id: Int? = null

    @Basic
    @Column(name = "link", nullable = false)
    open var link: String? = null

    @Basic
    @Column(name = "title", nullable = false)
    open var title: String? = null

    @Basic
    @Column(name = "type_id", nullable = true, insertable = false, updatable = false)
    open var typeId: String? = null

    @Basic
    @Column(name = "block_id", nullable = true, insertable = false, updatable = false)
    open var blockId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "type")
    open var refMediaTypeEntity: MediaTypeEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    open var refBlockEntity: BlockEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "link = $link " +
                "title = $title " +
                "typeId = $typeId " +
                "blockId = $blockId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MediaEntity

        if (id != other.id) return false
        if (link != other.link) return false
        if (title != other.title) return false
        if (typeId != other.typeId) return false
        if (blockId != other.blockId) return false

        return true
    }

}

