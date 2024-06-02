import axios from 'axios';

const API_URL = 'http://localhost:8080/admin/auth/';

const register = (adminData) => {
  return axios.post(`${API_URL}register`, adminData);
};

const getAdmin = (username) => {
  return axios.get(`${API_URL}get`, { params: { username } });
};

const deleteAdmin = (username) => {
  return axios.delete(`${API_URL}delete`, { data: { username } });
};

const updateAdmin = (adminData) => {
  return axios.put(`${API_URL}update`, adminData);
};

const login = (adminData) => {
  return axios.post(`${API_URL}login`, adminData);
};

export default {
  register,
  getAdmin,
  deleteAdmin,
  updateAdmin,
  login,
};
