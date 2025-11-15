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
    val a: Point = startTakenPoints[0];
    val b: Point = startTakenPoints[1];
    val c: Point = startTakenPoints[2];

    private fun crossProduct(v1: Point, v2: Point): Double = v1.x * v2.y - v1.y * v2.x

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

        val cross1 = crossProduct(ab, ap)
        val cross2 = crossProduct(bc, bp)
        val cross3 = crossProduct(ca, cp)

        return (cross1 >= 0 && cross2 >= 0 && cross3 >= 0) ||
                (cross1 <= 0 && cross2 <= 0 && cross3 <= 0)
    }
}