import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

fun main(){
    kotlinx.coroutines.runBlocking {
//        launch(Dispatchers.Main){
//            println("Main dispatcher. Thread : ${Thread.currentThread().name}")
//        }

        /*
        * Dispatchers determines which thread or thread pool the coroutine runs on
        * Dispatchers are available depending on the task specificity
        * Dispatchers.Main --> To update the Main UI thread in Android, which needs to define in Gradle
        * Dispatchers.Default --> Useful for CPU intensive work
        * Dispatchers.IO --> Useful for network communication or reading and writing files
        * Dispatchers.Unconfined --> Starts the coroutine in the inherited dispatcher that called it. Let system decide to use
        * newSingleThreadContext --> Creation of new thread
        * Threads are expensive and can not use many threads but coroutines are light weight
        * */

        launch(Dispatchers.Unconfined){
            println("Unconfined1. Thread: ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined2. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default){
            println("Default. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO){
            println("IO. Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("My Thread")){
            println("newSingleThreadContext. Thread: ${Thread.currentThread().name}")
        }
    }
}