package dotolhee.daramhee.setakfire.user.service

import dotolhee.daramhee.setakfire.user.dto.LoginDTO
import dotolhee.daramhee.setakfire.user.dto.RegisterDTO
import dotolhee.daramhee.setakfire.user.dto.ResponseDTO
import dotolhee.daramhee.setakfire.user.entity.User
import dotolhee.daramhee.setakfire.user.entity.UserRole
import dotolhee.daramhee.setakfire.user.repository.RoleRepository
import dotolhee.daramhee.setakfire.user.repository.UserRepository
import dotolhee.daramhee.setakfire.user.repository.UserRoleRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDateTime

@Service
class UserService(
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
    private val userRoleRepository: UserRoleRepository,
    private val userRepository: UserRepository
) {

    @Transactional
    fun register(request: RegisterDTO): ResponseDTO {
        if (!usernameValidation(request.username)) {
            throw IllegalArgumentException("이미 가입된 회원입니다.")
        }
        var user = User(
            username = request.username,
            encryptedPassword = passwordEncoder.encode(request.password),
            connectedId = null,
            currentSignInAt = Timestamp.valueOf(LocalDateTime.now()),
            token = null,
            isActive = true
        )
        user = userRepository.save(user)
        // ROLE 세팅
        val role = roleRepository.findByType(request.role)
        userRoleRepository.save(UserRole(userId = user.id, roleId = role.id))
        return ResponseDTO.fromRegisterEntity(user)
    }

    fun login(request: LoginDTO) {

    }

    private fun usernameValidation(username: String): Boolean {
        val user = userRepository.findByUsername(username)
        return user?.let { false } ?: true
    }
}