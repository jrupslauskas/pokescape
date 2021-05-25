PokeScape

Simple Spring Boot application for learning purposes. Pokemon are a fun dataset that is easy to work with.

Run with ./gradlew bootRun

Add to /add endpoint via curl command formatted as follows
curl http://localhost:8080/pokemon/add  -d pokedexEntry=*EntryNumber* -d name=*Name* -d type=*Type*
