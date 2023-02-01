package classes

import scalafx.scene.paint.Color
import classes.GeoPoint
import scalafx.scene.shape.Line

class GeoSegmentLine(val a: GeoPoint, val b: GeoPoint):

  def print(): Unit = println(a.id + b.id + " = " + a.getString() + "; " + b.getString())

  def len(): Double =
    val x0: Double = Math.abs(a.geoX - b.geoX)
    val y0: Double = Math.abs(a.geoY - b.geoY)
    Math.sqrt((x0*x0)+(y0*y0))

  def midpoint(): GeoPoint =
    val xm: Double = (this.a.geoX + this.b.geoX)/2
    val ym: Double = (this.a.geoY + this.b.geoY)/2
    GeoPoint(xm, ym)

  def show(): Line =
    val line = new Line {
      startX = a.geoX
      startY = a.geoY
      endX = b.geoX
      endY = b.geoY
      stroke = Color.Black
    }
    line











