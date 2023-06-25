package dotolhee.daramhee.setakfire.user.entity

import dotolhee.daramhee.setakfire.global.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,

    val username: String,

    val encryptedPassword: String,

    val connectedId: Long?,
) : BaseEntity()
