package ru.netology

fun agoToText(seconds: Int) {
    val result = when {
        seconds in 0..60 -> "был(а) только что"
        seconds in 61..3600 -> "${seconds / 60} ${minutesAgo(seconds / 60)} назад"
        seconds in 3601..86400 -> "${seconds / 3600} ${hoursAgo(seconds / 3600)} назад"
        seconds in 86401..172800 -> "был(а) вчера"
        seconds in 172801..259200 -> "был(а) позавчера"
        seconds > 259200 -> "был(а) давно"
        else -> "неизвестно"
    }
    println(result)
}

fun minutesAgo(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes != 11 -> "минуту"
        minutes % 10 in 2..4 && minutes !in 12..14 -> "минуты"
        else -> "минут"
    }
}

fun hoursAgo(hours: Int): String {
    return when {
        hours % 10 == 1 && hours != 11 -> "час"
        hours % 10 in 2..4 && hours !in 12..14 -> "часа"
        else -> "часов"
    }
}

fun main() {
    // Примеры вызова функции
    agoToText(30) // был(а) только что
    agoToText(120) // был(а) 2 минуты назад
    agoToText(3600) // был(а) 1 час назад
    agoToText(86400) // был(а) 24 часа назад
    agoToText(172800) // был(а) вчера
    agoToText(259200) // был(а) позавчера
    agoToText(300000) // был(а) давно
}
