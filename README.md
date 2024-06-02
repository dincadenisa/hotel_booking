# Hotel Booking Project

The hotel project is a comprehensive hotel management system designed to facilitate seamless operations for hospitality establishments. It encompasses various functionalities, catering to both the administrative side of hotel operations and enhancing the customer experience. At its core, the system offers robust capabilities for hotel reservation management, room allocation, and facilities management.
The platform will offer a user-friendly interface for both guests and administrators, ensuring efficient management of bookings and hotel information.

## Project Functionality

The Hotel Booking Project is designed to cover a wide range of functionalities, making it a versatile tool for both guests and hotel administrators. Below is an overview of the core features and functionalities provided by the system:
![umlhotel](https://github.com/dincadenisa/hotel_booking/assets/126794370/4415b330-663b-4a22-83e5-408d4951bc59)

### Use Case Descriptions
<<<<<<< HEAD

![usecase](https://github.com/dincadenisa/hotel_booking/assets/126794370/8d45971b-04cc-4ffd-9d23-d04036855f87)

#### User Use Cases

1. **Register**

   - **Description:** Users can create a new account by providing necessary details such as username, email, password, and other personal information. This process ensures that users have a unique identity within the system.
   - **Steps:**
     1. The user accesses the registration page.
     2. The user fills out the registration form with the required information.
     3. The system validates the information and creates a new user account.
     4. The user receives a confirmation message upon successful registration.

2. **Log In**

   - **Description:** Users can log in to their accounts using their registered email or username and password. This allows them to access personalized features such as booking history and account management.
   - **Steps:**
     1. The user navigates to the login page.
     2. The user enters their email/username and password.
     3. The system verifies the credentials.
     4. Upon successful authentication, the user is redirected to the homepage or dashboard.

3. **Choose Room**

   - **Description:** Users can browse through available rooms based on their preferences such as room type, price range, and amenities. They can view detailed descriptions and images of each room.
   - **Steps:**
     1. The user searches for rooms using filters like location, dates, and price.
     2. The system displays a list of available rooms matching the criteria.
     3. The user selects a room to view more details.
     4. The user confirms their choice by selecting the room for booking.

4. **Enter Details for Booking**

   - **Description:** Users enter booking details such as check-in and check-out dates, number of guests, and personal information to complete the reservation process.
   - **Steps:**
     1. The user provides check-in and check-out dates.
     2. The user enters the number of guests.
     3. The user fills out personal information required for the booking.
     4. The system calculates the total cost and presents a summary for confirmation.

5. **Book Room**
   - **Description:** Users confirm their booking details and proceed to make a reservation. The system saves the booking information and generates a booking confirmation.
   - **Steps:**
     1. The user reviews the booking summary.
     2. The user confirms the booking and submits the reservation.
     3. The system processes the booking and stores it in the database.
     4. The user receives a booking confirmation and details via email.

#### Admin Use Cases

1. **Log In**

   - **Description:** Admins can log in to the system using their credentials to manage users and reservations.
   - **Steps:**
     1. The admin navigates to the login page.
     2. The admin enters their username and password.
     3. The system verifies the credentials.
     4. Upon successful authentication, the admin is redirected to the admin dashboard.

2. **View, Update, and Delete Users**

   - **Description:** Admins can manage user accounts by viewing user details, updating user information, and deleting user accounts as necessary.
   - **Steps:**

=======
![usecase](https://github.com/dincadenisa/hotel_booking/assets/126794370/8d45971b-04cc-4ffd-9d23-d04036855f87)

#### User Use Cases

1. **Register**
   - **Description:** Users can create a new account by providing necessary details such as username, email, password, and other personal information. This process ensures that users have a unique identity within the system.
   - **Steps:**
     1. The user accesses the registration page.
     2. The user fills out the registration form with the required information.
     3. The system validates the information and creates a new user account.
     4. The user receives a confirmation message upon successful registration.

2. **Log In**
   - **Description:** Users can log in to their accounts using their registered email or username and password. This allows them to access personalized features such as booking history and account management.
   - **Steps:**
     1. The user navigates to the login page.
     2. The user enters their email/username and password.
     3. The system verifies the credentials.
     4. Upon successful authentication, the user is redirected to the homepage or dashboard.

3. **Choose Room**
   - **Description:** Users can browse through available rooms based on their preferences such as room type, price range, and amenities. They can view detailed descriptions and images of each room.
   - **Steps:**
     1. The user searches for rooms using filters like location, dates, and price.
     2. The system displays a list of available rooms matching the criteria.
     3. The user selects a room to view more details.
     4. The user confirms their choice by selecting the room for booking.

4. **Enter Details for Booking**
   - **Description:** Users enter booking details such as check-in and check-out dates, number of guests, and personal information to complete the reservation process.
   - **Steps:**
     1. The user provides check-in and check-out dates.
     2. The user enters the number of guests.
     3. The user fills out personal information required for the booking.
     4. The system calculates the total cost and presents a summary for confirmation.

5. **Book Room**
   - **Description:** Users confirm their booking details and proceed to make a reservation. The system saves the booking information and generates a booking confirmation.
   - **Steps:**
     1. The user reviews the booking summary.
     2. The user confirms the booking and submits the reservation.
     3. The system processes the booking and stores it in the database.
     4. The user receives a booking confirmation and details via email.

#### Admin Use Cases

1. **Log In**
   - **Description:** Admins can log in to the system using their credentials to manage users and reservations.
   - **Steps:**
     1. The admin navigates to the login page.
     2. The admin enters their username and password.
     3. The system verifies the credentials.
     4. Upon successful authentication, the admin is redirected to the admin dashboard.

2. **View, Update, and Delete Users**
   - **Description:** Admins can manage user accounts by viewing user details, updating user information, and deleting user accounts as necessary.
   - **Steps:**

>>>>>>> f1e72ffc0939f20551054eb05b09c9704fc615af
     1. The admin accesses the user management section.
     2. The admin views a list of all users.
     3. The admin selects a user to view detailed information.
     4. The admin can update user information or delete the user account.
     5. The system saves changes and updates the database accordingly.

3. **View, Update, and Delete Reservations**
   - **Description:** Admins can manage reservations by viewing all bookings, updating reservation details, and deleting reservations if required.
   - **Steps:**
     1. The admin accesses the reservation management section.
     2. The admin views a list of all reservations.
     3. The admin selects a reservation to view detailed information.
     4. The admin can update reservation details or delete the reservation.
     5. The system saves changes and updates the database accordingly.

## Endpoints

In the hotel management system, several key endpoints play pivotal roles in facilitating the operations and interactions between the users and the system. Here's an overview of the endpoints developed and their functionalities:
![uml2hotel](https://github.com/dincadenisa/hotel_booking/assets/126794370/85bc0074-a3b4-442f-bf25-9cf08e0ed8a2)

### Hotel Endpoints

- **Hotel Registration (POST /hotel/register)**:
<<<<<<< HEAD

  - This endpoint is designed for registering new hotels within the system. It accepts details such as the hotel's name, address, description, rating, rooms count, and facilities through a `HotelRegistrationBody`. This information is used to create a new hotel entry in the database. If a hotel with the same name already exists, it throws a `HotelAlreadyExistsException`, ensuring unique entries.

- **Hotel Deletion (DELETE /hotel/delete/{id})**:

  - The hotel deletion endpoint allows for the removal of a hotel from the system based on its unique identifier (id). This operation is crucial for maintaining an up-to-date listing of active hotels and removing those that are no longer operational or part of the hotel chain.

- **Fetch Hotel Details (GET /hotel/get/{id})**:

  - This endpoint retrieves the details of a specific hotel by its ID. It serves as a crucial feature for both administrators and customers, allowing them to view comprehensive information about a hotel, including its amenities, rooms, and services. If no hotel is found with the given ID, it returns a not found response, indicating the absence of such an entry in the system.

- **Hotel Update (PUT /hotel/update/{id})**:
  - The hotel update endpoint allows for modifying the details of an existing hotel. It requires the hotel's ID for identification and a `HotelRegistrationBody` with the new details to be updated. This feature is essential for keeping hotel information current, reflecting changes in services, facilities, or operational details.

### User Endpoints

- **User Registration (POST /auth/register)**:

  - This endpoint focuses on the registration of new users into the system. It leverages a `RegistrationBody` containing user details like name, email, and password. Upon successful registration, it returns an HTTP OK response. If an attempt is made to register a user that already exists, a `UserAlreadyExistsException` is thrown, resulting in an HTTP CONFLICT response, thus ensuring user uniqueness.

- **User Deletion (DELETE /auth/delete)**:

  - The deletion endpoint allows for the removal of a user from the system based on the provided `RegistrationBody`, which includes identification details such as the user's email or username. This functionality is crucial for users who wish to remove their accounts from the platform, catering to privacy and data management standards.

- **Fetch User Details (GET /auth/get)**:

  - Retrieving user information is facilitated through this endpoint, which requires a `RegistrationBody` for identification. This operation is essential for profile management and customization, enabling users to view and verify their stored information within the system.

- **Update User Information (PUT /auth/put)**:
  - The update endpoint serves to modify existing user details. Users can update their information such as name, email, or password through a `RegistrationBody`. This feature supports dynamic user data management, allowing for a flexible and responsive user experience.

### Admin Endpoints

- **Admin Registration (POST /admin/auth/register)**:

  - This endpoint is dedicated to the registration of new admin users. It accepts an `AdminRegistrationBody` containing the admin's registration details such as username, email, and password. Successful registration returns the registered admin's details. If an admin with the same identifying information already exists, it throws an `AdminAlreadyExistsException`, leading to an HTTP CONFLICT response. This ensures that each admin is unique within the system.

- **Admin Deletion (DELETE /admin/auth/delete)**:

  - The deletion endpoint allows for the removal of an admin from the system based on their registration information provided in an `AdminRegistrationBody`. This function is essential for maintaining the integrity and security of the admin panel by allowing the removal of admin accounts when necessary.

- **Retrieve Admin Information (GET /admin/auth/get)**:

=======
  - This endpoint is designed for registering new hotels within the system. It accepts details such as the hotel's name, address, description, rating, rooms count, and facilities through a `HotelRegistrationBody`. This information is used to create a new hotel entry in the database. If a hotel with the same name already exists, it throws a `HotelAlreadyExistsException`, ensuring unique entries.

- **Hotel Deletion (DELETE /hotel/delete/{id})**:
  - The hotel deletion endpoint allows for the removal of a hotel from the system based on its unique identifier (id). This operation is crucial for maintaining an up-to-date listing of active hotels and removing those that are no longer operational or part of the hotel chain.

- **Fetch Hotel Details (GET /hotel/get/{id})**:
  - This endpoint retrieves the details of a specific hotel by its ID. It serves as a crucial feature for both administrators and customers, allowing them to view comprehensive information about a hotel, including its amenities, rooms, and services. If no hotel is found with the given ID, it returns a not found response, indicating the absence of such an entry in the system.

- **Hotel Update (PUT /hotel/update/{id})**:
  - The hotel update endpoint allows for modifying the details of an existing hotel. It requires the hotel's ID for identification and a `HotelRegistrationBody` with the new details to be updated. This feature is essential for keeping hotel information current, reflecting changes in services, facilities, or operational details.

### User Endpoints

- **User Registration (POST /auth/register)**:
  - This endpoint focuses on the registration of new users into the system. It leverages a `RegistrationBody` containing user details like name, email, and password. Upon successful registration, it returns an HTTP OK response. If an attempt is made to register a user that already exists, a `UserAlreadyExistsException` is thrown, resulting in an HTTP CONFLICT response, thus ensuring user uniqueness.

- **User Deletion (DELETE /auth/delete)**:
  - The deletion endpoint allows for the removal of a user from the system based on the provided `RegistrationBody`, which includes identification details such as the user's email or username. This functionality is crucial for users who wish to remove their accounts from the platform, catering to privacy and data management standards.

- **Fetch User Details (GET /auth/get)**:
  - Retrieving user information is facilitated through this endpoint, which requires a `RegistrationBody` for identification. This operation is essential for profile management and customization, enabling users to view and verify their stored information within the system.

- **Update User Information (PUT /auth/put)**:
  - The update endpoint serves to modify existing user details. Users can update their information such as name, email, or password through a `RegistrationBody`. This feature supports dynamic user data management, allowing for a flexible and responsive user experience.

### Admin Endpoints

- **Admin Registration (POST /admin/auth/register)**:
  - This endpoint is dedicated to the registration of new admin users. It accepts an `AdminRegistrationBody` containing the admin's registration details such as username, email, and password. Successful registration returns the registered admin's details. If an admin with the same identifying information already exists, it throws an `AdminAlreadyExistsException`, leading to an HTTP CONFLICT response. This ensures that each admin is unique within the system.

- **Admin Deletion (DELETE /admin/auth/delete)**:
  - The deletion endpoint allows for the removal of an admin from the system based on their registration information provided in an `AdminRegistrationBody`. This function is essential for maintaining the integrity and security of the admin panel by allowing the removal of admin accounts when necessary.

- **Retrieve Admin Information (GET /admin/auth/get)**:
>>>>>>> f1e72ffc0939f20551054eb05b09c9704fc615af
  - This functionality enables the retrieval of admin details. It requires an `AdminRegistrationBody` for identifying the admin whose information is to be fetched. This feature is crucial for admin management and verification purposes, ensuring that admins can access and review their stored information within the system.

- **Update Admin Information (PUT /admin/auth/update)**:
  - The update endpoint facilitates the modification of existing admin details. Admins can update their information through an `AdminRegistrationBody`. This capability is vital for dynamic admin data management, accommodating changes in admin roles, permissions, or personal details.

### Reservation Endpoints

- **Create Reservation (POST /reservation/create)**:
<<<<<<< HEAD

  - This endpoint allows for the creation of new reservations by accepting reservation details through a `ReservationRegistrationBody`. If successful, it returns the created reservation. In case of any conflicts like the hotel or room not existing, appropriate exceptions are thrown.

- **Delete Reservation (DELETE /reservation/delete/{id})**:

  - This endpoint deletes a reservation identified by its unique ID. It's crucial for managing bookings and ensuring only valid reservations exist in the system.

- **Fetch Reservation Details (GET /reservation/get/{id})**:

  - This endpoint retrieves the details of a specific reservation by its ID. It helps both users and admins to view booking information. If the reservation does not exist, a not found response is returned.

- **Update Reservation (PUT /reservation/update/{id})**:

=======
  - This endpoint allows for the creation of new reservations by accepting reservation details through a `ReservationRegistrationBody`. If successful, it returns the created reservation. In case of any conflicts like the hotel or room not existing, appropriate exceptions are thrown.

- **Delete Reservation (DELETE /reservation/delete/{id})**:
  - This endpoint deletes a reservation identified by its unique ID. It's crucial for managing bookings and ensuring only valid reservations exist in the system.

- **Fetch Reservation Details (GET /reservation/get/{id})**:
  - This endpoint retrieves the details of a specific reservation by its ID. It helps both users and admins to view booking information. If the reservation does not exist, a not found response is returned.

- **Update Reservation (PUT /reservation/update/{id})**:
>>>>>>> f1e72ffc0939f20551054eb05b09c9704fc615af
  - This endpoint updates the details of an existing reservation. It requires the reservation ID and new details in a `ReservationRegistrationBody`. It ensures that booking information remains current and accurate.

- **Fetch All Reservations (GET /reservation/all)**:
  - This endpoint retrieves a list of all reservations in the system, facilitating comprehensive booking management for administrators.

## Observer Pattern

The Observer Pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them of any state changes, typically by calling one of their methods. It is primarily used to implement distributed event handling systems, in a manner that is decoupled between the object whose state is being observed (the subject) and the objects that need to be notified upon the state change (the observers).

In the context of the provided classes, the Observer Pattern is used to notify admins via email whenever a new user registers. This is an efficient way to keep the administration informed about user activities without requiring them to constantly check the system for updates. Here’s a breakdown of how the Observer Pattern is implemented in these classes:

### Observer Interface

This defines a common interface for all observers, ensuring they implement the `update(User user)` method. When notified, observers will execute this method, which encapsulates the reaction to the notification, in this case, sending an email to the admin.

### AdminNotificationObserver Class

Implements the Observer interface. This class is responsible for sending email notifications to the admin whenever it is updated with a new user registration. It utilizes JavaMail API properties for configuring the email session and sends out the email using SMTP protocol. The update method here specifically builds and sends an email to a predetermined admin email address whenever it's invoked.

### ObserverConfig Class

This class uses dependency injection to bring together the UserService (acting as the subject) and the AdminNotificationObserver (an observer). It automatically registers the AdminNotificationObserver with the UserService upon initialization, leveraging the `@PostConstruct` annotation. This setup ensures that the observer is ready to receive updates as soon as the application starts.

## Front-End Overview

### Introduction

The front-end of the Hotel Booking Project is built using React, a popular JavaScript library for building user interfaces. The application provides a smooth and intuitive experience for both guests and administrators, allowing them to interact with the system efficiently.

### Main Components

#### 1. LoginForm

- **Purpose:** Allows users and admins to log in to the system.
- **Functionality:**
  - Accepts username and password.
  - Attempts to log in as a user first; if unsuccessful, it tries to log in as an admin.
  - Navigates to the appropriate dashboard based on the user role.

#### 2. RegisterPage

- **Purpose:** Allows new users to create an account.
- **Functionality:**
  - Collects user details such as username, email, password, first name, and last name.
  - Submits the registration form to the backend.
  - Displays success or error messages based on the response.

#### 3. HomePage

- **Purpose:** Displays a list of available rooms for booking.
- **Functionality:**
  - Fetches room data from the backend.
  - Displays each room in a card format with an image, description, and price.
  - Includes a "Book Now" button for each room that navigates to the reservation page.

#### 4. ReservationPage

- **Purpose:** Allows users to book a room.
- **Functionality:**
  - Collects booking details such as guest name, phone number, number of persons, check-in, and check-out dates.
  - Calculates the total price based on the selected dates and room rate.
  - Submits the booking details to the backend.

#### 5. AdminPage

- **Purpose:** Provides an admin dashboard with various management options.
- **Functionality:**
  - Displays actions such as managing users and viewing reservations.
  - Navigates to the appropriate admin functionalities like user management and reservation management.

#### 6. ViewReservationsPage

- **Purpose:** Allows admins to view, update, and delete reservations.
- **Functionality:**
  - Fetches and displays a list of reservations from the backend.
  - Includes options to edit or delete each reservation.
  - Provides a form to update reservation details.

### Workflow

#### User Interaction

1. **Registration and Login:**
<<<<<<< HEAD

=======
>>>>>>> f1e72ffc0939f20551054eb05b09c9704fc615af
   - Users can register using the `RegisterPage`.
   - They can log in through the `LoginForm`, which redirects them to the homepage upon successful login.

2. **Searching and Booking:**
<<<<<<< HEAD

=======
>>>>>>> f1e72ffc0939f20551054eb05b09c9704fc615af
   - Users browse available rooms on the `HomePage`.
   - They select a room and proceed to the `ReservationPage` to complete the booking process.

3. **Profile Management:**
   - Users can access their profile information by clicking on the profile button, which displays their details (excluding the password).

#### Admin Interaction

1. **Admin Dashboard:**
<<<<<<< HEAD

=======
>>>>>>> f1e72ffc0939f20551054eb05b09c9704fc615af
   - Admins log in using the `LoginForm` and are redirected to the `AdminPage`.
   - They can manage users and reservations from the dashboard.

2. **Managing Reservations:**
   - Admins can view all reservations on the `ViewReservationsPage`.
   - They can update or delete reservations as needed, ensuring efficient reservation management.

### Styling

- **CSS:** Each component is styled using its corresponding CSS file to ensure a consistent and visually appealing interface.
- **Responsiveness:** The layout is designed to be responsive, providing a good user experience across different devices and screen sizes.

### API Interaction

- **Axios:** The application uses Axios for making HTTP requests to the backend. This library simplifies the process of sending asynchronous requests and handling responses.
- **Endpoints:** The front-end interacts with various endpoints to fetch data (e.g., room details, reservations) and perform actions (e.g., create bookings, update reservations).

By combining these components and workflows, the front-end of the Hotel Booking Project delivers a comprehensive and user-friendly interface for both guests and administrators, facilitating efficient hotel management and booking processes.
