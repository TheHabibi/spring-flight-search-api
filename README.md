```markdown
# Spring Boot Flight Search API

## Requirements

For building and running the application you need:

- JDK 11 or higher
- Spring Boot 2.5.0 or higher
- Maven 3.6.0 or higher
- MongoDB (A NoSQL database for storing flight and airport data)

## Running the Application Locally

To run the application locally, you can execute the following command:

```bash
mvn spring-boot:run
```

Alternatively, you can execute the `main` method in the `com.ali.flightsearch.FlightSearchApplication` class from your IDE.

## Flight Model

The flight data is represented by the `Flight` model, which includes the following attributes:

- `id`: Flight's unique identifier
- `departureAirport`: Departure airport code
- `arrivalAirport`: Arrival airport code
- `departureDate`: Departure date and time
- `returnDate`: Return date and time
- `price`: Flight price

## Airport Model

The airport data is represented by the `Airport` model, which includes the following attributes:

- `id`: Airport's unique identifier
- `city`: City name

## Flight Search

To search for flights, you can use the `/search` endpoint:

| HTTP Method | URL | Description |
|-------------|-----|-------------|
| `POST`      | /search/flights | Search for flights based on criteria |

## Scheduled Data Fetching

This application includes a scheduled job that fetches flight data from your custom mock data repository deployed on OnRender. The `FlightDataScheduler` class fetches the data using the `FlightDataFetcher` class and adds it to the repository using the `FlightService`. You can configure the interval by adjusting the `fixedRate` parameter in the `@Scheduled` annotation.

For the mock data, I made this [Mock Data API](https://github.com/TheHabibi/mock-data-api) with Node.js
## Security Feature: API Key Access

This API includes a security feature that requires clients to provide an API key to access the endpoints. Without a valid API key, requests will be denied. Here's how it works:

1. The API key is generated when the application starts.
2. Requests must include the API key in the `Amadeus-API-Key` header for authentication.
   


## API Usage

1. Start the application using the instructions provided above.

2. Utilize a tool like Postman to interact with the API endpoints. Below are the available endpoints and their respective methods:

   **Flights:**

   - `POST /flights`: Add a new flight.
   - `GET /flights`: Retrieve a list of flights.
   - `GET /flights/{flight_id}`: Get details of a specific flight.
   - `PUT /flights/{flight_id}`: Update information about a flight.
   - `DELETE /flights/{flight_id}`: Delete a flight.

   **Airports:**

   - `POST /airports`: Add a new airport.
   - `GET /airports`: Retrieve a list of airports.
   - `GET /airports/{airport_id}`: Get details of a specific airport.
   - `PUT /airports/{airport_id}`: Update information about an airport.
   - `DELETE /airports/{airport_id}`: Delete an airport.

   **Search Flights:**

   - `POST /search/flights`: Search for flights based on specified criteria.

For detailed information about the API endpoints, request and response formats, you can access the [API documentation](https://app.swaggerhub.com/apis/TheHabibi/Amadeus-case/1.0.0) on SwaggerHub.


## Notes

- Make sure to configure your MongoDB connection details in the `application.properties` file.
