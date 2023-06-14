package com.aristidevs.foodfast.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.aristidevs.foodfast.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //para el button Iniciar
        val buttonIniciar = findViewById<Button>(R.id.buttonIniciar) as Button

        buttonIniciar.setOnClickListener(){
            val iniciar = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(iniciar)
        }

//        buttonIniciar.setOnClickListener(){
//            val iniciar = Intent(this@MainActivity, MenuActivity::class.java)
//            startActivity(iniciar)
//        }


        //para java
    }
}