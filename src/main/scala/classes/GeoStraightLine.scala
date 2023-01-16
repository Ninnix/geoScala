package classes

import scalafx.scene.paint.Color
import classes.GeoPoint
import scalafx.scene.shape.Line

class GeoStraightLine(val m: Double, val q: Double):

  //costructor 2 -> implicit form (ax+by+c=0)
  def this(a: Double, b: Double, c: Double) =
    this(m = -a/b, q = -c/b)

  def show(): Line =

    val xMin = -100.0
    val xMax = 100.0

    val sX = xMin
    val sY = m * xMin + q
    val eX = xMax
    val eY = m * xMax + q

    val line = new Line {
      startX = sX
      startY = sY
      endX = eX
      endY = eY
      stroke = Color.Blue
    }
    line