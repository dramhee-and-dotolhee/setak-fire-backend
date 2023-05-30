package dotolhee.daramhee.setakfire.customer.dto

class CustomerDTO {
    data class New(
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