package dotolhee.daramhee.setakfire.user.dto

import dotolhee.daramhee.setakfire.global.enums.RoleType
import dotolhee.daramhee.setakfire.user.entity.Role
import dotolhee.daramhee.setakfire.user.entity.User
import java.sql.Timestamp

data class UserBasicDTO(
    val id: Long,
    val accountName: String,
    val encryptedPassword: String,
    val connectedId: Long?,
    var currentSignInAt: Timestamp,
    var token: String?,
    var isActive: Boolean,
    var role: Role,
) {
    companion object {
        fun fromEntity(user: User): UserBasicDTO {
            return UserBasicDTO(
                id = user.id,
                accountName = user.accountName,
                encryptedPassword = user.encryptedPassword,
                connectedId = user.connectedId,
                currentSignInAt = user.currentSignInAt,
                token = user.token,
                isActive = user.isActive,
                role = user.role
            )
        }
    }

    fun toEntity(): User {

        return User(
            id, accountName, encryptedPassword, connectedId, currentSignInAt, token, isActive, role
        )
    }
}

data class RegisterDTO(
    var username: String,
    var password: String,
    var role: RoleType,
    var connectedId: Long?,
)

data class LoginDTO(
    val username: String,
    val password: String,
)

data class LoginResponseDTO(
    val username: String,
    val accessToken: String,
)

data class ResponseDTO(
    var id: Long,
    var username: String,
    var token: String?,
) {
    companion object {
        fun fromRegisterEntity(user: User): ResponseDTO {
            return ResponseDTO(
                id = user.id,
                username = user.username,
                token = null
            )
        }

        fun fromAuthenticationEntity(user: User, token: String?): ResponseDTO {
            return ResponseDTO(
                id = user.id,
                username = user.username,
                token = token
            )
        }
    }
}