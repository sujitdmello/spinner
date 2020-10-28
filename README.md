## Simple Java Spring Boot app that consumes CPU

This was written primarily as a way to understand how Azure Spring Cloud handles high-CPU conditions
Once deployed, you can run the app locally and access it as follows:

```
mvn package -DskipTests
java -jar target/spinner-0.0.1-SNAPSHOT.jar
```
Then in another terminal, issue the following command:

```
curl http://localhost:8080/sleep?time=sleep_time_in_seconds
```

This will cause the JVM process to comsume 1 CPU as much as possible for the number of seconds in the query string parameter. The call may actually timeout before it completes executing so keep in mind that the JVM will still 'spin' even after the curl command returns, until the number of seconds requested has expired. 

It also logs a message to the standard out every 5 seconds so you can monitor the progress of the app via some monitoring console.

```
Elapsed time is 0 seconds
Elapsed time is 5 seconds
Elapsed time is 1 seconds
Elapsed time is 6 seconds
Elapsed time is 11 seconds
Elapsed time is 16 seconds
Elapsed time is 21 seconds
Elapsed time is 26 seconds
Elapsed time is 31 seconds
Elapsed time is 36 seconds
Elapsed time is 41 seconds
...
```