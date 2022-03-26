package de.dps.configupdater.config;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "config.mock")
@ToString
@Getter
@Setter
@JsonRootName("config.mock")
public class MockConfig {
    Map<String, Map<Integer, Integer>> random;
    Map<String, Map<Integer, String>> feature;
}
