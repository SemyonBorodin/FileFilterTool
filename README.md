# File Filtering and Sorting Utility (Eng)
This utility is designed to separate data from input files into three categories: integers, floating-point numbers, and strings.  
The lines from the files are read in turn according to their enumeration on the command line.  
The results are written to separate files with customizable output paths, filename prefixes, and append mode (by default the data is overwritten).  
The utility also provides statistics on the read data. 
## Features
### Options
- The **-o** option allows specifying the output directory. Supports absolute and relative paths.
- The **-p** option sets a prefix for output filenames.
- The **-a** option enables appending data to existing files instead of overwriting them (by default, files will be overwritten).
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
   Full statistics will be printed to the console.

## Instalation and run
1. Clone the repository  
   `git clone git@github.com:SemyonBorodin/FileFilterTool.git`  
   `cd FileFilterTool`
2. Build the project using Maven  
   `mvn clean package`  
Is is aslo create a JAR file in the target dir: FileFilterTool-1.0-SNAPSHOT.jar
 
3. Create input files with data; for exaple in1.txt in2.txt  

4. Run the utility via JAR or Maven as in the previous paragraph  
   `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-f -o someFolder/ -a in1.txt in2.txt"`
## Requirements
To build and run the FileFilterTool, you need the following:

1. Java Development Kit (JDK):

- JDK Required version: **17.0.14** or higher.

- Download: [OpenJDK 17](<https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html>) or [Azul Zulu 17](<https://www.azul.com/downloads/?package=jdk#zulu>)
- Recomended: OpenJDK **17.0.14** (Ubuntu build)  

2. Apache Maven:  

Version 3.8.7 or higher required
- `sudo apt install maven -y` to install

3. Dependencies  
After installing Java and Maven go to project dir and run  
   `mvn clean install` it will install:
- commons-cli:commons-cli 1.9.0  
  <https://mvnrepository.com/artifact/commons-cli/commons-cli/1.9.0>
- exec-maven-plugin 3.1.0  
  <https://mvnrepository.com/artifact/org.codehaus.mojo/exec-maven-plugin/3.1.0>
- junit-jupiter-api 5.11.4  
  <https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.4>
- junit-jupiter-engine 5.11.4  
  <https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.11.4>
- junit 4.13.2
  <https://mvnrepository.com/artifact/junit/junit/4.13.2>
- maven-shade-plugin 3.3.0  
  <https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-shade-plugin/3.3.0>
- maven-jar-plugin 3.2.2  
  <https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-jar-plugin/3.2.2>
  
4. System: Linux or WSL

### Exaple of work

Example of input files  
- in1.txt  
```
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
Нормальная форма числа с плавающей запятой
1.528535047E-25
Long
1234567890123456789
```
- `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-s -u -p important- in1.txt in1.txt in2.txt"`  
  short statistics, uniq mode, default output dir, prefix **important-**.
- important-integers.txt  
  ```
  45
  1234567890123456789
  100500
  ```
- important-floats.txt  
  ```
  1.5285351E-25
  3.1415
  -0.001
  ```
- important-strings.txt  
  ```
  Lorem ipsum dolor sit amet
  ормальная форма числа с плавающей запятой
  Пример
  Long
  consectetur adipiscing
  тестовое задание
  ```
  - Statistics:  
  ``` 
   3 elements successfully written in important-integers.txt!  
   3 elements successfully written in important-floats.txt!  
   6 elements successfully written in important-strings.txt!  
  ```

# Утилита для фильтрации и сортировки данных (Rus)

Утилита предназначена для разделения данных из входных файлов на три категории: целые числа, числа с плавающей точкой и строки.  
Строки из файлов читаются по очереди в соответствии с их порядком их перечисления в командной строке.  
Результаты записываются в отдельные файлы с возможностью указания пути вывода, префикса имен файлов и режима добавления данных (по умолчанию данные в файлах перезаписываются).  
Утилита также предоставляет статистику по прочитанным данным.  

## Возможности
### Опции
- Опция **-o** позволяет указать путь для выходных файлов. Поддерживает абсолютные и относительные пути.
- Опция **-p** задает префикс для имен выходных файлов.
- Опция **-a** позволяет добавлять данные в существующие файлы вместо их перезаписи (по умолчанию файлы перезаписываются).
- Опция **-s** предоставляет краткую статистику для каждого типа данных: количество элементов.
- Опция **-f** предоставляет полную статистику для каждого типа данных: минимальное, максимальное значение, сумма и среднее для целых и вещественных чисел; длина самой короткой и самой длинной строки для strings.
- Опция **-u** исключает дубликаты входных файлов, если один и тот же файл передан несколько раз.

### Обработка путей
Утилита корректно обрабатывает как абсолютные, так и относительные пути.  
Поддерживаются пути для Linux и WSL.  
Если путь не указан, указан некорректно или недоступен, используется текущая директория.  

## Пример использования
1. С помощью Jar
   
   `java -jar target/FileFilterTool-1.0-SNAPSHOT.jar -s -a -p sample- in1.txt in2.txt`
   
   Результаты будут записаны в файлы sample-integers.txt, sample-floats.txt, sample-strings.txt в текущей директории.
   
2. Через Maven  
   
   `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-f -o someFolder/ -a in1.txt in2.txt"`

   Результаты будут добавлены к существующим файлам integers.txt, floats.txt, strings.txt в папке someFolder в текущей директории.  
   Если какой-либо файл или директория отсутствуют, они будут созданы.  
   Полная статистика будет выведена в консоль.

## Установка и запуск
1. Клонируйте репозиторий  
   `git clone git@github.com:SemyonBorodin/FileFilterTool.git`  
   `cd FileFilterTool`
2. Соберите проект с помощью Maven  
   `mvn clean package`  
   Также создаст JAR-файл в папке target: FileFilterTool-1.0-SNAPSHOT.jar.
 
3. Создайте входные файлы с данными; например, in1.txt и in2.txt.  

4. Запустите утилиту через JAR или Maven, как в предыдущем пункте.  
   `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-f -o someFolder/ -a in1.txt in2.txt"`

## Требования
Для сборки и запуска **FileFilterTool** необходимо следующее:

1. Java Development Kit (JDK):

- Требуемая версия JDK: **17.0.14** или выше.

- Скачать: [OpenJDK 17](<https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html>) или [Azul Zulu 17](<https://www.azul.com/downloads/?package=jdk#zulu>)
- Рекомендуется: OpenJDK **17.0.14** (сборка для Ubuntu).  

2. Apache Maven:  

Требуется версия 3.8.7 или выше.
- Установка: выполните `sudo apt install maven -y` в терминале.

3. Зависимости  
После установки Java и Maven перейдите в директорию проекта и выполните:  
   `mvn clean install` — это установит:
- commons-cli:commons-cli 1.9.0  
  <https://mvnrepository.com/artifact/commons-cli/commons-cli/1.9.0>
- exec-maven-plugin 3.1.0  
  <https://mvnrepository.com/artifact/org.codehaus.mojo/exec-maven-plugin/3.1.0>
- junit-jupiter-api 5.11.4  
  <https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.4>
- junit-jupiter-engine 5.11.4  
  <https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.11.4>
- junit 4.13.2
  <https://mvnrepository.com/artifact/junit/junit/4.13.2>
- maven-shade-plugin 3.3.0  
  <https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-shade-plugin/3.3.0>
- maven-jar-plugin 3.2.2  
  <https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-jar-plugin/3.2.2>
  
4. Система: Linux или WSL.

### Пример работы

Пример входных файлов  
- in1.txt  
```
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
Нормальная форма числа с плавающей запятой
1.528535047E-25
Long
1234567890123456789
```
- `mvn exec:java -Dexec.mainClass="App" -Dexec.args="-s -u -p important- in1.txt in1.txt in2.txt"`  
  Краткая статистика, считываем только уникальные имена файлов, директория по умолчанию, префикс выходных файлов **important-**.  
- important-integers.txt  
  ```
  45
  1234567890123456789
  100500
  ```
- important-floats.txt  
  ```
  1.5285351E-25
  3.1415
  -0.001
  ```
- important-strings.txt  
  ```
  Lorem ipsum dolor sit amet
  ормальная форма числа с плавающей запятой
  Пример
  Long
  consectetur adipiscing
  тестовое задание
  ```
  - Статистика:  
  ``` 
   3 elements successfully written in important-integers.txt!  
   3 elements successfully written in important-floats.txt!  
   6 elements successfully written in important-strings.txt!  
  ```
