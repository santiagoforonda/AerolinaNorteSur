

import React, { useState } from 'react';
import axios from 'axios';

const SearchFlights = () => {
  const [departureAirportCode, setDepartureAirportCode] = useState('');
  const [arrivalAirportCode, setArrivalAirportCode] = useState('');
  const [departureDate, setDepartureDate] = useState('');
  const [flights, setFlights] = useState([]);
  const [isNoFlightsAvailable, setIsNoFlightsAvailable] = useState(false);

  const handleSearchFlights = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/Catalogs/catalogs', {
        params: {
          departureAirportCode,
          arrivalAirportCode,
          departureDate,
        },
      });

      const flightsData = response.data;
      setFlights(flightsData);

      if (flightsData.length === 0) {
        setIsNoFlightsAvailable(true);
      } else {
        setIsNoFlightsAvailable(false);
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <h2>Search Flights</h2>
      <div>
        <label>Departure Airport Code:</label>
        <input
          type="text"
          value={departureAirportCode}
          onChange={(e) => setDepartureAirportCode(e.target.value)}
        />
      </div>
      <div>
        <label>Arrival Airport Code:</label>
        <input
          type="text"
          value={arrivalAirportCode}
          onChange={(e) => setArrivalAirportCode(e.target.value)}
        />
      </div>
      <div>
        <label>Departure Date:</label>
        <input
          type="date"
          value={departureDate}
          onChange={(e) => setDepartureDate(e.target.value)}
        />
      </div>
      <button onClick={handleSearchFlights}>Search Flights</button>

      {isNoFlightsAvailable ? (
        <div>
          <h3>Lo lamentamos, no hay vuelos disponibles</h3>
        </div>
      ) : flights.length > 0 ? (
        <div>
          <h3>Search Results:</h3>
          <ul>
            {flights.map((flight) => (
              <li key={flight.id}>
                Flight ID: {flight.id}, Departure: {flight.departure}, Arrival: {flight.arrival}
              </li>
            ))}
          </ul>
        </div>
      ) : null}
    </div>
  );
};

export default SearchFlights;
