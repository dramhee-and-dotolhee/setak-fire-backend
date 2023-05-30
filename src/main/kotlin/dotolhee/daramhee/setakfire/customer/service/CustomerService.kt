package dotolhee.daramhee.setakfire.customer.service

import dotolhee.daramhee.setakfire.customer.dto.CustomerDTO
import dotolhee.daramhee.setakfire.customer.entity.Customer
import dotolhee.daramhee.setakfire.customer.repository.CustomerRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    @Transactional
    fun new(request: CustomerDTO.New): Map<String, Long> {
        val newCustomer = Customer(request)
        return mapOf("customerId" to customerRepository.save(newCustomer).id)

    }
}