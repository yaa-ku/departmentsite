package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "news", schema = "public", catalog = "department")
open class NewsEntity {
    @Basic
    @Column(name = "title", nullable = true)
    open var title: String? = null

    @Basic
    @Column(name = "description", nullable = false)
    open var description: String? = null

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    open var id: Int? = null

    @Basic
    @Column(name = "title_image_path", nullable = false)
    open var titleImagePath: String? = null

    @ManyToMany
    @JoinTable(
        name = "news_block_cross",
        joinColumns = [JoinColumn(name = "news_id")],
        inverseJoinColumns = [JoinColumn(name="block_id")]
    )
    open var blocks: MutableList<BlockEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "news_category_cross",
        joinColumns = [JoinColumn(name = "news_id")],
        inverseJoinColumns = [JoinColumn(name="news_category_id")]
    )    open var categories: MutableList<NewsCategoryEntity> = mutableListOf()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "title = $title " +
                "description = $description " +
                "id = $id " +
                "titleImagePath = $titleImagePath " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NewsEntity

        if (title != other.title) return false
        if (description != other.description) return false
        if (id != other.id) return false
        if (titleImagePath != other.titleImagePath) return false

        return true
    }

}

