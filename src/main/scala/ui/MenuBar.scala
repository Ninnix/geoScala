package ui

import GeoConfig.{menuBarSize, stageSize}
import classes.GeoPoint
import scalafx.geometry.Insets
import scalafx.scene.control.Button
import scalafx.scene.layout.VBox
import ui.CartesianPlane.plane

object MenuBar {
  val buttonPane = new VBox
  buttonPane.prefWidth = menuBarSize
  buttonPane.prefHeight = stageSize
  buttonPane.padding = Insets(5)
  buttonPane.spacing = 10

  val drawPointButton = new Button("◾")
  drawPointButton.onAction = _ => {
    plane.onMouseClicked = (event) => {
      val pointA: GeoPoint = GeoPoint(event.getX, event.getY)
      plane.children += pointA.show("A")
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

  buttonPane.children = List(drawPointButton, drawSegmentLineButton, drawLineButton, drawCircleButton)

}
