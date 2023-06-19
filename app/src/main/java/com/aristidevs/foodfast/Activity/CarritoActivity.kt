package com.aristidevs.foodfast.Activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.aristidevs.foodfast.R
import com.aristidevs.foodfast.databinding.ActivityCarritoBinding
import com.google.firebase.firestore.FirebaseFirestore

class CarritoActivity : AppCompatActivity() {

    lateinit var binding: ActivityCarritoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        setContentView(binding.root)


        //para mostrar las opciones de cambios en el carrito
        val btn_cambios = findViewById<TextView>(R.id.btn_realizarCambio)
        val linearLayout = findViewById<LinearLayout>(R.id.cuadro_cambios)
        btn_cambios.setOnClickListener {
            linearLayout.visibility = View.VISIBLE
        }


        //para mostrar los datos de los pedidos en el carrito
        binding.btnConsulta.setOnClickListener {
            var datos = ""
            db.collection("carrito_de_compra")
                .get()
                .addOnSuccessListener { result ->
                    for(document in result){
                        datos += "${document.id}: ${document.data}\n"
                    }
                    binding.tvConsulta.text = datos
                }
                .addOnFailureListener { exception ->
                    binding.tvConsulta.text = "No se ha podido conectar"
                }
        }


        //para modificar el pedido
        binding.btnModificarPedido.setOnClickListener {
            modificationDates(db)
        }


        //para eliminar quitar el pedido del carrito
        binding.btnQuitarCarrito.setOnClickListener {
            if (binding.etId.text.isNotBlank()) {

                db.collection("carrito_de_compra")
                    .document(binding.etId.text.toString())
                    .delete()
                    .addOnSuccessListener { _ ->
                        //binding.tvConfirmar.text = "Se añadió al carrito correctamente"
                        Toast.makeText(this, "El pedido fue cancelado", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener { _ ->
                        //binding.tvConfirmar.text = "No se pudo añadir al carrito"
                        Toast.makeText(this, "No se pudo cancelar el pedido", Toast.LENGTH_SHORT).show()
                    }
            }
        }



        //para localizar la ubicacion
        val btn_ubicacion = findViewById<Button>(R.id.btn_direccion)
        btn_ubicacion.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("geo:0,0?q=")
            startActivity(intent)
        }

        //para confirmar el pedido
        val btn_confirmar = findViewById<Button>(R.id.btn_confirmar_pedido)
        btn_confirmar.setOnClickListener {
            Toast.makeText(this, "Su pedido fue realizada exitosamente", Toast.LENGTH_SHORT).show()
        }


        //para obtener la direccion
        val btn_direccion = findViewById<TextView>(R.id.tv_direccion)
        val obtener_direccion = findViewById<LinearLayout>(R.id.obtener_direccion)
        btn_direccion.setOnClickListener {
            obtener_direccion.visibility = View.VISIBLE
        }


        //para el button salir
        val btnSalir = findViewById<Button>(R.id.btn_salir) as Button
         btnSalir.setOnClickListener(){
             val salir = Intent(this@CarritoActivity, MenuActivity::class.java)
             finish()
         }


        //para enviar la ubicacion
        val btn_enviarUbicacion = findViewById<TextView>(R.id.btn_enviarUbicacion)
        btn_enviarUbicacion.setOnClickListener {
            setDirection(db)
        }

    }




    //funcion para modificar los datos del carrito
    private fun modificationDates(db: FirebaseFirestore) {
        if (binding.etId.text.isNotBlank() &&
            binding.etProducto.text.isNotBlank() &&
            binding.etCantidad.text.isNotBlank()) {

            val dato = hashMapOf(
                "producto" to binding.etProducto.text.toString(),
                "Cantidad" to binding.etCantidad.text.toString()
            )

            db.collection("carrito_de_compra")
                .document(binding.etId.text.toString())
                .set(dato)
                .addOnSuccessListener { _ ->
                    //binding.tvConfirmar.text = "Se añadió al carrito correctamente"
                    Toast.makeText(this, "Se realizó correctamente los cambios", Toast.LENGTH_SHORT)
                        .show()
                }
                .addOnFailureListener { _ ->
                    //binding.tvConfirmar.text = "No se pudo añadir al carrito"
                    Toast.makeText(this, "No se pudo realizar los cambios", Toast.LENGTH_SHORT).show()
                }
        }
    }



    //para guardar la direccion
    private fun setDirection(db: FirebaseFirestore) {
        if (binding.etIdLink.text.isNotBlank() &&
            binding.etEnlaceDireccion.text.isNotBlank()) {

            val dato = hashMapOf(
                "enlace" to binding.etEnlaceDireccion.text.toString()
            )

            db.collection("ubicacion")
                .document(binding.etIdLink.text.toString())
                .set(dato)
                .addOnSuccessListener { _ ->
                    //binding.tvConfirmar.text = "Se añadió al carrito correctamente"
                    Toast.makeText(this, "Se envió ubicación correctamente", Toast.LENGTH_SHORT)
                        .show()
                }
                .addOnFailureListener { _ ->
                    //binding.tvConfirmar.text = "No se pudo añadir al carrito"
                    Toast.makeText(this, "No se pudo enviar la ubicación", Toast.LENGTH_SHORT).show()
                }
        }
    }
}