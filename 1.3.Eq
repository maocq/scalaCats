import cats.syntax.eq._
import cats.instances.int._
import cats.instances.option._

Option(1) === Option.empty[Int] // false

import cats.syntax.option._
val r: Option[Int] = 1.some

1.some =!= None // true