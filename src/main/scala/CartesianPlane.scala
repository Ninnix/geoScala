import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Line
import scalafx.geometry.Pos
import scalafx.scene.layout.StackPane
import scalafx.scene.layout.Pane

object CartesianPlane extends JFXApp3 {

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title = "Cartesian Plane"
      scene = new Scene(800, 800) {
        val pane = new Pane

        // Draw x-axis
        val xAxis: Line = new Line {
          startX = -800
          startY = 400
          endX = 800
          endY = 400
          stroke = Color.Black
          strokeWidth = 2
        }
        pane.children += xAxis

        // Draw y-axis
        val yAxis: Line = new Line {
          startX = 400
          startY = -800
          endX = 400
          endY = 800
          stroke = Color.Black
          strokeWidth = 2
        }
        pane.children += yAxis

        // Draw grid
        for (i <- -800 to 800 by 50) {
          val vLine = new Line {
            startX = i
            startY = -800
            endX = i
            endY = 800
            stroke = Color.LightGray
            strokeWidth = 1
          }
          pane.children += vLine
        }

        for (i <- -800 to 800 by 50) {
          val hLine = new Line {
            startX = -800
            startY = i
            endX = 800
            endY = i
            stroke = Color.LightGray
            strokeWidth = 1
          }
          pane.children += hLine
        }

        val stackPane = new StackPane()
        stackPane.alignment = Pos.Center
        stackPane.children += pane

        content = stackPane
      }
    }
  }
}
