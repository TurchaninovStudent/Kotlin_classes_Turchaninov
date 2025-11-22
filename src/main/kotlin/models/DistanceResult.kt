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
 * Модель передачи данных для результатов нахождения дистанции между точками
 * @param givenDistance Дистанция
 * @param givenFirstPointNumber номер первой точки
 * @param givenSecondPointNumber номер второй точки
 */
data class DistanceResult(private val givenDistance: Double, private val givenFirstPointNumber: Int, private val givenSecondPointNumber: Int) {
    val distance: Double = givenDistance
    val start: Int = givenFirstPointNumber
    val end: Int = givenSecondPointNumber
}
