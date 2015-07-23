package playground.typelevel

import shapeless.test.illTyped

object BoolTypeSpecs {
  implicitly[TrueType =:= TrueType]
  implicitly[FalseType =:= FalseType]
  illTyped("implicitly[TrueType =:= FalseType]")
  illTyped("implicitly[FalseType =:= TrueType]")

  // NOT
  implicitly[TrueType#Not =:= FalseType]
  implicitly[FalseType#Not =:= TrueType]
  illTyped("implicitly[TrueType#Not =:= TrueType]")
  illTyped("implicitly[FalseType#Not =:= FalseType]")

  // OR
  implicitly[TrueType#Or[TrueType] =:= TrueType]
  implicitly[TrueType#Or[FalseType] =:= TrueType]
  implicitly[FalseType#Or[TrueType] =:= TrueType]
  implicitly[FalseType#Or[FalseType] =:= FalseType]

  // AND
  implicitly[TrueType#And[TrueType] =:= TrueType]
  implicitly[TrueType#And[FalseType] =:= FalseType]
  implicitly[FalseType#And[TrueType] =:= FalseType]
  implicitly[FalseType#And[FalseType] =:= FalseType]

  // IMPLICATION
  implicitly[TrueType#Imp[TrueType] =:= TrueType]
  implicitly[TrueType#Imp[FalseType] =:= FalseType]
  implicitly[FalseType#Imp[TrueType] =:= TrueType]
  implicitly[FalseType#Imp[FalseType] =:= TrueType]
}
