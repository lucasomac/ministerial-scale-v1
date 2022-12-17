#FROM gradle:latest AS build
#COPY --chown=gradle:gradle . /home/gradle/ministerial-scale-v1
#WORKDIR /home/gradle/ministerial-scale-v1
#RUN gradle build
#
#FROM openjdk:11
#EXPOSE 8080
#COPY --from=build /home/gradle/src/build/libs/ministerial-scale-v1-0.0.1-SNAPSHOT.jar /ministerial-scale-v1/
#RUN bash -c 'touch /ministerial-scale-v1/ministerial-scale-v1-0.0.1-SNAPSHOT.jar'
#ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/ministerial-scale-v1/ministerial-scale-v1-0.0.1-SNAPSHOT.jar"]


#FROM openjdk:11
#EXPOSE 8080
#ADD /build/libs/ministerial-scale-v1-0.0.1-SNAPSHOT.jar ministerial-scale-v1.jar
#ENTRYPOINT ["java", "-jar", "ministerial-scale-v1.jar"]
#
#
#FROM gradle:4.5-jdk8-alpine as builder
#USER root
#WORKDIR /builder
#ADD . /builder
#RUN gradle build --stacktrace
#
#FROM openjdk:8-jre-alpine
#WORKDIR /app
#EXPOSE 8080
#COPY --from=builder /builder/build/libs/server.jar .
#CMD ["java", "-jar", "server.jar"]

FROM openjdk
VOLUME /tmp
RUN mkdir /ministerial-scale-v1
COPY . /ministerial-scale-v1
WORKDIR /ministerial-scale-v1
RUN /work/gradlew build
RUN mv /work/build/libs/*.jar /ministerial-scale-v1/server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ministerial-scale-v1/server.jar"]