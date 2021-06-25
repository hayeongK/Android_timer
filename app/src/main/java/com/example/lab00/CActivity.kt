package com.example.lab00

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timer

class CActivity : AppCompatActivity() {
    private var time = 0
    private var timerTask: Timer? = null
    private lateinit var txtTime:TextView
    private var isRunning = false
    private var index :Int = 1
    private lateinit var lap_layout:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        txtTime = findViewById(R.id.txtTime)
        lap_layout = findViewById<LinearLayout>(R.id.lap_layout)

        val btn_start = findViewById<Button>(R.id.btn_start)
        val btn_pause = findViewById<Button>(R.id.btn_pause)
        val btn_stop = findViewById<Button>(R.id.btn_stop)

        btn_start.setOnClickListener {
            startTimer()
        }
        btn_pause.setOnClickListener {
            pauseTimer()
        }
        btn_stop.setOnClickListener {
            stopTimer()
        }
    }
    fun startTimer(){
        //1000이 1초
        timerTask = timer(period=10){
            time++

            val min = time/100/60
            val sec = time/100%60
            val milli = time % 100

            runOnUiThread {
                //txtTime.text = "${min} : ${sec} : ${milli}"
                txtTime.text = String.format("%02d : %02d : %02d", min, sec, milli)
                if((time%1000)==0 || (time%1000)==1){
                    lapTime()
                }
            }
        }
    }
    fun pauseTimer(){
        timerTask?.cancel()
    }
    fun stopTimer(){
        timerTask?.cancel() // timerTask가 null이 아니라면 cancel() 호출

        time = 0 // 시간저장 변수 초기화
        isRunning = false // 현재 진행중인지 판별하기 위한 Boolean변수 false 세팅
        txtTime.text = "00 : 00 : 00"

        //lap_Layout.removeAllViews() // Layout에 추가한 기록View 모두 삭제
        index = 1
    }
    fun lapTime(){
        val lapTime = time

        // apply() 스코프 함수로, TextView를 생성과 동시에 초기화
        val textView = TextView(this).apply{
            setTextSize(20f)// fontSize 20 설정
        }

        val currentTime = System.currentTimeMillis()//ms로 반환
        val dataFormat = SimpleDateFormat("HH:mm:ss")
        textView.text = "${lapTime/100}초 경과 (${dataFormat.format(currentTime)})"

        lap_layout.addView(textView,0)// layout에 추가, (View, index) 추가할 위치(0 최상단 의미)
        index++ // 추가된 View의 개수를 저장하는 index 변수
    }
}