package dotolhee.daramhee.setakfire.user.repository

import dotolhee.daramhee.setakfire.global.enums.RoleType
import dotolhee.daramhee.setakfire.user.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByType(type: RoleType): Role
}