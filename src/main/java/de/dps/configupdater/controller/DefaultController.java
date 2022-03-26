package de.dps.configupdater.controller;

import de.dps.configupdater.service.ConfigPropsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DefaultController {

    @Autowired
    private ConfigPropsService configPropsService;

    @RequestMapping("/version")
    public String version() {
        String version = "v1.0";
        log.info("version: {}", version);
        return version;
    }

    @RequestMapping("/getConfigProps")
    public String getConfigProps() {
        return configPropsService.getMockConfigJson();
    }

    @RequestMapping("/overrideProps")
    public void updateConfigProps() {
        String testVal = "config:\n" +
                "  mock:\n" +
                "    random:\n" +
                "      objA1:\n" +
                "        100: 10\n" +
                "        101: 10\n" +
                "      objA2:\n" +
                "        102: 10\n" +
                "        103: 10\n" +
                "    feature:\n" +
                "      objB1:\n" +
                "        200: \"feat0\"\n" +
                "        201: \"feat1\"\n" +
                "      objB2:\n" +
                "        202: \"feat2\"\n" +
                "        203: \"feat3\"\n";

        this.configPropsService.overrideMockConfigJson(testVal);
    }

}
