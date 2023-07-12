package dotolhee.daramhee.setakfire.user.entity

import dotolhee.daramhee.setakfire.global.entity.BaseEntity
import jakarta.persistence.*
import java.sql.Timestamp

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

    @Column
    val currentSignInAt: Timestamp,

    @Column
    val token: String?,

    @Column
    val isActive: Boolean,
) : BaseEntity()
//    , UserDetails {
//    companion object {
////        fun getCurrentUser(): User {
////            val principal = SecurityContextHolder.getContext().authentication.principal as UserDetails
////            return User(
////                username = principal.username,
////                encryptedPassword = principal.password,
////            )
////        }
//    }
//    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
//        return null
//    }
//
//    override fun getPassword(): String {
//        return encryptedPassword
//    }
//
////    override fun getUsername(): String {
////        return username
////    }
//
//    override fun isAccountNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isAccountNonLocked(): Boolean {
//        return true
//    }
//
//    override fun isCredentialsNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isEnabled(): Boolean {
//        return isActive
//    }
//}
