package dotolhee.daramhee.setakfire.shop.controller

import dotolhee.daramhee.setakfire.partner.entity.Partner
import dotolhee.daramhee.setakfire.partner.repository.PartnerRepository
import dotolhee.daramhee.setakfire.shop.dto.NewShopDTO
import dotolhee.daramhee.setakfire.shop.dto.ShopResponseDTO
import dotolhee.daramhee.setakfire.shop.entity.Shop
import dotolhee.daramhee.setakfire.shop.repository.ShopRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.RequiredArgsConstructor
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@Tag(name = "매장")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ["/shops"])
class ShopController(
    private val shopRepository: ShopRepository,
    private val partnerRepository: PartnerRepository,
) {

    @GetMapping("")
    @Operation(summary = "매장 전체 조회")
    fun list(): List<ShopResponseDTO> {
        val shops = shopRepository.findAll()
        return shops.map { ShopResponseDTO.fromEntity(it) }
    }

    @PostMapping("")
    @Operation(summary = "매장 생성")
    fun new(
        @RequestBody request: NewShopDTO
    ): Shop {
        val partner: Partner =
            partnerRepository.findByIdOrNull(request.partnerId)
                ?: throw NoSuchElementException("존재하지않는 파트너 입니다.")
        return shopRepository.save(Shop(request, partner))
    }
}