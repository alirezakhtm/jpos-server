package ir.navaco.mcb.jpos.camel;

import ir.navaco.mcb.credit.card.camel.routes.control.JPOSRoute;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class CamelRestConsumer extends JPOSRoute {

    private String routeId;
    private static final String TAG = "CamelRestConsumer";
    private JPOSLogger logger = new JPOSLogger(TAG);

    @Override
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String getRouteId() {
        return this.routeId;
    }

    @Override
    public void configure() throws Exception {

        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(User.class);

        restConfiguration("rest-api")
                .component("restlet")
                .host("localhost")
                .port(8085)
                .dataFormatProperty("pretty-print", "true");

        rest("/test")
                .produces("application/json").consumes("application/json")
                .get("/sample-user").to("direct:sampleuser")
                .get("/echo-user").to("direct:echouser");

        from("file:C:/inboxREST").to("direct:sampleuser");
        from("file:C:/inboxPOST").to("direct:echouser");

        from("direct:sampleuser")
                .id("camel-sample-user")
                .setHeader(Exchange.HTTP_METHOD, simple("POST"))
                .setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
                .to("netty-http:http://localhost:9090/getusersample")
                .process(new MyProcess("SampleUser"));

        from("direct:echouser")
                .id("echo-user")
                .log("Echo-User Called.")
                .process(new CreateUserProcessor())
                .marshal(jacksonDataFormat)
                .process(new MyProcess("EchoUser - Created Object"))
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
                .to("netty-http:http://localhost:9090/echouser")
                .log("Response of service: ")
                .process(new MyProcess("EchoUser - Response Service"));
    }

}
