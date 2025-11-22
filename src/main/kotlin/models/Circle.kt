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
 * Окружность
 * @param startCenter центр окружности
 * @param startRadious радиус окружности
 */
class Circle(private val startCenter: Point, private val startRadious: Double) {
    val radious: Double = startRadious
    val center: Point = startCenter
}