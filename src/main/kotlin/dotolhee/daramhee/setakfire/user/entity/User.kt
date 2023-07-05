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

    @Column(unique = true)
    val username: String,

    @Column
    val encryptedPassword: String,

    @Column
    val connectedId: Long?,
) : BaseEntity()
