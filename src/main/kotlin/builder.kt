import java.util.function.UnaryOperator

data class Building(val address: String, val floors: List<Floor>)
data class Floor(val name: String, val flats: List<Flat>)
data class Flat(val number: String, val area: Double, val balcoonArea: Double?)

fun building(assemble: Builder.()->Unit) : Building {
    val builder = Builder()
    builder.assemble()

    val building =  builder.build()

    return building.copy(address = building.address.toUpperCase())
}

class Builder {
    var address = ""
    var floors: MutableList<Floor> = mutableListOf()

    fun floor(assemble: FloorBuilder.() -> Unit): Unit {
        val floorBuilder = FloorBuilder()
        floorBuilder.assemble()
        floors.add(floorBuilder.build())
    }
    fun build() = Building(address, floors)
}

class FloorBuilder {
    fun build()= Floor(name, flats)

    var name = ""
    var flats: MutableList<Flat> = mutableListOf()

    fun flat(assemble: FlatBuilder.() -> Unit) {
        val builder = FlatBuilder()
        builder.assemble()
        flats.add(builder.build())
    }

}

class FlatBuilder {
    var number = ""
    var area = 0.0
    var balcoonArea: Double? = null

    fun build() = Flat(number, area, balcoonArea)
}

fun main() {

    val building = building {
        address = "Krakowska 1, Krakow 20-341"
        floor {
            name = "Ground floor"
            flat {
                number = "1";
                area = 13.23
            }
            flat {
                number = "2";
                area = 17.23
            }
        }
        floor {
            name = "1st"
            flat {
                number = "3";
                area = 13.23;
                balcoonArea = 12.12
            }
        }
    }

    println(building)
}
