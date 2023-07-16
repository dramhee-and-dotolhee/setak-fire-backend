package dotolhee.daramhee.setakfire.user.entity

import dotolhee.daramhee.setakfire.global.entity.BaseEntity
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.sql.Timestamp

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,

    @Column(unique = true)
    val accountName: String,

    @Column
    val encryptedPassword: String,

    @Column
    val connectedId: Long?,

    @Column
    var currentSignInAt: Timestamp,

    @Column
    var token: String?,

    @Column
    val isActive: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    var role: Role,
) : BaseEntity(), UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return  listOf(SimpleGrantedAuthority(role.type.displayName))
    }

    override fun getPassword(): String {
        return encryptedPassword
    }

    override fun getUsername(): String {
        return accountName
    }

    override fun isAccountNonExpired(): Boolean {
        return isActive
    }

    override fun isAccountNonLocked(): Boolean {
        return isActive
    }

    override fun isCredentialsNonExpired(): Boolean {
        return isActive
    }

    override fun isEnabled(): Boolean {
        return isActive
    }
}
