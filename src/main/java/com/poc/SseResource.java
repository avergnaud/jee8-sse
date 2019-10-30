package com.poc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Path("stock")
public class SseResource {

    private Sse sse;
    private OutboundSseEvent.Builder eventBuilder;

    @Context
    public void setSse(Sse sse) {
        this.sse = sse;
        this.eventBuilder = sse.newEventBuilder();
    }

    @GET
    @Path("prices")
    @Produces("text/event-stream")
    public void getStockPrices(@Context SseEventSink sseEventSink) {

        for(int i=0; i<4; i++) {

            Stock stock = new Stock(i, BigDecimal.valueOf(i), LocalDateTime.now());

            OutboundSseEvent sseEvent = this.eventBuilder
                    .name("stock")
                    .id(""+i)
                    .mediaType(MediaType.APPLICATION_JSON_TYPE)
                    .data(Stock.class, stock)
                    .reconnectDelay(5000)
                    .comment("price change")
                    .build();
            sseEventSink.send(sseEvent);

            try {
                //Wait 2 seconds
                Thread.sleep(2 * 1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        sseEventSink.close();
    }
}
