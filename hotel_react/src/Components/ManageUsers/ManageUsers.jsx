import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './ManageUsers.css';

const ManageUsers = () => {
  const [users, setUsers] = useState([]);
  const [editingUser, setEditingUser] = useState(null);
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = () => {
    axios
      .get('http://localhost:8080/auth/users')
      .then((response) => setUsers(response.data))
      .catch((error) => console.error('Error fetching users:', error));
  };

  const handleDelete = (userId) => {
    axios
      .delete(`http://localhost:8080/auth/delete/${userId}`)
      .then(() => fetchUsers())
      .catch((error) => console.error('Error deleting user:', error));
  };

  const handleEdit = (user) => {
    setEditingUser(user);
    setUsername(user.username);
    setEmail(user.email);
    setFirstName(user.firstName);
    setLastName(user.lastName);
  };

  const handleUpdate = () => {
    if (!editingUser) return;

    const updatedUser = {
      ...editingUser,
      username,
      email,
      firstName,
      lastName,
    };

    axios
      .put('http://localhost:8080/auth/put', updatedUser)
      .then(() => {
        fetchUsers();
        setEditingUser(null);
        setUsername('');
        setEmail('');
        setFirstName('');
        setLastName('');
      })
      .catch((error) => console.error('Error updating user:', error));
  };

  return (
    <div className="manage-users">
      <h1>Manage Users</h1>
      {editingUser && (
        <div className="edit-form">
          <input
            type="text"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            type="text"
            placeholder="First Name"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
          <input
            type="text"
            placeholder="Last Name"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
          <button className="update-btn" onClick={handleUpdate}>
            Update User
          </button>
        </div>
      )}
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            <div className="user-details">
              {user.username} - {user.email} - {user.firstName} -{' '}
              {user.lastName}
            </div>
            <div className="user-actions">
              <button className="edit-btn" onClick={() => handleEdit(user)}>
                Edit
              </button>
              <button
                className="delete-btn"
                onClick={() => handleDelete(user.id)}
              >
                Delete
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ManageUsers;
