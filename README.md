# Hotel Booking Project


The hotel project is a comprehensive hotel management system designed to facilitate seamless operations for hospitality establishments. It encompasses various functionalities, catering to both the administrative side of hotel operations and enhancing the customer experience. At its core, the system offers robust capabilities for hotel reservation management, room allocation, and facilities management.
The platform will offer a user-friendly interface for both guests and administrators, ensuring efficient management of bookings and hotel information.

User Use-Cases:
Search and Browse:
-Users can search for hotels based on location, dates, price range, and amenities.
-Browse through a list of hotels with detailed descriptions, images, and reviews.

Booking Process:
-Select desired dates and room types.
-View real-time availability and pricing.
-Fill in the necessary data to make the reservation

User Accounts:
-Users can create accounts to manage bookings and personal information.

Reviews and Ratings:
-Users can leave reviews and ratings based on their stay experience.
-View reviews from other guests.

Admin Use-Cases:
Hotel Management:
-Add, edit, or remove hotel listings.
-Manage availability calendars.

Booking Management:
-View and manage all incoming bookings, including pending, confirmed, and canceled reservations.
-Modify booking details, such as dates, room types, and guest information.

User Management:
-Admins can manage user accounts, including registration, authentication, and account deletion.
-Access user data for analysis and customer relationship management.

Features:
-Customers who spend a certain amount of money will be generated a voucher that they can use for their current vacation or future bookings.

Classes:

Hotel Booking Project
The platform will offer a user-friendly interface for both guests and administrators, ensuring efficient management of bookings and hotel information.

User Use-Cases:
Search and Browse:
-Users can search for hotels based on location, dates, price range, and amenities.
-Browse through a list of hotels with detailed descriptions, images, and reviews.

Booking Process:
-Select desired dates and room types.
-View real-time availability and pricing.
-Fill in the necessary data to make the reservation

User Accounts:
-Users can create accounts to manage bookings and personal information.

Reviews and Ratings:
-Users can leave reviews and ratings based on their stay experience.
-View reviews from other guests.

Admin Use-Cases:
Hotel Management:
-Add, edit, or remove hotel listings.
-Manage availability calendars.

Booking Management:
-View and manage all incoming bookings, including pending, confirmed, and canceled reservations.
-Modify booking details, such as dates, room types, and guest information.

User Management:
-Admins can manage user accounts, including registration, authentication, and account deletion.
-Access user data for analysis and customer relationship management.

Features:
-Customers who spend a certain amount of money will be generated a voucher that they can use for their current vacation or future bookings.

Database Diagram:

![diagrama](https://github.com/dincadenisa/hotel_booking/assets/126794370/5fd4bc4c-b46b-48af-96bf-decb783a9512)


# Endpoints

In the hotel management system, several key endpoints play pivotal roles in facilitating the operations and interactions between the users and the system. Here's an overview of the endpoints developed and their functionalities:

Hotel Registration (POST /hotel/register)
This endpoint is designed for registering new hotels within the system. It accepts details such as the hotel's name, address, description, rating, rooms count, and facilities through a HotelRegistrationBody. This information is used to create a new hotel entry in the database. If a hotel with the same name already exists, it throws a HotelAlreadyExistsException, ensuring unique entries.

Hotel Deletion (DELETE /hotel/delete/{id})
The hotel deletion endpoint allows for the removal of a hotel from the system based on its unique identifier (id). This operation is crucial for maintaining an up-to-date listing of active hotels and removing those that are no longer operational or part of the hotel chain.

Fetch Hotel Details (GET /hotel/get/{id})
This endpoint retrieves the details of a specific hotel by its ID. It serves as a crucial feature for both administrators and customers, allowing them to view comprehensive information about a hotel, including its amenities, rooms, and services. If no hotel is found with the given ID, it returns a not found response, indicating the absence of such an entry in the system.

Hotel Update (PUT /hotel/update/{id})
The hotel update endpoint allows for modifying the details of an existing hotel. It requires the hotel's ID for identification and a HotelRegistrationBody with the new details to be updated. This feature is essential for keeping hotel information current, reflecting changes in services, facilities, or operational details.


User Registration (POST /auth/register)
This endpoint focuses on the registration of new users into the system. It leverages a RegistrationBody containing user details like name, email, and password. Upon successful registration, it returns an HTTP OK response. If an attempt is made to register a user that already exists, a UserAlreadyExistsException is thrown, resulting in an HTTP CONFLICT response, thus ensuring user uniqueness.

User Deletion (DELETE /auth/delete)
The deletion endpoint allows for the removal of a user from the system based on the provided RegistrationBody, which includes identification details such as the user's email or username. This functionality is crucial for users who wish to remove their accounts from the platform, catering to privacy and data management standards.

Fetch User Details (GET /auth/get)
Retrieving user information is facilitated through this endpoint, which requires a RegistrationBody for identification. This operation is essential for profile management and customization, enabling users to view and verify their stored information within the system.

Update User Information (PUT /auth/put)
The update endpoint serves to modify existing user details. Users can update their information such as name, email, or password through a RegistrationBody. This feature supports dynamic user data management, allowing for a flexible and responsive user experience.


Admin Registration (POST /admin/auth/register)
This endpoint is dedicated to the registration of new admin users. It accepts an AdminRegistrationBody containing the admin's registration details such as username, email, and password. Successful registration returns the registered admin's details. If an admin with the same identifying information already exists, it throws an AdminAlreadyExistsException, leading to an HTTP CONFLICT response. This ensures that each admin is unique within the system.

Admin Deletion (DELETE /admin/auth/delete)
The deletion endpoint allows for the removal of an admin from the system based on their registration information provided in an AdminRegistrationBody. This function is essential for maintaining the integrity and security of the admin panel by allowing the removal of admin accounts when necessary.

Retrieve Admin Information (GET /admin/auth/get)
This functionality enables the retrieval of admin details. It requires an AdminRegistrationBody for identifying the admin whose information is to be fetched. This feature is crucial for admin management and verification purposes, ensuring that admins can access and review their stored information within the system.

Update Admin Information (PUT /admin/auth/update)
The update endpoint facilitates the modification of existing admin details. Admins can update their information through an AdminRegistrationBody. This capability is vital for dynamic admin data management, accommodating changes in admin roles, permissions, or personal details.

# Observer Pattern

The Observer Pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them of any state changes, typically by calling one of their methods. It is primarily used to implement distributed event handling systems, in a manner that is decoupled between the object whose state is being observed (the subject) and the objects that need to be notified upon the state change (the observers).

In the context of the provided classes, the Observer Pattern is used to notify admins via email whenever a new user registers. This is an efficient way to keep the administration informed about user activities without requiring them to constantly check the system for updates. Here’s a breakdown of how the Observer Pattern is implemented in these classes:

Observer Interface
This defines a common interface for all observers, ensuring they implement the update(User user) method. When notified, observers will execute this method, which encapsulates the reaction to the notification, in this case, sending an email to the admin.

AdminNotificationObserver Class
Implements the Observer interface. This class is responsible for sending email notifications to the admin whenever it is updated with a new user registration. It utilizes JavaMail API properties for configuring the email session and sends out the email using SMTP protocol. The update method here specifically builds and sends an email to a predetermined admin email address whenever it's invoked.

Subject Interface
Defines the operations for attaching, detaching, and notifying observers. It’s a crucial part of the pattern, allowing the subject to manage its observers. The implementation of this interface (not fully shown) would handle the registration and deregistration of observers and notify them of changes.

ObserverConfig Class
This class uses dependency injection to bring together the UserService (acting as the subject) and the AdminNotificationObserver (an observer). It automatically registers the AdminNotificationObserver with the UserService upon initialization, leveraging the @PostConstruct annotation. This setup ensures that the observer is ready to receive updates as soon as the application starts.
