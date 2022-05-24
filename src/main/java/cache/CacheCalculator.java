package cache;

import api.EquationInput;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

@Aspect
@EnableAspectJAutoProxy
public class CacheCalculator {

    private Map<EquationInput, String> cache = new HashMap<>();

    @Around(value = "@annotation(cache.MyCacheable)")
    public String useCacheIfExists(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            EquationInput input = (EquationInput) args[0];
            if (cache.keySet().contains(input)) {
                System.out.println("get result from cache");
                return cache.get(input);
            } else {
                String proceed = (String) joinPoint.proceed(args);
                cache.put(input, proceed);
                return proceed;
            }
        }
        return null;
    }

}
