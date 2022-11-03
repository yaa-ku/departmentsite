package com.cscg.departmentsite.entity

import javax.persistence.*

@Entity
@Table(name = "feedbacks", schema = "public", catalog = "department")
open class FeedbacksEntity {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Basic
    @Column(name = "feedback_date", nullable = false)
    open var feedbackDate: java.sql.Date? = null

    @Basic
    @Column(name = "first_name", nullable = false)
    open var firstName: String? = null

    @Basic
    @Column(name = "last_name", nullable = false)
    open var lastName: String? = null

    @Basic
    @Column(name = "email", nullable = false)
    open var email: String? = null

    @Basic
    @Column(name = "feedback_text", nullable = false)
    open var feedbackText: String? = null


    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "feedbackDate = $feedbackDate " +
                "firstName = $firstName " +
                "lastName = $lastName " +
                "email = $email " +
                "feedbackText = $feedbackText " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as FeedbacksEntity

        if (id != other.id) return false
        if (feedbackDate != other.feedbackDate) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (email != other.email) return false
        if (feedbackText != other.feedbackText) return false

        return true
    }

}

