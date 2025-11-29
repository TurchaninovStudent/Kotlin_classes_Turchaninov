import models.shapes.Point
import models.shapes.Triangle

/////////////////////////////////////////////
//
// Практическая №4. Классы, основы
// Выполнили Турчанинов А.Е.
// Политехнический колледж городского хозяйства
// Группа: ИП-23-3
// 3 Курс 1 семестр
//
/////////////////////////////////////////////

fun printAsInteger(number: Double) {
    if (number == number.toInt().toDouble()) {
        print(number.toInt())
    } else {
        print(number)
    }
}

fun enterPoint(number: Int, array: Array<Point>? = null): Point? {
    val x: Double
    val y: Double

    try {
        print("Введите X точки ${number}: ")
        x = readln().toDouble()

        print("Введите Y точки ${number}: ")
        y = readln().toDouble()

        if (array != null) {
            if (pointContains(array.toList(), Point(x, y))) {
                throw Exception()
            }
        }

    } catch (_: Exception) {
        println("Вводить только целые числа и без повторов")
        return null
    }

    println()
    return Point(x, y)
}

fun initializeTriangle(): Triangle? {
    val resultPoints: Array<Point> = Array(3) { Point(0.0,0.0) }
    var i = 0

    while (i < 3) {
        println("Введите ${i + 1}-ую координату треугольника: ")

        val point = enterPoint(i + 1) ?: continue

        resultPoints[i] = point
        i++
    }

    if (!arePointsValidForTriangle(resultPoints)) {
        println("Введённый треугольник не валиден (все находиться на одно линии)")
        return null
    }

    return Triangle(resultPoints)
}

fun pointContains (targetArray: List<Point>, targetPoint: Point): Boolean {
    for (i in targetArray.indices) {
        if (targetArray[i].x == targetPoint.x && targetArray[i].y == targetPoint.y) {
            return true
        }
    }

    return false
}

fun arePointsValidForTriangle(targetPoints: Array<Point>): Boolean {
    val a = targetPoints[0]
    val b = targetPoints[1]
    val c = targetPoints[2]

    if (a == b || b == c || a == c) {
        return false
    }

    val ab = Point(b.x - a.x, b.y - a.y)
    val ac = Point(c.x - a.x, c.y - a.y)

    val cross = Point.crossProduct(ab, ac) // ab.x * ac.y - ab.y * ac.x

    return cross != 0.0
}