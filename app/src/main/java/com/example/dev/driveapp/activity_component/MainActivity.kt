package com.example.dev.driveapp.activity_component

import android.os.Bundle
import android.util.Log
import com.example.dev.driveapp.R
import com.example.dev.driveapp.adapter.ViewPagerAdapter
import com.example.dev.driveapp.modules.AppModule
import com.example.dev.driveapp.modules.FragmentModule
import com.hannesdorfmann.mosby.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : MvpActivity<MainActivityView, MainActivityPresenter>(), MainActivityView {

    override fun goLeft() {
        vpPager.currentItem = vpPager.currentItem - 1
        Log.d("tag", "current" + vpPager.currentItem)
    }

    lateinit var component: MainActivityComponent
    var adapter: ViewPagerAdapter? = null

    fun injectDependencies() {
        component = DaggerMainActivityComponent.builder()
                .appModule(AppModule(applicationContext))
                .fragmentModule(FragmentModule(supportFragmentManager))
                .build()
    }

    override fun createPresenter(): MainActivityPresenter {
        return component.presenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = component.adapter()
        vpPager.adapter = adapter
        tlTabs.setupWithViewPager(vpPager)
        Log.d("tag", "current" + vpPager.currentItem)

    }

    override fun onBackPressed() {
        if (vpPager.currentItem == 1) {
            goLeft()
        } else {
            super.onBackPressed()
        }
    }
}
