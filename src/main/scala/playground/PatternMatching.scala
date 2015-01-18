package playground

object PatternMatching extends App {

  /**
   * Person is a case class, thus all its fields are implicitly
   * marked as `vals`.
   */
  case class Person(name: String, surname: String, age: Int)

  /**
   * Standard, non-case class. To make its fields public we have
   * to mark them as `vals` explicitly.
   */
  class Animal(val species: String, val weight: Int)

  /**
   * Vehicle is just a plain non-case class...
   */
  class Vehicle(val make: String, val model: String, val diesel: Boolean) {
    override def toString = s"Vehicle($make,$model,$diesel)"
  }

  /**
   * ...so we have to provide an `unapply` method to allow
   * alias syntax usage for pattern matching.
   */
  object Vehicle {
    def unapply(vehicle: Vehicle) = Some((vehicle.make, vehicle.model, vehicle.diesel))
  }

  def inspect(value: Any) = value match {
    // '@' is used for an alias syntax - p is an alias here:
    case p @ Person(name, surname, _) => println(s"$p - Note that it's $name $surname!")

    // Animal is neither a case class nor it doesn't provide unapply/unapplySeq methods,
    // so we cannot use alias syntax for pattern matching:
    // case a @ Animal(species, weight) => println("Whoops! It doesn't work like that...") [DOES NOT COMPILE]

    // We can use an alias syntax for Vehicle because we've provided an unapply method:
    case v @ Vehicle(make, _, _) => println(s"$v - That's $make! Nice.")

    case _ => println("Value not matched")
  }

  val tom = Person("Tom", "Hanks", 58)
  val porsche = new Vehicle("Porsche", "911", diesel = false)

  inspect(tom)
  inspect(porsche)

  /**
   * Prints:
   *  Person(Tom,Hanks,58) - Note that it's Tom Hanks!
   *  Vehicle(Porsche,911,false) - That's Porsche! Nice.
   */

}
