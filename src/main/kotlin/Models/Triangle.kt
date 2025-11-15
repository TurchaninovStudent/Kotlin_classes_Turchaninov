package Models

import Models.Point

/////////////////////////////////////////////
//
// Практическая №4. Классы, основы
// Выполнили Турчанинов А.Е.
// Политехнический колледж городского хозяйства
// Группа: ИП-23-3
// 3 Курс 1 семестр
//
/////////////////////////////////////////////

/**
 * Треугольник
 * @param startTakenPoints точки треугольника в виде списка (A - 0, B - 1, C - 2).
 */
class Triangle(private val startTakenPoints: Array<Point>) {
    private val takenPoints = startTakenPoints;

    private fun crossProduct(v1: Point, v2: Point): Double {
        return v1.x * v2.y - v1.y * v2.x
    }

    /**
     * Проверяет, лежит ли точка ВНУТРИ или НА ГРАНИЦЕ треугольника.
     * @return true, если точка внутри или на границе, иначе false.
     */
    fun isDotInsideOrOnEdge(point: Point): Boolean {
        val a = takenPoints[0]
        val b = takenPoints[1]
        val c = takenPoints[2]

        val ab = Point(b.x - a.x, b.y - a.y)
        val bc = Point(c.x - b.x, c.y - b.y)
        val ca = Point(a.x - c.x, a.y - c.y)

        val ap = Point(point.x - a.x, point.y - a.y)
        val bp = Point(point.x - b.x, point.y - b.y)
        val cp = Point(point.x - c.x, point.y - c.y)

        val originalOrientation = crossProduct(ab, Point(c.x - a.x, c.y - a.y))

        if (originalOrientation == 0.0) {
            return false
        }

        val signP1 = crossProduct(ab, ap)
        val signP2 = crossProduct(bc, bp)
        val signP3 = crossProduct(ca, cp)

        println("Signatures: $signP1, $signP2, $signP3")

        return if (originalOrientation > 0) {
            signP1 >= 0 && signP2 >= 0 && signP3 >= 0
        } else {
            signP1 <= 0 && signP2 <= 0 && signP3 <= 0
        }
    }
}