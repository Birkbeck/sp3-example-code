# Worksheet

## The Java Platform Module System (JPMS)

Most of these exercises are run from the command line and do not require answers other than "walking through" the code steps.
If you wish to perform similar steps using an IDE (e.g., IntelliJ), then feel free to do so.

Exercise 1: Create a hello world module
-------------------------------------------

Create a "Hello world!" module. Compile, Package, and Run it.

1\) Observe the following directory structure, and check the contents of the  `module-info.java` and `Hello.java` classes.

    hello-world
    	src
    		module-info.java
    		com
    			foo
    				Hello.java

where `hello-world` is the project's name (or IntelliJ module, depending on how you wish to arrange things).

**module-info.java**

```java
module com.foo {
    // no definition yet
}
```

**com.foo.Hello.java**

```java
package com.foo;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
```

2\) Compile the module artefacts

`module-info.java` is a module descriptor file. It should be compiled along with other classes in the module.

```bash
cd hello-world
javac src/module-info.java src/com/foo/Hello.java -d dist
```

After compilation,  the`hello-world/dist` folder should include the compiled module descriptor and `Hello.class`.

```bash
hello-world
	dist
		module-info.class
		com
			foo
				Hello.class
```

3\) Run the module with `dist` folder

Add the `dist` directory to the module path to be able to resolve the `com.foo` module inside, and run the `com.foo.Hello` class inside the`com.foo` module.

```bash
java --module-path dist -m com.foo/com.foo.Hello
// Hello world!
```

4\) Package the modular app

We can package a standard Java module as a JAR (Java Archive) file. Then we can call it as a modular JAR file.

```bash
jar --create --file hello.jar --main-class=com.foo.Hello -C dist .
```

After the jar command is completed, verify that you have a `hello.jar` file in the current directory.

5\) Run the module with a modular JAR file

We can also add modular JAR files to the --module-path.

```bash
java --module-path hello.jar -m com.foo/com.foo.Hello
// Hello world!
```

6\) Link

`jlink` is a link tool for Java which has been present since Java 9. It creates a portable bundle of your application and a JRE.

For Windows:

```bash
jlink --module-path "%JAVA_HOME%/jmods;hello.jar" --add-modules com.foo --launcher hello=com.foo/com.foo.Hello --output release 
```

For *nix:

```bash
jlink --module-path $JAVA_HOME/jmods:hello.jar --add-modules com.foo --launcher hello=com.foo/com.foo.Hello --output release
```

After linking, you will have a special JRE with `Hello` module included.
You can run the module with produced launcher.

```bash
cd release
bin\hello.bat (for Windows)
./bin/hello  (for *nix)
```

Exercise 2: Control access between modules
----------------------------------------------

We will now use the `exports` and `requires` keywords to control **access** between modules.

`exports`  declares which package(s) will be readable to external modules.

`requires`  declares which module(s) is needed to read/access.

<table>
<caption>module-core directory</caption>
<colgroup>
<col style="width: 50%" />
<col style="width: 50%" />
</colgroup>
<thead>
<tr class="header">
<th>printer-client module</th>
<th>printer-impl module</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><pre><code>#printer-client
##src
###module-info.java
###com
####printer
#####client
######PrinterClient.java</code></pre></td>
<td><pre><code>#printer-impl
##src
###module-info.java
###com
####printer
#####impl
######Printer.java</code></pre></td>
</tr>
</tbody>
</table>
where `#` is the indentation level of the file/folder (directory).

In this practice exercise, you are going to experiment with the  `exports` and the `requires` keywords to understand them more easily.

**Case 1**  — When exports and requires are not declared in module descriptor.

Open the  `module-core` directory, and check that the`printer-client/module-info.java` file doesn’t include `requires` and that the`printer-impl/module-info.java` file doesn’t include `exports` keywords.

Compile the  `printer-impl` and `printer-client` modules, and notice how the Java module system prevents access when `exports` and `requires` are missed.

**Compile modules**

```
javac printer-impl/module-info.java printer-impl/src/com/printer/impl/Printer.java -d dist/printer-impl 

javac printer-client/module-info.java printer-client/src/com/printer/client/PrinterClient.java -p dist/printer-impl -d dist/printer-client 
```

**Run modules**

```bash
java --module-path dist -m com.printer.client/com.printer.client.PrinterClient
```

**Case2**  — When `exports` declared, but `requires` is not declared

Update the `printer-impl/module-info.java` descriptor file to export the  `com.printer.impl` package to other modules.

**printer-impl/module-info.java**

```java
module com.printer.impl {
    exports com.printer.impl;
}
```

Notice how the Java module system prevents access when `requires` is missed.

**Compile modules**

```java
javac printer-impl/module-info.java printer-impl/src/com/printer/impl/Printer.java -d dist/printer-impl 

javac printer-client/module-info.java printer-client/src/com/printer/client/PrinterClient.java -p dist/printer-impl -d dist/printer-client 
```

**Run modules**

```bash
java --module-path dist -m com.printer.client/com.printer.client.PrinterClient
```

Case 3  - When `requires` is declared, but `exports` is not declared

Update the  `printer-impl/module-info.java` descriptor file to not export any package, and update `printer-client/module-info.java` to require the `printer-impl` module.

**printer-impl/module-info.java**

```java
module com.printer.impl {

}
```

**printer-client/module-info.java**

```java
module com.printer.client {
    requires com.printer.impl;
}
```

**Compile modules**

```bash
javac printer-impl/module-info.java printer-impl/src/com/printer/impl/Printer.java -d dist/printer-impl 

javac printer-client/module-info.java printer-client/src/com/printer/client/PrinterClient.java -p dist/printer-impl -d dist/printer-client 
```

**Run modules**

```bash
java --module-path dist -m com.printer.client/com.printer.client.PrinterClient
```

Compile the `printer-impl` and the `printer-client` modules, and notice how the Java module system prevents access when `exports` is missed.

Case 4  - When both `requires` and `exports` are declared

Update the `printer-impl/module-info.java` descriptor file to export the`com.printer.impl` package, and update the `printer-client/module-info.java`file to require the  `com.printer.impl` module.

**Compile modules**

```bash
javac printer-impl/module-info.java printer-impl/src/com/printer/impl/Printer.java -d dist/printer-impl 

javac printer-client/module-info.java printer-client/src/com/printer/client/PrinterClient.java -p dist/printer-impl -d dist/printer-client 
```

**Run modules**

```bash
java --module-path dist -m com.printer.client/com.printer.client.PrinterClient
```

Compile the `printer-impl` and `printer-client` modules, and note that the  Java module system controls access among modules successfully.

Exercise 3: Using Auto-modules
----------------------------------

Auto-modules is designed for smooth migration to the Java module system.

When a non-modular classic JAR file is added to module path (`--module-path` or `-p`), then it becomes an *auto-module*.

Note: All packages of an auto-module are readable by other modules.

Open the`auto-module` directory, and check that there is a non-modular `jansi-1.17.1.jar `file present. Then, edit the module descriptors for both the\ `printer-client`and `printer-impl` modules.

**printer-client/module-info.java**

```java
module com.printer.client {
    requires com.printer.impl;
}
```

**printer-impl/module-info.java**

```java
module com.printer.impl {
    exports com.printer.impl;

    requires jansi; 
}
```

`jansi` is a non-modular Jar file and it behaves like a module (auto-module) if it is added to the module path. The module name is resolved without the version part from the file name.

```java
package com.printer.impl;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

public class Printer {
    public void print(String message) {
        AnsiConsole.systemInstall();
        System.out.println(ansi().fg(BLUE).a("This is a coloured output!"));
        System.out.println(ansi().fg(RED).a(message));
    }
}
```

**Compile modules**

```bash
javac printer-impl/module-info.java printer-impl/src/com/printer/impl/Printer.java -p lib -d dist/printer-impl

javac printer-client/module-info.java printer-client/src/com/printer/client/PrinterClient.java -p dist/printer-impl;lib -d dist/printer-client
```

**Run modules**

```bash
java --module-path dist;lib -m com.printer.client/com.printer.client.PrinterClient
```

After compilation, run the auto-module app and verify that the console output is coloured with the jansi library.

Exercise 4: Using Unnamed modules
-------------------------------------

In this exercise, you are going to test access from an unnamed module to a module.

Open the `unnamed-module` folder, and check that `printer-client` module does not have a module descriptor file, and compile it as a non-module,
and the `printer-impl` module.

```bash
javac printer-impl/module-info.java printer-impl/src/com/printer/impl/Printer.java -d dist/printer-impl 

javac printer-client/src/com/printer/client/PrinterClient.java -p dist/printer-impl --add-modules c
om.printer.impl -d dist/printer-client 
```

-   Compile `printer-impl` module.

-   Compile `printer-client` without a `module-info.java` descriptor file.

After compilation, run the non-modular `printer-client` and verify that it is able to access the exported packages from the unnamed module.

```bash
java --module-path dist --add-modules com.printer.impl -cp dist/printer-client com.printer.client.PrinterClient 
```

------

**End of worksheet**
