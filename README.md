Structure Tree
```python
├── .gitignore
├── .mvn
│   └── wrapper
│       ├── maven-wrapper.jar
│       └── maven-wrapper.properties
├── .vscode
│   └── settings.json
├── mvnw
├── mvnw.cmd
├── pom.xml
├── questions.json
├── site
├── src
│   ├── main <-- Where the Action Happens >
│   │   ├── java
│   │   │   └── mis
│   │   │       └── jewishlewish
│   │   │           └── demo <---- THIS IS WHERE THE ACTION HAPPENS >
│   │   │               ├── AppController.java
│   │   │               ├── json.java
│   │   │               ├── Py.java
│   │   │               └── ThymeleafeDemoApplication.java
│   │   └── resources <--- THIS IS WEBSITE CONTENT >
│   │       ├── application.properties
│   │       ├── static
│   │       │   ├── bootstrap
│   │       │   │   ├── css
│   │       │   │   │   └── bootstrap.min.css
│   │       │   │   └── js
│   │       │   │       └── bootstrap.min.js
│   │       │   ├── css
│   │       │   │   └── Google-Style-Login-.css
│   │       │   └── img
│   │       │       └── avatar_2x.png
│   │       └── templates
│   │           ├── app.html
│   │           └── res.html
│   └── test... <--- Can be ignored>
│
│
└── target <--- Classes>
    ├── classes
    │   ├── application.properties
    │   ├── mis
    │   │   └── jewishlewish
    │   │       └── demo
    │   │           ├── AppController.class
    │   │           ├── json.class
    │   │           ├── Py.class
    │   │           └── ThymeleafeDemoApplication.class
    │   ├── static
    │   │   ├── bootstrap
    │   │   │   ├── css
    │   │   │   │   └── bootstrap.min.css
    │   │   │   └── js
    │   │   │       └── bootstrap.min.js
    │   │   ├── css
    │   │   │   └── Google-Style-Login-.css
    │   │   └── img
    │   │       └── avatar_2x.png
    │   └── templates
    │       ├── app.html
    │       └── res.html
    └── test-classes
        └── mis
            └── jewishlewish
                └── demo
                    └── DemoApplicationTests.class
```