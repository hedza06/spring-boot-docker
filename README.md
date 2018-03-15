# Dockerizing Spring Boot and MySQL

Demo project with demonstration of dockerizing Spring Boot App and MySQL.


## Running the project

1. Install docker on your local machine. You can find the installation steps on this link: https://docs.docker.com/install/
2. Open terminal and navigate to project directory
2. Run command: ```mvn clean install -DskipTests```
3. Run command: ```mvn clean package -DskipTest```

## Build images and deploy docker stack

1. Run command to build images: ```docker-compose build```
2. Run command to deploy stack locally: ```docker stack deploy -c docker-compose.yml <your_stack_name>```
3. Run command ```docker ps``` to see running containers.

## View docker container logs

1. Run command: ```docker ps```
2. Run command: ```docker logs -f <container_id>``` 
<br><br>  


**NOTE:** The above steps will create docker stack with MySQL and Java running containers.


## Author

Heril Muratović  
Software Engineer  
<br>
**Mobile**: +38269657962  
**E-mail**: hedzaprog@gmail.com  
**Skype**: hedza06  
**Twitter**: hedzakirk  
**LinkedIn**: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
**StackOverflow**: https://stackoverflow.com/users/4078505/heril-muratovic
