import React, { useState } from 'react';
import { useParams, useLocation } from 'react-router-dom';
import './ReservationPage.css'; // Import the CSS file
import axios from 'axios';

const ReservationPage = () => {
  const { roomId } = useParams();
  const location = useLocation();
  const room = location.state.room;
  const user = location.state.username;
  const pricePerNight = location.state.room.pricePerNight;

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [numberOfPersons, setNumberOfPersons] = useState(1);
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');

  const calculateTotalPrice = () => {
    const start = new Date(startDate);
    const end = new Date(endDate);
    const diffTime = Math.abs(end - start);
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
    return diffDays * pricePerNight;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const reservationDetails = {
      hotelId: 1, // Replace with actual hotelId if needed
      roomId: roomId,
      username: user, // Replace with actual username
      roomNumber: roomId, // Replace with actual roomNumber
      checkInDate: startDate,
      checkOutDate: endDate,
      guestName: `${firstName} ${lastName}`,
      firstName: firstName,
      lastName: lastName,
      phoneNumber: phoneNumber,
      numberOfPersons: numberOfPersons,
    };

    try {
      const response = await axios.post(
        'http://localhost:8080/reservation/create',
        reservationDetails
      );
      if (response.status === 200) {
        alert('Reservation created successfully!');
      } else {
        alert('Failed to create reservation.');
      }
    } catch (error) {
      console.error('Error creating reservation:', error);
      alert('An error occurred while creating the reservation.');
    }
  };

  return (
    <div className="reservation-container">
      <h1>Reservation for Room {roomId}</h1>
      <form className="reservation-form" onSubmit={handleSubmit}>
        <div>
          <label>First Name:</label>
          <input
            type="text"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Last Name:</label>
          <input
            type="text"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Phone Number:</label>
          <input
            type="text"
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Number of Persons:</label>
          <input
            type="number"
            value={numberOfPersons}
            onChange={(e) => setNumberOfPersons(e.target.value)}
            required
            min="1"
          />
        </div>
        <div>
          <label>Start Date:</label>
          <input
            type="date"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
            required
          />
        </div>
        <div>
          <label>End Date:</label>
          <input
            type="date"
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
            required
          />
        </div>
        <div>
          <p>Total Price: ${calculateTotalPrice()}</p>
        </div>
        <button type="submit">Submit Reservation</button>
      </form>
    </div>
  );
};

export default ReservationPage;
