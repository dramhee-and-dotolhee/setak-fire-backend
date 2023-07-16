package dotolhee.daramhee.setakfire.global.advicer

import org.springframework.http.HttpStatus

data class ResponseDTO(
    var data: Any?,
    var status: HttpStatus,
    var message: String? = null,
)