package com.example.dev.driveapp.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by dev on 07.11.16..
 */
@Module
class AppModule(val context: Context) {

    @Provides
    fun providesContext(): Context {
        return context
    }

}