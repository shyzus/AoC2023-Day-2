import java.io.File

var sum = 0

File("input.txt").useLines { lines ->
    lines.forEach { line ->
        val sets = line.split(':')[1].split(';')

        var lowestRed = 0
        var lowestGreen = 0
        var lowestBlue = 0

        for (set in sets) {
            set.replace(" ", "")
                .split(',')
                .forEach { entry ->
                    val color = entry.filterNot {
                        it.isDigit()
                    }
                    val amount = entry.replace(color, "").toInt()
                    when (color){
                        "red" -> if (amount > lowestRed || lowestRed == 0) { lowestRed = amount }
                        "green" -> if (amount > lowestGreen || lowestGreen == 0) { lowestGreen = amount }
                        "blue" -> if (amount > lowestBlue || lowestBlue == 0) { lowestBlue = amount }
                    }
                }
        }
        sum += (lowestRed * lowestGreen * lowestBlue)
    }
}
println(sum)