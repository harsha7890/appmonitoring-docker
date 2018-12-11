FROM openjdk:10-jdk

RUN apt-get -yqq update && apt-get -yqq install docker.io

ADD ./target/agent-0.0.1-SNAPSHOT.jar /usr/app/agent-0.0.1-SNAPSHOT.jar

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "agent-0.0.1-SNAPSHOT.jar"]

