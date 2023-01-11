package classes

import classes.Point

class SegmentLine(val a: Point, val b: Point):

  def len(): Double =
    val x0: Double = Math.abs(a.x - b.x)
    val y0: Double = Math.abs(a.y - b.y)
    Math.sqrt((x0*x0)+(y0*y0))

  def midpoint(): Point =
    val xm: Double = (this.a.x + this.b.x)/2
    val ym: Double = (this.a.y + this.b.y)/2
    Point(xm, ym)









