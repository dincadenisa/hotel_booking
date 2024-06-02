import React from 'react';
import PropTypes from 'prop-types';
import './RoomCard.css'; // Assuming you have some CSS for styling

const RoomCard = ({ roomName, description, price, onButtonClick }) => {
  return (
    <div className="room-card">
      <div className="room-card__image">
        <img
          src={
            'https://www.thespruce.com/thmb/iMt63n8NGCojUETr6-T8oj-5-ns=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/PAinteriors-7-cafe9c2bd6be4823b9345e591e4f367f.jpg'
          }
          alt={roomName}
        />
      </div>
      <div className="room-card__details">
        <h2>{'Room Number ' + roomName}</h2>
        <p>{description}</p>
        <p className="room-card__price">${price}</p>
      </div>
      <div className="room-card__button">
        <button onClick={onButtonClick}>Book Now</button>
      </div>
    </div>
  );
};

RoomCard.propTypes = {
  imageSrc: PropTypes.string.isRequired,
  roomName: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
  buttonLabel: PropTypes.string.isRequired,
  onButtonClick: PropTypes.func.isRequired,
};

export default RoomCard;
