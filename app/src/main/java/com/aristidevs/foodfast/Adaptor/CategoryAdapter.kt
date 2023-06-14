package com.aristidevs.foodfast.Adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.foodfast.Activity.Domain.Category
import com.aristidevs.foodfast.R
//import com.aristidevs.foodfast.Activity.Domain.DataCategory

class CategoryAdapter(private val categoryList:List<Category>) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflater.inflate(R.layout.viewholder_category, parent, false))
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = categoryList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = categoryList.size
}