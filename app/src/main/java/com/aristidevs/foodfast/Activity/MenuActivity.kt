package com.aristidevs.foodfast.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
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

        val btn_perfil = findViewById<ImageView>(R.id.btn_perfil)
        btn_perfil.setOnClickListener {
            val intent = Intent(this@MenuActivity, PerfilActivity::class.java)
            startActivity(intent)
        }


        //para ir a carrito de compra
        fb_carritoCompra = findViewById<FloatingActionButton>(R.id.fb_carritoCompra)
        fb_carritoCompra.setOnClickListener{
            val intent = Intent(this@MenuActivity, CarritoActivity::class.java)
            startActivity(intent)
        }

        val store = findViewById<ImageView>(R.id.iv_store)
        store.setOnClickListener{
            val intent = Intent(this@MenuActivity, StoreActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Bienvenido a nuestra tienda", Toast.LENGTH_SHORT).show()
        }


        //variables para los tres productos al añadir al carrito
        val setPizza = findViewById<LinearLayout>(R.id.carrito_pizza)
        val setBurger = findViewById<LinearLayout>(R.id.carrito_burger)
        val setHotDog = findViewById<LinearLayout>(R.id.carrito_hotdog)


        //variable para los productos populares
        val btn_pizzaPopular = findViewById<Button>(R.id.btn_pizza_popular)
        val btn_burgerPopular = findViewById<Button>(R.id.btn_burger_popular)
        val btn_hotdogPopular = findViewById<Button>(R.id.btn_hotdog_popular)

        btn_pizzaPopular.setOnClickListener{
            val intent = Intent(this@MenuActivity, CompraPizzaActivity::class.java)
            startActivity(intent)
        }


        btn_burgerPopular.setOnClickListener{
            val intent = Intent(this@MenuActivity, CompraBurgerActivity::class.java)
            startActivity(intent)
        }

        btn_hotdogPopular.setOnClickListener{
            val intent = Intent(this@MenuActivity, CompraHotdogActivity::class.java)
            startActivity(intent)
        }

        //para ordenarel pedido
        val btn_orderNew : Button = findViewById(R.id.btnOrdenNew)
        btn_orderNew.setOnClickListener {
            val intent = Intent(this@MenuActivity, CartActivity::class.java)
            startActivity(intent)
        }

        //ejemplo
//        val btn_gps = findViewById<ImageView>(R.id.btn_bebida)
//        btn_gps.setOnClickListener {
//            val intent = Intent(this@MenuActivity, MonitoreoActivity::class.java)
//            startActivity(intent)
//        }

        //para las bebidas
        val btn_bebida = findViewById<ImageView>(R.id.btn_bebida)
        btn_bebida.setOnClickListener {
            val intent = Intent(this@MenuActivity, BebidaActivity::class.java)
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