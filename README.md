# Movie Production House Simulator

A simulation of operations within a movie production house, implemented as part of the CSE213 Object-Oriented Programming course. This project showcases real-world software design using Java and object-oriented principles.

## Project Overview

This project simulates the workflows, scheduling, resource management, and collaboration typical of a movie production house like Warner Brothers. With role-based functionalities, this system manages appointments, orders, resources, and creative collaborations effectively.

### Features
- **Role-Specific Dashboards**: Each role, including Producer, Project Manager, and Resource Supplier, has distinct functionalities.
- **Appointment Management**: Schedule and manage project-related appointments.
- **Inventory and Order Management**: Handle resource orders and maintain inventory for production requirements.
- **Visualization Tools**: Generate performance analysis charts and other visual aids.
- **Collaboration Features**: Facilitates communication and workflow alignment among team members.

---

## Key Contributors

### My Role
I am **Mst. Aysa Siddika Meem**, and I contributed to the project in the following roles:

#### Project Manager (User7)
1. **Create Appointment Schedule**: Developed a system to:
   - View all appointment schedules through a dedicated interface.
   - Define participation designations, including dates and times.
   - Save appointment schedules into the database with confirmation generation.

2. **View Director's Purchase Requests**: Built a feature to:
   - Access purchase requests submitted by the Director.
   - Inform resource suppliers with authorized requests.
   - Maintain accurate records of approved purchase requests.

3. **Leave Management System**: Designed a module to:
   - Apply for leave by specifying dates and reasons.
   - Track the status of leave applications (approved, pending, or denied).
   - Maintain a record of leave applications for future reference.

4. **Budget Collaboration**: Collaborated with the Producer to:
   - Discuss and review the approximate budget for production.
   - Suggest and distribute the budget among team members and production tools.
   - Verify calculated budgets and ensure proper adjustments.

5. **View All Movie Locations**: Implemented functionality to:
   - Access and review movie shooting locations.
   - Provide feedback on location choices.

6. **Inventory Management**: Developed features to:
   - Track current production resources.
   - Reorder damaged equipment and update inventory statuses in the database.

7. **Place and Confirm Resource Orders**: Built a system to:
   - Place resource orders by selecting quantities and delivery dates.
   - Confirm order acknowledgments and update the inventory system accordingly.

8. **Creative Team Collaboration**: Ensured smooth collaboration with:
   - The Producer to align on goals and constraints.
   - The Director to execute the creative vision.
   - The Resource Supplier to provide necessary resources.
   - Facilitated communication across all team members.

#### Resource Supplier (User8)
1. **Product Management**: Implemented a system to:
   - Add, update, and delete product details in the database.
   - Ensure newly added products are visible to the Project Manager.

2. **Order Confirmation**: Built workflows to:
   - Confirm orders after delivering production resources.
   - Notify the Project Manager and update the database with order statuses.

3. **View Products and History**:
   - Display a comprehensive list of all available products.
   - Allow viewing and managing order and supply history.

4. **Data Visualization**: Created statistical tools to:
   - Generate performance analysis pie charts for products.
   - Ensure data is current and accessible.

5. **Appointment Scheduling**: Enabled scheduling of appointments with the Project Manager by:
   - Creating and saving appointment details in the system.
   - Ensuring visibility and notifications for both parties.

6. **Collaboration**: Worked with the Producer and Director to align resources with creative goals.

---

## File Structure
The project includes the following key components:

### 1. **Source Files**
- **Controllers**
  - `User_7_8_CreateAppoinmentScheduleToProjectManagerController.java`: Manages the creation and management of appointments for the Project Manager. Handles form validations and table updates dynamically.
  - `User_8_ConfirmationOrderController.java`: Handles the confirmation of resource orders by the Resource Supplier. Implements functionality to add items to the order list.
  - `User_8_Resource_Supplier_DashboardController.java`: Provides the main dashboard for the Resource Supplier, with navigation to various scenes like order details, product performance, and appointment scheduling.

- **FXML Files** (User Interfaces)
  - `User_7_8_CreateAppoinmentScheduleToProjectManager.fxml`: Defines the UI layout for creating appointments.
  - `User_8_Product_Chart_Analysis.fxml`: UI for displaying product performance analysis using charts.

### 2. **Model Classes**
- **Appointment**: Represents an appointment with properties like designation, date, and time.
- **Item**: Represents a product item with properties like name and quantity.
- **ProductReadWrite**: Handles data persistence for product-related actions.

### 3. **Data Files**
- Stores serialized data for appointments, orders, and product inventory.

---

## Setup and Usage

### Prerequisites
- **Java JDK** 8 or higher
- **JavaFX** runtime for graphical interfaces
- An IDE such as IntelliJ IDEA, Eclipse, or NetBeans


