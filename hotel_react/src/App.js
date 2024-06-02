import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AdminPage from './Components/AdminPage/AdminPage';
import ManageUsers from './Components/ManageUsers/ManageUsers';
import HomePage from './Components/HomePage/HomePage';
import LoginForm from './Components/LoginForm/LoginForm';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginForm />} />
        <Route path="/admin" element={<AdminPage />} />
        <Route path="/admin/manage-users" element={<ManageUsers />} />
        <Route path="/homepage" element={<HomePage />} />
      </Routes>
    </Router>
  );
};

export default App;
