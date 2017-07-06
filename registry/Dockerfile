FROM openjdk:8-alpine

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/registry/lib
# Add the service itself
ADD target/registry.jar /usr/share/registry/registry.jar

WORKDIR /usr/share/registry

ENTRYPOINT ["/usr/bin/java", "-jar", "-Dspring.profiles.active=container", "registry.jar"]