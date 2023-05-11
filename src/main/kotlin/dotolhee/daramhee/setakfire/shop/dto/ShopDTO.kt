package dotolhee.daramhee.setakfire.shop.dto

import dotolhee.daramhee.setakfire.global.enums.CategoryType
import dotolhee.daramhee.setakfire.shop.entity.Shop
import java.sql.Timestamp

data class ShopResponseDTO (
    var id: Long = 0L,
    var name: String,
    var imageUrls: List<String>?,
    var partnerId: Long,
    var isAvailableDelivery: Boolean,
    var categoryTypes: List<CategoryType>,
    var minimumCharge: Int?,
    var minimumUnit: Int?,
    var deliveryCharge: Int?,
    var address: String,
    var createdAt: Timestamp?,
    var updateAt: Timestamp?,
    var x: Double?,
    var y: Double?,
) {
    companion object {
        fun fromEntity(shop: Shop): ShopResponseDTO {

            return ShopResponseDTO(
                id = shop.id,
                name = shop.name,
                address = shop.address,
                categoryTypes = shop.categoryTypes,
                minimumCharge = shop.minimumCharge,
                minimumUnit = shop.minimumUnit,
                deliveryCharge = shop.deliveryCharge,
                imageUrls = shop.imageUrls,
                isAvailableDelivery = shop.isAvailableDelivery,
                partnerId = shop.partner.id,
                createdAt = shop.createdAt,
                updateAt = shop.updatedAt,
                x = shop.x,
                y = shop.y,
            )
        }
    }
}
data class NewShopDTO (
    val name: String,
    val imageUrls: List<String>?,
    val partnerId: Long,
    val isAvailableDelivery: Boolean,
    val categoryTypes: List<CategoryType>,
    val minimumCharge: Int?,
    val minimumUnit: Int?,
    val deliveryCharge: Int?,
    val address: String,
)