package dotolhee.daramhee.setakfire.user.repository

import dotolhee.daramhee.setakfire.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByAccountName(accountName: String): User?
}