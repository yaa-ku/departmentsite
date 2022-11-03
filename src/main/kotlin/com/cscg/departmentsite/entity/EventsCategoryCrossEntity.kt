package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "events_category_cross", schema = "public", catalog = "department")
@IdClass(EventsCategoryCrossEntityPK::class)
open class EventsCategoryCrossEntity {
    @Id
    @Column(name = "event_id", nullable = false, insertable = false, updatable = false)
    open var eventId: Int? = null

    @Id
    @Column(name = "event_category_id", nullable = false, insertable = false, updatable = false)
    open var eventCategoryId: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    open var refEventsEntity: EventsEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_category_id", referencedColumnName = "title")
    open var refEventsCategoryEntity: EventsCategoryEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "eventId = $eventId " +
                "eventCategoryId = $eventCategoryId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EventsCategoryCrossEntity

        if (eventId != other.eventId) return false
        if (eventCategoryId != other.eventCategoryId) return false

        return true
    }

}

class EventsCategoryCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "event_id", nullable = false, insertable = false, updatable = false)
    open var eventId: Int? = null

    @Id
    @Column(name = "event_category_id", nullable = false, insertable = false, updatable = false)
    open var eventCategoryId: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EventsCategoryCrossEntityPK

        if (eventId != other.eventId) return false
        if (eventCategoryId != other.eventCategoryId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
