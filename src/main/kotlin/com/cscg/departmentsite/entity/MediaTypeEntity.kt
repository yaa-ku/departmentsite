package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "media_type", schema = "public", catalog = "department")
open class MediaTypeEntity {
    @Id
    @Column(name = "type", nullable = false, insertable = false, updatable = false)
    open var type: String? = null

    @OneToMany(mappedBy = "refMediaTypeEntity")
    open var refMediaEntities: MutableList<MediaEntity> = mutableListOf()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "type = $type " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MediaTypeEntity

        if (type != other.type) return false

        return true
    }

}

