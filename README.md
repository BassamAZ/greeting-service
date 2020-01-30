
# **Greeting Service**

**The purpose of this service**


The purpose of Greeting service is mainly to give demonstration of code writing basis.

## **Required Scope**

Development of a single REST endpoint GET /greeting which behaves in a manner that fulfills the following criteria:

1. Given the following input values account=personal and id=123 
and the allowable values for an account are personal and business
and the allowable values for id are all positive integers
then return "Hi, userId 123".

2. Given the following input values account=business and type=small and 
and the allowable values for an account are personal and business
and the allowable values for type are small and big
then return an error that the path is not yet implemented.

3. Given the following input values account=business and type=big and 
and the allowable values for an account are personal and business
and the allowable values for type are small and big
then return "Welcome, business user!".

## **Task**

We should be able to:
- build the application with Maven
- build the Docker image and run it
- make a request to localhost:5000/greeting and verify the behavior
Please provide an archive with the source code and a list of the terminal commands to build and run the application.

## **Functional services**

**Greeting service**

Contains simple methods which commonly used by other clients:

| Method | Path                | Description                  | User authenticated | Available from UI |
|--------|---------------------|------------------------------|--------------------|-------------------|
| GET    | /greeting/{id}      | Get specified greeting data   |                    |                   |
| GET    | /greeting/          | Get all greeting data        |                    |                   |
| POST   | /greeting/{greeting}| Get greeting data |                    |                   |


Notes:

-