import React, { useState } from 'react';
import { useParams } from 'react-router-dom';

const ReservationPage = () => {
  const { roomId } = useParams();
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
    const pricePerNight = 250; // Replace with actual price logic if needed
    return diffDays * pricePerNight;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission
    console.log('Reservation details:', {
      firstName,
      lastName,
      phoneNumber,
      numberOfPersons,
      startDate,
      endDate,
      totalPrice: calculateTotalPrice(),
    });
  };

  return (
    <div>
      <h1>Reservation for Room {roomId}</h1>
      <form onSubmit={handleSubmit}>
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
