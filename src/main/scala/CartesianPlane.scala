import scalafx.geometry.Pos
import scalafx.scene.Group
import scalafx.scene.shape.*
import scalafx.scene.layout.*
import scalafx.scene.paint.Color

object CartesianPlane {

  val pane = new Pane

  val xAxis = new Line {
    startX = 0
    startY = 400
    endX = 800
    endY = 400
    strokeWidth = 2
  }
  pane.children += xAxis

  val yAxis = new Line {
    startX = 400
    startY = 0
    endX = 400
    endY = 800
    strokeWidth = 2
  }
  pane.children += yAxis

  for (i <- 0 to 800 by 50) {
    val vLine = new Line {
      startX = i
      startY = 0
      endX = i
      endY = 800
      stroke = Color.LightGray
      strokeWidth = 1
    }
    pane.children += vLine
  }

  for (i <- 0 to 800 by 50) {
    val hLine = new Line {
      startX = 0
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

}
