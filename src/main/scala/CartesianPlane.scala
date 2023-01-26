import scalafx.geometry.Pos
import scalafx.scene.Group
import scalafx.scene.shape.*
import scalafx.scene.layout.*
import scalafx.scene.paint.Color

object CartesianPlane {
  val xAxis = new Line {
    startX = 0
    startY = 400
    endX = 800
    endY = 400
    strokeWidth = 2
  }

  val yAxis = new Line {
    startX = 400
    startY = 0
    endX = 400
    endY = 800
    strokeWidth = 2
  }

  val grid = new Group {
    for (i <- 0 to 800 by 50) {
      children.add(new Line {
        startX = i
        startY = 0
        endX = i
        endY = 800
        strokeWidth = 0.5
        stroke = if (i == 0) Color.Black else Color.LightGray
      })
      children.add(new Line {
        startX = 0
        startY = i
        endX = 800
        endY = i
        strokeWidth = 0.5
        stroke = if (i == 0) Color.Black else Color.LightGray
      })
    }
  }

  val plane = new Pane {
    children ++= Seq(xAxis, yAxis, grid)
    prefWidth = 800
    prefHeight = 800
  }
}
