FROM openjdk:8
CMD ["mkdir", "/root/jpos"]
CMD ["mkdir", "/deploy"]
CMD ["mkdir", "/root/jpos/libs"]
COPY jpos-gateway/target/jpos-gateway.jar /root/jpos/
COPY jpos-gateway/target/libs/*.jar /root/jpos/libs/
COPY deploy/*.xml /deploy/
#COPY src/main/resources/META-INF/transactionConfig/*.xml /deploy/
#COPY jpos-gateway/src/main/resources/http-configuration.properties /
COPY jpos-gateway/target/classes/hibernate.cfg.xml /root/jpos/
COPY jpos-gateway/target/classes/http-configuration.properties /
ENTRYPOINT ["java", "-jar", "/root/jpos/jpos-gateway.jar"]
