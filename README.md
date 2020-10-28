## Simple Java Spring Boot app that comsumes CPU

This was written primarily as a way to understand how Azure Spring Cloud handles high-CPU conditions
Once deployed, you can run the app locally and access it as follows:

curl http://localhost:8080/sleep?time=sleep_time_in_seconds

This will cause the JVM process to comsume 1 CPU as much as possible for the number of seconds in the query string parameter. The call may actually timeout before it completes executing so keep in mind that the JVM will still 'spin' even after the curl command returns until the number of seconds requested has expired.