package com.example.dev.driveapp.speedcomponent

import android.content.Context
import com.example.dev.driveapp.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dev on 29.11.16..
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface SpeedComponent{

    fun inject(context: Context)

    fun presenter(): SpeedPresenter

}