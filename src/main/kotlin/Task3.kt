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

    print("Максимальное растояние: ")
    printAsInteger(getMostPoint(points, true))

    print("Минимальное растояние: ")
    printAsInteger(getMostPoint(points, false))
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

fun getMostPoint(points: Array<Point>, max: Boolean): Double {
    var maxDistance = getDistanceBetweenThePoints(points[0], points[1])

    for (i in points.indices) {
        for (j in points.indices) {
            if (points[i] == points[j]) {
                continue
            }

            val current = getDistanceBetweenThePoints(points[j], points[i])

            if (max) {
                if (maxDistance < current) {
                    maxDistance = current
                }
            } else {
                if (maxDistance > current) {
                    maxDistance = current
                }
            }
        }
    }

    return maxDistance
}