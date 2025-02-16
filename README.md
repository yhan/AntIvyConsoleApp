# AntIvyConsoleApp


Install Plugins:
--
* Ant
* IvyIDEA

Ant
--
Ant command:
Like msbuild, run with `target` name:
```
ant clean resolve compile
ant run
```
Ivy
--

## Setup
1. Add Ivy Module:  
File > Project Structure ...
![image](https://github.com/user-attachments/assets/a8d207c6-dece-4d90-99c1-bf6bcc7fb521)


2. Once specified dependencies in ivy.xml file, right click on ivy.xml or ivysettings.xml:

![image](https://github.com/user-attachments/assets/0d8fecd8-e943-43b7-894f-9dd46e7becc2)

3. build Ivy report to show dependencies tree
   ```
   ant report
   ```

## Configure ant target in intellij

`Run > Edit configurations: `  

![image](https://github.com/user-attachments/assets/caf170f4-9bd5-466a-9036-899ec9c149af)


Troubleshoot
--
## Java home
if you installed sudo apt install java, you may have:
```
yhan@yhan-XPS-15-9500:~/IdeaProjects/AntConsoleApp$ ls /usr/bin/java
/usr/bin/java
yhan@yhan-XPS-15-9500:~/IdeaProjects/AntConsoleApp$ /usr/bin/java -version
openjdk version "21.0.5" 2024-10-15
OpenJDK Runtime Environment (build 21.0.5+11-Ubuntu-1ubuntu122.04)
OpenJDK 64-Bit Server VM (build 21.0.5+11-Ubuntu-1ubuntu122.04, mixed mode, sharing)

```

This is the default java/javac path. ant use this version of java. This path has precedence over JAVA_hoME you ve written in .bashrc, even if you have:  
```
export JAVA_HOME=/home/yhan/.jdks/openjdk-22.0.1
export PATH=${M2_HOME}/bin:/snap/rider/471/bin:$HOME/.dotnet/tools:/usr/lib/x86_64-linux-gnu/libstdc++.so.6:$JAVA_HOME:${PATH}
```
because /usr/bin is by default in PATH, if you want ant to take java 22, you have to put java22 before concat to default PATH:  

in this situaiton, you compile with ant and run test 

```
Caused by: java.lang.UnsupportedClassVersionError: MainTest has been compiled by a more recent version of the Java Runtime (class file version 66.0), this version of the Java Runtime only recognizes class file versions up to 65.0
```


```
export JAVA_HOME=/home/yhan/.jdks/openjdk-22.0.1
export PATH=$JAVA_HOME/bin:$M2_HOME/bin:/snap/rider/471/bin:$HOME/.dotnet/tools:/usr/lib/x86_64-linux-gnu/libstdc++.so.6:$PATH
```




