## Java Selenium WebDriver Project using Page Object Model

#### Install Java:

```https://www.oracle.com/technetwork/java/javase/downloads/index.html```

#### Install Maven:

```brew install maven```

#### Add environment variables to .bash_profile file:

```export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.5.jdk/Contents/Home```
```export PATH=$JAVA_HOME/bin:$PATH```
```export PATH=/usr/local/Cellar/maven/3.6.2/bin:$PATH```

#### Git Large File Storage:

```https://git-lfs.github.com/```

#### Run all scenarios:

```mvn clean compile test```

#### Run scenarios from specific Test class:

```mvn clean test -Dtest=PositiveLoginTests```

#### Run scenarios from specific TestNG xml file:

```mvn clean test -Dsuite=DragAndDropTests```

#### Run scenarios for specific group:

```mvn clean test -Dgroups=smokeTests```
