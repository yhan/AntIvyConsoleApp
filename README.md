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
## 1. Java home
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

Put jdk 22 before PATH
```
export JAVA_HOME=/home/yhan/.jdks/openjdk-22.0.1
export PATH=$JAVA_HOME/bin:$M2_HOME/bin:/snap/rider/471/bin:$HOME/.dotnet/tools:/usr/lib/x86_64-linux-gnu/libstdc++.so.6:$PATH
```


Ant: Explicitely run test by calling java:  
looking in production compilation result in `build`, test classes in `build/test-classes` and lib:
```
java -cp "build:build/test-classes:lib/*" org.junit.platform.console.ConsoleLauncher --select-class MainTest
```


## 2. JUnit 
Trap:  
> ant has his default junit 4 


in ant build.xml file:   
```xml
    <target name="test" depends="compile-test">
        <mkdir dir="${build.dir}/test-results"/>

        <junit printsummary="yes" haltonfailure="yes">
            <classpath>
                <pathelement location="${test.build.dir}"/>
                <pathelement location="${build.dir}"/>
                <fileset dir="${lib.dir}">
                    <include name="**/*.jar"/>
                </fileset>
            </classpath>

            <formatter type="plain"/>
            <formatter type="xml"/>

            <batchtest fork="yes" todir="${build.dir}/test-results">
                <fileset dir="${test.dir}">
                    <include name="**/*Test.java"/>
                </fileset>
            </batchtest>
        </junit>
    </target>
```

`ant clean compile-test test` fails: with 

```
build\test-result\test-maintest.txt:
Testsuite: MainTest
Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.055 sec

Testcase: initializationError took 0.001 sec
	Caused an ERROR
Invalid test class 'MainTest':
  1. No runnable methods
org.junit.runners.model.InvalidTestClassError: Invalid test class 'MainTest':
  1. No runnable methods
	at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:502)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)
```


Run this to diagnose, idea is have a look at the java classpath:
```
ant -verbose test | grep "classpath"
```
you see ant involved junit4
```
[junit] Implicitly adding /snap/ant/25/lib/ant-launcher.jar:/snap/ant/25/lib/ant.jar:/snap/ant/25/lib/ant-junit.jar:/snap/ant/25/lib/ant-junit4.jar to CLASSPATH
```

Change the build.xml

```xml
    <target name="test" depends="compile-test">
        <mkdir dir="${build.dir}/test-results"/>

        <java classname="org.junit.platform.console.ConsoleLauncher" fork="true">
            <classpath>
                <pathelement location="${build.dir}/test-classes"/>  <!-- ✅ Test compiled classes -->
                <pathelement location="${build.dir}"/>
                <fileset dir="${lib.dir}">  <!-- ✅ Include JUnit 5 JARs -->
                    <include name="**/*.jar"/>
                </fileset>
            </classpath>

            <arg value="--select-class=MainTest"/> <!-- works for only one test class -->
            <arg value="--scan-classpath"/>  <!-- works by scanning all -->
            <arg value="--reports-dir=${build.dir}/test-results"/>

        </java>
    </target>
```

## 3. added junit lib to dependencies, now test run correctly in intellij
Problem is that Intellij does not look for the junit dependencies correctly.  

After have done `ant resolve`, the dependencies are in `./lib` folder.   

`ant test` will find the class because `test` target enforced the classpath by `<pathelement location="${build.dir}/test-classes"/>  <!-- ✅ Test compiled classes -->`.  
But intellij won't.

Solution:

Manually Add lib/ as a "Library" in IntelliJ (Best Option)
 * Go to File → Project Structure → Modules → Dependencies.
 * Click ➕ (Add) → JARs or Directories.
 * Select lib/ from your project.
 * Set Scope to "Test".
 * Click Apply → OK.

Why you have to do this?  lib/ is in the classpath for both produciton & test code
```
  <!-- Compile Main Source Code -->
    <target name="compile">
        <mkdir dir="${build.dir}"/>
        <javac srcdir="${src.dir}" destdir="${build.dir}" includeantruntime="false">
            <classpath>
                <fileset dir="${lib.dir}">
                    <include name="**/*.jar"/>
                </fileset>
            </classpath>
        </javac>
    </target>

    <!-- Compile Test Classes -->
    <target name="compile-test" depends="compile">
        <mkdir dir="${test.build.dir}"/>
        <javac srcdir="${test.dir}" destdir="${test.build.dir}" includeantruntime="false">
            <classpath>
                <pathelement location="${build.dir}"/>

                <fileset dir="${lib.dir}">
                    <include name="**/*.jar"/>
                </fileset>
            </classpath>
        </javac>
    </target>
```

how intellij can detect lib for production code, but not test code; and i have to add lib/ to module -> dependencies with Scope=Test ? 

Your Ant build script includes lib/ in the classpath for both production and test code, but IntelliJ does not automatically apply it to test code.  

__Production Code Works Automatically__   

lib/ is included in the Ant compile target.    
IntelliJ scans src/ and applies lib/ automatically.    

__Test Code Fails in IntelliJ__  

lib/ is NOT explicitly marked for tests inside IntelliJ.    
IntelliJ does NOT read compile-test target when resolving classpaths for test code.    
It only looks at the test folder and its manually assigned dependencies.   


## 4. IntelliJ IDEA is not recognizing your test folder as a valid source root, meaning your test files won’t be compiled.

![image](https://github.com/user-attachments/assets/f50e3a21-91cb-4771-8068-d8f3bf77308d)


🛠 Fix 1: Mark test as a Test Source Root  
1️⃣ Right-click on the test folder in IntelliJ.  
2️⃣ Select "Mark Directory as" → "Test Sources".  
3️⃣ The test folder should turn green (indicating it's a test source root).  
4️⃣ Rebuild the project:

Click Build → Rebuild Project  [Main.class](../temp/org/apache/ivy/Main.class)
OR run Ctrl + Shift + F9 (Recompile)  
🚀 Now IntelliJ should recognize and compile your test files!  


## 5. ivy jar should be part of source code

``` show ivy version
java -jar ./ivylib/ivy-2.5.3.jar -version
```
Ivy the dependency resolver for ant. The ivy jar should be available for the resolving system.  
In build.xml, we have:  

```xml
 <!-- Register Ivy Task -->
    <taskdef resource="org/apache/ivy/ant/antlib.xml" uri="antlib:org.apache.ivy.ant">
        <classpath>
            <pathelement location="${ivylib.dir}/ivy-2.5.3.jar"/>
        </classpath>
    </taskdef>
```