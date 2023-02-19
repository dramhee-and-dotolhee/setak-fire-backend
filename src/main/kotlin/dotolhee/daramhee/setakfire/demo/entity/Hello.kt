package dotolhee.daramhee.setakfire.demo.entity

import jakarta.persistence.*


@Entity
class Hello(
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val message: String? = "안녕하세요",
)