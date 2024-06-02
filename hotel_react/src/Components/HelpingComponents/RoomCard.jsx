import React from 'react';
import PropTypes from 'prop-types';
import './RoomCard.css'; // Assuming you have some CSS for styling

const RoomCard = ({
  imageSrc,
  roomName,
  description,
  price,
  onButtonClick,
}) => {
  return (
    <div className="room-card">
      <div className="room-card__image">
        <img src={imageSrc} alt={roomName} />
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
  onButtonClick: PropTypes.func.isRequired,
};

export default RoomCard;
