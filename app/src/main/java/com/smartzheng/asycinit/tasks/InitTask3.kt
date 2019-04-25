package com.smartzheng.asycinit.tasks

import com.smartzheng.launcherstarter.task.Task

/**
 * Created by smartzheng
 * 2019-04-25
 */
class InitTask3: Task() {
    override fun needRunAsSoon(): Boolean {//提高优先级,也可以指定优先级大小
        return true
    }

    override fun run() {
        //初始化
    }
}