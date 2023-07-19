package dotolhee.daramhee.setakfire.customer.service

import dotolhee.daramhee.setakfire.customer.dto.CustomerDTO
import dotolhee.daramhee.setakfire.customer.entity.Customer
import dotolhee.daramhee.setakfire.customer.repository.CustomerRepository
import dotolhee.daramhee.setakfire.user.repository.UserRepository
import dotolhee.daramhee.setakfire.user.service.UserService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val userService: UserService,
    private val userRepository: UserRepository
) {
    @Transactional
    fun new(request: CustomerDTO.New): Customer {
        val userInfo = request.userInfo
        val user = userService.register(userInfo)
        var newCustomer = Customer(request)
        newCustomer = customerRepository.save(newCustomer)
        user.connectedId = newCustomer.id
        userRepository.save(user)
        return newCustomer
    }
}