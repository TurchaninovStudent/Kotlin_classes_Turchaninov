import models.Point

/////////////////////////////////////////////
//
// Практическая №4. Классы, основы
// Выполнили Турчанинов А.Е.
// Политехнический колледж городского хозяйства
// Группа: ИП-23-3
// 3 Курс 1 семестр
//
/////////////////////////////////////////////

fun main() {
    println(
        """Программа, выполняет следующий функционал:
        Две точки находятся на координатной плоскости. 
        Каждая точка описана своими координатами. 
        Найти расстояние между указанными точками."""
    )

    var point1 = Point(0.0,0.0)
    var point2 = Point(0.0,0.0)

    try {
        print("Введите X первой точки: ")
        point1.x = readln().toDouble()

        print("Введите Y первой точки: ")
        point1.y = readln().toDouble()

        print("Введите X второй точки: ")
        point2.x = readln().toDouble()

        print("Введите Y второй точки: ")
        point2.y = readln().toDouble()

    } catch (_: Exception) {
        print("Вводить только числа")
        return
    }

    val distance = getDistanceBetweenThePoints(point1, point2)

    print("Расстояние от точки 1 до точки 2: ")
    printAsInteger(distance)
}