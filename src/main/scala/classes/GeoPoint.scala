package classes

import scalafx.scene.paint.Color.*
import scalafx.scene.shape.Circle
import scalafx.scene.text.Text
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.{LinearGradient, Stops}
import GeoConfig.stageSize
import scalafx.scene.layout.Pane

class GeoPoint(var geoX: Double, var geoY: Double):

  var id = ""
  val (cartesianX, cartesianY) = scaleCoordinates(geoX, geoY, stageSize)

  def print(): Unit = println( id + ":" + "(" + cartesianX + "," + cartesianY + ")")

  def getString(): String = s"$id:($cartesianX, $cartesianY)"

  def scaleCoordinates(x: Double, y: Double, stageSize: Double): (Double, Double) = {
    val xScaled = (x / (stageSize / 4)) * (stageSize / 4) - (stageSize / 2)
    val yScaled = (stageSize / 2) - (y / (stageSize / 4)) * (stageSize / 4)
    (xScaled, yScaled)
  }

  def show(varName: String): Pane =
    val circle = new Circle {
      centerX = geoX
      centerY = geoY
      radius = 3
      fill = Red
    }
    id = varName
    var idText = this.showText(id)

    val panePoint = new Pane {
      children ++= Seq(circle, idText)
      prefWidth = stageSize
      prefHeight = stageSize
    }
    panePoint

  private def showText(varName: String): Text =
    val label = new Text {
      text = varName
      x = geoX + 10
      y = geoY + 5
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
