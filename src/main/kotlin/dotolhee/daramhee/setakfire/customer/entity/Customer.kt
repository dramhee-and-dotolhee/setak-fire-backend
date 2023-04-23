package dotolhee.daramhee.setakfire.customer.entity

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
): BaseEntity()