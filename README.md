# ElasticSearch
This project implements a basic User Management System with Elasticsearch for searching users by their username, email, bio, LinkedIn, GitHub, and Twitter information. The system is built using Spring Boot and leverages Elasticsearch to provide fast and scalable full-text search capabilities.

### Features
- Create User: Allows you to create and store users with details like username, email, bio, LinkedIn, GitHub, and Twitter URLs.
- Search Users: Search users using Elasticsearch by any combination of username, email, LinkedIn, GitHub, or Twitter handle.
- Populate Users: Add 100 sample users to the Elasticsearch index for testing purposes.
- Full-Text Search: Search queries are case-insensitive and use wildcard matching to find partial matches.

### Architecture
- Spring Boot: Backend framework handling user creation and interaction with Elasticsearch.
- Elasticsearch: Search engine used to index and search user information.
- Docker: Elasticsearch is run in a Docker container for easy setup and isolation.

### Endpoints
#### Create User
- POST /users : Creates a new user by accepting a User object in the request body.

#### Search Users via Elasticsearch
- GET /users/search/es?query={query} : Performs a search for users based on the query (can search by username, email, LinkedIn, GitHub, or Twitter).

#### Get All Users
- GET /users : Returns a list of all users in the Elasticsearch index.

#### Populate Users
- POST /users/populate : Populates the Elasticsearch index with 100 sample users if the index is empty.

### Steps to Run the Project
Note** You need docker desktop to run or you can simply download the elasticsearch
#### Clone the repository:
```git clone https://github.com/Yash919/ElasticSearch```

#### Build the Spring Boot application:
```mvn clean install```

#### Run Elasticsearch using Docker:
```docker-compose up```

#### Run the Spring Boot application:
```mvn spring-boot:run```

### Dependencies
- Spring Boot: Handles web requests and business logic.
- Elasticsearch: Provides the full-text search capabilities.
- Spring Data Elasticsearch: Integrates Spring Boot with Elasticsearch for indexing and querying.
- Docker: Used to run Elasticsearch in a containerized environment.

### ScreenShots: 
<img width="1512" alt="image" src="https://github.com/user-attachments/assets/ef19ab7f-e30c-4c9f-8510-1a84b72249cf">


### Credits
This project was created by Yash Mehta 🚀
