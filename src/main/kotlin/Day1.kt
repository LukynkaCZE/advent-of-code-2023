// This is solution to Advent of Code 2023 Day 1: Trebuchet?!
// You can find the challenge at https://adventofcode.com/2023/day/1
// You can find the challenge input at https://adventofcode.com/2023/day/1/input
import java.io.File

val input = mutableListOf<String>()

// For part 2
val part2digits = listOf(
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine"
)

fun main(args: Array<String>) {

    // Load input to list
    File("./inputs/day1.txt").forEachLine { input.add(it) }

    repeat(2) { part ->
        var sum = 0
        input.forEach { input ->
            val numbers = if(part == 0) getNumbersFromString(input) else getCalibratedNumbersFromString(input)
            if(numbers.isEmpty()) return@forEach
            val first = numbers.first()
            val last = numbers.last()
            val combined = "$first$last".toInt()
            sum += combined
        }
        println("[PART ${part+1}] Total sum is $sum")
    }
}

fun getNumbersFromString(input: String): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    input.forEach { if(!it.isLetter()) {numbers.add(it.toString().toInt())} }
    return numbers
}

fun getCalibratedNumbersFromString(input: String): MutableList<Int> {
    val first = literalToInt(input.findAnyOf(part2digits)?.second)
    val last = literalToInt(input.findLastAnyOf(part2digits)?.second)
    return mutableListOf(first, last)
}

fun literalToInt(input: String?): Int {
    return when (input) {
        "one" -> 1
        "two" -> 2
        "three" -> 3
        "four" -> 4
        "five" -> 5
        "six" -> 6
        "seven" -> 7
        "eight" -> 8
        "nine" -> 9
        else -> input!!.toInt()
    }
}