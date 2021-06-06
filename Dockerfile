FROM openjdk:11-jdk
ADD target/bills-1.0-SNAPSHOT-1.0.jar bills-1.0-SNAPSHOT.jar
ENV TZ=Europe/Moscow
ENTRYPOINT exec java $JAVA_OPTS -jar /bills-1.0-SNAPSHOT.jar