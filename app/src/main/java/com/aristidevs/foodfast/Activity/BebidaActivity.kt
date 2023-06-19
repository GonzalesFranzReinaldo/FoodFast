package com.aristidevs.foodfast.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.aristidevs.foodfast.R
import com.aristidevs.foodfast.databinding.ActivityBebidaBinding
import com.google.firebase.firestore.FirebaseFirestore

class BebidaActivity : AppCompatActivity() {

    lateinit var binding: ActivityBebidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBebidaBinding.inflate(layoutInflater)
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        setContentView(binding.root)


        //para agregar al carrito
        val btn_agregar = findViewById<Button>(R.id.btn_agregarGaseosa)
        btn_agregar.setOnClickListener {
            agregarDatos(db)
        }

    }


    //funcion para agregar datos
    private fun agregarDatos(db: FirebaseFirestore) {
        if (binding.etId.text.isNotBlank() &&
            binding.etProductoAgregar.text.isNotBlank() &&
            binding.etCantidadAgregar.text.isNotBlank()
        ) {

            val dato = hashMapOf(
                "producto" to binding.etProductoAgregar.text.toString(),
                "Cantidad" to binding.etCantidadAgregar.text.toString()
            )

            db.collection("carrito_de_compra")
                .document(binding.etId.text.toString())
                .set(dato)
                .addOnSuccessListener { _ ->
                    //binding.tvConfirmar.text = "Se añadió al carrito correctamente"
                    Toast.makeText(this, "Se añadió al carrito corectamente", Toast.LENGTH_SHORT)
                        .show()
                }
                .addOnFailureListener { _ ->
                    //binding.tvConfirmar.text = "No se pudo añadir al carrito"
                    Toast.makeText(this, "No se pudo añadir al carrito", Toast.LENGTH_SHORT).show()
                }
        }
    }
}