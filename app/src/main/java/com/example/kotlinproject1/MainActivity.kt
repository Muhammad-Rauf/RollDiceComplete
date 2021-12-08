package com.example.kotlinproject1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceimage:ImageView
     lateinit var mp1 : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp1= MediaPlayer.create(this, R.raw.raw_dice_rolling);
        diceimage =findViewById(R.id.resultdiceid)
        var rollbutton :Button=findViewById(R.id.dicebuttonid)
        rollbutton.text="Lets Roll"
        rollbutton.setOnClickListener{
           // Toast.makeText(this,"Button click",Toast.LENGTH_SHORT).show();
            mp1.start()
            mp1= MediaPlayer.create(this, R.raw.raw_dice_rolling);
            val aniRotate = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_clockwise)
            diceimage.startAnimation(aniRotate)
            rollDice()


        }
    }

    private fun rollDice() {

       var drawableResource =when(Random().nextInt(6)+1)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            //6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }

       diceimage.setImageResource(drawableResource)
      //  resultTest.text=number.toString()


    }
}