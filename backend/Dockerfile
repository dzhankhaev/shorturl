FROM eclipse-temurin:11-jre-alpine

RUN mkdir shorturl
WORKDIR shorturl

COPY target/backend-1.0.jar /shorturl/
COPY wait-for.sh /shorturl/
RUN chmod +x wait-for.sh

CMD ["java", "-jar", "backend-1.0.jar"]