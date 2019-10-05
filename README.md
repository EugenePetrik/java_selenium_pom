## Java Selenium WebDriver project

### Run all scenarios:

```mvn clean compile test```

### Run scenarios from specific Java class:

```mvn clean test -Dtest=PositiveLoginTests```

### Run scenarios from TestNG xml file:

```mvn clean test -DsuiteXmlFile=testng.xml```

### Run scenarios from specific TestNG xml file:

```mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/TestSuites/NegativeLoginTests.xml```

### Run scenarios for smokeTests group:

```mvn clean test -Dgroups=smokeTests```
