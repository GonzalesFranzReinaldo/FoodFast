package com.aristidevs.foodfast.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.foodfast.Activity.Domain.ItemsViewModel
import com.aristidevs.foodfast.Adaptor.CustomAdapter
import com.aristidevs.foodfast.R
import com.aristidevs.foodfast.databinding.ActivityStoreBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class StoreActivity : AppCompatActivity() {

    lateinit var binding: ActivityStoreBinding

//    val db = Firebase.firestore
//    val TAG = "Datos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreBinding.inflate(layoutInflater)

        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        setContentView(binding.root)

        //getData()


        binding.btnConsulta.setOnClickListener {

            var datos = ""
            db.collection("tienda")
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



    }


//    private fun getData(){
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val data = ArrayList<ItemsViewModel>()
//
//        db.collection("tienda")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result){
//                    data.add(ItemsViewModel("Oso", document.data.get("nombre").toString()))
//                    //data.add(ItemsViewModel("Oso", document.data.get("telefono").toString()))
//                    //data.add(ItemsViewModel("Oso", document.data.get("direccion").toString()))
//                    Log.d(TAG, "${document.id} => ${document.data}")
//                }
//
//                val adapter = CustomAdapter(data)
//                recyclerView.adapter = adapter
//            }
//            .addOnFailureListener { exception ->
//                Log.w(TAG, "Error getting documents", exception)
//            }
//    }


}



