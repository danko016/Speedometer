package com.example.dev.driveapp.speedcomponent

import android.content.Context
import android.location.*
import android.os.Bundle
import android.util.Log
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import java.io.IOException
import java.util.*
import javax.inject.Inject

/**
 * Created by dev on 29.11.16..
 */
class SpeedPresenter
@Inject
constructor(val context: Context) : MvpBasePresenter<SpeedView>() {

    var currentSpeed: Int = 0
    var locationManager: LocationManager? = null


    fun getProvider(): String {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria()
        criteria.powerRequirement = Criteria.POWER_LOW // Chose your desired power consumption level.
        criteria.accuracy = Criteria.ACCURACY_FINE // Choose your accuracy requirement.
//        criteria.accuracy = Criteria.ACCURACY_HIGH
        criteria.isSpeedRequired = true // Chose if speed for first location fix is required.
        criteria.isAltitudeRequired = false // Choose if you use altitude.
        criteria.isBearingRequired = false // Choose if you use bearing.
        criteria.isCostAllowed = false // Choose if this provider can waste money :-)

        // Provide your criteria and flag enabledOnly that tells
        // LocationManager only to return active providers.
        return locationManager!!.getBestProvider(criteria, true)
    }

    fun locate(provider: String) {

        Log.d("tag", "locate init")
        val minTime: Long = 0
        val minDistance = 0f
        try {
            locationManager?.requestLocationUpdates(provider, minTime, minDistance, object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    Log.d("tag", "locate " + location)
                    var name: String? = null
                    val longitudeA = location.longitude
                    val latitudeA = location.latitude

                    val geocoder = Geocoder(context, Locale.getDefault())
                    val addresses: List<Address>
                    try {
                        addresses = geocoder.getFromLocation(latitudeA, longitudeA, 1)
                        if (addresses.isNotEmpty() || addresses.isEmpty()) {
                            name = addresses[0].locality
                        }
                    } catch (e: IOException) {

                    }
                    currentSpeed = (location.speed * 3.6).toInt()
//                    textLocality = name!!.toString()
//                    latLng = latitude.toString() + ", " + longitude.toString()
//                    Log.d("tag", "name " + name)
//                    Log.d("tag", "textLocality " + textLocality)
                    view?.setSpeed()
                }


                override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

                }

                override fun onProviderEnabled(provider: String) {

                }

                override fun onProviderDisabled(provider: String) {
                }
            })
        } catch (e: SecurityException) {

        }
    }

    override fun attachView(view: SpeedView?) {
        super.attachView(view)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }

}