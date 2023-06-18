package com.aristidevs.foodfast.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.foodfast.Activity.Domain.CategoryProvider
import com.aristidevs.foodfast.Adaptor.CategoryAdapter
import com.aristidevs.foodfast.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MenuActivity : AppCompatActivity() {

    lateinit var fb_carritoCompra: FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        //para el button salir
        //val btnSalir = findViewById<Button>(R.id.btnSalir) as Button


       /* btnSalir.setOnClickListener(){
            val salir = Intent(this@MenuActivity, MainActivity::class.java)
            finish()
        }*/

        val compraPizza = findViewById<Button>(R.id.btn_popular1) as Button

        //para ir a carrito de compra
        fb_carritoCompra = findViewById<FloatingActionButton>(R.id.fb_carritoCompra)
        fb_carritoCompra.setOnClickListener{
            val intent = Intent(this@MenuActivity, MonitoreoActivity::class.java)
            startActivity(intent)
        }

        val store = findViewById<ImageView>(R.id.iv_store)
        store.setOnClickListener{
            val intent = Intent(this@MenuActivity, StoreActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Bienvenido a nuestra tienda", Toast.LENGTH_SHORT).show()
        }

        val btn_popular1 = findViewById<Button>(R.id.btn_popular1)
        btn_popular1.setOnClickListener{
            val intent = Intent(this@MenuActivity, CompraActivity::class.java)
            startActivity(intent)
        }


    }



    /*//parte el recycler view
    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_Categoria)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CategoryAdapter(CategoryProvider.categoryList)
    }*/

}