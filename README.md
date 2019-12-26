## Java Selenium WebDriver Project using Page Object Model

#### Install Java:

[Java Installer](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

#### Install Maven:

```shell
brew install maven
```

#### Add environment variables to .bash_profile file:

```shell
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.5.jdk/Contents/Home
```

```shell
export PATH=$JAVA_HOME/bin:$PATH
```

```shell
export PATH=/usr/local/Cellar/maven/3.6.2/bin:$PATH
```

#### Git Large File Storage:

[Git Storage](https://git-lfs.github.com/)


#### Run all scenarios:

```shell
mvn clean compile test
```

#### Run scenarios from specific Test class:

```shell
mvn clean test -Dtest=PositiveLoginTests
```

#### Run scenarios from specific TestNG xml file:

```shell
mvn clean test -Dsuite=DragAndDropTests
```

#### Run scenarios for specific group:

```shell
mvn clean test -Dgroups=smokeTests
```
