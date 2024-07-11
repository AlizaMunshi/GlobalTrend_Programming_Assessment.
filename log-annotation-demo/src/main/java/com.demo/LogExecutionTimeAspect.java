package com.logdemo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {
	  @Around("@annotation(LogExecutionTime)")
	    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	        long start = System.currentTimeMillis();

	        Object proceed = joinPoint.proceed();

	        long executionTime = System.currentTimeMillis() - start;

	        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	        return proceed;
	    }

}

/*This is an Aspect-Oriented Programming (AOP) code in Spring Boot. The code defines an aspect that logs the execution time of methods annotated with `@LogExecutionTime`.

Here's a breakdown of the code:

- `@Aspect`: This annotation is used to declare an aspect. An aspect is a class that implements cross-cutting concerns, such as logging, security, etc.

- `@Component`: This annotation is used to declare a Spring Bean. Spring Beans are objects that are managed by the Spring container.

- `@Around("@annotation(LogExecutionTime)")`: This is an advice. Advices are actions taken by an aspect at a particular join point. In this case, the advice is around advice, which means it runs before and after the method execution. The `@annotation(LogExecutionTime)` expression is a pointcut that matches all the join points where the method is annotated with `@LogExecutionTime`.

- `public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable`: This is the method that implements the advice. The `ProceedingJoinPoint` is a specific kind of `JoinPoint` that represents a method execution. The `proceed()` method is used to continue with the method execution.

- `long start = System.currentTimeMillis();` and `long executionTime = System.currentTimeMillis() - start;`: These lines are used to calculate the execution time of the method.

- `System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");`: This line logs the execution time of the method.

- `return proceed;`: This line returns the result of the method execution.

So, whenever a method annotated with `@LogExecutionTime` is executed, this aspect will log the execution time of that method.
 */