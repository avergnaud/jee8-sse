# SSE

* WildFly18 [https://wildfly.org/news/2019/10/03/WildFly18-Final-Released/](https://wildfly.org/news/2019/10/03/WildFly18-Final-Released/)
* java 11
* JEE 8 JAX-RS 2.1

[https://www.baeldung.com/java-ee-jax-rs-sse](https://www.baeldung.com/java-ee-jax-rs-sse)

/Users/adrien/Documents/wildfly-18.0.0.Final/bin
http://127.0.0.1:9990/console/index.html

```
curl -N --http2 -H "Accept:text/event-stream" http://127.0.0.1:8080/sse/api/stock/prices
```

![jee8-sse](jee8-sse.gif)

something else
A B C
