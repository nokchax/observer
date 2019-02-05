package com.nokchax.observer.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * this class run before spring boot start.
 * logging is not work
 *
 * environment.getPropertySources() contains propertySource lists
 * if there are same name of properties, spring use first value of them
 * if you want overwrite application.yml (default properties) add propertySource in front of lists not end of them
 */
public class EnvironmentsPostProcessorImpl implements EnvironmentPostProcessor {
    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
    private static final List<String> sourceFiles = Arrays.asList(
            "/data/etc/observer/token.yaml"
    );

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        sourceFiles.forEach(
                path -> environment.getPropertySources()
                .addFirst(loadYaml(new FileSystemResource(path)))
        );
    }

    //todo if path not exist pass source and log it
    private PropertySource<?> loadYaml(Resource path) {
        if(!path.exists())
            throw new IllegalArgumentException("Resource " + path + " does not exist");

        try {
            return this.loader.load("custom-resource", path).get(0);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load yaml configuration from " + path, e);
        }
    }
}
