package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "block", schema = "public", catalog = "department")
open class BlockEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    open var id: Int? = null

    @Basic
    @Column(name = "title", nullable = false)
    open var title: String? = null

    @Basic
    @Column(name = "content", nullable = false)
    open var content: String? = null

    @OneToMany(mappedBy = "refBlockEntity")
    open var refEventBlockCrossEntities: MutableList<EventBlockCrossEntity> = mutableListOf()

    @OneToMany(mappedBy = "refBlockEntity")
    open var refMaterialBlockCrossEntities: MutableList<MaterialBlockCrossEntity> = mutableListOf()

    @OneToMany(mappedBy = "refBlockEntity", fetch = FetchType.EAGER)
    open var media: MutableList<MediaEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "news_block_cross",
        joinColumns = [JoinColumn(name = "block_id")],
        inverseJoinColumns = [JoinColumn(name="news_id")]
    )
    open var refNewsBlockCrossEntities: MutableList<NewsEntity> = mutableListOf()


    @OneToMany(mappedBy = "refBlockEntity", fetch = FetchType.EAGER)
    open var refMediaEntities: MutableList<MediaEntity> = mutableListOf()

    @OneToMany(mappedBy = "refBlockEntity")
    open var refProjectsBlockCrossEntities: MutableList<ProjectsBlockCrossEntity>? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "title = $title " +
                "content = $content " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BlockEntity

        if (id != other.id) return false
        if (title != other.title) return false
        if (content != other.content) return false

        return true
    }

}

