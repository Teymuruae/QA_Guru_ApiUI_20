package tests.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/config.properties"
})

public interface Configs extends Config {

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("baseUrl")
    String getBaseUrl();
}
