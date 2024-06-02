import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './ViewReservationsPage.css';

const ViewReservationsPage = () => {
  const [reservations, setReservations] = useState([]);
  const [editingReservation, setEditingReservation] = useState(null);

  useEffect(() => {
    fetchReservations();
  }, []);

  const fetchReservations = () => {
    axios
      .get('http://localhost:8080/reservation/all')
      .then((response) => setReservations(response.data))
      .catch((error) => console.error('Error fetching reservations:', error));
  };

  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8080/reservation/delete/${id}`)
      .then(() => {
        setReservations((prevReservations) =>
          prevReservations.filter((reservation) => reservation.id !== id)
        );
      })
      .catch((error) => console.error('Error deleting reservation:', error));
  };

  const handleUpdate = (reservation) => {
    axios
      .put(
        `http://localhost:8080/reservation/update/${reservation.id}`,
        reservation
      )
      .then(() => {
        fetchReservations();
        setEditingReservation(null);
      })
      .catch((error) => console.error('Error updating reservation:', error));
  };

  const startEditing = (reservation) => {
    setEditingReservation(reservation);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEditingReservation((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    handleUpdate(editingReservation);
  };

  return (
    <div className="reservation-wrapper">
      <h1>Reservations</h1>
      {editingReservation ? (
        <form className="reservation-form" onSubmit={handleSubmit}>
          <input
            type="text"
            name="firstName"
            value={editingReservation.firstName}
            onChange={handleChange}
            placeholder="First Name"
            required
          />
          <input
            type="text"
            name="lastName"
            value={editingReservation.lastName}
            onChange={handleChange}
            placeholder="Last Name"
            required
          />
          <input
            type="text"
            name="phoneNumber"
            value={editingReservation.phoneNumber}
            onChange={handleChange}
            placeholder="Phone Number"
            required
          />
          <input
            type="number"
            name="numberOfPersons"
            value={editingReservation.numberOfPersons}
            onChange={handleChange}
            placeholder="Number of Persons"
            required
          />
          <input
            type="date"
            name="checkInDate"
            value={editingReservation.checkInDate.slice(0, 10)}
            onChange={handleChange}
            required
          />
          <input
            type="date"
            name="checkOutDate"
            value={editingReservation.checkOutDate.slice(0, 10)}
            onChange={handleChange}
            required
          />
          <button type="submit">Update Reservation</button>
          <button type="button" onClick={() => setEditingReservation(null)}>
            Cancel
          </button>
        </form>
      ) : (
        <ul className="reservation-list">
          {reservations.map((reservation) => (
            <li key={reservation.id} className="reservation-item">
              <div className="reservation-info">
                <p>
                  <strong>Guest Name:</strong> {reservation.firstName}{' '}
                  {reservation.lastName}
                </p>
                <p>
                  <strong>Phone Number:</strong> {reservation.phoneNumber}
                </p>
                <p>
                  <strong>Number of Persons:</strong>{' '}
                  {reservation.numberOfPersons}
                </p>
                <p>
                  <strong>Check-in Date:</strong>{' '}
                  {new Date(reservation.checkInDate).toLocaleDateString()}
                </p>
                <p>
                  <strong>Check-out Date:</strong>{' '}
                  {new Date(reservation.checkOutDate).toLocaleDateString()}
                </p>
              </div>
              <div className="reservation-actions">
                <button onClick={() => startEditing(reservation)}>Edit</button>
                <button onClick={() => handleDelete(reservation.id)}>
                  Delete
                </button>
              </div>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ViewReservationsPage;
