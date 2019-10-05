package ir.navaco.mcb.credit.card.camel.routes;

import ir.navaco.mcb.credit.card.camel.routes.control.JPOSRoute;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.apache.camel.component.jackson.JacksonDataFormat;

public class CamelRESTRoute extends JPOSRoute {

    private static final String TAG = "CamelRESTRoute";

    private String routeId;
    private ir.navaco.mcb.credit.card.camel.dto.JPOSRoute jposRoute;
    private JPOSLogger logger;

    private String fileLocation;

    private Object messageObject;

    private JacksonDataFormat jsonDataFormat;

    public CamelRESTRoute(ir.navaco.mcb.credit.card.camel.dto.JPOSRoute jposRoute, String fileLocation, Object messageObject){
        this.jposRoute = jposRoute;
        this.routeId = jposRoute.getRouteId();
        logger = new JPOSLogger(TAG);
        this.fileLocation = fileLocation;
        this.messageObject = messageObject;
        this.jsonDataFormat = new JacksonDataFormat(this.messageObject.getClass());
    }

    @Override
    public void configure() throws Exception {
        rest("/first-address")
                .get("/test").to("direct:page");

        from("direct:page")
                .transform().constant("");

        /*from("file:" + fileLocation + this.routeId)
                .setHeader(Exchange.HTTP_METHOD, simple(jposRoute.getMethod()))
                .setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
                .process(new ReadMessageFileM1100())
                .choice()
                    .when(new PredicateSomeThing())
                    .to("")
                .otherwise()
                    .to("")
                .end();*/


    }

    @Override
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String getRouteId() {
        return this.routeId;
    }
}
