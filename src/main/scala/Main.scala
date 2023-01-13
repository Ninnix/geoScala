import scalafx.application.JFXApp3
import classes.{GeoPoint, GeoSegmentLine, GeoStraightLine, GeoCircle}

@main def main(): Unit = {

  var pointA = GeoPoint(1,1)
  pointA.printCoords()
  var pointB = GeoPoint(1,1)
  println(pointA.geoX)

  var segmentAB = GeoSegmentLine(pointA, pointB)
  println(segmentAB.a.geoY)
  println(segmentAB.len())
  segmentAB.midpoint().printCoords()
}

