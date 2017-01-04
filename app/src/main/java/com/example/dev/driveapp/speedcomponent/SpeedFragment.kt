package com.example.dev.driveapp.speedcomponent

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.driveapp.R
import com.example.dev.driveapp.modules.AppModule
import com.hannesdorfmann.mosby.mvp.MvpFragment
import com.mcxiaoke.koi.ext.onClick
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.speedlayout.*

/**
 * Created by dev on 29.11.16..
 */
class SpeedFragment : MvpFragment<SpeedView, SpeedPresenter>(), SpeedView {

    lateinit var component: SpeedComponent

    override fun setSpeed() {
        TVSpeed?.text = presenter.currentSpeed.toString()
    }

    fun injectDependencies() {
        component = DaggerSpeedComponent.builder()
                .appModule(AppModule(context))
                .build()
    }

    override fun createPresenter(): SpeedPresenter {
        return component.presenter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        injectDependencies()
        return inflater?.inflate(R.layout.speedlayout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.locate(presenter.getProvider())

        BTNExit.visibility = View.GONE
        BTNHud.onClick {

            LLSpeed?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            activity.tlTabs.visibility = View.GONE
            RLSpeed.scaleX = -1.0f
            BTNHud.visibility = View.GONE
            BTNExit.visibility = View.VISIBLE
            val orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
            activity.requestedOrientation = orientation

        }

        BTNExit.onClick {
            val orientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
            activity.requestedOrientation = orientation
            RLSpeed.scaleX = 1.0f
            activity.tlTabs.visibility = View.VISIBLE
            BTNHud.visibility = View.VISIBLE
        }
    }

}