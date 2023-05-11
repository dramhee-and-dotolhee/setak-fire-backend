package dotolhee.daramhee.setakfire.shop.repository

import dotolhee.daramhee.setakfire.shop.entity.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository: JpaRepository<Shop, Long> {
}