package classes

import scalafx.scene.shape.Circle
import classes.GeoPoint
import scalafx.scene.paint.Color

class GeoCircle (val geoRadius: Double, val o: GeoPoint):

  val pi = 3.141592

  def area(): Double =
    geoRadius*geoRadius*pi

  def perimeter(): Double =
    2*geoRadius*pi

  def show(): Circle =
    val circle = new Circle {
      centerX = o.geoX
      centerY = o.geoY
      radius = geoRadius
      fill = Color.Transparent
      stroke = Color.Red
    }
    circle