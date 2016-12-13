package com.example.dev.driveapp.activity_component

import android.content.Context
import com.example.dev.driveapp.adapter.ViewPagerAdapter
import com.example.dev.driveapp.modules.AppModule
import com.example.dev.driveapp.modules.FragmentModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dev on 07.11.16..
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, FragmentModule::class))
interface MainActivityComponent{

    fun inject(context: Context)

    fun presenter(): MainActivityPresenter

    fun adapter(): ViewPagerAdapter

}