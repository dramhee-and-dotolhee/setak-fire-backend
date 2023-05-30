package dotolhee.daramhee.setakfire.customer.entity

import dotolhee.daramhee.setakfire.customer.dto.CustomerDTO
import dotolhee.daramhee.setakfire.global.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "customers")
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,

    @Column
    val name: String,

    @Column
    val phoneNumber: String,

    @Column
    val address1: String,

    @Column
    val address2: String,

    @Column
    val address3: String?,

    @Column
    val postCode: String,

    @Column
    val howToEnter: String?,

    @Column
    val requirementMemo: String?,

    @Column
    val district: String?,

    @Column
    val latitude: Double?,

    @Column
    val longitude: Double?,

    @Column
    val memo: String?,
): BaseEntity() {
    constructor(
        newDTO: CustomerDTO.New
    ):this(
        id = 0L,
        name = newDTO.name,
        phoneNumber = newDTO.phoneNumber,
        address1 = newDTO.address1,
        address2 = newDTO.address2,
        address3 = newDTO.address3,
        postCode = newDTO.postCode,
        howToEnter = newDTO.howToEnter,
        requirementMemo = newDTO.requirementMemo,
        district = newDTO.district,
        latitude = newDTO.latitude,
        longitude = newDTO.longitude,
        memo = newDTO.memo,
    )
}