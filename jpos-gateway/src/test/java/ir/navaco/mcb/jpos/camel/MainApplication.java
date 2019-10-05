package ir.navaco.mcb.jpos.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.component.http.HttpComponent;
import org.apache.camel.component.netty.http.NettyHttpComponent;
import org.apache.camel.component.sparkrest.SparkComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        CamelRestConsumer camelRestConsumer = new CamelRestConsumer();
        CamelContext context = new DefaultCamelContext();
        context.addComponent("spark-rest", new SparkComponent());
        context.addComponent("http", new HttpComponent());
        context.addComponent("netty-http", new NettyHttpComponent());
        context.addRoutes(camelRestConsumer);
        context.start();
    }
}
