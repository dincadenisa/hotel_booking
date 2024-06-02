// src/services/UserService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/auth/';

const register = (userData) => {
  return axios.post(`${API_URL}register`, userData);
};

const getUser = (username) => {
  return axios.get(`${API_URL}get`, { params: { username } });
};

const deleteUser = (username) => {
  return axios.delete(`${API_URL}delete`, { data: { username } });
};

const updateUser = (userData) => {
  return axios.put(`${API_URL}put`, userData);
};

const login = (userData) => {
  return axios.post(`${API_URL}login`, userData);
};

export default {
  register,
  getUser,
  deleteUser,
  updateUser,
  login,
};
