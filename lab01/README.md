# NOTES ON LAB01 WEATHER PROJECT

The entire build cycle can be managed from the command line, which makes Maven a convenient tool across multiple operating systems and in continuous integration scenarios
```
$ mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

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

###Build the Project -> mvn package
```
mvn exec:java -Dexec.mainClass="package.App"
mvn exec:java -Dexec.mainClass="test.Main" -Dexec.args="arg1 arg2 arg3"
```

In a simple project, for example weather forecast project in LAB01, we will need:
 -> to open a HTTP connection
 -> create a well-formatted GET request
 -> get the JSON response
 -> process the response content
 Instead of programming all these (demanding) steps by hand, we should use a good library, or, in Maven terms, an artifact.

Gson: Java library used to convert Java Objects into their JSON representation
Square's Retrofit: a type-safe HTTP client for Java that allows mapping an external REST API into a local (Java) interface.
Declare both dependencies in your POM

---------------------------------------------------------------------------------------------------------------------------

##DOCKER

What is a container?
 -> Simply put, a container is a sandboxed process on your machine that is isolated from all other processes on the host machine.
 
What is a container image?
 -> When running a container, it uses an isolated filesystem. This custom filesystem is provided by a container image. Since the image contains the container’s filesystem, it must contain everything needed to run an application - all dependencies, configuration, scripts, binaries, etc. The image also contains other configuration for the container, such as environment variables, a default command to run, and other metadata.
 
###Dockerfile 
```
syntax=docker/dockerfile:1
FROM node:12-alpine
RUN apk add --no-cache python g++ make
WORKDIR /app
COPY . .
RUN yarn install --production
CMD ["node", "src/index.js"]
```

In the folder containing the Dockerfile:
 -> build the container image using the docker build command: 
```
docker build -t getting-started .
```
 
Start an app container
 -> Start your container using the docker run command and specify the name of the image we just created: 
```
docker run -dp 3000:3000 getting-started
```

After a few seconds, open your web browser to http://localhost:3000. You should see our app.
----------------------------------------------------------------------------------------------------------------------------

###A) Maven has three lifecycles: clean, site and default. Explain the main phases in the default lifecycle.
```
Validate-> validate the project is correct and all necessary information is available

Compile-> compile the source code of the project

Test-> test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed

Package-> take the compiled code and package it in its distributable format, such as a JAR.

Verify-> run any checks on results of integration tests to ensure quality criteria are met

Install-> install the package into the local repository, for use as a dependency in other projects locally

Deploy-> done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.
```

###B) Maven is a build tool; is it appropriate to run your project to?
```
Yes, it is. Maven main purpose is to configure projects and handle the build activities and resulting artifacts but t can also activate different plugins which can be used to execute(run) specific classes.
```

###C) What would be a likely sequence of Git commands required to contribute with a new feature to a given project? (i.e., get a fresh copy, develop some increment, post back the added functionality)
```
git pull
```
To get the most recent changes of the code.

```
git add .
```
To add the files we want to update.
Parameter "." means we're selecting everything from the repository.

```
git commit -m "Lab01 completed"
```
To commit the changes. It requires parameter -m followed by a commit message.

```
git push
```
To update the repository with the newly committed changes.

###D) There are strong opinions on how to write Git commit messages… Find some best practices online and give your own informed recommendations on how to write good commit messages (in a team project).
```
Commit messages are important because they give us a generalized idea of what is going on in the current code and to know what was updated or removed, so other colaboratores can be on the same page. The contributors to these repositories know that a well-crafted Git commit message is the best way to communicate context about a change to fellow developers

7 rules:
Separate subject from body with a blank line
Limit the subject line to 50 characters
Capitalize the subject line
Do not end the subject line with a period
Use the imperative mood in the subject line
Wrap the body at 72 characters
Use the body to explain what and why vs. how


Example:
# Bad
git commit -m "Fix bug"

# Good
git commit -m "Add auto login for verified users - Closes BLG-20"

```

E) Docker automatically prepares the required volume space as you start a container. Why is it important that you take an extra step configuring the volumes for a 
(production) database?
```
Volumes help you decouple the configuration of the Docker host from the container runtime. When you want to store your container's data on a remote host or a cloud provider, rather than locally. When you need to back up, restore, or migrate data from one Docker host to another, volumes are a better choice.
Dedicated resources makes data safer agaisnt problems like container deletion and it is aso easier to backup production databases.
```
