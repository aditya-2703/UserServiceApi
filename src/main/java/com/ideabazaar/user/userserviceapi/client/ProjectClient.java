package com.ideabazaar.user.userserviceapi.client;

import com.ideabazaar.user.userserviceapi.dto.ProjectDTO;
import feign.Feign;
import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.stereotype.Component;
import feign.slf4j.Slf4jLogger;

import java.util.List;


//@FeignClient(name = "projectserv  ice", url = "${projectServiceConfig.url}")
@Component
public interface ProjectClient {

    @RequestLine("GET /customproject/{id}")
    List<ProjectDTO> getAllProjectsByUserId(@Param("id") Long id);

    // Static factory method to create the Feign client instance
    static ProjectClient create() {
        return Feign.builder()
                .decoder(new GsonDecoder()) // Jackson decoder
                .encoder(new GsonEncoder()) // Jackson encoder (if you need POST/PUT requests)
                .logger(new Slf4jLogger(ProjectClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ProjectClient.class, "http://localhost:8080/api"); // Replace with your base URL
    }

}



