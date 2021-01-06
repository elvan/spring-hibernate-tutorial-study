package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExampleAopExpressions {

  @Pointcut("execution(* org.example.aopdemo.repository.*.*(..))")
  public void forRepositoryPackage() {
  }

  // create pointcut for getter methods
  @Pointcut("execution(* org.example.aopdemo.repository.*.get*(..))")
  public void forGetterMethods() {
  }

  // create pointcut for setter methods
  @Pointcut("execution(* org.example.aopdemo.repository.*.set*(..))")
  public void forSetterMethods() {
  }

  // create pointcut include package .. exclude getter/setter
  @Pointcut(
    "forRepositoryPackage() && !(forGetterMethods() || forSetterMethods())"
  )
  public void forRepositoryNoGetterSetter() {
  }

}
