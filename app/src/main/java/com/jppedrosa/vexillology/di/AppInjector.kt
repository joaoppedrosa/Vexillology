package com.jppedrosa.vexillology.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.jppedrosa.vexillology.VexillologyApplication
import com.jppedrosa.vexillology.di.component.DaggerAppComponent
import dagger.android.AndroidInjection

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 16/09/2022.
 */

object AppInjector {
    fun init(application: VexillologyApplication) {
        DaggerAppComponent.builder().application(application).build().inject(application)
        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                AndroidInjection.inject(activity)
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }
}