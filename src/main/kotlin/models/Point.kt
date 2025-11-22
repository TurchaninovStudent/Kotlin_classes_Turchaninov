package models

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
class Point(private val startX: Double, private val startY: Double) {
    var x: Double = startX;
    var y: Double = startY;

    companion object {
        fun crossProduct(v1: Point, v2: Point): Double = v1.x * v2.y - v1.y * v2.x

        /**
         * Получить расстояние
         * @param point точка
         */
        fun distance(point1: Point, point2: Point): Double {
            return sqrt((point1.x - point2.x).pow(2.0) + (point1.y - point2.y).pow(2.0))
        }

        /**
         * Возвести точку в квадрат
         * @param point точка
         */
        fun sqrPoint(point: Point): Double {
            return Math.pow(point.x, 2.0) + Math.pow(point.y, 2.0)
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