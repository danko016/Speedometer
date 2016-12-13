package com.example.dev.driveapp.modules

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides

/**
 * Created by dev on 21.11.16..
 */
@Module
class LayoutModule(val context: Context){

    @Provides
    fun providesLayout(): LinearLayoutManager{
        return LinearLayoutManager(context)
    }

}