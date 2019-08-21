package com.example.demo.karate;

import com.example.demo.server.ServerStart;
import com.example.demo.server.ServerStop;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@KarateOptions(tags = "~@ignore")
//@CucumberOptions(features = "classpath:karate")
public class KarateTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        ServerStart server = new ServerStart();
        server.start(new String[]{"--server.port="+System.getenv("DEMO_PORT")});
        System.out.println("Application Started on "+System.getenv("DEMO_PORT")+" !!!");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        new ServerStop().stopServer(Integer.parseInt(System.getenv("DEMO_PORT")));
        System.out.println("Application Stopped !!!");
    }

}
