package com.example.catchthemouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    var score = 0

    //image array'inde imageView'lar olan bir array tanimladik:
    var imageArray = arrayListOf<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)


        hideImages()

        //CountDownTimer: app acildigi gibi geri sayma islemine baslayacagim icin onCreate icinde yapacagiz
        object : CountDownTimer(15000, 1000) {
            override fun onTick(p0: Long) {
                timeText.text = "Time: " + p0 / 1000
            }

            override fun onFinish() {
                timeText.text = "Time: 0"

                //Alert uyari mesaji olusturma:
                var alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart the Game?")
                alert.setPositiveButton("Yes") { dialog, which ->
                    //restart
                    //intent aslinda activity'ye baska activity'den putExtra ile gonderilen seyleri almaya yariyordu.
                    //Burada activity'yi yeniden baslatmak icin kullandik.
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(this@MainActivity, "Game Over", Toast.LENGTH_LONG).show()
                }
                alert.show()
            }

        }.start()
    }

    fun hideImages() {
        for (image in imageArray) {
            image.visibility = View.INVISIBLE
        }
        val random = Random()
        val randomIndex = random.nextInt(9)
        imageArray[randomIndex].visibility = View.VISIBLE
    }


    fun increaseScore(view: View) {
        score = score + 1
        scoreText.text = "Score: $score"
    }
}