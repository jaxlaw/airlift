package com.proofpoint.sample;

import com.proofpoint.sample.HelloConfig;

import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class HelloResource
{
    private final HelloConfig config;

    @Inject
    public HelloResource(HelloConfig config)
    {
        this.config = config;
    }

    @GET
    @Produces("text/plain")
    public String getPlainText()
    {
        if ("es".equals(config.getLanguage())) {
            return "hola mundo";
        }
        else {
            return "hello world";
        }
    }

    @GET
    @Produces("application/json")
    public String getJson()
    {
        return "{\"message\": \"hello world\"}";
    }
}