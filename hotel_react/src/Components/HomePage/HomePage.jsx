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

  const imageUrls = [
    'https://assets.architecturaldigest.in/photos/65b2aecf269da4a0ee6c9b40/master/w_1600%2Cc_limit/atr.royalmansion-bedroom2-mr.jpg',
    'https://www.travelandleisure.com/thmb/DrKk89lVBFueSGokviOcCFPYyc8=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/TAL-empty-hotel-room-BEDBUGHTL1023-93cb047ba72f48d4bc70505073ee8d10.jpg',
    'https://pinkpeachhh.home.blog/wp-content/uploads/2020/12/luxury-bedroom-suite-resort-high-rise-hotel-with-working-table.jpg?w=1024',
    'https://assets.simpleviewinc.com/simpleview/image/upload/c_limit,h_1200,q_75,w_1200/v1/clients/milwaukee/VM_Hilton_Plaza_Suite_King_Room_9b5d673a-95c6-445e-ad6b-5ae85e260f18.jpg',
    'https://www.thepriory.com/images/rooms/dlKing.jpg',
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFomsoTfwnWZIc_tXthw39_YCOcZ-Hm3GxLw&s',
    'https://dq5r178u4t83b.cloudfront.net/wp-content/uploads/sites/125/2021/08/11060441/deluxe_harbour_web.jpg',
    'https://dq5r178u4t83b.cloudfront.net/wp-content/uploads/sites/125/2021/08/11060441/deluxe_harbour_web.jpg',
    'https://vwartclub.com/media/projects/3322/1.jpg',
    'https://www.pymnts.com/wp-content/uploads/2016/05/Hotel-Room-Secondary-Market.jpg',
  ];

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
        {rooms.map((room, index) => (
          <li key={room.id} className="room-list-item">
            <RoomCard
              imageSrc={imageUrls[index % imageUrls.length]}
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
