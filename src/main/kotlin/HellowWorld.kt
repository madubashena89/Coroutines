import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.ThreadContextElement
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){

    /* Coroutines are light weight
    * */
    GlobalScope.launch {
        delay(1000)
        println("World")
    }

    print("Hellow ")
    Thread.sleep(2000)

    runBlocking()
}

fun runBlocking(){
    kotlinx.coroutines.runBlocking {
        repeat(1_000_000){
            launch {
                print(".")
            }
        }
    }
}