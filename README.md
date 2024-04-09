# 🚀 HETIC Learning Java 🚀

## Compile and run the project
1. Compile the project
```bash
javac -d bin src/fr/hetic/*.java
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
```bash
java -jar bin/Calculator.jar 5 3 +
```
-> 8
```bash
java -jar bin/Calculator.jar 5 3 -
```
-> 2
```bash
java -jar bin/Calculator.jar 5 3 "*"
```
-> 15
```bash
java -jar bin/Calculator.jar 5 3 /
```
-> 1.6666666666666667


## 👤️ Authors 👤
- Maxence BREUILLES ([@MisterAzix](https://github.com/MisterAzix))<br />
