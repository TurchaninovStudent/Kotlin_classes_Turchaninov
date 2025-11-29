package models.shapes

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

/**
 * Точка на координатной плоскости
 * @param startX Координата X.
 * @param startY Координата Y.
 */
class Point(startX: Double, startY: Double) {
    var x = startX
    var y = startY

    companion object {
        /**
         * Получить перемноженные координаты точке
         * @param point1 первая точка
         * @param point2 вторая точка
         */
        fun crossProduct(point1: Point, point2: Point): Double = point1.x * point2.y - point1.y * point2.x

        /**
         * Получить расстояние между точками
         * @param point1 первая точка
         * @param point2 вторая точка
         */
        fun distance(point1: Point, point2: Point): Double {
            return sqrt((point1.x - point2.x).pow(2.0) + (point1.y - point2.y).pow(2.0))
        }

        /**
         * Возвести точку в квадрат
         * @param point точка
         */
        fun sqrPoint(point: Point): Double {
            return point.x.pow(2.0) + point.y.pow(2.0)
        }
    }

    operator fun plus(otherPoint: Point): Point {
        return Point(x + otherPoint.x, y + otherPoint.y)
    }

    operator fun minus(otherPoint: Point): Point {
        return Point(x - otherPoint.x, y - otherPoint.y)
    }

    operator fun div(otherPoint: Point): Point {
        return Point(x / otherPoint.x, y / otherPoint.y)
    }
}