package dotolhee.daramhee.setakfire.partner.entity

import dotolhee.daramhee.setakfire.global.entity.BaseEntity
import dotolhee.daramhee.setakfire.partner.dto.NewPartnerDTO
import jakarta.persistence.*

@Entity
@Table(name = "partners")
class Partner(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,

    @Column
    val ownerName: String,

    @Column
    val contact: String,
) : BaseEntity() {
    constructor(
        newDTO: NewPartnerDTO
    ) : this(
        ownerName = newDTO.ownerName,
        contact = newDTO.contact
    )
}