import React from 'react';
import { Link } from 'react-router-dom';
import './AdminPage.css';

const AdminPage = () => {
  const handlePlaceholderClick = (e) => {
    e.preventDefault();
    alert('This feature is coming soon!');
  };

  return (
    <div className="admin-wrapper">
      <div className="admin-header">
        <h1>Admin Dashboard</h1>
        <p>Welcome, Admin!</p>
      </div>
      <div className="admin-content">
        <h2>Actions</h2>
        <ul>
          <li>
            <Link to="/admin/manage-users">Manage Users</Link>
          </li>
          <li>
            <Link to="#" onClick={handlePlaceholderClick}>
              View Reports
            </Link>
          </li>
          <li>
            <Link to="#" onClick={handlePlaceholderClick}>
              Settings
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default AdminPage;
