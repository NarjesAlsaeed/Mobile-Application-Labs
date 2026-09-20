package com.example.lab2

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

fun findCourse(list: List<Course>, code: String): String {
    return list.firstOrNull { it.code == code }?.title
        ?: "Course not found"
}

fun task5() {
    val courses = listOf(
        Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
        Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
        Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
        Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
        Course("ENG 214", "Technical Writing", 2, "Tue")
    )

    println("All courses:")
    courses.forEach {
        println(it)
    }

    println("\nCourses with 3 credits or more:")
    courses.filter { it.credits >= 3 }.forEach {
        println(it)
    }

    val courseCodes = courses.map { it.code }
    println("\nCourse codes:")
    println(courseCodes)

    val totalCredits = courses.sumOf { it.credits }
    println("\nTotal credit hours: $totalCredits")

    println("\n${findCourse(courses, "CSC 402")}")
    println(findCourse(courses, "CSC 999"))

    val originalCourse = courses.first { it.code == "CSC 402" }
    val copiedCourse = originalCourse.copy(credits = 4)

    println("\nCopied course:")
    println(copiedCourse)

    println("\nOriginal course:")
    println(originalCourse)
}

fun main() {
    task5()
}