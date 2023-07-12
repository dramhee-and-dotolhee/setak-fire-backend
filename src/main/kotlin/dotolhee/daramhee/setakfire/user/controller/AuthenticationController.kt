package dotolhee.daramhee.setakfire.user.controller

import dotolhee.daramhee.setakfire.user.dto.LoginDTO
import dotolhee.daramhee.setakfire.user.dto.RegisterDTO
import dotolhee.daramhee.setakfire.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class AuthenticationController(
    private val userService: UserService
) {

    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterDTO,
    ): ResponseEntity<out Any> {
        return try {
            val response = userService.register(request)
            ResponseEntity(response, HttpStatus.OK)
        } catch (ex: Exception) {
            ex.printStackTrace()
            ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/login")
    fun authenticate(@RequestBody request: LoginDTO) {
        return userService.login(request)
    }
}