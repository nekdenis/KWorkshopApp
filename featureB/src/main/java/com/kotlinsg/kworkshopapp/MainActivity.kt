package com.kotlinsg.kworkshopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlinsg.kworkshopapp.appB.R
import com.kotlinsg.kworkshopapp.di.Logger
import com.kotlinsg.kworkshopapp.di.MainActivityBComponent
import javax.inject.Inject

class MainBActivity : AppCompatActivity() {

    @Inject lateinit var log: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).run {
            MainActivityBComponent.Initializer.init(getAppComponent()).inject(this@MainBActivity)
        }

        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.icon).setOnClickListener { openGithubScreen() }
        log.d("Main activity created. Logger injected successfully")
    }

    private fun openGithubScreen() {
//        startActivity(Intent(this, GithubActivity::class.java))
    }
}
