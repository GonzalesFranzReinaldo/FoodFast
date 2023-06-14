package com.aristidevs.foodfast.Adaptor

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.foodfast.Activity.Domain.Category
import com.aristidevs.foodfast.R

class CategoryViewHolder(view: View):RecyclerView.ViewHolder(view) {

    //creamos variable para los componentes
    val categoryName = view.findViewById<TextView>(R.id.tvCategoryName_1)
    val categoryPhoto = view.findViewById<ImageView>(R.id.ivCategory_1)

    //para asignarle
    fun render(categoryModel: Category){
        categoryName.text = categoryModel.realName
    }
}