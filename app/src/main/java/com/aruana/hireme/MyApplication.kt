package com.aruana.hireme

import android.app.Application
import com.aruana.hireme.di.AppComponent
import com.aruana.hireme.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}