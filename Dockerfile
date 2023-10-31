FROM openjdk:17
# Define argument variables
ARG user=admin
ARG group=cliente
ARG uid=1000
ARG gid=1000

# Create user and group with specified UID and GID
RUN groupadd -g ${gid} ${group} && useradd -u ${uid} -g ${group} -s /bin/sh ${user}

USER admin:cliente
VOLUME /tmp
# Set the working directory to /app
WORKDIR /app

# Copy the JAR file into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Set environment variable for Java options
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]
