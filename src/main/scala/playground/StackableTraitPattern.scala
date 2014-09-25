package playground

object StackableTraitPattern extends App {

  trait Lifecycle {
    def startup(): Unit
    def shutdown(): Unit
  }

  /**
   * Both OrdersModule and DatabaseModule serve as stackable traits.
   */

  trait OrdersModule extends Lifecycle {
    private val name = "OrdersModule"

    abstract override def startup() = {
      super.startup()
      println(s"$name started")
    }

    abstract override def shutdown() = {
      println(s"$name stopped")
      super.shutdown()
    }
  }

  trait DatabaseModule extends Lifecycle {
    private val name = "DatabaseModule"

    abstract override def startup() = {
      super.startup()
      println(s"$name started")
    }

    abstract override def shutdown() = {
      println(s"$name stopped")
      super.shutdown()
    }
  }

  class Application extends Lifecycle {
    private val name = "Application"

    def startup() = println(s"$name start")

    def shutdown() = println(s"$name stop")
  }

  /**
   * Method 'startup' from OrdersModule is invoked before 'startup' from DatabaseModule
   * (generally, mixins further to the right take the effect first), but due to the use
   * of super in these, DatabaseModule is started effectively before OrdersModule.
   */

  val app = new Application with DatabaseModule with OrdersModule

  app.startup()
  println("Some actions...")
  app.shutdown()

  /**
   * Prints:
   *  Application start
   *  DatabaseModule started
   *  OrdersModule started
   *  Some actions...
   *  OrdersModule stopped
   *  DatabaseModule stopped
   *  Application stop
   */

}
