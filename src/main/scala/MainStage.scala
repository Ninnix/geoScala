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
import GeoConfig.{menuBarSize, stageSize}
import scalafx.scene.image.Image


object MainStage extends JFXApp3 {

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "GeoScala"
      icons += new Image("resources/GeoScalaLogo.png")
      width = stageSize + menuBarSize + 20
      height = stageSize + 40


      scene = new Scene {
        //content = pointA.showText()
        val mainPane = new HBox
        mainPane.children = List(buttonPane, plane)
        content = mainPane
      }
    }
  }
}