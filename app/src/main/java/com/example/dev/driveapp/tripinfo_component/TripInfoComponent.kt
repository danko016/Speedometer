package com.example.dev.driveapp.tripinfo_component

import android.content.Context
import com.example.dev.driveapp.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dev on 08.11.16..
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface TripInfoComponent {

    fun inject(context: Context)

    fun presenter(): TripInfoPresenter

}