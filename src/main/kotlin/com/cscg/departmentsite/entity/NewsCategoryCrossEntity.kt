package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "news_category_cross", schema = "public", catalog = "department")
@IdClass(NewsCategoryCrossEntityPK::class)
open class NewsCategoryCrossEntity {
    @Id
    @Column(name = "news_id", nullable = false, insertable = false, updatable = false)
    open var newsId: Int? = null

    @Id
    @Column(name = "news_category_id", nullable = false, insertable = false, updatable = false)
    open var newsCategoryId: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    open var refNewsEntity: NewsEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_category_id", referencedColumnName = "title")
    open var refNewsCategoryEntity: NewsCategoryEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "newsId = $newsId " +
                "newsCategoryId = $newsCategoryId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NewsCategoryCrossEntity

        if (newsId != other.newsId) return false
        if (newsCategoryId != other.newsCategoryId) return false

        return true
    }

}

class NewsCategoryCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "news_id", nullable = false, insertable = false, updatable = false)
    open var newsId: Int? = null

    @Id
    @Column(name = "news_category_id", nullable = false, insertable = false, updatable = false)
    open var newsCategoryId: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NewsCategoryCrossEntityPK

        if (newsId != other.newsId) return false
        if (newsCategoryId != other.newsCategoryId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
