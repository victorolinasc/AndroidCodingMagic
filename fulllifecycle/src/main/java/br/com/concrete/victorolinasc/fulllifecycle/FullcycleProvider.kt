package br.com.concrete.victorolinasc.fulllifecycle

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import java.lang.ref.WeakReference

const val TAG = "FullcycleProvider"

object FullcycleProvider {

    private lateinit var currentActivityRef: WeakReference<Activity>

    /**
     * Magic context from anywhere. Not only that, it is the current foreground Activity context :)
     */
    fun getCurrentActivity() = currentActivityRef.get()

    /**
     * Init function called from AutoInit.
     */
    fun init(ctx: Context) {

        val app = ctx.applicationContext as Application

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d(TAG, "${activity.javaClass.canonicalName}.onActivityCreated()")

                // AHMAGAD... A static context????
                currentActivityRef = WeakReference(activity)

                if (activity is FragmentActivity) {
                    activity.supportFragmentManager.registerFragmentLifecycleCallbacks(

                            object : android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks() {
                                // Fragment lifecycle :)
                                // Exercise for yourself :)
                            }, false
                    )
                }
            }

            override fun onActivityPaused(activity: Activity) {
                Log.d(TAG, "${activity.javaClass.canonicalName}.onActivityPaused()")

            }

            override fun onActivityResumed(activity: Activity) {
                Log.d(TAG, "${activity.javaClass.canonicalName}.onActivityResumed()")
            }

            override fun onActivityStarted(activity: Activity) {
                Log.d(TAG, "${activity.javaClass.canonicalName}.onActivityStarted()")
            }

            override fun onActivityDestroyed(activity: Activity) {
                Log.d(TAG, "${activity.javaClass.canonicalName}.onActivityDestroyed()")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
                Log.d(TAG, "${activity.javaClass.canonicalName}.onActivitySaveInstanceState()")
            }

            override fun onActivityStopped(activity: Activity) {
                Log.d(TAG, "${activity.javaClass.canonicalName}.onActivityStopped()")
            }
        })

    }
}