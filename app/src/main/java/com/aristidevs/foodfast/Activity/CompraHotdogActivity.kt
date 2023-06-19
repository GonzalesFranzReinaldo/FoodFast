package com.aristidevs.foodfast.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.aristidevs.foodfast.R
import com.aristidevs.foodfast.databinding.ActivityCompraHotdogBinding
import com.google.firebase.firestore.FirebaseFirestore

class CompraHotdogActivity : AppCompatActivity() {

    lateinit var binding: ActivityCompraHotdogBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompraHotdogBinding.inflate(layoutInflater)
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        setContentView(binding.root)

        //bottom agregar al carrito
        val btn_agregarHotdog = findViewById<Button>(R.id.btn_agregar_hotdog_carrito)

        btn_agregarHotdog.setOnClickListener {
            Toast.makeText(this, "Su añadió al carrito", Toast.LENGTH_SHORT).show()
        }



        binding.btnAgregarHotdogCarrito.setOnClickListener {
            if (binding.etId.text.isNotBlank() &&
                binding.etProductoAgregar.text.isNotBlank() &&
                binding.etCantidadAgregar.text.isNotBlank()){

                val dato = hashMapOf(
                    "producto" to binding.etProductoAgregar.text.toString(),
                    "Canridad" to binding.etCantidadAgregar.text.toString()
                )

                db.collection("carrito_de_compra")
                    .document(binding.etId.text.toString())
                    .set(dato)
                    .addOnSuccessListener { _ ->
                        //binding.tvConfirmar.text = "Se añadió al carrito correctamente"
                        Toast.makeText(this, "Se añadió al carrito corectamente", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { _ ->
                        //binding.tvConfirmar.text = "No se pudo añadir al carrito"
                        Toast.makeText(this, "No se pudo añadir al carrito", Toast.LENGTH_SHORT).show()
                    }
            }
        }

    }
}