package classes


class GeoPoint(var x: Double, var y: Double):
  
  //costructor 2 point with coords in the origin
  def this() = this(x = 0, y = 0)

  def printCoords(): Unit =
    println("(" + x.toString + ", " + y.toString + ")")

  def move(dx: Double, dy: Double): Unit =
    x = x + dx
    y = y + dy