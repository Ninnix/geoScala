package classes

import scalafx.scene.layout.Pane
import scalafx.scene.paint.Color.*
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.Polygon

class GeoTriangle(a: GeoPoint, b: GeoPoint, c: GeoPoint):
  def show(): Pane =
    val jfxTriangle = new javafx.scene.shape.Polygon(a.geoX, a.geoY, b.geoX, b.geoY, c.geoX, c.geoY)
    val sfxTriangle = new scalafx.scene.shape.Polygon(jfxTriangle)
    sfxTriangle.fill = Transparent
    sfxTriangle.stroke = Black
    val pane = new scalafx.scene.layout.Pane
    pane.children.add(sfxTriangle)
    pane