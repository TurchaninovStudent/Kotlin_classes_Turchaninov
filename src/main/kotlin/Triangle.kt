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
public class Triangle(val startTakenPoints: Array<Point>) {
    public val TakenPoints = startTakenPoints;

    public fun isDotOutside(point: Point): Boolean {
        val signAB: Double = (TakenPoints[1].X - TakenPoints[0].X) * (point.Y - TakenPoints[0].Y) - (point.X - TakenPoints[0].X) * (TakenPoints[1].Y - TakenPoints[0].Y)
        val signBC: Double = (TakenPoints[2].X - TakenPoints[1].X) * (point.Y - TakenPoints[1].Y) - (point.X - TakenPoints[1].X) * (TakenPoints[2].Y - TakenPoints[1].Y)
        val signCA: Double = (TakenPoints[0].X - TakenPoints[2].X) * (point.Y - TakenPoints[2].Y) - (point.X - TakenPoints[2].X) * (TakenPoints[2].Y - TakenPoints[2].Y)

        println(signAB)
        println(signBC)
        println(signCA)

        if ((signAB >= 0 && signBC >= 0 && signCA >= 0)
            || (signAB < 0 && signBC < 0 && signCA < 0))
        {
            return false
        }

        return true
    }
}