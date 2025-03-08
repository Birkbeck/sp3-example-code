package mypackage;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

// This class will be used as an interceptor.
public class LoggingInterceptor {

    private Logger logger = Logger.getLogger("mypackage");

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.info("------> " + ic.getTarget().getClass() + ", method name: " + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.info("<------ " + ic.getTarget().getClass() + ", method name: " + ic.getMethod().getName());
        }
    }
}
