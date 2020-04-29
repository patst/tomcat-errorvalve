# Tomcat error report valve configuration

The error page for the Tomcat ErrorReportValve is not configurable.

There are errors like invalid URls which trigger the internal error page to be presented. 

This way everybody knows a Tomcat is serving the website (information disclosure).

Example URL: http://localhost:8080/[test

The tomcat ErrorReportValve can be configured by creating a custom valve (see `TomcatErrorReportValveConfiguration` class).

It would be easier to have the error page configured by the `application.properties`.

Activate the `customerrorvalve` profile to run with a custom error valve.
