package com.example.lab2

fun greetStudent(name: String, course: String = "CSC 402"): String {
    return "Welcome to $course, $name!"
}

fun finalMark(
    quizzes: Double,
    project: Double,
    finalExam: Double
): Double = quizzes * 0.10 + project * 0.70 + finalExam * 0.20

fun printBanner(title: String, width: Int = 40) {
    val line = "-".repeat(width)
    println(line)
    println(title)
    println(line)
}

fun task2() {
    printBanner("CSC 402 Lab 2")

    println(greetStudent("Sara"))
    println(greetStudent("Sara", "CSC 311"))

    val mark1 = finalMark(90.0, 80.0, 70.0)

    val mark2 = finalMark(
        finalExam = 70.0,
        quizzes = 90.0,
        project = 80.0
    )

    println(mark1)
    println(mark2)
}

fun main() {
    task2()
}