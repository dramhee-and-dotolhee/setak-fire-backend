package dotolhee.daramhee.setakfire.shop.entity

import dotolhee.daramhee.setakfire.global.converter.JsonCategoryTypeArrayConverter
import dotolhee.daramhee.setakfire.global.converter.JsonStringArrayConverter
import dotolhee.daramhee.setakfire.global.entity.BaseEntity
import dotolhee.daramhee.setakfire.global.enums.CategoryType
import dotolhee.daramhee.setakfire.partner.entity.Partner
import dotolhee.daramhee.setakfire.shop.dto.NewShopDTO
import jakarta.persistence.*

@Entity
@Table(name = "shops")
class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,

    @Column
    val name: String,

    @Convert(converter = JsonStringArrayConverter::class)
    @Column(columnDefinition = "json")
    var imageUrls: List<String>?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    val partner: Partner,

    @Column
    val isAvailableDelivery: Boolean = false,

    @Convert(converter = JsonCategoryTypeArrayConverter::class)
    @Column(columnDefinition = "json")
    val categoryTypes: List<CategoryType>,

    @Column
    val minimumCharge: Int? = 0,

    @Column
    val minimumUnit: Int? = 0,

    @Column
    val deliveryCharge: Int? = 0,

    @Column
    val address: String,

    @Column
    val latitude: Double?,

    @Column
    val longitude: Double?,
    ) : BaseEntity() {

    constructor(newDTO: NewShopDTO, partner: Partner) : this(
        name = newDTO.name,
        address = newDTO.address,
        categoryTypes = newDTO.categoryTypes,
        minimumCharge = newDTO.minimumCharge,
        minimumUnit = newDTO.minimumUnit,
        deliveryCharge = newDTO.deliveryCharge,
        imageUrls = newDTO.imageUrls,
        isAvailableDelivery = newDTO.isAvailableDelivery,
        partner = partner,
        latitude = newDTO.latitude,
        longitude = newDTO.longitude,
    )
}