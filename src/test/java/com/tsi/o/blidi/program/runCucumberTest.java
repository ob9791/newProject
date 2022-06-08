package com.tsi.o.blidi.program;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "src/test/resources/Cucumber",
        glue = "com.tsi.o.blidi.program")


public class runCucumberTest {

}
