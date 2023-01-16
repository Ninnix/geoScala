import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.geometry.{Insets, Point2D}
import scalafx.scene.Scene
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.{Circle, Line, Rectangle}
import classes.{GeoCircle, GeoPoint, GeoSegmentLine, GeoStraightLine}
import scalafx.scene.layout.{HBox, Pane}

object MainStage extends JFXApp3 {

  val pointA: GeoPoint = GeoPoint(100, 100)
  val pointB: GeoPoint = GeoPoint(350, 350)
  val circleC: GeoCircle = GeoCircle(100, pointA)
  val segmentAB: GeoSegmentLine = GeoSegmentLine(pointA, pointB)
  val lineL: GeoStraightLine = GeoStraightLine(0, 250)


  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "GeoScala"
      width = 600
      height = 450


      scene = new Scene {
        fill = LightGrey // Color.rgb(38, 38, 38)
        //content = pointA.showText()
        val pane = new Pane
        pane.children += pointA.show()
        pane.children += pointA.showText()
        pane.children += circleC.show()
        pane.children += segmentAB.show()
        pane.children += lineL.show()
        content = pane
      }
    }
  }
}