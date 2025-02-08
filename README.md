## User API

![usermodule](https://github.com/user-attachments/assets/26602ed9-bf45-4e42-84cf-f05160e8299a)

**Description:** The User API is responsible for handling all user-related operations, such as registration, login, profile updates, and bookmarking projects.

**Components:**

* **User API:** This is the main entry point for all user-related requests.
* **User Business Logic:** Contains the logic for processing user-related operations.
* **User Repository:** Stores user data, including user profiles, bookmarks, and saved projects.

**Interactions:**

* **Client Layer:** The User API receives requests from the client layer, such as registration, login, or profile updates.
* **Authentication:** The User API interacts with the authentication service to verify user credentials during login.
* **Project Service:** The User API interacts with the project service to get information about projects for bookmarking.
* **User Repository:** The User API interacts with the user repository to store and retrieve user data.

**Data Flow:**

1. The client layer sends a request to the User API.
2. The User API verifies the request and passes it to the User Business Logic.
3. The User Business Logic processes the request, interacts with the User Repository, and publishes events to the event bus.
4. The User API sends the response back to the client layer.

**External Services:**

* **Authentication Service:** Used to verify user credentials during login.
* **Project Service:** Used to get information about projects for bookmarking.
