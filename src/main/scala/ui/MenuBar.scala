package ui

import GeoConfig.{menuBarSize, stageSize}
import classes.GeoPoint
import scalafx.geometry.Insets
import scalafx.scene.control.Button
import scalafx.scene.layout.VBox
import ui.CartesianPlane.{grid, plane, xAxis, yAxis}

object MenuBar {
  val buttonPane = new VBox
  buttonPane.prefWidth = menuBarSize
  buttonPane.prefHeight = stageSize
  buttonPane.padding = Insets(5)
  buttonPane.spacing = 10

  val drawPointButton = new Button("◾")
  private var pCount: Int = 0
  drawPointButton.onAction = _ => {
    plane.onMouseClicked = (event) => {
      val objPoint: GeoPoint = GeoPoint(event.getX, event.getY)
      plane.children += objPoint.show("P" + pCount)
      print(objPoint.id, objPoint.cartesianX, objPoint.cartesianY)
      println()
      pCount += 1
    }
  }

  val drawSegmentLineButton = new Button("➖")
  drawSegmentLineButton.onAction = _ => {
    // Add code to draw segment line on the cartesian plane
  }

  val drawLineButton = new Button("↔")
  drawLineButton.onAction = _ => {
    // Add code to draw line on the cartesian plane
  }

  val drawCircleButton = new Button("\uD83D\uDD34")
  drawCircleButton.onAction = _ => {
    // Add code to draw circle on the cartesian plane
  }

  val cleanAllPlate = new Button("\uD83D\uDDD1")
  cleanAllPlate.onAction = _ => {
    plane.children.clear()
    plane.children ++= Seq(xAxis, yAxis, grid)
    pCount = 0
  }

  buttonPane.children = List(drawPointButton, drawSegmentLineButton, drawLineButton, drawCircleButton, cleanAllPlate)

}
