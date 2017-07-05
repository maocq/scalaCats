/**
  * Instance Trait
  */

trait TestTrait {
  def returnHello(name: String): String
}

val instanceTest: TestTrait = new TestTrait {
  override def returnHello(name: String) = s"Hello $name"
}

val hello = instanceTest.returnHello("mao") //Hello mao


/***
  * Type class
  */

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrintable = new Printable[String] {
    def format(input: String) = s"_ $input"
  }

  implicit val intPrintable = new Printable[Int] {
    def format(input: Int) = s"_ ${input.toString}"
  }
  //etc
}

object Printable {
  def myFormat[A](input: A)(implicit p: Printable[A]): String =
    p.format(input)
}

import PrintableInstances._
Printable.myFormat("Hello")


// Método de extensión para proporcionar una mejor sintaxis
object PrintableSyntax {
  implicit class PrintOps[A](value: A) {
    def myFormat(implicit p: Printable[A]): String =
      p.format(value)
  }
}

import PrintableSyntax._
"Hello".myFormat // "_ Hello