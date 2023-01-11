package classes

import classes.Point

class Circle (val radius: Double, val o: Point){

  val pi = 3.141592

  def area(): Double =
    radius*radius*pi

  def perimeter(): Double =
    2*radius*pi
  
}
