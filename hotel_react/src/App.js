import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AdminPage from './Components/AdminPage/AdminPage';
import ManageUsers from './Components/ManageUsers/ManageUsers';
import HomePage from './Components/HomePage/HomePage';
import LoginForm from './Components/LoginForm/LoginForm';
import ReservationPage from './Components/ReservationPage/ReservationPage';
import RegisterPage from './Components/RegisterPage/RegisterPage';
import ViewReservationsPage from './Components/ViewReservationsPage/ViewReservationsPage';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginForm />} />
        <Route path="/admin" element={<AdminPage />} />
        <Route path="/admin/manage-users" element={<ManageUsers />} />
        <Route
          path="/admin/view-reservations"
          element={<ViewReservationsPage />}
        />
        <Route path="/homepage" element={<HomePage />} />
        <Route path="/homepage/:roomId" element={<ReservationPage />} />
        <Route path="/register" element={<RegisterPage />} />
      </Routes>
    </Router>
  );
};

export default App;
