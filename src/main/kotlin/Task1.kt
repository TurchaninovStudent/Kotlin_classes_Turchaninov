import Models.Point
import Models.Triangle

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
        Треугольник описан координатами трех своих вершин. 
        Указаны координаты отдельной точки. 
        Составить программу, показывающую где находится точка - внутри или вне треугольника. 
        Треугольник и точка находятся на координатной плоскости."""
    )

    val triangle = initializeTriangle() ?: return

    var point = Point(0.0,0.0)

    try {
        print("Введите X точки: ")
        point.x = readln().toDouble()

        print("Введите Y точки: ")
        point.y = readln().toDouble()

    } catch (_: Exception) {
        print("Вводить только числа")
        return
    }

    if (triangle.isDotInsideOrOnEdge(point)) {
        println("Точка за пределами или на треугольнике")
    } else {
        println("Точка внутри треугольника")
    }
}

fun initializeTriangle(): Triangle? {
    var resultPoints: Array<Point> = Array(3) { Point(0.0,0.0) }

    for (i in 0 until 3) {
        println("Введите ${i + 1}-ую координату треугольника: ")

        val x: Double
        val y: Double

        try {
            print("x: ")
            x = readln().toDouble()

            print("y: ")
            y = readln().toDouble()

        } catch (_: Exception) {
            print("Вводить только числа")
            return null
        }

        resultPoints[i] = Point(x, y)
    }

    if (!arePointsValidForTriangle(resultPoints)) {
        print("Введённый треугольник не валиден")
        return null
    }

    return Triangle(resultPoints)
}

fun arePointsValidForTriangle(targetPoints: Array<Point>): Boolean {
    val abSize = getDistanceBetweenThePoints(targetPoints[0], targetPoints[1])
    val bcSize = getDistanceBetweenThePoints(targetPoints[1], targetPoints[2])
    val caSize = getDistanceBetweenThePoints(targetPoints[2], targetPoints[0])

    if (abSize + bcSize == caSize
        || bcSize + caSize == abSize
        || abSize + caSize == bcSize) {
        return false
    }

    return true
}