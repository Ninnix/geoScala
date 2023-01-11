import scalafx.application.JFXApp3
import classes.{Point, SegmentLine, StraightLine, Circle}

@main def main() = {

  var pointA = Point(1,1)
  pointA.printCoords()
  var pointB = Point(1,1)
  println(pointA.x)

  var segmentAB = SegmentLine(pointA, pointB)
  println(segmentAB.a.y)
  println(segmentAB.len())
  segmentAB.midpoint().printCoords()
}

