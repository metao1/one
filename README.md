# PersoInfo Backend

Welcome to One (http://persoinfo.com), the most basic task management app in the whole wide world
a very limited set of features and an even more limited set of tests.

# Development

The application consists of a frontend and a backend. Both can be started separately. The frontend is
[Angular](https://angular.io/) based and the backend is based on [Spring Boot](https://spring.io/projects/spring-boot).

Before you begin with the frontend, you need to setup your development environment. You can find good and clear instructions
on the Angular website under the [Quickstart](https://angular.io/guide/quickstart) section.

Nothing else needs to be installed for the backend itself. However, the backend requires a
[PostgreSQL](https://www.postgresql.org/) database server that is provided by a [Docker](https://www.docker.com/) container.
Therefore, Docker is required. Here, too, you can find the information you need to set up the
runtime environment, on the Docker website under [Get Started](https://www.docker.com/get-started).

## Getting Started Frontend

The fronted was generated with [Angular CLI](https://github.com/angular/angular-cli).

### Install dependencies
Run `yarn` to install the dependencies for the app. You can also add new dependencies via `yarn add`.

### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change
any of the source files.

To run the dev server with a mocked backend use `yarn start-mock`.

### Code scaffolding

Run `ng generate component component-title` to generate a new component. You can also use
`ng generate directive|pipe|service|class|guard|interface|enum|module`.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod`
flag for a production build.

### Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

### Further help

To get more help on the Angular CLI use `ng help` or go check out the
[Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Getting Started Backend

The backend was generated with [Spring Initializr](https://start.spring.io/).

### Running database server

Run `docker-compose up -d` to launch the PostgreSQL docker container.

### Development server

Run `./gradlew bootRun` for a dev server. The server is available under `http://localhost:8080/`.

### Running tests

Run `./gradlew test` to execute the tests.

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

# Contributor Tasks

Feel free to focus on a single feature or aspect of the application. Here are some ideas if you don't know where to start:

* __Frontend application feature improvements:__
   - a userEntity can assign priorities
   - a userEntity can add categories
   - a userEntity can sort the list of tasks
   - a userEntity can use markdown
   - a userEntity's tasks are persisted in the browser's storage
   - ...
* __Backend application features:__
   - the application contains a RESTful API
   - the tasks are persisted in the database
   - ...

* __Backend application structural improvements / proposals:__
   - improve or introduce an architecture (e. g. presentation, domain, data source)
   - provide interfaces for the domain layer / business logic
   - ...

As you can see, there's a lot to do. Just pick one of the ideas above or surprise us with one of your own improvements.
Also, do not hesitate to contact us if you run into any problems. We are here to help.

You can simply create a new branch and start working on One. Feel free to create a pull request if you would
like to see your changes merged into the application.
# persoinfo_back
