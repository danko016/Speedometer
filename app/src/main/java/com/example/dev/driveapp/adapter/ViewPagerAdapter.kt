package com.example.dev.driveapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import javax.inject.Inject

/**
 * Created by dev on 08.11.16..
 */
class ViewPagerAdapter
@Inject
constructor(fragmentManager: FragmentManager, val listFragment: MutableList<Fragment>): FragmentStatePagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position){
            0 -> return "Speedometer"
            1 -> return "Trip Info"
        }
        return "Error"
    }

}