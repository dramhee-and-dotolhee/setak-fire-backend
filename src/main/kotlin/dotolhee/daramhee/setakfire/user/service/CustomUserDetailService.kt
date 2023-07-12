package dotolhee.daramhee.setakfire.user.service

import dotolhee.daramhee.setakfire.user.entity.User
import dotolhee.daramhee.setakfire.user.repository.RoleRepository
import dotolhee.daramhee.setakfire.user.repository.UserRepository
import dotolhee.daramhee.setakfire.user.repository.UserRoleRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
    private val userRoleRepository: UserRoleRepository,
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = username?.let { userRepository.findByUsername(it) }
            ?: throw NoSuchElementException("사용자를 찾을 수 없습니다: $username")
        return User(
            id = user.id,
            username = user.username,
            encryptedPassword = user.encryptedPassword,
            connectedId = user.connectedId,
            currentSignInAt = user.currentSignInAt,
            token = user.token,
            isActive = user.isActive
        ) as UserDetails
    }
}