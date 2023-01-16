package classes

import scalafx.scene.paint.Color.*
import scalafx.scene.shape.Circle
import scalafx.scene.text.Text
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.{LinearGradient, Stops}

class GeoPoint(var geoX: Double, var geoY: Double):
  
  //costructor 2 point with coords in the origin
  def this() = this(geoX = 0, geoY = 0)

  def printCoords(): Unit =
    println("(" + geoX.toString + ", " + geoY.toString + ")")

  def move(dx: Double, dy: Double): Unit =
    geoX = geoX + dx
    geoY = geoY + dy

  def show(): Circle =
    val circle = new Circle {
      centerX = geoX
      centerY = geoY
      radius = 3
      fill = Red
    }
    circle

  def showText(): Text =
    val label = new Text {
      text = "FX"
      x = geoX + 10
      y = geoY + 5
      style = "-fx-font: italic bold 10pt sans-serif"
      fill = new LinearGradient(
        endX = 10,
        stops = Stops(White, DarkGray)
      )
      effect = new DropShadow {
        color = DarkGray
        radius = 15
        spread = 0.25
      }
    }
    label
