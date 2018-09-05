package playground.intellij

object ImplicitShortcuts {

  implicit val defaultValue: Int = 42

  implicit def stringToIntWithMore(s: String)(implicit more: Int): Int = Integer.parseInt(s) + more

  val i: Int = "123"

}

object MoreImplicits {

  class A
  class B
  class C
  class D

  implicit def aFromB(implicit b: B): A = new A
  implicit def bFromC(implicit c: C): B = new B

  implicit val someC: C = new C
  implicit val anotherC: C = new C // comment out to get rid of error
  implicit val someD: D = new D

  // A <- B <- [C] and [D]
  def materializeB(text: String)(implicit a: A, d: D): B = new B

  // underlined by IntelliJ (uncomment)
  // materializeB("")

}

object Other {

  val x: BigInt = 1000

  val someRange: Range = 1 to 5

}
