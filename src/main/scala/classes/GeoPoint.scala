package classes

import scalafx.scene.paint.Color.*
import scalafx.scene.shape.Circle
import scalafx.scene.text.Text

import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.{LinearGradient, Stops}

class GeoPoint(var x: Double, var y: Double):
  
  //costructor 2 point with coords in the origin
  def this() = this(x = 0, y = 0)

  def printCoords(): Unit =
    println("(" + x.toString + ", " + y.toString + ")")

  def move(dx: Double, dy: Double): Unit =
    x = x + dx
    y = y + dy

  def show(): Circle =
    val circle = new Circle {
      centerX = x
      centerY = y
      radius = 3
      fill = Red
    }
    circle

  def showText(): Text =
    val label = new Text {
      text = "FX"
      style = "-fx-font: italic bold 100pt sans-serif"
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
