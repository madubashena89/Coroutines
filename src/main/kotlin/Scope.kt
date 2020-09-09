import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){
   /*
   * Scope provides lifecycle methods for coroutines
   * Allow us start and stop coroutines
   * Scope can create and mange a coroutine and also can stop when all the inner coroutines are finished.
   * */
    println("Program will start now")

    /*RunBlocking creates a scope and runs a coroutine in a blocking way. We use when the only thing we are trying to do in the application.
    * */
    kotlinx.coroutines.runBlocking {
        launch {
            delay(1000L)
            println("Task from runBlocking")
        }

        /* GlobalScore lifecycle of the entire application. Which will not stop unless the application stops.
        Which runs in background and will not finish unless the application stops */
        GlobalScope.launch {
            delay(500L)
            println("Task from GlobalScope")
        }

        /*
        * Creates a new scope does not complete until all children coroutines complete
        * */
        coroutineScope {
            launch {
                delay(1500L)
                println("Task from coroutineScope")
            }
        }
    }

    println("Program has finished now")
}