// src/Components/LoginForm/LoginForm.jsx
import React, { useState } from 'react';
import './LoginForm.css';
import { FaUser, FaLock } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';
import UserService from '../../Services/UserService';
import AdminService from '../../Services/AdminService';

const LoginForm = () => {
  console.log('LoginForm component is being rendered');

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    console.log('handleLogin function called');

    try {
      // Attempt to login as user
      const userResponse = await UserService.login({ username, password });
      if (userResponse.data.role === 'USER') {
        console.log('User login successful, navigating to homepage');
        navigate('/homepage');
        return;
      }
    } catch (error) {
      console.error('Failed to login as user', error);
    }

    try {
      // Attempt to login as admin
      const adminResponse = await AdminService.login({ username, password });
      if (adminResponse.data.role === 'ADMIN') {
        console.log('Admin login successful, navigating to admin page');
        navigate('/admin');
        return;
      }
    } catch (error) {
      console.error('Failed to login as admin', error);
    }

    alert('Failed to login');
  };

  return (
    <div className="wrapper">
      <form onSubmit={handleLogin}>
        <h1>Login</h1>
        <div className="input-box">
          <input
            type="text"
            placeholder="Username"
            required
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <FaUser className="icon" />
        </div>
        <div className="input-box">
          <input
            type="password"
            placeholder="Password"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <FaLock className="icon" />
        </div>
        <div className="remember-forgot">
          <label>
            <input type="checkbox" />
            Remember me
          </label>
          <a href="#">Forgot password?</a>
        </div>
        <button type="submit">Login</button>
        <div className="register-link">
          <p>
            Don't have an account? <a href="#">Register</a>
          </p>
        </div>
      </form>
    </div>
  );
};

export default LoginForm;
