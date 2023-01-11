package classes

import classes.GeoPoint

class GeoCircle (val radius: Double, val o: GeoPoint){

  val pi = 3.141592

  def area(): Double =
    radius*radius*pi

  def perimeter(): Double =
    2*radius*pi
  
}
