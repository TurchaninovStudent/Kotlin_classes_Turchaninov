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

fun main() {
    println(
        """Программа, выполняет следующий функционал:
        Треугольник описан координатами трех своих вершин. 
        Указаны координаты отдельной точки. 
        Составить программу, показывающую где находится точка - внутри или вне треугольника. 
        Треугольник и точка находятся на координатной плоскости."""
    )

    val triangle = initializeTriangle() ?: return

    val x: Double
    val y: Double

    try {
        print("Введите X точки: ")
        x = readln().toDouble()

        print("Введите Y точки: ")
        y = readln().toDouble()

    } catch (_: Exception) {
        print("Вводить только числа")
        return
    }

    if (triangle.isDotOutside(Point(x, y))) {
        println("Точка за пределами или на треугольнике")
    } else {
        println("Точка внутри треугольника")
    }
}

fun initializeTriangle(): Triangle? {
    var resultPoints: Array<Point> = Array(3) {Point(0.0,0.0)}

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
        return null
    }

    return Triangle(resultPoints)
}

fun arePointsValidForTriangle(targetPoints: Array<Point>): Boolean {
    val abSize = sqrt((targetPoints[0].X - targetPoints[1].X).pow(2.0) + (targetPoints[0].Y - targetPoints[1].Y).pow(2.0))
    val bcSize = sqrt((targetPoints[1].X - targetPoints[2].X).pow(2.0) + (targetPoints[1].Y - targetPoints[2].Y).pow(2.0))
    val caSize = sqrt((targetPoints[2].X - targetPoints[0].X).pow(2.0) + (targetPoints[2].Y - targetPoints[0].Y).pow(2.0))

    if (abSize + bcSize == caSize) {
        return false
    }

    return true
}