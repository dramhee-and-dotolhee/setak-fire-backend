package dotolhee.daramhee.setakfire.user.service

import dotolhee.daramhee.setakfire.global.security.token.JwtTokenUtil
import dotolhee.daramhee.setakfire.user.dto.LoginDTO
import dotolhee.daramhee.setakfire.user.dto.LoginResponseDTO
import dotolhee.daramhee.setakfire.user.dto.RegisterDTO
import dotolhee.daramhee.setakfire.user.dto.UserBasicDTO
import dotolhee.daramhee.setakfire.user.entity.User
import dotolhee.daramhee.setakfire.user.repository.RoleRepository
import dotolhee.daramhee.setakfire.user.repository.UserRepository
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDateTime

@Service
@RequiredArgsConstructor
class UserService(
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
    private val userRepository: UserRepository,
    private val customUserDetailService: CustomUserDetailService,
    private val jwtTokenUtil: JwtTokenUtil,
) {

    @Transactional
    fun register(request: RegisterDTO): User {
        if (!usernameValidation(request.username)) {
            throw IllegalArgumentException("이미 가입된 회원입니다.")
        }
        val role = roleRepository.findByType(request.role)
        var user = User(
            accountName = request.username,
            encryptedPassword = passwordEncoder.encode(request.password),
            connectedId = null,
            currentSignInAt = Timestamp.valueOf(LocalDateTime.now()),
            token = null,
            isActive = true,
            role = role
        )
        // ROLE 세팅
        return userRepository.save(user)
    }

    fun login(request: LoginDTO): LoginResponseDTO {
        val userDetails = customUserDetailService.loadUserByUsername(request.username)
        if (!passwordEncoder.matches(request.password, userDetails.password)) {
            throw Exception("존재하지 않는 아이디이거나 비밀번호가 잘못되었습니다.")
        }
        val accessToken = getToken(userDetails)
        val user: User = userRepository.findByAccountName(request.username)
            ?: throw IllegalArgumentException("알 수 없는 에러(유저 정보 미존재)")
        updateLoginInfo(accessToken, user)
        return LoginResponseDTO(userDetails.username, accessToken)
    }

    private fun usernameValidation(username: String): Boolean {
        val user = userRepository.findByAccountName(username)
        return user?.let { false } ?: true
    }

    private fun getToken(userDetails: UserDetails): String {
        return jwtTokenUtil.generateToken(userDetails)
    }

    private fun updateLoginInfo(accessToken: String, user: User) {
        val userDTO = UserBasicDTO.fromEntity(user)
        userDTO.token = accessToken
        userDTO.currentSignInAt = Timestamp.valueOf(LocalDateTime.now())
        userRepository.save(userDTO.toEntity())
    }
}