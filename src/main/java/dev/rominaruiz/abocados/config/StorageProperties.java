package dev.rominaruiz.abocados.config;

import org.springframework.stereotype.Component;

@Component
public class StorageProperties {
    
    String Location = "src/main/resources/static/images";

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }
    
}