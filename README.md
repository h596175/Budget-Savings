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
> 7. It is recommended that you send the "CreateGoal" request early on since the database has not been seeded with prior data regarding goals.

## Comments
Comments regaring design choices, decisions, or anything at all.
