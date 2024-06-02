import React, { useEffect, useState } from 'react';
import './HomePage.css'; // Make sure to create and import the CSS file for styling
import RoomCard from '../HelpingComponents/RoomCard';
import axios from 'axios';
import { useLocation, useNavigate } from 'react-router-dom';

const HomePage = () => {
  const [rooms, setRooms] = useState([]);
  const navigate = useNavigate();
  const location = useLocation();
  const [username, setUsername] = useState(location.state);

  const handleButtonClick = (roomId, room) => {
    navigate(`/homepage/${roomId}`, { state: { room, username } });
  };

  useEffect(() => {
    fetchRooms();
  }, []);

  const fetchRooms = () => {
    axios
      .get('http://localhost:8080/room/allrooms')
      .then((response) => setRooms(response.data))
      .catch((error) => console.error('Error fetching rooms:', error));
  };
  console.log(rooms);
  return (
    <div className="home-container">
      <header className="header">
        <h1 className="hotel-title">Sunset Hotel</h1>
        <p className="hotel-description">
          Welcome to Sunset Hotel, where luxury meets comfort. Nestled in the
          heart of the city, our hotel offers breathtaking views, world-class
          amenities, and unparalleled service. Whether you're here for business
          or leisure, Sunset Hotel is your perfect home away from home.
        </p>
      </header>
      <ul className="room-list">
        {rooms.map((room) => (
          <li key={room.id} className="room-list-item">
            <RoomCard
              roomName={room.id}
              description={room.hotel.description}
              price={room.pricePerNight}
              onButtonClick={() => handleButtonClick(room.id, room)}
            />
          </li>
        ))}
      </ul>
    </div>
  );
};

export default HomePage;
