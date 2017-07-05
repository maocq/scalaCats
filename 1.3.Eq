import cats.syntax.eq._
import cats.instances.int._
import cats.instances.option._

Option(1) === Option.empty[Int] // res0: Boolean = false

import cats.syntax.option._
val r: Option[Int] = 1.some // r: Option[Int] = Some(1)

1.some =!= None // res1: Boolean = true