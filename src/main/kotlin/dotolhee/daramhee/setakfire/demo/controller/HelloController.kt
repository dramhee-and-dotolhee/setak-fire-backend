package dotolhee.daramhee.setakfire.demo.controller

import dotolhee.daramhee.setakfire.demo.dto.HelloResDTO
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class HelloController {

    @GetMapping("hello")
    fun sayHello(): HelloResDTO {
        return HelloResDTO("hello?")
    }
}
