package dotolhee.daramhee.setakfire.user.entity

import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor

@Entity
@Table(name = "users_roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class UserRole (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val userId: Long?,

    @Column
    val roleId: Long?,
)