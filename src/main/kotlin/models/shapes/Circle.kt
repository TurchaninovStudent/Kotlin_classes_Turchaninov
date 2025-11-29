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
 * Окружность
 * @param startCenter центр окружности
 * @param startRadius радиус окружности
 */
class Circle(startCenter: Point, startRadius: Double) {
    val radius: Double = startRadius
    val center: Point = startCenter
}