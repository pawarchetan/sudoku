# Getting started

### To start back-end:

run next command from project root folder:  
`./mvnw spring-boot:run`  

### To start frond-end:

navigate to `web` folder:   
`cd src/main/web`  

install npm packages:   
`npm i`

then run command:   
`ng serve --open`

Example of a working app:  
![img_valid.png](img_valid.png)  
![img_invalid.png](img_invalid.png)  
![img_in_browser.png](img_in_browser.png)  

### Running app using Docker
We have 2 options to run application
1. Run Backend.Dockerfile to generate dockerfile for backend and manually run frontend application.
   * Move to the root directory of the application.
   * Create docker image using `docker build -t sudoku:latest -f Backend.Dockerfile .`
   * Run application: `docker run -p 8080:8080 sudoku`
2. Run Frontend and backend together using docker-compose
   * Move to the root directory of the application.
   * Run `docker compose up` which will build and run images as container

#### Why we used docker-compose?
We have multiple components in application and running those as containers in isolated environment will be a good choice. We created backend and frontend images and running them in isolated environment, connected via `sudoku-network`


