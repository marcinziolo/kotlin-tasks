import java.io.File

interface Printer {
    fun print(text: String)
}

interface Scanner {
    fun scan(): File
}

class PrinterImpl: Printer {
    override fun print(text: String) {
        println("Println implementation")
    }
}

class ScannerImpl: Scanner {
    override fun scan(): File {
        println("Scanner implementation")
        return File("file.txt")
    }
}


class MultifunctionalMachine(
    private val printer: Printer,
    private val scanner: Scanner): Printer by printer, Scanner by scanner

fun main() {
    val machine = MultifunctionalMachine(PrinterImpl(), ScannerImpl())
    machine.print("a text")
    machine.scan()
}