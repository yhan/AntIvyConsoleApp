# tar.gz
list files
-
tar -tzf file.tar.gz | less


unzip
-
tar -xzf file.tar.gz -C /targetpath [--verbose]

# top

search / type COMMAND=
quit search:  =


sort by cpu: P
sort by memory: M

display full command: c


# java


## exception
--
java.lang.Object
└── java.lang.Throwable
├── java.lang.Error       ← serious system issues (not meant to be caught)
└── java.lang.Exception   ← normal application-level exceptions
└── java.lang.RuntimeException ← unchecked exceptions


✅ Throwable includes:
--
Errors (like OutOfMemoryError, StackOverflowError)

Exceptions (like IOException, NullPointerException)


✅ Exception is for recoverable problems
--
Things you can (and often should) catch and handle.

Split into:

1. **Checked exceptions (must be declared or caught)**

   e.g., IOException, SQLException

2. **Unchecked exceptions (don’t need to be declared)**

   e.g., NullPointerException, IllegalArgumentException (these are RuntimeExceptions)

