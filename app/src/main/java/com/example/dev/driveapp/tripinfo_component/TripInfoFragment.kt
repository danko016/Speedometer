package com.example.dev.driveapp.tripinfo_component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.driveapp.R
import com.example.dev.driveapp.modules.AppModule
import com.hannesdorfmann.mosby.mvp.MvpFragment

/**
 * Created by dev on 08.11.16..
 */

class TripInfoFragment : MvpFragment<TripInfoView, TripInfoPresenter>(), TripInfoView {

    lateinit var component: TripInfoComponent

    fun injectDependencies(){
        component = DaggerTripInfoComponent.builder()
                .appModule(AppModule(context))
                .build()
    }

    override fun createPresenter(): TripInfoPresenter {
        return component.presenter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        injectDependencies()
        return inflater?.inflate(R.layout.tripinfo_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}