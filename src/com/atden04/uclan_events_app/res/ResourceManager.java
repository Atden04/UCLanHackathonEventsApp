package com.atden04.uclan_events_app.res;

import java.net.URL;

public class ResourceManager {

    public static URL getFxml(String name) {
        var url = ResourceManager.class.getResource(name);
        if(url == null) {
            throw new RuntimeException("Resource not found: "+name);
        }
        return url;
    }

    public static URL getImageUrl(String imagePath) {
        var url = ResourceManager.class.getResource(imagePath);
        if(url == null) {
            throw new RuntimeException("Resource not found: "+imagePath);
        }
        return url;
    }

    public static URL getCss(String name) {
        var url = ResourceManager.class.getResource(name);
        if(url == null) {
            throw new RuntimeException("Resource not found: "+name);
        }
        return url;
    }
}
