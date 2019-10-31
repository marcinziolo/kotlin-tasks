import java.util.*
import java.util.function.Consumer

fun <T> Optional<T>.ifPresentOrElse(consumer: Consumer<T>, runnable: Runnable) {
    //TODO Implement method
    if (this.isPresent ) {
        consumer.accept(this.get())
    } else {
        runnable.run()
    }
}

fun main() {
//    val optional: Optional<String> = Optional.of("value")
    val optionalEmpty: Optional<String> = Optional.empty()
    optionalEmpty.ifPresentOrElse(Consumer { println(it) }, Runnable{ println("Absent") })
}