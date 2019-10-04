## Java Selenium WebDriver project

### Run all scenarios:

```mvn clean compile test```

### Run scenarios from specific Java class:

```mvn clean test -Dtest=PositiveLoginTests```

### Run scenarios from TestNG xml file:

```mvn clean test -DsuiteXmlFile=testng.xml```

### Run scenarios from specific TestNG xml file:

```mvn test -Dsurefire.suiteXmlFiles=src/test/resources/TestSuites/NegativeLoginTests.xml```

### TestNG documentation:

```https://testng.org/doc/documentation-main.html#testng-xml```
