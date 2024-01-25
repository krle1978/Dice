package com.atvss.dicee2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.atvss.dicee2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val diceArray = intArrayOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )
        var scoreFirstArray = intArrayOf()
        var scoreSecondArray = intArrayOf()
        var pntFirstPlayer = 0
        var pntSecondPlayer = 0
        var rolls = 0
        var clickedFirst = 0
        var clickedSecond = 0
        var winsFirst = 0
        var winsSecond = 0
        binding.apply {
            btnRoll.setOnClickListener {
                //Buttons
                btnFirstPlayer.isEnabled = true
                btnSecondPlayer.isEnabled = true
                val randNumberGen = java.util.Random()
                var index1 = randNumberGen.nextInt(6)
                ivLeftDice.setImageResource(diceArray[index1])
                var index2 = randNumberGen.nextInt(6)
                ivRightDice.setImageResource(diceArray[index2])
                //izracunavanje
                pntFirstPlayer += index1 +1
                pntSecondPlayer += index2 +1
                tnFirstPlay.setText(pntFirstPlayer.toString())
                tnSecPlay.setText(pntSecondPlayer.toString())
                rolls +=1
                Log.d("MainTag", "rolls = $rolls")
                Log.d("MainTag", "index1 = $index1 : index2 = $index2")
                //getWinner(rolls,index1, pntFirstPlayer, pntSecondPlayer, index2)
                Log.e("MainTag", "I am IN")
                if (rolls > 3 && index1 == index2){
                    Log.e("MainTag", "I am IF")
                    //buttons
                    btnFirstPlayer.isEnabled = false
                    btnSecondPlayer.isEnabled = false
                    btnFirstPlayer.visibility=View.GONE
                    btnSecondPlayer.visibility=View.GONE
                    Log.d("MainTag", "Buttons are: First ${btnFirstPlayer.isEnabled}, Second: ${btnSecondPlayer.isEnabled}")
                    btnRoll.isEnabled = false
                    btnRoll.visibility = View.GONE
                    btnPlyAgn.visibility = View.VISIBLE
                    if (pntFirstPlayer > pntSecondPlayer){
                        Log.e("MainTag", "First Winning")
                        tv1stWinner.visibility = View.VISIBLE
                        winsFirst+=1
                    }else{
                        Log.e("MainTag", "Second Winning")
                        tv2ndWinner.visibility = View.VISIBLE
                        winsSecond+=1
                    }
                    btnPlyAgn.setOnClickListener {
                        btnFirstPlayer.isEnabled = true
                        btnSecondPlayer.isEnabled = true
                        btnFirstPlayer.visibility=View.VISIBLE
                        btnSecondPlayer.visibility=View.VISIBLE
                        btnRoll.isEnabled = true
                        btnRoll.visibility = View.VISIBLE
                        btnPlyAgn.visibility = View.GONE
                        tnFirstPlay.setText("0")
                        tnSecPlay.setText("0")
                        tv1stWinner.visibility = View.GONE
                        tv2ndWinner.visibility = View.GONE
                        pntFirstPlayer = 0
                        pntSecondPlayer = 0
                        rolls = 0
                       /* scoreFirstArray[scoreFirstArray.size] = pntFirstPlayer
                        scoreSecondArray[scoreFirstArray.size] = pntSecondPlayer*/
                        tnScorFirstPlay.setText(winsFirst.toString())
                        tnScorSecondPlay.setText(winsSecond.toString())
                    }
                }
            }
            btnFirstPlayer.setOnClickListener {
                btnRoll.isEnabled = false
                val randNumberGen = java.util.Random()
                var index1 = randNumberGen.nextInt(6)
                ivLeftDice.setImageResource(diceArray[index1])
               //Buttons
                btnFirstPlayer.isEnabled = false
                btnSecondPlayer.isEnabled = true
                //izracunavanje
                pntFirstPlayer += index1 +1
                tnFirstPlay.setText(pntFirstPlayer.toString())
                clickedFirst += 1
                if (clickedFirst == clickedSecond){
                    btnRoll.isEnabled = true
                }
            }
            btnSecondPlayer.setOnClickListener {
                btnRoll.isEnabled = false
                val randNumberGen = java.util.Random()
                var index2 = randNumberGen.nextInt(6)
                ivRightDice.setImageResource(diceArray[index2])
                //Buttons
                btnFirstPlayer.isEnabled = true
                btnSecondPlayer.isEnabled = false
                //izracunavanje
                pntSecondPlayer += index2 +1
                tnSecPlay.setText(pntSecondPlayer.toString())
                clickedSecond +=1
                if (clickedFirst == clickedSecond){
                    btnRoll.isEnabled = true
                }
            }
        }



    }

    private fun getWinner(
        rolls: Int,
        index1: Int,
        index2: Int,
        pntFirstPlayer: Int,
        pntSecondPlayer: Int
    ) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            Log.e("MainTag", "I am IN")
            if (rolls > 3 && index1 == index2){
                Log.e("MainTag", "I am IF")
                //buttons
                btnFirstPlayer.isEnabled = false
                btnSecondPlayer.isEnabled = false
                Log.d("MainTag", "Buttons are: First ${btnFirstPlayer.isEnabled}, Second: ${btnSecondPlayer.isEnabled}")
                btnRoll.isEnabled = false
                btnRoll.visibility = View.GONE
                btnPlyAgn.visibility = View.VISIBLE
                if (pntFirstPlayer > pntSecondPlayer){
                    Log.e("MainTag", "First Winning")
                    tv1stWinner.visibility = View.VISIBLE
                }else{
                    Log.e("MainTag", "Second Winning")
                    tv2ndWinner.visibility = View.VISIBLE
                }
                btnPlyAgn.setOnClickListener {
                    btnFirstPlayer.isEnabled = true
                    btnSecondPlayer.isEnabled = true
                    btnRoll.isEnabled = true
                    btnRoll.visibility = View.VISIBLE
                    btnPlyAgn.visibility = View.GONE
                    tnFirstPlay.setText("0")
                    tnSecPlay.setText("0")
                    tv1stWinner.visibility = View.GONE
                    tv2ndWinner.visibility = View.GONE
                    /*pntFirstPlayer = 0
                    pntSecondPlayer = 0
                    rolls = 0*/
                }
            }

        }

    }


    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}