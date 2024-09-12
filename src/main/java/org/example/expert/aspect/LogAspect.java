package org.example.expert.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class LogAspect {

  @Pointcut("execution(* org.example.expert.domain.user.controller.*.*(..))")
  public void changeUserRole() {}

  @Pointcut("execution(* org.example.expert.domain.comment.controller.*.*(..))")
  public void deleteComment() {}

  @Around("changeUserRole() || deleteComment()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String userId = request.getHeader("userId");
    LocalDateTime localDateTime = LocalDateTime.now();
    String uri = request.getRequestURI();
    log.info("userId: {}, localDateTime: {}, uri: {}", userId, localDateTime, uri);
    Object result = joinPoint.proceed();

    return result;
  }

}
