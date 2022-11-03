package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "news_block_cross", schema = "public", catalog = "department")
@IdClass(NewsBlockCrossEntityPK::class)
open class NewsBlockCrossEntity {
    @Id
    @Column(name = "news_id", nullable = false, insertable = false, updatable = false)
    open var newsId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    open var refNewsEntity: NewsEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    open var refBlockEntity: BlockEntity? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "newsId = $newsId " +
                "blockId = $blockId " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NewsBlockCrossEntity

        if (newsId != other.newsId) return false
        if (blockId != other.blockId) return false

        return true
    }

}

class NewsBlockCrossEntityPK : java.io.Serializable {
    @Id
    @Column(name = "news_id", nullable = false, insertable = false, updatable = false)
    open var newsId: Int? = null

    @Id
    @Column(name = "block_id", nullable = false, insertable = false, updatable = false)
    open var blockId: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NewsBlockCrossEntityPK

        if (newsId != other.newsId) return false
        if (blockId != other.blockId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}
