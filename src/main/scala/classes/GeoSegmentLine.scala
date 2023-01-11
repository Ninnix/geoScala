package classes

import classes.GeoPoint

class GeoSegmentLine(val a: GeoPoint, val b: GeoPoint):

  def len(): Double =
    val x0: Double = Math.abs(a.x - b.x)
    val y0: Double = Math.abs(a.y - b.y)
    Math.sqrt((x0*x0)+(y0*y0))

  def midpoint(): GeoPoint =
    val xm: Double = (this.a.x + this.b.x)/2
    val ym: Double = (this.a.y + this.b.y)/2
    GeoPoint(xm, ym)









