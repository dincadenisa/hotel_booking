import React, { useEffect, useState } from 'react';
import './HomePage.css'; // Make sure to create and import the CSS file for styling
import RoomCard from '../HelpingComponents/RoomCard';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const HomePage = () => {
  const [rooms, setRooms] = useState([]);
  const navigate = useNavigate();

  const handleButtonClick = (roomId, room) => {
    navigate(`/homepage/${roomId}`, { state: { room } });
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
                onButtonClick={() => handleButtonClick(room.id, room)}
              />
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default HomePage;
