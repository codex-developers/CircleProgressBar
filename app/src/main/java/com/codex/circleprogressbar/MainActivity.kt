package com.codex.circleprogressbar

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.codex.circle_progress_bar.TextMode
import com.codex.circleprogressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.circleProgressView.apply {
            setText("Measuring...")
            isShowTextWhileSpinning = true
            spin()
            setTextMode(TextMode.TEXT)
            isUnitVisible = false
        }

        timer.start()
    }

    private val timer = object : CountDownTimer(10000, 1000) {
        override fun onTick(p0: Long) {
            val time = (p0 / 1000).toFloat()
            binding.circleProgressView.apply {
                maxValueAllowed = 10f
                minValueAllowed = 0f
                maxValue = 10f
                setText(time.toString())
                setValue(time)
//                setValueAnimated(time)
                isUnitVisible = false
            }
        }

        override fun onFinish() {
            binding.circleProgressView.setValueAnimated(10f)
            cancel()
        }

    }
}