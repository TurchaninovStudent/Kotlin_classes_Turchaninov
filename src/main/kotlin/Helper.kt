import Models.Point
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

fun getDistanceBetweenThePoints(point1: Point, point2: Point): Double {
    return sqrt((point1.x - point2.x).pow(2.0) + (point1.y - point2.y).pow(2.0))
}

fun printAsInteger(number: Double) {
    if (number == number.toInt().toDouble()) {
        print(number.toInt())
    } else {
        print(number)
    }
}