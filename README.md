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


