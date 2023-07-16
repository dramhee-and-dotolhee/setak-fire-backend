package dotolhee.daramhee.setakfire.user.service

import dotolhee.daramhee.setakfire.user.entity.User
import dotolhee.daramhee.setakfire.user.repository.RoleRepository
import dotolhee.daramhee.setakfire.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = username?.let { userRepository.findByAccountName(it) }
            ?: throw Exception("존재하지 않는 아이디이거나 비밀번호가 잘못되었습니다.")
        return User(
            id = user.id,
            accountName = user.username,
            encryptedPassword = user.encryptedPassword,
            connectedId = user.connectedId,
            currentSignInAt = user.currentSignInAt,
            token = user.token,
            isActive = user.isActive,
            role = user.role,
        )
    }
}