package com.example.miholamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var lbl: TextView
    lateinit var img1: ImageView
    lateinit var img2: ImageView
    var puntosDados = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)

        boton = findViewById(R.id.btnRoller)
        lbl = findViewById(R.id.lblSaludo)
        img1 = findViewById(R.id.imgRoller1)
        img2 = findViewById(R.id.imgRoller2)
        // img.setImageDrawable(resources.getDrawable(R.drawable.dice_3))

//        boton.setOnClickListener(
//            View.OnClickListener {
//                //crea una  notificacion
//                Toast.makeText(applicationContext, "Boton presionado", Toast.LENGTH_LONG).show()
//            }
//        )

        boton.setOnClickListener {
            val idImagenAl1 = getRandomDiceImage()
            puntosDados += " y "
            val idImagenAl2 = getRandomDiceImage()
            Toast.makeText(applicationContext, "Puntos de los dados: " + puntosDados, Toast.LENGTH_LONG).show()

            img1.setImageResource(idImagenAl1)
            img2.setImageResource(idImagenAl2)
            lbl.text = "Resultados: " + puntosDados
            puntosDados = ""
        }
    }

    private fun getRandomDiceImage() : Int {
        val al = diceRoller()
        puntosDados += al
        return when(al){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }

    fun diceRoller() : Int {
        return (1..6).random()
    }
}