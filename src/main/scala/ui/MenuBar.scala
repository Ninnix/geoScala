package ui

import scalafx.geometry.Insets
import scalafx.scene.Cursor
import scalafx.scene.control.{Button, Dialog, TextInputDialog}
import scalafx.scene.layout.{Pane, VBox}
import scalafx.scene.shape.{Circle, Line}
import scalafx.scene.control.TextInputDialog
import scalafx.scene.shape.Line
import scalafx.Includes.*
import scala.util.control.Breaks.break
import ui.CartesianPlane.{grid, plane, xAxis, yAxis}
import classes.{GeoCircle, GeoEllipse, GeoPoint, GeoSegmentLine, GeoStraightLine, GeoTriangle}
import GeoConfig.{menuBarSize, stageSize}

object MenuBar {
  val buttonPane = new VBox
  buttonPane.prefWidth = menuBarSize
  buttonPane.prefHeight = stageSize
  buttonPane.padding = Insets(5)
  buttonPane.spacing = 10

  var points: List[GeoPoint] = List()
  var segments: List[GeoSegmentLine] = List()
  var lines: List[GeoStraightLine] = List()
  var circles: List[GeoCircle] = List()
  var triangles: List[GeoTriangle] = List()
  var ellipses: List[GeoEllipse] = List()

  val drawPointButton = new Button("◾")
  private var pCount: Int = 0
  drawPointButton.onAction = _ => {
    plane.onMouseClicked = (event) => {
      val objPoint: GeoPoint = GeoPoint(event.getX, event.getY)
      plane.children += objPoint.show("P" + pCount)
      objPoint.print()
      points = points :+ objPoint
      pCount += 1
    }
  }

  val drawSegmentLineButton = new Button("➖")
  drawSegmentLineButton.onAction = _ => {
    if (points.length >= 2) {
      val p1 = points(0)
      val p2 = points(1)
      val segment = new GeoSegmentLine(p1, p2)
      plane.children += segment.show()
      points = List()
      segments = segments :+ segment
      println(segment.a.id + segment.b.id + "=" + segment.a.print() + segment.b.print() )
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
        lines = lines :+ line
      case None => println("Input dialog was cancelled.")
    }
  }

  val drawCircleButton = new Button("○")
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

  val drawEllipseButton = new Button("⬭")
  drawEllipseButton.onAction = _ => {
    plane.onMouseClicked = (event) => {
      val center = GeoPoint(event.getX, event.getY)
      val inputDialogRx = new TextInputDialog("50")
      inputDialogRx.title = "Input x radius"
      inputDialogRx.headerText = "Enter the x radius of the ellipse:"
      inputDialogRx.contentText = "X Radius:"

      val resultRx = inputDialogRx.showAndWait()
      resultRx match {
        case Some(rxString) =>
          val rx = rxString.toDouble
          val inputDialogRy = new TextInputDialog("30")
          inputDialogRy.title = "Input y radius"
          inputDialogRy.headerText = "Enter the y radius of the ellipse:"
          inputDialogRy.contentText = "Y Radius:"

          val resultRy = inputDialogRy.showAndWait()
          resultRy match {
            case Some(ryString) =>
              val ry = ryString.toDouble
              val ellipse = new GeoEllipse(center, rx, ry)
              plane.children += ellipse.show()
            case None => println("Input dialog was cancelled.")
          }
        case None => println("Input dialog was cancelled.")
      }
    }
  }

  val cleanAllPlate = new Button("\uD83D\uDDD1")
  cleanAllPlate.onAction = _ => {
    plane.children.clear()
    plane.children ++= Seq(xAxis, yAxis, grid) // restore the cartesian plate
    points = List.empty[GeoPoint]
    segments = List.empty[GeoSegmentLine]
    lines = List.empty[GeoStraightLine]
    pCount = 0
  }

  buttonPane.children = List(drawPointButton, drawSegmentLineButton,
    drawLineButton, drawCircleButton, drawTriangleButton, drawEllipseButton, cleanAllPlate)

}
