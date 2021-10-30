# **Lab 02 - 98595**

## Notes on Lab02.1 - **Java at the server-side and the role of application containers**

A Servlet is a Java
class that runs at the server, handles (client) requests, processes them, and reply with a response. When an application running in a web server
receives a request, the Server hands the request to
the Servlet Container which in turn passes it to the
target Servlet.

### Running **Tomcat** server

Inside *< path to Tomcat >/bin folder*:

```
chmod 744 setup.sh
chmod 744 catalina.sh
./startup.sh
```

We can see the server is running by:

```
curl -I 127.0.0.1:8080
```

OR access the default page in the browser: <http://localhost:8080>

### Give manager permissions

In *tomcat-users.xml* inside apache-tomcat/conf:

```
  <role rolename="manager-gui"/>
  <role rolename="manager-script"/>
  <user username="dxogo" password="dxogo" 
roles="manager-gui,manager-script"/>
```

### To Start/Stop TomCat

Inside *< path to Tomcat >/bin folder*:

```
./catalina.sh stop
./startup.sh
```

### Check -> [**Source Code for Request Parameters**](http://localhost:8080/examples/servlets/reqparams.html)

Note the '*extends HttpServlet*' in the *Java* class

## Create a web application and deploy it into Tomcat

```
mvn archetype:generate -DgroupId=com.dxogo -DartifactId=tomcat_webapp -DarchetypeArtifactId=webapp-javaee7 -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeVersion=1.1 -DinteractiveMode=false
```

## Exercise h) Important information to retain

- We create **Java** project on *com.dxogo*, execute '```$mvn package```' and deploy the .*war* file in */target* in the [TomCat Manager](http://localhost:8080/manager) (we might have to undeploy the old version first). After that we open the web server in:

 ```
 <http://localhost:8080//<webapp_name>/<server_url>
 ```

- *webapp_name* : composed by *ArtifactId*+*version* (in our case it is **tomcat_webapp-1.0-SNAPSHOT**)
- *server_url* : defined in the *Java* app on :  ```@WebServlet(name = "server_name", urlPatterns = {"/server_url"})```

- In this case the URL is **MyFirstServlet**

\
\
.

## Notes on Lab02.2 - **Server-side programming with embedded servers**

Most times, it is easier to write an application and a jetty server together rather writing an application and deploying a WAR file on jetty server. It saves time and keeps things simple with application handling.

### **Steps**

1) Create a Maven Project
2) Modify pom.xml to add some dependencies like ***jetty-server*** and ***jetty-servlet***
3) Create **Java** project in *src->main->java*
4) You can run this project in eclipse by executing the **Java** code. This runs an HTTP server on port *8680*.

### [-> Embedded Jetty Server Example](https://examples.javacodegeeks.com/enterprise-java/jetty/embedded-jetty-server-example/)

\
\
.

## Notes on Lab02.3 - **Lab 2 Introduction to web apps with a full-featured framework (Spring Boot)**

**Spring Boot** is a convention-over-configuration addition to the Spring
platform, useful to get started with minimum effort and create stand-alone, production-grade
applications.

[Spring Initializr](https://start.spring.io/) templates contain a collection of all the relevant transitive dependencies that are needed to start a particular functionality and will simplify the setup of the POM. Be sure to add the *Spring web* dependency.

Running ```./mvnw spring-boot:run``` and access your browser at <http://localhost:8080/> (8080 if default port) you should retrieve a page produced by Spring
Boot.

#### **Attention**: port *8080* is also Tomcat's port so make sure it's not running at the moment

### To change the port

- On *main/java/resources/**application.propreties*** write ```server.port=XXXX```

On ***GreetingController.Java*** we define:
```@GetMapping("/greeting")```

This ensures that HTTP GET requests to **/greeting** are mapped to the greeting() method and we can see our written code in *<http://localhost:8080>*/***greeting*** in this specificic case.

### Important to read

## **[Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/#initial)**
\
\
.

## Notes on Lab02.4 - **Lab 2 Wrapping-up & integrating concepts**

**A**. What are the responsibilities/services of a “servlet container”?
\
Answer:

**B**. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)
\
Answer:

**C**. Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies?
\
Answer:

**D**. Which annotations are transitively included in the @SpringBootApplication?
\
Answer:

**E**. Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them   in you own words.
\
Answer: