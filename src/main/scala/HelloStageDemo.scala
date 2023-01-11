import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.geometry.Point2D
import scalafx.scene.Scene
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.{Circle, Line, Rectangle}
import classes.{GeoPoint, GeoSegmentLine, GeoStraightLine, GeoCircle}

object HelloStageDemo extends JFXApp3 {

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "GeoScala"
      width = 600
      height = 450


      scene = new Scene {
        fill = LightGrey
        var pointA: GeoPoint = GeoPoint(10, 10)
        content = new Circle{
          centerX = pointA.x
          centerY = pointA.y
          radius = 3
          fill = Red
        }
      }
    }
  }
}