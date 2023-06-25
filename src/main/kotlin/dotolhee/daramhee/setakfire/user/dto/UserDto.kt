package dotolhee.daramhee.setakfire.user.dto

import dotolhee.daramhee.setakfire.global.enums.RoleType
import dotolhee.daramhee.setakfire.user.entity.User

data class RegisterDTO(
    var username: String,
    var password: String,
    var role: RoleType,
    var connectedId: Long?,
)

data class ResponseDTO(
    var id: Long,
    var username: String,
    var token: String?,
) {
    companion object {
        fun fromRegisterEntity(user: User) : ResponseDTO {
            return ResponseDTO(
                id = user.id,
                username = user.username,
                token = null
            )
        }

        fun fromAuthenticationEntity(user: User, token: String?) : ResponseDTO {
            return ResponseDTO(
                id = user.id,
                username = user.username,
                token = token
            )
        }
    }
}