import scalafx.geometry.Pos
import scalafx.scene.Group
import scalafx.scene.shape.*
import scalafx.scene.layout.*
import scalafx.scene.paint.Color
import GeoConfig.stageSize

object CartesianPlane {
  val xAxis = new Line {
    startX = 0
    startY = stageSize/2
    endX = stageSize
    endY = stageSize/2
    strokeWidth = 2
  }

  val yAxis = new Line {
    startX = stageSize/2
    startY = 0
    endX = stageSize/2
    endY = stageSize
    strokeWidth = 2
  }

  val grid = new Group {
    for (i <- 0 to stageSize by 50) {
      children.add(new Line {
        startX = i
        startY = 0
        endX = i
        endY = stageSize
        strokeWidth = 0.5
        stroke = if (i == 0) Color.Black else Color.LightGray
      })
      children.add(new Line {
        startX = 0
        startY = i
        endX = stageSize
        endY = i
        strokeWidth = 0.5
        stroke = if (i == 0) Color.Black else Color.LightGray
      })
    }
  }

  val plane = new Pane {
    children ++= Seq(xAxis, yAxis, grid)
    prefWidth = stageSize
    prefHeight = stageSize
  }
}
