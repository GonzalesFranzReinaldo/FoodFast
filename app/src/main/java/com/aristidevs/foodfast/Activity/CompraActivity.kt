package com.aristidevs.foodfast.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.aristidevs.foodfast.R

class CompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        //bottom agregar al carrito
        val btn_agregarCarrito = findViewById<Button>(R.id.btn_agregarCarrito)

        btn_agregarCarrito.setOnClickListener{
            Toast.makeText(this, "Su añadió al carrito", Toast.LENGTH_SHORT).show()
        }
    }
}