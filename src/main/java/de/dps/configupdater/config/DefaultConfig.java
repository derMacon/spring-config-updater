package de.dps.configupdater.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Iterator;

@Configuration
public class DefaultConfig {

    private static class MyObjMapper extends ObjectMapper {

        private final ObjectMapper objectMapper;
        private final Iterator<String> rootPrefix;


        public MyObjMapper(String prefix) {
            this.objectMapper = new ObjectMapper(new YAMLFactory());
            this.rootPrefix = Arrays.asList(prefix.split("\\.")).iterator();
        }

        public <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException, JsonMappingException {
            Iterator<JsonNode> objectNode = objectMapper.readTree(content).iterator();
            if (objectNode != null
                    && objectNode.hasNext()
                    && rootPrefix.hasNext()
                    && content
                    .replaceAll("\\{", "")
                    .replaceAll("\\\"", "")
                    .startsWith(rootPrefix.next())
            ) {
                System.out.println("test");
                return readValue(objectNode.next().toString(), valueType);
            }
            return objectMapper.readValue(content, valueType);
        }

    }



    @Bean
    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.readerFor(MockConfig.class)
//                .withRootName("config:mock");
//        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        return objectMapper;


//        ObjectMapper myObjMapper = new ObjectMapper() {
//
//        };

        return new MyObjMapper("config.mock");
    }

}
