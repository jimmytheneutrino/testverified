## How to compile to native image

### Prerequisites

* Download GraalVM 20.0.0 Java 8 Community Edition from https://github.com/graalvm/graalvm-ce-builds/releases for your platform
* Extract it to some directory
* Set environments variables for using GraalVM as your default Java installation :

##### Windows

```
set JAVA_HOME=<path to graalvm 20.0.0 java8 CE>
set PATH=%JAVA_HOME%\bin;%PATH%
```

##### Linux / MacOS X

```
export JAVA_HOME=<path to graalvm 20.0.0 java8 CE>
export PATH=$JAVA_HOME/bin:$PATH
```

* Install GraalVM native image :

```
gu install native-image
```

* Install prerequisites for building native executables on your platform :

```
Windows: Windows 7.1 SDK
Linux: glibc, zlib
MacOS X: xcode
```


### Running GraalVM agent

This step is used to generate platform specific GraalVM configuration files, which are mandatory for building the native image :

```
mvnw -Pagent clean package
```

This step will execute the application, opening the SWT Hello World window using standard GraalVM java virtual machine (non native mode).
This is necessary so that GraalVM can profile the application.
Once the SWT window is opened, you can safely close it and the agent will generate configuration files for reflection, JNI, resources and proxies in the folder ``graal/youros``.

### Creating the native image

Note: if under Windows, don't forget to execute this command with the `Windows SDK 7.1 command prompt`.

```
mvnw -Pnative clean package
```


### Testing the native image

```
cd target
swt-native-hello-world
```