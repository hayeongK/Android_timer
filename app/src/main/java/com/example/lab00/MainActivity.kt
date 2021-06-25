package com.example.lab00

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_layout_toolbar)) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24) // 홈버튼 이미지 변경
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게

        val navigationView = findViewById<NavigationView>(R.id.main_navigationView)
        navigationView.setNavigationItemSelectedListener(this) //navigation 리스너
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{ // 메뉴 버튼
                val drawer = findViewById<DrawerLayout>(R.id.main_drawer_layout)
                drawer.openDrawer(GravityCompat.START)    // 네비게이션 드로어 열기
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var intent1 = Intent(this, AActivity::class.java)
        var intent2 = Intent(this, BActivity::class.java)
        var intent3 = Intent(this, CActivity::class.java)
        when(item.itemId){
            //R.id.account-> Toast.makeText(this,"account clicked",Toast.LENGTH_SHORT).show()
            R.id.item2-> startActivity(intent1)
            R.id.item3-> startActivity(intent2)
            R.id.timer-> startActivity(intent3)
            //R.id.item3-> Toast.makeText(this,"item3 clicked",Toast.LENGTH_SHORT).show()
        }
        return false
    }

    override fun onBackPressed() { //뒤로가기 처리
        val drawer = findViewById<DrawerLayout>(R.id.main_drawer_layout)
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawers()
            // 테스트를 위해 뒤로가기 버튼시 Toast 메시지
            Toast.makeText(this,"back btn clicked",Toast.LENGTH_SHORT).show()
        } else{
            super.onBackPressed()
        }
    }
}