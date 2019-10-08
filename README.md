## Java Selenium WebDriver project

### Run all scenarios:

```mvn clean compile test```

### Run scenarios from specific Java class:

```mvn clean test -Dtest=PositiveLoginTests```

### Run scenarios from specific TestNG xml file:

```mvn clean test -Dsuite=DragAndDropTests```

### Run scenarios for smokeTests group:

```mvn clean test -Dgroups=smokeTests```
