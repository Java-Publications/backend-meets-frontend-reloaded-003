# backend-meets-frontend-reloaded-001
A Vaadin 10 Tutorial for Core Java Developers - Part 01

## Target of this Tutorial
Target of this tutorial is the development of an industrial style project.
We will cover here in this part
* how to initialize the project
* how to handle different JDK venders and versions
* how to ramp up a Vaadin 10 project

Have in mind, that this is only the first part of the tutorial.

## technical information's
To explore all possibilities of this tutorial you need docker installed.
Additionally docker-compose if you want to have a look at the TDD part
that includes full stack tests with Testbench.
Notice: Testbench is a commercial product from Vaadin that is available here [https://vaadin.com/testbench](https://vaadin.com/testbench)
To play around, you can request a trial lic.

### Servlet - Container
For this tutorial we are using Meecrowave from Apache Open-Webbeans - Team
This is based on Tomcat, but more in a SpringBoot style.
So we are able to manage the complete container with a few lines of code like the following.

```java
public class BasicTestUIRunner {
  private BasicTestUIRunner() { }

  public static void main(String[] args) {
    new Meecrowave(new Meecrowave.Builder() {
      {
//        randomHttpPort();
        setHttpPort(8080);
        setTomcatScanning(true);
        setTomcatAutoSetup(true);
        setHttp2(true);
      }
    })
        .bake()
        .await();
  }
}
``` 

To start the App, invoke the main method from the class **BasicTestUIRunner**.
The Meecrowave is started at Port **8080**. But have in mind, that you can use a random port 
with **randomHttpPort();**. This is very usefull for concurrent UI Tests later.
But be patient, we will explore this together..  

Meecrowave will is offering a maven plugin as well.
This is not needed if you don´´ want to use it. But it is convenient if
you want to start the container inside docker for development purposes.

For this have a look at the file **docker_run_locale.sh** 
How this is done and how to use this, I will explain later, as well.


## Coding styles
One thing that we are using here is the Functional Approach with Core Java.
Here we are using functional aspects, to structure the code as much as possible.
All of this can be expressed in OO - Style as well. But, as always, personal 
flavour will have an impact of this tutorial code.

### UI Code
The UI Code here is written in a way to be as much as possible
readable. This was one point to decide, that I am using here the **double curly brace initial style**
A lot of discussions are done about this, and a lot of traditionally developers are complaining 
that this will lead to a bigger amount of anonymous classes. Yes, you are right, this will lead to more
classes compared to the pure usage of the existing classes. And it will lead to 
distributed initializations. Compared to other languages like kotlin or scala
the **double curly** style is not creating more classes. If you want to check, what your GC is doing,
use the following flags **-XX:+TraceClassLoading** and **-XX:+TraceClassUnloading**. 

There is one important thing to know. The instance of this is bound to the life cycle 
of the holding instance/class. This means, don´t share this dynamic created instances.
But, who is sharing Action-Listeners? Well, same here. Don´t share an instance of a button.
Use events instead! I will show how to do this.

  

 