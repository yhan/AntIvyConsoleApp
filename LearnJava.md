Debug
---
agentlib:jdwp	Load the JDWP agent
transport=dt_socket	Use socket-based communication
server=n	JVM acts as client; debugger must connect to it (common in IDE attach mode)
suspend=y	JVM waits (does not run main()) until a debugger attaches
address=127.0.0.1:43249	Use this IP and port for debug connection


Debugging running process
--
Option	What it does
transport=dt_socket	Use socket for connection
server=y	JVM waits for debugger to attach
suspend=n	Do not pause, just run immediately
address=*:5005	Listen on port 5005 on all interfaces