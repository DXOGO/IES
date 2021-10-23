NOTES ON LAB01 WEATHER PROJECT (LEARNING MAVEN)

The entire build cycle can be managed from the command line, which makes Maven a convenient tool across multiple operating systems and in continuous integration scenarios

$ mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

Note: “-D” switch is used to define/pass a property to Maven in CLI.

groupId uniquely identifies your project across all projects. This means it starts with a reversed domain name you control. eg. org.apache.maven, org.apache.commons

artifactId is the name of the jar without version. 
If you created it, then you can choose whatever name you want with lowercase letters and no strange symbols. If it's a third party jar, you have to take the name of the jar as it's distributed.
eg. maven, commons-math

----------- standard project structure.
my-app
|-- pom.xml
`-- src
    |-- main
    |   `-- java
    |       `-- com
    |           `-- mycompany
    |               `-- app
    |                   `-- App.java
    `-- test
        `-- java
            `-- com
                `-- mycompany
                    `-- app
                        `-- AppTest.java
                        
src/main/java: contains the project source code
src/test/java: contains the test source
pom.xml file: project's Project Object Model, or POM (the core of a project's configuration in Maven. It is a single configuration file that contains the majority of information required to build a project in just the way you want)

Build the Project -> mvn package
mvn exec:java -Dexec.mainClass="package.App"
mvn exec:java -Dexec.mainClass="test.Main" -Dexec.args="arg1 arg2 arg3"

In a simple project, for example weather forecast project in LAB01, we will need:
 -> to open a HTTP connection
 -> create a well-formatted GET request
 -> get the JSON response
 -> process the response content
 Instead of programming all these (demanding) steps by hand, we should use a good library, or, in Maven terms, an artifact.

Gson: Java library used to convert Java Objects into their JSON representation
Square’s Retrofit: a type-safe HTTP client for Java that allows mapping an external REST API into a local (Java) interface.
Declare both dependencies in your POM


---------------------------------------------------------------------------------------------------------------------------

DOCKER

What is a container?
 -> Simply put, a container is a sandboxed process on your machine that is isolated from all other processes on the host machine.
 
What is a container image?
 -> When running a container, it uses an isolated filesystem. This custom filesystem is provided by a container image. Since the image contains the container’s filesystem, it must contain everything needed to run an application - all dependencies, configuration, scripts, binaries, etc. The image also contains other configuration for the container, such as environment variables, a default command to run, and other metadata.
 
Dockerfile 
# syntax=docker/dockerfile:1
FROM node:12-alpine
RUN apk add --no-cache python g++ make
WORKDIR /app
COPY . .
RUN yarn install --production
CMD ["node", "src/index.js"]

In the folder containing the Dockerfile:
 -> build the container image using the docker build command: 'docker build -t getting-started .'
 
Start an app container
 -> Start your container using the docker run command and specify the name of the image we just created: 'docker run -dp 3000:3000 getting-started'
After a few seconds, open your web browser to http://localhost:3000. You should see our app.
