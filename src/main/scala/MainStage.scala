import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.geometry.{Insets, Point2D}
import scalafx.scene.Scene
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.{Circle, Line, Rectangle}
import scalafx.scene.layout.{HBox, Pane}
import classes.{GeoCircle, GeoPoint, GeoSegmentLine, GeoStraightLine}
import ui.CartesianPlane.plane
import ui.MenuBar.buttonPane
import GeoConfig.{stageSize, menuBarSize}


object MainStage extends JFXApp3 {

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "GeoScala"
      width = stageSize + menuBarSize + 20
      height = stageSize + 40


      scene = new Scene {
        //content = pointA.showText()
        val pane = new HBox
        pane.children = List(buttonPane, plane)
        content = pane
      }
    }
  }
}