package de.dps.configupdater.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dps.configupdater.config.MockConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConfigPropsService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockConfig mockConfig;

    @SneakyThrows
    public String getMockConfigJson() {
        return mockConfig.toString();
    }

    @SneakyThrows
    public void overrideMockConfigJson(String mockConfigContent) {
        this.mockConfig = objectMapper
                .readValue(mockConfigContent, MockConfig.class);
        log.info("mockConfig: {}", mockConfig);
    }

}
