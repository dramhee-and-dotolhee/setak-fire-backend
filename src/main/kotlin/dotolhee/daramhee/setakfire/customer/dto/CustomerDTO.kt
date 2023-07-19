package dotolhee.daramhee.setakfire.customer.dto

import dotolhee.daramhee.setakfire.user.dto.RegisterDTO

class CustomerDTO {
    data class New(
        var userInfo: RegisterDTO,
        var name: String,
        var phoneNumber: String,
        var address1: String,
        var address2: String,
        var address3: String?,
        var postCode: String,
        var howToEnter: String?,
        var requirementMemo: String?,
        var district: String?,
        var latitude: Double?,
        var longitude: Double?,
        var memo: String?,
    )
}