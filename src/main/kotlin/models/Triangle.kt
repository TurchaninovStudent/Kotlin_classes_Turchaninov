package models

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
    private val a: Point = startTakenPoints[0];
    private val b: Point = startTakenPoints[1];
    private val c: Point = startTakenPoints[2];

    companion object {

    }

    /**
     * Проверяет, лежит ли точка ВНУТРИ или НА ГРАНИЦЕ треугольника.
     * @return true, если точка внутри или на границе, иначе false.
     */
    fun isDotInsideOrOnEdge(point: Point): Boolean {
        val ab = b - a
        val bc = c - b
        val ca = a - c

        val ap = point - a
        val bp = point - b
        val cp = point - c

        val cross1 = Point.crossProduct(ab, ap)
        val cross2 = Point.crossProduct(bc, bp)
        val cross3 = Point.crossProduct(ca, cp)

        return (cross1 >= 0 && cross2 >= 0 && cross3 >= 0) ||
                (cross1 <= 0 && cross2 <= 0 && cross3 <= 0)
    }

    fun area(): Double {
        return 0.5 * ((a.x * b.y + b.x * c.y + c.x * a.y) - (a.y * b.x + b.y * c.x + c.y * a.x))
    }

    fun getOutOfBoundsCircle(): Circle? {
        val d = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))

        if (d.toInt() == 0) {
            return null
        }

        val ux = (Point.sqrPoint(a) * (b.y - c.y) + Point.sqrPoint(b) * (c.y - a.y) + Point.sqrPoint(c) * (a.y - b.y))
        val uy = (Point.sqrPoint(a) * (b.x - c.x) + Point.sqrPoint(b) * (c.x - a.x) + Point.sqrPoint(c) * (a.x - b.x))

        val center = Point(ux, uy)

        val r = Point.getDistanceBetweenThePoints(center, a)

        return Circle(center, r);
    }

}