package dotolhee.daramhee.setakfire.customer.controller

import dotolhee.daramhee.setakfire.customer.dto.CustomerDTO
import dotolhee.daramhee.setakfire.customer.entity.Customer
import dotolhee.daramhee.setakfire.customer.service.CustomerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Customer")
@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping("")
    @Operation(summary = "고객 생성")
    fun new(
        @RequestBody request: CustomerDTO.New
    ): Customer {
        return customerService.new(request)
    }
}