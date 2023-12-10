import java.io.File

val targetRed = 12
val targetGreen = 13
val targetBlue = 14
var sum = 0

File("input.txt").useLines { lines ->
    lines.forEach { line ->
        val splitLine = line.split(':')
        val gameID = splitLine[0].split(' ')[1].toInt()
        val sets = splitLine[1].split(';')

        var shouldSkip = false
        for (set in sets) {
            set.replace(" ", "")
                .split(',')
                .forEach { entry ->
                    val color = entry.filterNot {
                        it.isDigit()
                    }
                    val amount = entry.replace(color, "").toInt()
                    when (color){
                        "red" -> if (amount > targetRed) { shouldSkip = true }
                        "green" -> if (amount > targetGreen) { shouldSkip = true }
                        "blue" -> if (amount > targetBlue) { shouldSkip = true }
                    }
                }

            if (shouldSkip) {
                continue
            }
        }
        if (!shouldSkip) {
            sum += gameID
        }
    }
}
println(sum)