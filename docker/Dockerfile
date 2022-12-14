FROM eclipse-temurin:11
RUN mkdir /opt/mockmock
COPY ./MockMock.jar /opt/mockmock

EXPOSE 8282
EXPOSE 25

CMD ["java", "-jar", "/opt/mockmock/MockMock.jar"]