package org.cdi.advocacy;

//import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class TransportFactory {

	//@Produces
	ATMTransport createTransport(InjectionPoint injectionPoint) {

		Transport transportConfig = injectionPoint.getAnnotated().getAnnotation(Transport.class);

		if (transportConfig!=null) {
			
		}
		StandardAtmTransport transport = new StandardAtmTransport();

		transport.setRetries(transportConfig.retries());
		return transport;
	}
	// //Look up config parameters in some config file
	// System.out.println("ATMTransport created with producer makes decisions");
	//
	// if (behindFireWall) {
	// if (useJSON) {
	// System.out.println("return passed JSON transport");
	// return jsonTransport;
	// } else {
	// System.out.println("return passed SOAP transport");
	// return soapTransport;
	// }
	// } else {
	// System.out.println("Create Standard transport");
	// return new StandardAtmTransport();
	// }

	// // private boolean useJSON = true;
	// // private boolean behindFireWall = true;
	//
	//
	// // @Produces ATMTransport createTransport(InjectionPoint injectionPoint)
	// {
	// //
	// // System.out.println("annotated " + injectionPoint.getAnnotated());
	// // System.out.println("bean " + injectionPoint.getBean());
	// // System.out.println("member " + injectionPoint.getMember());
	// // System.out.println("qualifiers " + injectionPoint.getQualifiers());
	// // System.out.println("type " + injectionPoint.getType());
	// // System.out.println("isDelegate " + injectionPoint.isDelegate());
	// // System.out.println("isTransient " + injectionPoint.isTransient());
	// //
	// // Bean<?> bean = injectionPoint.getBean();
	// // TransportConfig transportConfig =
	// bean.getBeanClass().getAnnotation(TransportConfig.class);
	// //
	// // System.out.println("bean.beanClass " + bean.getBeanClass());
	// // System.out.println("bean.injectionPoints " +
	// bean.getInjectionPoints());
	// // System.out.println("bean.name " + bean.getName());
	// // System.out.println("bean.qualifiers " + bean.getQualifiers());
	// // System.out.println("bean.scope " + bean.getScope());
	// // System.out.println("bean.stereotypes " + bean.getStereotypes());
	// // System.out.println("bean.types " + bean.getTypes());
	// //
	// // Annotated annotated = injectionPoint.getAnnotated();
	// // System.out.println("annotated.annotations " +
	// annotated.getAnnotations());
	// // System.out.println("annotated.annotations " +
	// annotated.getBaseType());
	// // System.out.println("annotated.typeClosure " +
	// annotated.getTypeClosure());
	// //
	// // //TransportConfig transportConfig =
	// annotated.getAnnotation(TransportConfig.class);
	// //
	// //
	// //
	// // StandardAtmTransport transport = new StandardAtmTransport();
	// //
	// // transport.setRetries(transportConfig.retries());
	// // return transport;
	// //// //Look up config parameters in some config file
	// ////
	// System.out.println("ATMTransport created with producer makes decisions");
	// ////
	// //// if (behindFireWall) {
	// //// if (useJSON) {
	// //// System.out.println("return passed JSON transport");
	// //// return jsonTransport;
	// //// } else {
	// //// System.out.println("return passed SOAP transport");
	// //// return soapTransport;
	// //// }
	// //// } else {
	// //// System.out.println("Create Standard transport");
	// //// return new StandardAtmTransport();
	// //// }
	// }

}
