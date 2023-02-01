package classes

import scalafx.scene.paint.Color
import classes.GeoPoint
import scalafx.scene.shape.Line
import GeoConfig.stageSize

class GeoStraightLine(val m: Double, val q: Double):

  //costructor 2 -> implicit form (ax+by+c=0)
  def this(a: Double, b: Double, c: Double) = this(m = -a/b, q = -c/b)

  def show(): Line =
    val xMin = -stageSize / 2
    val xMax = stageSize / 2

    val sX = xMin
    val sY = m * xMin + q
    val eX = xMax
    val eY = m * xMax + q

    val line = new Line {
      startX = sX + stageSize / 2
      startY = -(sY - stageSize / 2)
      endX = eX + stageSize / 2
      endY = -(eY - stageSize / 2)
      stroke = Color.Blue
    }
    line