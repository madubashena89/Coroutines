import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

fun main(){

    /*
    * Async is used to retrive values from coroutines. Example suspend functions
    * */
    kotlinx.coroutines.runBlocking {
        val firstDeffered =async { getFirstValue() }
        val secondDeffered = async { getSecondValue() }

        println("Doing some processing here")
        delay(500L)
        println("Waiting for values")

        val firstValue = firstDeffered.await()
        val secondValue = secondDeffered.await()

        println("The total is ${firstValue + secondValue}")
    }
}

suspend fun getFirstValue(): Int{
    delay(1000L)
    val value = Random.nextInt(100)
    println("Returning first value $value")
    return value
}

suspend fun getSecondValue(): Int{
    delay(2000L)
    val value = Random.nextInt(1000)
    println("Returning second value $value")
    return value
}