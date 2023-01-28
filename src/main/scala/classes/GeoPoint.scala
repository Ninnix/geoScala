package classes

import scalafx.scene.paint.Color.*
import scalafx.scene.shape.Circle
import scalafx.scene.text.Text
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.{LinearGradient, Stops}
import GeoConfig.stageSize
import scalafx.scene.layout.Pane

class GeoPoint(var geoX: Double, var geoY: Double):
  
  //costructor 2 point with coords in the origin
  def this() = this(geoX = 0, geoY = 0)

  val (startX, startY) = scaleToCenter(geoX, geoY, stageSize, stageSize)
  val cartesianX = startX
  val cartesianY = startY

  private def scaleToCenter(x: Double, y: Double, width: Double, height: Double): (Double, Double) = {
    val centerX = width / 2
    val centerY = height / 2
    (x + centerX, centerY - y)
  }

  def printCoords(): Unit =
    println("(" + geoX.toString + ", " + geoY.toString + ")")

  def move(dx: Double, dy: Double): Unit =
    geoX = geoX + dx
    geoY = geoY + dy

  def show(varName: String): Pane =
    val circle = new Circle {
      centerX = cartesianX
      centerY = cartesianY
      radius = 3
      fill = Red
    }
    var varText = this.showText(varName)

    val panePoint = new Pane {
      children ++= Seq(circle, varText)
      prefWidth = stageSize
      prefHeight = stageSize
    }
    panePoint

  private def showText(varName: String): Text =
    val label = new Text {
      text = varName
      x = cartesianX + 10
      y = cartesianY + 5
      style = "-fx-font: italic bold 10pt sans-serif"
      fill = new LinearGradient(
        endX = 10,
        stops = Stops(Black, DarkGray)
      )
      effect = new DropShadow {
        color = DarkGray
        radius = 15
        spread = 0.25
      }
    }
    label
