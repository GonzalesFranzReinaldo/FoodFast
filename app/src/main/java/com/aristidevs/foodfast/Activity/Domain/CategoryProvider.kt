package com.aristidevs.foodfast.Activity.Domain

class CategoryProvider {
    companion object {
        val categoryList = listOf<Category>(
            Category(
                "Pizza",
                "https://e7.pngegg.com/pngimages/317/611/png-clipart-pizza-pizza-sticker-pepperoni-pizza-food-pizza-delivery.png"
            ),
            Category(
                "Hamburguesa",
                "https://img.lovepik.com/element/45007/2397.png_860.png"
            ),
            Category(
                "HotDog",
                "https://e7.pngegg.com/pngimages/626/707/png-clipart-hot-dog-food-hot-dog-bread-thumbnail.png"
            )
        )
    }
}