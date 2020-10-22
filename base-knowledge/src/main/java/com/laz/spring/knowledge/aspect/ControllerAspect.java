package com.laz.spring.knowledge.aspect;

import java.lang.reflect.Method;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * controller 日志打印
 * 服务请求拦截
 * 1.请求处理
 * 2.map转请求对象
 *
 * @author 码农猿
 */
@Aspect
@Component
public class ControllerAspect {
	private Logger log = LoggerFactory.getLogger(ControllerAspect.class);
	private static Random random = new Random();


    /**
     * 统一切点,对com.example.controller及其子包中所有的类的所有方法切面
     */
    @Pointcut("execution(public * com.laz.spring.knowledge.controller..*.*(..))")
    private void allMethod() {
    }

    @Around("allMethod()")
    public Object doAround(ProceedingJoinPoint call) throws Throwable {

        MethodSignature signature = (MethodSignature) call.getSignature();
        Method method = signature.getMethod();

        String[] classNameArray = method.getDeclaringClass().getName().split("\\.");
        String methodName = classNameArray[classNameArray.length - 1] + "  >>> " + method.getName();

        String params = buildParamsDefault(call);
        long start = System.currentTimeMillis();
        //随机请求标识，便于日志追踪
        String reqId = getRandom(10);
        Object result = null;
        try {
            log.info("日志标识：{} >> [接口请求开始] 方法名：{} , 请求参数：{}", reqId, methodName, params);
            result = call.proceed();
            return result;

        } finally {
            long runTimes = System.currentTimeMillis()- start;
            log.info("日志标识：{} >> [接口请求结束] 方法名：{} , 请求耗时：{} ms", reqId, methodName, runTimes);
        }
    }


    private String buildParamsDefault(ProceedingJoinPoint call) {
        String params = " [";
        for (int i = 0; i < call.getArgs().length; i++) {
            Object obj = call.getArgs()[i];
            if (null != obj) {
                if (obj instanceof HttpServletRequest) {
                    continue;
                }
                String str = obj.toString();
                if (obj.getClass() != String.class) {
                    str = ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE);
                }
                if (i != call.getArgs().length - 1) {
                    params += str + ",";
                } else {
                    params += str + " ]";
                }
            }
            if (params.length() == 1) {
                params += "]";
            }
        }
        return params;
    }


    private static String getRandom(int length) {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            boolean isChar = random.nextInt(2) % 2 == 0;
            if (isChar) {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                ret.append((char) (choice + random.nextInt(26)));
            } else {
                ret.append(Integer.toString(random.nextInt(10)));
            }
        }

        return ret.toString();
    }

}
