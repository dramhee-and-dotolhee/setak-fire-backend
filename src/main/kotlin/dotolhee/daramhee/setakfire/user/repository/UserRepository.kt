package dotolhee.daramhee.setakfire.user.repository

import dotolhee.daramhee.setakfire.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(userName: String): User?
}