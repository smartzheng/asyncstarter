package com.smartzheng.asycinit

import android.app.Application
import com.smartzheng.asycinit.tasks.InitTask1
import com.smartzheng.asycinit.tasks.InitTask2
import com.smartzheng.asycinit.tasks.InitTask3
import com.smartzheng.launcherstarter.LauncherStarter

/**
 * Created by smartzheng
 * 2019-04-25
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LauncherStarter.init(this)
        LauncherStarter.createInstance()
            .run {
                addTask(InitTask1())
                    .addTask(InitTask2())
                    .addTask(InitTask3())
                    //addTask()...
                    .start()
                await()
            }
    }
}