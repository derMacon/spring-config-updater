package de.dps.configupdater.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ToString
@Getter
@Setter
public class TestPojo {
    private String name;

    public TestPojo() {
        this.name = "testtestname";
    }
}
