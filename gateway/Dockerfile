FROM openjdk:8-alpine

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/gateway/lib
# Add the service itself
ADD target/gateway.jar /usr/share/gateway/gateway.jar

WORKDIR /usr/share/gateway

ENTRYPOINT ["/usr/bin/java", "-jar", "-Dspring.profiles.active=container", "gateway.jar"]