import React, { useEffect, useState } from 'react';
import './HomePage.css'; // Make sure to create and import the CSS file for styling
import RoomCard from '../HelpingComponents/RoomCard';
import axios from 'axios';

const HomePage = () => {
  const [rooms, setRooms] = useState([]);

  const handleButtonClick = () => {
    alert('Button clicked!');
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = () => {
    axios
      .get('http://localhost:8080/room/allrooms')
      .then((response) => setRooms(response.data))
      .catch((error) => console.error('Error fetching users:', error));
  };
  console.log(rooms);
  return (
    <div>
      <ul>
        {rooms.map((room) => (
          <li key={room.id}>
            <div>
              <RoomCard
                roomName={room.id}
                description={room.hotel.description}
                price={room.pricePerNight}
                onButtonClick={handleButtonClick}
              />
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default HomePage;
