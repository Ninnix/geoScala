package classes


class StraightLine(val m: Double, val q: Double):

  //costructor 2 -> implicit form (ax+by+c=0)
  def this(a: Double, b: Double, c: Double) =
    this(m = -a/b, q = -c/b)