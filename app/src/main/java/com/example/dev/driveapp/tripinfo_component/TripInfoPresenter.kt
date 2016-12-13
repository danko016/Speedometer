package com.example.dev.driveapp.tripinfo_component

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import javax.inject.Inject


/**
 * Created by dev on 08.11.16..
 */
class TripInfoPresenter
@Inject
constructor() : MvpBasePresenter<TripInfoView>() {

    override fun attachView(view: TripInfoView?) {
        super.attachView(view)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }
}

