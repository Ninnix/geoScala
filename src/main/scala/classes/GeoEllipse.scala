package classes

import scalafx.scene.layout.Pane

class GeoEllipse(val center: GeoPoint, val rx: Double, val ry: Double) {
  def show(): Pane = {
    val jfxEllipse = new javafx.scene.shape.Ellipse(center.geoX, center.geoY, rx, ry)
    jfxEllipse.setStroke(javafx.scene.paint.Color.BLACK)
    jfxEllipse.setFill(javafx.scene.paint.Color.TRANSPARENT)
    val sfxEllipse = new scalafx.scene.shape.Ellipse(jfxEllipse)
    val pane = new scalafx.scene.layout.Pane
    pane.children.add(sfxEllipse)
    pane
  }
}

