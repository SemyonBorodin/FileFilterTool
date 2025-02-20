# File Filtering and Sorting Utility (Eng)
This utility is designed to separate data from input files into three categories: integers, floating-point numbers, and strings.  
The lines from the files are read in turn according to their enumeration on the command line.  
The results are written to separate files with customizable output paths, filename prefixes, and append mode.  
The utility also provides statistics on the read data.  
## Features
### Options
- The **-o** option allows specifying the output directory. Supports absolute and relative paths.
- The **-p** option sets a prefix for output filenames.
- The **-a** option enables appending data to existing files instead of overwriting them (by default, files are overwritten).
- The **-s** option is provides short statistics for each type on read data: option counts of elements.
- The **-f** option is provides full statistics for each type on read data: option counts of elements min, max, sum, and average for integers and floats; length of the shortest and longest string.
- The **-u** option excludes duplicate input files if the same file is passed multiple times.
### Path Handling
The utility correctly handles both absolute and relative paths.  
Supports paths for Linux, and WSL (Windows Subsystem for Linux).  
If no path is specified, path is incorrect or cannot be created or reached, the current directory is used.  
## Example of usage
1. Via Jar  
   
   `java -jar target/FileFilterTool-1.0-SNAPSHOT.jar -s -a -p sample- in1.txt in2.txt`
   
   Results will be written to sample-integers.txt, sample-floats.txt, sample-strings.txt in the current directory.
   
2. Via Maven  
   
   `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-f -o someFolder/ -a in1.txt in2.txt"`

   Results will be appended to existing ones integers.txt, floats.txt, strings.txt in the someFolder folder in current directory,  
   if any file or directive is missing, it will be firstly created.
Statistics will be printed to the console.

## Instalation and run
1. Clone the repository  
   `git clone git@github.com:SemyonBorodin/FileFilterTool.git`  
   `cd FileFilterTool`
2. Build the project using Maven  
   `mvn clean package`  
Is is aslo create a JAR file in the target dir: FileFilterTool-1.0-SNAPSHOT.jar
 
3. Create input files with data; for exaple in1.txt in2.txt

4.Run the utility via JAR or Maven as in the previous paragraph  
   `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-f -o someFolder/ -a in1.txt in2.txt"`
## Requirements
To build and run the FileFilterTool, you need the following:

1. Java Development Kit (JDK):

- Version: 17.0.14 or higher.

- Download: Azul-23 Azul Zulu 23.0.2 or OpenJDK.

2. Apache Maven:  

Version 3.8.7 or higher required
- `sudo apt install maven -y` to install

3. Dependencies  
After installing Java and Maven go to project dir and run  
   `mvn clean install` it will install:
- commons-cli:commons-cli:1.9.0
- exec-maven-plugin 3.1.0
- junit-jupiter-api:5.11.4
- junit-jupiter-engine:5.11.4
- junit
  
4. System: Linux or WSL

### Exaple of work

Example of input files  
- in1.txt  
```
1
3
5
Lorem ipsum dolor sit amet
45
Пример
3.1415
consectetur adipiscing
-0.001
тестовое задание
100500
 ```

- in2.txt
```
2
4
Нормальная форма числа с плавающей запятой
1.528535047E-25
Long
1234567890123456789
```
- `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-s -u -p important- in1.txt in1.txt in2.txt"C`  
  short statistics, uniq mode, default output dir, prefix **important-**.
- important-integers.txt  
  ```
  1
  3
  5
  45
  100500
  ```
- important-floats.txt  
  ```
  3.1415
  -0.001
  ```
- important-strings.txt  
  ```
  Lorem ipsum dolor sit amet
  Пример
  consectetur adipiscing
  тестовое задание
  ```
  
