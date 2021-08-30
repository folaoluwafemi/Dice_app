package com.example.myapplication

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.toRange


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val dice1: ImageView = findViewById(R.id.imageView)
        val dice2: ImageView = findViewById(R.id.imageView2)
        button.setOnClickListener {
            rollDice(dice1)
            rollDice(dice2)
        }
    }
    private fun rollDice(image: ImageView) {
        val dice = Dice(6)
        val drawableResource = when(dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
            image.setImageResource(drawableResource)

    }
    class Dice(private val sides: Int){
        fun roll(): Int{
            return  (1..sides).random()
        }
    }
}
