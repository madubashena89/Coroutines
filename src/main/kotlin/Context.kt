import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(){
    /*
    * Context is a set of variables and data relates to a coroutine
    * Elements of context are Dispatcher and Job
    * */

    kotlinx.coroutines.runBlocking {
        launch(CoroutineName("myCoroutine")){
            println("This is run from ${coroutineContext.get(CoroutineName.Key)}")
        }

        GlobalScope.launch {

        }

    }
}