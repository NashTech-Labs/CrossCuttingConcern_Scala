package com.knoldus

import org.specs2.mutable.SpecificationWithJUnit
import com.knoldus.aspect.Sum

class AnnotationAspectTest extends SpecificationWithJUnit {

  "Sum of 2 and 3" should {

    "be 5" in {

      val sum = new Sum

      assert(sum.checkSum(2, 3) == 5)
    }
  }

}