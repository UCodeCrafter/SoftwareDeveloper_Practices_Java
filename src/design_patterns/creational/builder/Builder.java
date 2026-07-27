package design_patterns.creational.builder;

import java.util.Map;

// Builder is a creational design pattern, used to create complex object with n no of optional fields
public class Builder {
    public static void main(String[] args) {
        System.out.println("Starting the Builder Design Pattern .............");


        CustomeHttpRequest customeHttpRequest = new CustomeHttpRequest.Builder("https://api.example.com/data")
                .method("GET")
                .build();
        System.out.println("Custom HTTP Request created: " + customeHttpRequest);
    }

}


class CustomeHttpRequest{
    //Required field
    private final String url;
    //Optional Fields
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParems;
    private final String body;
    private final int timeoutMs;
    private final String userAgent;
    private final boolean followRedirects;
    private final String proxy;

    private CustomeHttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParems = builder.queryParems;
        this.body = builder.body;
        this.timeoutMs = builder.timeoutMs;
        this.userAgent = builder.userAgent;
        this.followRedirects = builder.followRedirects;
        this.proxy = builder.proxy;
    }


    static class Builder {
        //Required field
        private final String url;
        //Optional Fields
        private String method;
        private Map<String, String> headers;
        private Map<String, String> queryParems;
        private String body = "";
        private int timeoutMs = 5000;
        private String userAgent = "CustomHttpClient/1.0";
        private boolean followRedirects = true;
        private String proxy = null;

        public Builder(String url) {
            if (!url.startsWith("http://") && !url.startsWith("https://"))
                throw new IllegalArgumentException("Url must start with 'http://  or https://' ");
            this.url = url;
        }


        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder headers(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder queryParameters(String key, String value) {
            this.queryParems.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timemout(int timeoutMs) {
            this.timeoutMs = timeoutMs;
            return this;
        }

        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder followRedirects(boolean followRedirects) {
            this.followRedirects = followRedirects;
            return this;
        }

        public Builder proxy(String proxy) {
            this.proxy = proxy;
            return this;
        }

        public CustomeHttpRequest build() {
            return new CustomeHttpRequest(this);

        }
    }

    @Override
    public String toString() {
        return "CustomeHttpRequest{" +
                "url='" + url + '\'' +
                ",\n method='" + method + '\'' +
                ",\n headers=" + headers +
                ",\n queryParems=" + queryParems +
                ",\n body='" + body + '\'' +
                ",\n timeoutMs=" + timeoutMs +
                ",\n userAgent='" + userAgent + '\'' +
                ",\n followRedirects=" + followRedirects +
                ", proxy='" + proxy + '\'' +
                '}';
    }
}


