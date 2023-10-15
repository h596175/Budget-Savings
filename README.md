# Budget-Savings

## Task description
> I decided to focus mainly on backend with the goal of: "To help us and the banks to make this financial product more fun and incentivizing for the customer to save their money" in mind.
> 


## How to run
> Run in IDE:
> 1. Import the project as an existing maven project.
> 2. Right click MainApplication.java located in budgetsavings.main and run as "Java application"
> 3. Your are good to go when you get the message "Transaction initiliazition done!".
> 4. Navigate to the URL: "http://localhost:8080/h2-console", login with the username: "sa" (No password required) (jdbc url: jdbc:h2:mem:bank)
> 5. Double check that the tables have been seeded properly with the provided data by sending the queries: "SELECT * FROM ACCOUNT" and "SELECT * FROM TRANSACTION".
> 6. From here you can import my attached postman collection and start sending requests.
> 7. It is recommended that you send the "CreateGoal" request early on since the database has not been seeded with prior goal data.

## Comments
First off i decided to make this a Spring boot project as it is something im already familiar with, and also because https://start.spring.io/ makes the startup process easy.
Then i made a H2 database to avoid (hopefully) any conflicts regarding the database, as it is an in memory and persistent relational database.
Mid development i made the decision to forgo the frontend of the application, and rather focus on the foundation which it could later be built upon.


## Suggestions for improvement
- Make the program more robust: Create actual tests for testing the program, as most of the testing was done through postman/console.
- Apply more constraints: To what a user can or cannot do in terms of methods/requests they have at their disposal. Try to restrict them through both backend and frontend.
- Make use of HATEOAS: For ease of use.
- Frontend: Create a functioning frontend to compelete the project
- Support for different currencies: EUR, USD etc.
- Better reward system: Split the "road" to the goal into to multiple milestones. So instead of having 1 milestone set by the user you could instead make one at 150%, 200%, 250% of the savings account current balance. I would also change the flat +100 NOK gain when a milestone is reached into a point system instead. Where the owner of the account would gain different benefits depending on what sum of points they have.
- Changing the database: Make use Microsoft Azure to host a database instead of letting it run locally.
