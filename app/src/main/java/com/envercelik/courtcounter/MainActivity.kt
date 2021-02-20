package com.envercelik.courtcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.envercelik.courtcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private var scoreTeamA = 0
    private var scoreTeamB = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()


        binding.btnResetScore.setOnClickListener {
            binding.textViewScoreTeamA.text = "0"
            binding.textViewScoreTeamB.text = "0"

            scoreTeamA = 0
            scoreTeamB = 0
        }

    }



    private fun setListeners() {

        val clickAbleViews:List<View> = listOf(
                binding.btnOnePointTeamA,
                binding.btnTwoPointTeamA,
                binding.btnThreePointTeamA,

                binding.btnOnePointTeamB,
                binding.btnTwoPointTeamB,
                binding.btnThreePointTeamB
        )


        for (item in clickAbleViews) {
            item.setOnClickListener { increaseScore(it) }
        }

    }


    private fun increaseScore(it: View?) {

        when(it!!.id) {

            R.id.btn_one_point_team_a -> increaseTeamAScore(1)
            R.id.btn_two_point_team_a -> increaseTeamAScore(2)
            R.id.btn_three_point_team_a -> increaseTeamAScore(3)

            R.id.btn_one_point_team_b -> increaseTeamBScore(1)
            R.id.btn_two_point_team_b -> increaseTeamBScore(2)
            R.id.btn_three_point_team_b -> increaseTeamBScore(3)

        }
    }


    private fun increaseTeamAScore(throwPoint:Int) {
        scoreTeamA += throwPoint
        binding.textViewScoreTeamA.text = scoreTeamA.toString()
    }



    private fun increaseTeamBScore(throwPoint:Int) {
        scoreTeamB += throwPoint
        binding.textViewScoreTeamB.text = scoreTeamB.toString()
    }

}