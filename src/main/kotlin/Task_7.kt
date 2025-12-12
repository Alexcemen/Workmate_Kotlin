package org.example

import kotlin.math.abs
import kotlin.math.round


fun main() {
    val list = listOf(
    Emp("Max Petrov", 22, "programmer"),
    Emp("Ivan Shapovalov", 33, "analyst"),
    Emp("Semen Deznev", 55, "manager"),
    Emp("Oleg Petrov", 19, "intern"),
    Emp("Katerina Drogova", 31, "programmer"),
    Emp("Nikolay Spivakov", 23, "analyst"),
    Emp("Boris Moiseev", 48, "manager"),
    Emp("Petr Sveshnikov", 37, "programmer"),
    Emp("Maria Kasatonova", 33, "analyst"),
    Emp("Olga Filimonova", 27, "programmer"),
    )

    val youngerEmployee = list.minOf { it.age }
    println("Младший сотрудник: $youngerEmployee")
    println()

    val sumAge = list.sumOf { it.age }
    println("Сумма возрастов программистов: $sumAge")
    println()


    val countUniqueSpecialties = list.distinctBy { it.position }.count()
    println("Количество уникальных специальностей: $countUniqueSpecialties")
    println()


    val allEmployeesAdult = list.all { it.age >= 18 }
    val result = if (allEmployeesAdult) "да" else "нет"
    println("Все ли работники совершеннолетние: $result")
    println()


    val mostExperiencedEmployees =
        list.sortedByDescending { it.age }
            .take(2)
            .map { it.name }
    println("Два самых опытных сотрудника: ${mostExperiencedEmployees}")
    println()


    val womenSurnames =
        list.filter { it.name.last() == 'a' }
        .map { it.name.substringAfter(" ") }
    println("Фамилии женщин: $womenSurnames")
    println()


    val listEmployeesNames = list.sortedByDescending { it.age }.map { it.name.substringBefore(" ") }
    println("Имена всех сотрудников от старших к младшим: $listEmployeesNames")
    println()


    val programmersCount = list.count { it.position == "programmer" }
    println("Количество программистов: $programmersCount")
    println()


    val multiplyAgeList =
        list.filter { it.age < 40 }
            .map { it.age }
            .reduce { acc, age -> age * acc }
    println("Произведение возрастов всех работников младше 40 лет: $multiplyAgeList")
    println()


    val listPairNameWithSpecialties = list.map { it.name to it.position }
    println("Имя -> Позиция: $listPairNameWithSpecialties")
    println()


    val analystsAverageAge = list.filter { it.position == "analyst" }.map { it.age }.average()
    val rounded = (round(analystsAverageAge * 10))/10
    println("Средний возраст аналитиков: $rounded")
    println()


    val group = list.groupBy { it.age < 40 }
    val younger = group[true].orEmpty()
    val older = group[false].orEmpty()
    println("Группа сотрудников - младше 40 лет: $younger")
    println("Группа сотрудников - старше 40 лет: $older")
    println()


    val specialtiesMostOlder = list.filter { it.age < 40 }.maxBy { it.age }.position
    println("Профессия самого опытного из тех кто младше 40 лет: $specialtiesMostOlder")
    println()


    val (younger40, older40) = list.partition{ it.age < 40}
    val youngAverage = younger40.map { it.age }.average()
    val olderAverage = older40.map { it.age }.average()
    val pairAverageAge = youngAverage to olderAverage
    println("Пара из средних возрастов тех кто младше и тех кто старше 40: $pairAverageAge")
    println()


    val countEmployeesSpecialties = list.groupBy { it.position }.map { it.key to it.value.count() }
    println( "Список пар из профессии и количества сотрудников в ней: $countEmployeesSpecialties")
    println()


    val listSurnamesToAge = list.map { it.name.substringAfter(" ") to it.age }
    println("Список пар из фамилии и возраста: $listSurnamesToAge")
    println()


    val allNames = list.joinToString { it.name.substringBefore(" ") }
    println("Все имена: $allNames")
    println()


    val mostAge = list.groupBy { it.age }.maxByOrNull { it.value.size }?.key ?: 0
    println("Самый частовстречающийся возраст: $mostAge")
    println()


    val listMostYounger = list
        .groupBy { it.position }
        .map { (_, employees) -> employees.minByOrNull { it.age } }
    println("Список самых молодых специалистов в каждой профессии: $listMostYounger")
    println()


    val pairYoungerAndOlder = list.minByOrNull { it.age } to list.maxByOrNull { it.age }
    println("Пара сотрудников с наибольшей разницей в возрасте $pairYoungerAndOlder")
    println()


    val maxAgeDifference = abs((pairYoungerAndOlder.first?.age ?: 0) - (pairYoungerAndOlder.second?.age ?: 0))
    println("Максимальная разница в возрастах сотрудников: $maxAgeDifference")
    println()
}

data class Emp(
    val name: String,
    val age: Int,
    val position: String
)