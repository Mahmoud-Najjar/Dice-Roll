package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var textView :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s=Dice()
        println(s.sides)
        s.roll()
        println("Your ${s.sides} sided dice rolled ${s.roll2()}!")
        s.sides=30
        println("Your ${s.sides} sided dice rolled ${s.roll3()}!")
        var s2=Dice2(30)
        println("Your ${s2.side} sided dice rolled ${s2.roll()}!")
        textView =findViewById(R.id.textView)
       val rollButton : Button =findViewById<Button>(R.id.button)
       rollButton.setOnClickListener{
           val toast= Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
           toast.show()
           //textView.text="6"
           rollDice()
        }
    }
    private fun rollDice(){
     var r=Dice2(6)
     var image : ImageView = findViewById(R.id.imageView)
      var n=r.roll()
        when(n)
        {
            1->image.setImageResource(R.drawable.dice_1)
            2->image.setImageResource(R.drawable.dice_2)
            3->image.setImageResource(R.drawable.dice_3)
            4->image.setImageResource(R.drawable.dice_4)
            5->image.setImageResource(R.drawable.dice_5)
            6->image.setImageResource(R.drawable.dice_6)
        }
      textView.text=n.toString()
    }

}

class Dice(){
    var sides=6

    fun roll(){
        val randomNumber = (1..6).random()
        println(randomNumber)
    }
    fun roll2():Int{
        val randomNumber = (1..6).random()
        return randomNumber

    }
    fun roll3():Int{
        val randomNumber = (1..sides).random()
        return randomNumber

    }
}
class Dice2(val numberOfSide:Int){
    var side=6
    fun roll():Int{
        val randomNumber=(1..numberOfSide).random()
        return randomNumber
    }
}
