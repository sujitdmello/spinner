package com.microsoft.cse.spinner;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SpinnerController {
    int load = 1;
	@GetMapping("/sleep")
    public String index(@RequestParam(value = "time", defaultValue = "10") String sleepTime)
    throws InterruptedException 
        {
        Long sleepInternval = Long.parseLong(sleepTime);
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        long currentCount = 0;
        long lastLogCount = 0;
        long maxCount = Integer.MAX_VALUE * sleepInternval;
        // Loop for the given duration
        while (currentCount  < maxCount) {
            if (currentCount % (Integer.MAX_VALUE * 5) == 0) {
                if (lastLogCount != currentCount){
                    lastLogCount = currentCount;
                    elapsedTime = System.currentTimeMillis() - startTime;
                    System.out.println("Elapsed time is " + elapsedTime/1000 + " seconds");
                }
            }
            currentCount ++;
        }        
        long currentTime =System.currentTimeMillis();

 		return "Greetings from Spring Cloud after " + (currentTime - startTime)/1000 + " seconds.\n";
	}

}