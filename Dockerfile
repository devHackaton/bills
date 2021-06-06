FROM openjdk:11-jdk
ADD target/bills-1.0.jar bills.jar
ENV TZ=Europe/Moscow
ENTRYPOINT exec java $JAVA_OPTS -jar /bills.jar