package dotolhee.daramhee.setakfire.partner.controller

import dotolhee.daramhee.setakfire.partner.dto.NewPartnerDTO
import dotolhee.daramhee.setakfire.partner.entity.Partner
import dotolhee.daramhee.setakfire.partner.repository.PartnerRepository
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.RequiredArgsConstructor
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@Tag(name = "점주")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ["/partners"])
class PartnerController(
    private val partnerRepository: PartnerRepository,
) {

    @GetMapping("{id}")
    fun list(
        @PathVariable id: Long
    ): Partner? {
        return partnerRepository.findByIdOrNull(id)
    }

    @PostMapping("")
    fun new(
        @RequestBody request: NewPartnerDTO
    ): Partner {
        return partnerRepository.save(Partner(request))
    }
}