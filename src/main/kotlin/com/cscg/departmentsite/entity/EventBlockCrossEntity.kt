package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "event_block_cross", schema = "public", catalog = "department")
@IdClass(EventBlockCrossEntityPK::class)
open class EventBlockCrossEntity {
    @Id
    @Column(name = "event_id", nullable = false, insertable = false, updatable = false)
    open var eventId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    open var refEventsEntity: EventsEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    open var refBlockEntity: BlockEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "eventId = $eventId " +
                "blockId = $blockId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EventBlockCrossEntity

        if (eventId != other.eventId) return false
        if (blockId != other.blockId) return false

        return true
    }

}

class EventBlockCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "event_id", nullable = false, insertable = false, updatable = false)
    open var eventId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EventBlockCrossEntityPK

        if (eventId != other.eventId) return false
        if (blockId != other.blockId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
