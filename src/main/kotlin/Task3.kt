import models.DistanceResult
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
        Множество точек расположено на координатной плоскости.
        Количество точек задается в консоли при запуске программы и оно должно быть больше двух.
        Каждая точка задается своими координатами. Точки не совпадают друг с другом.
        Требуется найти минимальное и максимальное расстояние между точками."""
    )

    var pointsAmount: Int = 0

    try {
        print("количество точек: ")
        pointsAmount = readln().toInt()

        if (pointsAmount < 2) {
            print("Нужно как минимум 2 точки")
            return
        }

    } catch (_: Exception) {
        print("Вводить только числа")
        return
    }

    println()
    var points = input1DPointArray(pointsAmount)

    var maxResult = getMaxDistanceBetweenThePoint(points)

    print("Максимальное растояние найдено между ${maxResult.start} и ${maxResult.end}: ")
    printAsInteger(maxResult.distance)
    println()

    var minResult = getMinDistanceBetweenThePoint(points)

    print("Минимальное растояние найдено между ${minResult.start} и ${minResult.end}: ")
    printAsInteger(minResult.distance)
    println()
}

fun input1DPointArray(pointsAmount: Int): Array<Point> {
    val resultArray = Array(pointsAmount) { Point(0.0,0.0) }
    var i = 0

    while (i < pointsAmount) {
        try {
            print("Введите X точки ${i+1}: ")
            resultArray[i].x = readln().toDouble()

            print("Введите Y точки ${i+1}: ")
            resultArray[i].y = readln().toDouble()

            println()
        } catch (_: Exception) {
            println("Вводить только целые числа")
            continue
        }
        i++
    }

    return resultArray
}

fun getMaxDistanceBetweenThePoint(points: Array<Point>): DistanceResult {
    var firstPointNumber: Int = 0
    var secondPointNumber: Int = 1
    var maxDistance = Point.distance(points[firstPointNumber], points[secondPointNumber])

    for (i in points.indices) {
        for (j in points.indices) {
            if (points[i] == points[j]) {
                continue
            }

            val current = Point.distance(points[j], points[i])

            if (maxDistance < current) {
                maxDistance = current
                firstPointNumber = i + 1
                secondPointNumber = j + 1
            }
        }
    }

    return DistanceResult(maxDistance, firstPointNumber, secondPointNumber)
}

fun getMinDistanceBetweenThePoint(points: Array<Point>): DistanceResult {
    var firstPointNumber: Int = 0
    var secondPointNumber: Int = 1
    var maxDistance = Point.distance(points[firstPointNumber], points[secondPointNumber])

    for (i in points.indices) {
        for (j in points.indices) {
            if (points[i] == points[j]) {
                continue
            }

            val current = Point.distance(points[j], points[i])

            if (maxDistance > current) {
                maxDistance = current
                firstPointNumber = i + 1
                secondPointNumber = j + 1
            }
        }
    }

    return DistanceResult(maxDistance, firstPointNumber, secondPointNumber)
}