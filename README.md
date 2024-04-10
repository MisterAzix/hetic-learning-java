# 🚀 HETIC Learning Java 🚀

## Compile and run the project

1. Compile the project

```bash
javac -d bin src/fr/hetic/**/*.java
```

2. Create the JAR file

```bash
jar cfe bin/Calculator.jar fr.hetic.Main -C bin fr
```

3. Run the JAR file

```bash
java -jar bin/Calculator.jar
```

### Examples

1. Create a file `input.op` with the following content:

```
1 2 +
6 1 +
4 0 +
2 1 -
4 2 *
12 5 /
```

2. Run the JAR file with the `input.op` file

```bash
java -jar bin/Calculator.jar input.op output.res
```

3. Check the `output.res` file

```
3
7
4
1
8
2.4
```

## 👤️ Authors 👤

- Maxence BREUILLES ([@MisterAzix](https://github.com/MisterAzix))<br />
