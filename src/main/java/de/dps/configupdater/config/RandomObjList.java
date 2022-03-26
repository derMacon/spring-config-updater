package de.dps.configupdater.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "test")
@ToString
@Getter
@Setter
public class RandomObjList {
    private Map<String, Map<Integer, String>> lst;
}
