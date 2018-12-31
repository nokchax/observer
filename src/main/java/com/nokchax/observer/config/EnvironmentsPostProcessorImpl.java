package com.nokchax.observer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class EnvironmentsPostProcessorImpl implements EnvironmentPostProcessor {
    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
    private static final List<String> sourceFiles = Arrays.asList(
            "/data/etc/observer/token.yaml"
    );

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        log.info("Start load custom properties");
        sourceFiles.forEach(path -> {
            Resource resource = new FileSystemResource(path);
            environment.getPropertySources().addLast(loadYaml(resource));
        });
        log.info("End load custom properties");
    }

    private PropertySource<?> loadYaml(Resource path) {
        log.info("Start Load file : {}", path.getFilename());
        if(!path.exists())
            throw new IllegalArgumentException("Resource " + path + " does not exist");

        try {
            return this.loader.load("custom-resource", path).get(0);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load yaml configuration from " + path, e);
        }
    }
}
