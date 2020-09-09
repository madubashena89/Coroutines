import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var functionCalls  = 0
/*
* Suspending function is a function which can run inside a coroutine
* Make callbacks seamless (execute and can access a local variable
* */
fun main(){
    GlobalScope.launch { completeMessage() }
    GlobalScope.launch { improveMEssage() }
    print("Hellow ")
    Thread.sleep(3000)
    println("There have been $functionCalls calls so far")
}

suspend fun completeMessage(){
    delay(1000L)
    println("World")
    functionCalls ++
}

suspend fun improveMEssage(){
    delay(2000L)
    println("Suspend functions are cool")
    functionCalls++
}