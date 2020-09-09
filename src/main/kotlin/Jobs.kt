import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){
    /*
    * Job handles a coroutine which runs in a background
    * Jobs lives in a hierarchy or other jobs both as parents and children
    * */
   kotlinx.coroutines.runBlocking {
       val job1 = launch {
           //delay(3000L)
           println("Job 1 launched")
           val job2 = launch {
               println("Job2 has launched")
               delay(3000L)
               println("Job2 is finishing")
           }
           job2.invokeOnCompletion {
               println("Job2 completed")
           }
           val job3 = launch {
               println("Job3 has launched")
               delay(3000L)
               println("Job3 is finishing")
           }
           job3.invokeOnCompletion {
               println("job3 has completed")
           }






       }
       job1.invokeOnCompletion {
           println("Job1 completed")
       }
       delay(500L)
       println("Job1 will be cancelled")
       job1.cancel()
   }
}