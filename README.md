# asycstarter
Android异步初始化工具，更多内容请见博客：https://www.jianshu.com/p/ae0884e83c55

1.添加仓库
```
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
2. 添加依赖
```
dependencies {
    implementation 'com.github.smartzheng:launcherstarter:1.0.2'
}
```
3.自定义Task

```
class InitTask : Task() {
    override fun needWait(): Boolean {//是否需要在阻塞在await(),在Application的onCreate方法之前执行完
        return true
    }

    override fun dependsOn(): MutableList<Class<out Task>> {//等待另一个Task执行完再执行此任务初始化
        return mutableListOf(InitTask1::class.java)
    }
    override fun runOnMainThread(): Boolean {//是否需要运行在主线程
        return true
    }
    override fun needRunAsSoon(): Boolean {//提高优先级,也可以指定优先级大小priority
        return true
    }
    override fun run() {
        //初始化
    }
}
```

4.在Application中

```
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LauncherStarter.init(this)
        val starter = LauncherStarter.createInstance()

        starter.addTask(InitTask1())
            .addTask(InitTask2())
            .addTask(InitTask3())
            //addTask()...
        starter.start()
        starter.await()
        //LauncherStarter.createInstance()
        //            .run {
        //                addTask(InitTask1())
        //                    .addTask(InitTask2())
        //                    .addTask(InitTask3())
        //                    //addTask()...
        //                    .start()
        //                await()
        //            }
    }
}
```






















