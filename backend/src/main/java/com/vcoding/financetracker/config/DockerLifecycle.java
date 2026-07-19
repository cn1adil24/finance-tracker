package com.vcoding.financetracker.config;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class DockerLifecycle {

    private static final Logger log = LoggerFactory.getLogger(DockerLifecycle.class);

    @Value("${docker.compose.dir:../docker}")
    private String composeDir;

    @PreDestroy
    public void stopContainers() {
        stop("Postgres", composeDir);
    }

    private void stop(String name, String dir) {
        try {
            new ProcessBuilder("docker", "compose", "down")
                    .directory(new File(dir))
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
            log.warn("Failed to stop {} container", name, e);
        }
    }
}
