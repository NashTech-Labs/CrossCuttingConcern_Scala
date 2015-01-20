package com.knoldus.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory

@Aspect
class AnnotationBasedAspect {

  /**
   * around execution of Sum
   */
  @Around("execution(@com.knoldus.aspect.Loggable * *.*(..))")
  def aroundSum(joinPoint: ProceedingJoinPoint): Object = {
    val result = joinPoint.proceed
    println("Method:-" + joinPoint.toShortString() + " Input:-" + joinPoint.getArgs().toList.mkString(",") + " Result:-" + result)
    result
  }

}

class Sum {
  @Loggable
  def checkSum(a: Int, b: Int): Int = a + b
}