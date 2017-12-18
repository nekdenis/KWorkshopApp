package com.kotlinsg.kworkshopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.appB.R
import com.kotlinsg.kworkshopapp.di.Logger
import com.kotlinsg.kworkshopapp.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var log: Logger
    @Inject lateinit var showGithubScreenAction: ShowGithubScreenAction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).run {
            MainActivityComponent.Initializer.init(getAppComponent()).inject(this@MainActivity)
        }

        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.icon).setOnClickListener { openGithubScreen() }
        log.d("Main activity created. Logger injected successfully")
    }

    private fun openGithubScreen() {
        showGithubScreenAction.show(this)
    }
}
