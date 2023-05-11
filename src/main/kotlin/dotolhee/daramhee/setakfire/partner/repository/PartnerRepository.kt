package dotolhee.daramhee.setakfire.partner.repository

import dotolhee.daramhee.setakfire.partner.entity.Partner
import org.springframework.data.jpa.repository.JpaRepository

interface PartnerRepository : JpaRepository<Partner, Long> {
}