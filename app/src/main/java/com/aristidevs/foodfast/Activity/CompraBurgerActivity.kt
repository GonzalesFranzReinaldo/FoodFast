package com.aristidevs.foodfast.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.aristidevs.foodfast.R
import com.aristidevs.foodfast.databinding.ActivityCompraBurgerBinding
import com.google.firebase.firestore.FirebaseFirestore

class CompraBurgerActivity : AppCompatActivity() {

    lateinit var binding: ActivityCompraBurgerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompraBurgerBinding.inflate(layoutInflater)
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        setContentView(binding.root)


        //bottom agregar al carrito
//        val btn_agregarBurgerCarrito = findViewById<Button>(R.id.btn_agregarBurger)
//
//        btn_agregarBurgerCarrito.setOnClickListener{
//            Toast.makeText(this, "Su añadió al carrito", Toast.LENGTH_SHORT).show()
//        }

        binding.btnAgregarBurger.setOnClickListener {
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