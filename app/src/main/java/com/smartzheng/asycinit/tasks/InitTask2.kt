package com.smartzheng.asycinit.tasks

import com.smartzheng.launcherstarter.task.Task

/**
 * Created by smartzheng
 * 2019-04-25
 */
class InitTask2: Task() {
    override fun runOnMainThread(): Boolean {//是否需要运行在主线程
        return true
    }

    override fun run() {
        //初始化
    }
}