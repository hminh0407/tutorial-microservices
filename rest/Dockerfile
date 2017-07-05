FROM openjdk:8-alpine

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/rest/lib
# Add the service itself
ADD target/rest.jar /usr/share/rest/rest.jar

WORKDIR /usr/share/rest

ENTRYPOINT ["/usr/bin/java", "-jar", "-Dspring.profiles.active=container", "rest.jar"]