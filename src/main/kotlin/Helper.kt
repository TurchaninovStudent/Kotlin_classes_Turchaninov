import models.Point
import models.Triangle
import kotlin.math.pow
import kotlin.math.sqrt

/////////////////////////////////////////////
//
// Практическая №4. Классы, основы
// Выполнили Турчанинов А.Е.
// Политехнический колледж городского хозяйства
// Группа: ИП-23-3
// 3 Курс 1 семестр
//
/////////////////////////////////////////////

fun getDistanceBetweenThePoints(point1: Point, point2: Point): Double {
    return sqrt((point1.x - point2.x).pow(2.0) + (point1.y - point2.y).pow(2.0))
}

fun printAsInteger(number: Double) {
    if (number == number.toInt().toDouble()) {
        print(number.toInt())
    } else {
        print(number)
    }
}

fun initializeTriangle(): Triangle? {
    var resultPoints: Array<Point> = Array(3) { Point(0.0,0.0) }
    var i = 0

    while (i < 3) {
        println("Введите ${i + 1}-ую координату треугольника: ")

        var x: Double = 0.0
        var y: Double = 0.0

        try {
            print("x: ")
            x = readln().toDouble()

            print("y: ")
            y = readln().toDouble()

        } catch (_: Exception) {
            println("Вводить только числа")
            continue
        }

        resultPoints[i] = Point(x, y)
        i++
    }

    if (!arePointsValidForTriangle(resultPoints)) {
        println("Введённый треугольник не валиден")
        return null
    }

    return Triangle(resultPoints)
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

    val cross = ab.x * ac.y - ab.y * ac.x

    return cross != 0.0
}