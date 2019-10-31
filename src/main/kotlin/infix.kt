import com.sun.org.apache.xpath.internal.operations.Neg

fun main() {

    val boolean = true

//    val value = if (boolean) "positive" else "negative"
    // TODO Implement more pleasant conditional
    val value = boolean then getPositive() or getNegative()
    println(value)
}

private fun getNegative(): String {
    println("getting negative")
    return "negative"
}

private fun getPositive(): String {
    println("getting positive")
    return "positive"
}

infix fun <T> Boolean.then(positiveValue: T): OrCase<T> {
    return if(this) {
        PositiveCase(positiveValue)
    } else {
        NegativeCase()
    }
}

sealed class OrCase<T> {
    abstract infix fun or(value: T): T
}

class PositiveCase<T>(private val positiveValue: T): OrCase<T>() {
    override fun or(value: T): T = positiveValue
}

class NegativeCase<T>(): OrCase<T>() {
    override fun or(value: T): T = value
}