
	./mvnw package
	docker build --build-arg JAR_FILE=target/CurrenciesRetriever-0.0.1-SNAPSHOT.jar -t ggh1981/currencies .	