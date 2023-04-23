package dotolhee.daramhee.setakfire.global.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@MappedSuperclass
abstract class BaseEntity {
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    open val createdAt: Timestamp? = null

    @Column(nullable = false)
    @UpdateTimestamp
    open val updatedAt: Timestamp? = null
}