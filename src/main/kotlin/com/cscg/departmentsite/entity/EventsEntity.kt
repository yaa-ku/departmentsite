package com.cscg.departmentsite.entity

import java.text.SimpleDateFormat
import javax.persistence.*

@Entity
@Table(name = "events", schema = "public", catalog = "department")
open class EventsEntity {
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
    @Column(name = "start_date", nullable = false)
    open var startDate: java.sql.Date? = null

    @Basic
    @Column(name = "end_date", nullable = true)
    open var endDate: java.sql.Date? = null

    @Basic
    @Column(name = "title_image_path", nullable = false)
    open var titleImagePath: String? = null

    @ManyToMany
    @JoinTable(
        name = "event_block_cross",
        joinColumns = [JoinColumn(name = "event_id")],
        inverseJoinColumns = [JoinColumn(name="block_id")]
    )
    open var blocks: MutableList<BlockEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "events_category_cross",
        joinColumns = [JoinColumn(name = "event_id")],
        inverseJoinColumns = [JoinColumn(name="event_category_id")]
    )
    open var categories: MutableList<EventsCategoryEntity> = mutableListOf()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "title = $title " +
                "description = $description " +
                "startDate = $startDate " +
                "endDate = $endDate " +
                "titleImagePath = $titleImagePath " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EventsEntity

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (titleImagePath != other.titleImagePath) return false

        return true
    }

    fun getDate():String{
        var result = ""
        startDate?.let {
            result+=SimpleDateFormat("dd.MM.yyyy").format(it)
        }
        endDate?.let {
            result += if (startDate==null)
                SimpleDateFormat("dd.MM.yyyy").format(it)
            else
                " - ${SimpleDateFormat("dd.MM.yyyy").format(it)}"
        }
        return result
    }
}

