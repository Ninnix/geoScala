package ui

import GeoConfig.{menuBarSize, stageSize}
import classes.{GeoCircle, GeoPoint, GeoSegmentLine, GeoStraightLine, GeoTriangle}
import scalafx.geometry.Insets
import scalafx.scene.Cursor
import scalafx.scene.control.{Button, Dialog, TextInputDialog}
import scalafx.scene.layout.{Pane, VBox}
import scalafx.scene.shape.{Circle, Line}
import ui.CartesianPlane.{grid, plane, xAxis, yAxis}
import scalafx.scene.control.TextInputDialog
import scalafx.scene.shape.Line
import scalafx.Includes._

import scala.util.control.Breaks.break

object MenuBar {
  val buttonPane = new VBox
  buttonPane.prefWidth = menuBarSize
  buttonPane.prefHeight = stageSize
  buttonPane.padding = Insets(5)
  buttonPane.spacing = 10

  var points: List[GeoPoint] = List()

  val selectElementButton = new Button("↘")
  selectElementButton.onAction = _ => {
    plane.onMouseClicked = (event) => {
      val selectedX = event.getX
      val selectedY = event.getY
      var selectedElement: Option[Any] = None
      val range = 100 // change this value to increase or decrease the hitbox size

      // Check if a GeoPoint is selected
      for (point <- points) {
        if (Math.abs(point.cartesianX - selectedX) <= range && Math.abs(point.cartesianY - selectedY) <= range) {
          selectedElement = Some(point)
          break
        }
      }

      // Print information about the selected element
      selectedElement match {
        case Some(point: GeoPoint) => println(s"Selected GeoPoint: id = ${point.id}, cartesianX = ${point.cartesianX}, cartesianY = ${point.cartesianY}")
        case None => println("No element selected.")
      }
    }
  }

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

  val drawTriangleButton = new Button("△")
  drawTriangleButton.onAction = _ => {
    if (points.length >= 3) {
      val p1 = points(0)
      val p2 = points(1)
      val p3 = points(2)
      val triangle = new GeoTriangle(p1, p2, p3)
      plane.children += triangle.show()
      points = List()
    }
  }

  val cleanAllPlate = new Button("\uD83D\uDDD1")
  cleanAllPlate.onAction = _ => {
    plane.children.clear()
    plane.children ++= Seq(xAxis, yAxis, grid) // restore the cartesian plate
    points = List.empty[GeoPoint]
    pCount = 0
  }

  buttonPane.children = List(selectElementButton, drawPointButton, drawSegmentLineButton, drawLineButton, drawCircleButton, drawTriangleButton, cleanAllPlate)

}
