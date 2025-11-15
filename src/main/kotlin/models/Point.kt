package models/////////////////////////////////////////////
//
// Практическая №4. Классы, основы
// Выполнили Турчанинов А.Е.
// Политехнический колледж городского хозяйства
// Группа: ИП-23-3
// 3 Курс 1 семестр
//
/////////////////////////////////////////////

/**
 * Точка на координатной плоскости
 * @param startX Координата X.
 * @param startY Координата Y.
 */
class Point(private val startX: Double, private val startY: Double) {
    var x: Double = startX;
    var y: Double = startY;

    operator fun plus(otherPoint: Point): Point {
        return Point(x + otherPoint.x, y + otherPoint.y)
    }

    operator fun minus(otherPoint: Point): Point {
        return Point(x - otherPoint.x, y - otherPoint.y)
    }
}