# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Stage 2: Run the application
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/UserServiceApi-0.0.1-SNAPSHOT.jar user-service.jar
EXPOSE 8080
CMD ["java", "-jar", "user-service.jar"]

#sudo docker run -d -p 80:8080 adityachauhan2703/user-servicev1:v1
#52f8dc20b42b0b62cecb18d2eab5657092caa42658ecbab1af3a3c74f5d78797



#
#
#
#docker buildx build --platform linux/amd64 -t user-service:latest .

#docker tag user-service:latest adityachauhan2703/user-service:v1

#docker push adityachauhan2703/user-service:v1

#sudo docker run -d -p 80:8080 adityachauhan2703/user-service:v1
#sudo docker run -d -p 80:8081 --network=twotier adityachauhan2703/user-service:v1

#sudo docker logs 658c4806b0ac1fc6201eb18dfe6a087488d44f592ff19360cda4c4912fece28e


#docker network inspect twotier
#docker network create twotier
#docker run -d \
#    --name mysql \
#    -v mysql-data:/var/lib/mysql \
#    --network=twotier \
#    -e MYSQL_DATABASE=root \
#    -e MYSQL_ROOT_PASSWORD=admin \
#    -p 3306:3306 \
#    mysql:5.7

















