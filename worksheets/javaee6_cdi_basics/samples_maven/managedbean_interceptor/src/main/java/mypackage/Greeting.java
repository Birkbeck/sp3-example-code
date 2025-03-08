package mypackage;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptors;

//@ManagedBean
@RequestScoped
@Interceptors(LoggingInterceptor.class)
public class Greeting {

    public String greet(String name) {
        return "Hello " + name;
    }

    @PostConstruct
    private void init() {
        System.out.println("\n=======> init() method is called as PostConstruct");
    }

    @PreDestroy
    private void release() {
        System.out.println("=======> release() method is called as PreDestroy");
    }
}