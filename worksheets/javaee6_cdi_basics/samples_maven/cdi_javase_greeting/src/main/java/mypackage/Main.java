package mypackage;

import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;

public class Main {

	static BeanContainer beanContainer =  BeanContainerManager.getInstance();

	public static void main(String[] args) throws Exception {
		Greeting greeting = (Greeting) beanContainer
				.getBeanByName("greeting");

		System.out.println(greeting.greet("Sang Shin"));

	}

}
