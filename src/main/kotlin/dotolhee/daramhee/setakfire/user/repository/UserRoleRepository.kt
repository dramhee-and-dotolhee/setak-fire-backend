package dotolhee.daramhee.setakfire.user.repository

import dotolhee.daramhee.setakfire.user.entity.UserRole
import org.springframework.data.jpa.repository.JpaRepository

interface UserRoleRepository : JpaRepository<UserRole, Long> {
}