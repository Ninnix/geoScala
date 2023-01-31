package ui

import GeoConfig.{menuBarSize, stageSize}
import classes.{GeoCircle, GeoPoint, GeoSegmentLine, GeoStraightLine}
import scalafx.geometry.Insets
import scalafx.scene.Cursor
import scalafx.scene.control.{Button, Dialog, TextInputDialog}
import scalafx.scene.layout.{Pane, VBox}
import scalafx.scene.shape.Line
import ui.CartesianPlane.{grid, plane, xAxis, yAxis}

object MenuBar {
  val buttonPane = new VBox
  buttonPane.prefWidth = menuBarSize
  buttonPane.prefHeight = stageSize
  buttonPane.padding = Insets(5)
  buttonPane.spacing = 10

  var points: List[GeoPoint] = List()

  val drawPointButton = new Button("◾")
  private var pCount: Int = 0
  drawPointButton.onAction = _ => {
    plane.onMouseClicked = (event) => {
      val objPoint: GeoPoint = GeoPoint(event.getX, event.getY)
      plane.children += objPoint.show("P" + pCount)
      print(objPoint.id, objPoint.cartesianX, objPoint.cartesianY)
      println()
      pCount += 1
      points = points :+ objPoint
    }
  }

  val drawSegmentLineButton = new Button("➖")
  drawSegmentLineButton.onAction = _ => {
    if (points.length >= 2) {
      val p1 = points(0)
      val p2 = points(1)
      val line = new GeoSegmentLine(p1, p2)
      plane.children += line.show()
      points = List()
    }
  }

  import scalafx.scene.control.TextInputDialog
  import scalafx.scene.shape.Line
  import scalafx.Includes._

  val drawLineButton = new Button("↔")
  drawLineButton.onAction = _ => {
    val inputDialog = new TextInputDialog("0,0")
    inputDialog.title = "Input line parameters"
    inputDialog.headerText = "Enter the parameters of the line (m,q):"
    inputDialog.contentText = "Parameters (m,q):"

    val result = inputDialog.showAndWait()
    result match {
      case Some(paramsString) =>
        val Array(m, q) = paramsString.split(",").map(_.toDouble)
        val line = new GeoStraightLine(m, q)
        plane.children += line.show()
      case None => println("Input dialog was cancelled.")
    }
  }


  val drawCircleButton = new Button("\uD83D\uDD34")
  drawCircleButton.onAction = _ => {
    plane.onMouseClicked = (event) => {
      val center = GeoPoint(event.getX, event.getY)
      val inputDialog = new TextInputDialog("50")
      inputDialog.title = "Input radius"
      inputDialog.headerText = "Enter the radius of the circle:"
      inputDialog.contentText = "Radius:"

      val result = inputDialog.showAndWait()
      result match {
        case Some(radiusString) =>
          val geoRadius = radiusString.toDouble
          val circle = new GeoCircle(geoRadius, center)
          plane.children += circle.show()
        case None => println("Input dialog was cancelled.")
      }
    }
  }


  val cleanAllPlate = new Button("\uD83D\uDDD1")
  cleanAllPlate.onAction = _ => {
    plane.children.clear()
    plane.children ++= Seq(xAxis, yAxis, grid) // restore the cartesian plate
    points = List.empty[GeoPoint]
    pCount = 0
  }

  buttonPane.children = List(drawPointButton, drawSegmentLineButton, drawLineButton, drawCircleButton, cleanAllPlate)

}
