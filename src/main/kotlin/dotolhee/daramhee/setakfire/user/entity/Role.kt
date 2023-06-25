package dotolhee.daramhee.setakfire.user.entity

import dotolhee.daramhee.setakfire.global.enums.RoleType
import jakarta.persistence.*

@Entity
@Table(name = "roles")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,

    @Enumerated(EnumType.STRING)
    val type: RoleType,
)