package models.shapes

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
    private val a = startTakenPoints[0]
    private val b = startTakenPoints[1]
    private val c = startTakenPoints[2]

    private val ab = Point.distance(a, b)
    private val bc = Point.distance(b, c)
    private val ca = Point.distance(c, a)

    /**
     * Проверяет, лежит ли точка внутри или на границе треугольника.
     * @return true, если точка внутри или на границе, иначе false.
     */
    fun isPointInsideOrOnEdge(point: Point): Boolean {
        val vectorAb = b - a
        val vectorBc = c - b
        val vectorCa = a - c

        val ap = point - a
        val bp = point - b
        val cp = point - c

        val cross1 = Point.crossProduct(vectorAb, ap)
        val cross2 = Point.crossProduct(vectorBc, bp)
        val cross3 = Point.crossProduct(vectorCa, cp)

        return (cross1 >= 0 && cross2 >= 0 && cross3 >= 0) ||
                (cross1 <= 0 && cross2 <= 0 && cross3 <= 0)
    }

    /**
     * Получить площадь треугольника
     */
    private fun area(): Double {
        return 0.5 * ((a.x * b.y + b.x * c.y + c.x * a.y) - (a.y * b.x + b.y * c.x + c.y * a.x))
    }

    /**
     * Получить описанную окружность вокруг треугольника
     */
    fun getOutOfBoundsCircle(): Circle? {
        val d = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))

        if (d.toInt() == 0) {
            return null
        }

        val ux = (Point.sqrPoint(a) * (b.y - c.y)
                + Point.sqrPoint(b) * (c.y - a.y)
                + Point.sqrPoint(c) * (a.y - b.y)) / d

        val uy = (Point.sqrPoint(a) * (c.x - b.x)
                + Point.sqrPoint(b) * (a.x - c.x)
                + Point.sqrPoint(c) * (b.x - a.x)) / d

        val center = Point(ux, uy)

        val r = Point.distance(center, b)

        return Circle(center, r)
    }

    /**
     * Получить вписанную окружность в треугольник
     */
    fun getInBoundsCircle(): Circle {
        val ux = (bc * a.x + ca * b.x + ab * c.x) / (ab + bc + ca)
        val uy = (bc * a.y + ca * b.y + ab * c.y) / (ab + bc + ca)

        val center = Point(ux, uy)

        val r = area() / ((ab + bc + ca) / 2.0)

        return Circle(center, r)
    }
}