FROM openjdk:8-alpine

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/config/lib
# Add the service itself
ADD target/config.jar /usr/share/config/config.jar

WORKDIR /usr/share/config

ENTRYPOINT ["/usr/bin/java", "-jar", "-Dspring.profiles.active=native", "config.jar"]
#ENTRYPOINT ["/usr/bin/java", "-jar", "-Dspring.profiles.active=container", "config.jar"]