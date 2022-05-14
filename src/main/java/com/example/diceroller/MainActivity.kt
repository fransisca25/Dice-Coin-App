package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { makeActions() }

        makeActions()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun makeActions() {
        //First Dice
        val myFirstDice = Dice(6)
        val diceRoll = myFirstDice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource: Int = when(diceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

        //Second Dice
        val mySecondDice = Dice(6)
        val diceRoll2 = mySecondDice.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView4)
        val drawableResource2: Int = when(diceRoll2)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll.toString()


        //Flip a coin
        val myCoin = Coin()
        val coinToss = myCoin.flip()
        val coinImage: ImageView = findViewById(R.id.imageView5)
        val drawableResource3: Int = when(coinToss){
            1 -> R.drawable.coin_head
            else -> R.drawable.coin_tail
        }
        coinImage.setImageResource(drawableResource3)
        coinImage.contentDescription = coinToss.toString()
    }
}

private class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

private class Coin {
    fun flip(): Int{
        return (1..2).random()
    }
}