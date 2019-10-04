## Java Selenium WebDriver project

### Run all scenarios:

```mvn clean compile test```

### Run scenarios from specific class:

```mvn -Dtest=PositiveTests clean test```

### Run scenarios from TestNG xml file:

```mvn clean test -DsuiteXmlFile=testng.xml```
```mvn clean test -DsuiteXmlFile=LoginTests.xml```

### TestNG documentation:

```https://testng.org/doc/documentation-main.html#testng-xml```
