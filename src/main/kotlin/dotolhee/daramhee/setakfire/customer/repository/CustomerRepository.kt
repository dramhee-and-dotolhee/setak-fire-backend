package dotolhee.daramhee.setakfire.customer.repository

import dotolhee.daramhee.setakfire.customer.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}