package com.microsoft.cse.spinner;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SpinnerController {
    int load = 1;
	@GetMapping("/sleep")
    public String index(@RequestParam(value = "time", defaultValue = "10") String sleepTime) 
        {
        Long sleepInternval = Long.parseLong(sleepTime) * 1000;
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        long lastLogTime = 0;
        long currentTime =System.currentTimeMillis();
        // Loop for the given duration
        while (currentTime - startTime < sleepInternval) {
            elapsedTime = currentTime - startTime;
            // Every 5s, print a message
            if (currentTime % 5000 == 0) {
                if (currentTime != lastLogTime) {
                    lastLogTime = System.currentTimeMillis();
                    System.out.println("Elapsed time is " + elapsedTime/1000 + " seconds");
                }
            }
            currentTime = System.currentTimeMillis();
        }
 		return "Greetings from Spring Cloud! after " + sleepTime + " seconds.\n";
	}

}