package com.example.dev.driveapp.modules

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.dev.driveapp.speedcomponent.SpeedFragment
import com.example.dev.driveapp.tripinfo_component.TripInfoFragment
import dagger.Module
import dagger.Provides

/**
 * Created by dev on 08.11.16..
 */
@Module
class FragmentModule(val fragmentManager: FragmentManager){

    @Provides
    fun providesFragmentManager(): FragmentManager{
        return fragmentManager
    }

    @Provides
    fun provideListFragment(): List<Fragment>{
        val list: List<Fragment> = listOf(SpeedFragment(), TripInfoFragment())
        return list
    }

}