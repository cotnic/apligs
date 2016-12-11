Links to REST services:

GET:
Get all users -> http://localhost:8080/apligs/v1/users/
Get user login -> http://localhost:8080/apligs/v1/users/login?email=mj0073@student.uni-lj.si&password=mitja

Get all instruments played by userID -> http://localhost:8080/apligs/v1/users/instruments?id=4
Get all genres from a user by ID -> http://localhost:8080/apligs/v1/users/genres?id=4


Get all message sent by user ID -> http://localhost:8080/apligs/v1/messages/2

Get all adverts from database -> http://localhost:8080/apligs/v1/adverts
Get specific advert with id -> http://localhost:8080/apligs/v1/adverts/2

Get List of Values for locations -> http://localhost:8080/apligs/v1/lov/locations
Get List of Values for roles -> http://localhost:8080/apligs/v1/lov/roles
Get List of Values for instruments -> http://localhost:8080/apligs/v1/lov/instruments
Get List of Values for genres -> http://localhost:8080/apligs/v1/lov/genres




POST:
Create new user -> http://localhost:8080/apligs/v1/users?location=2380&role=1&name=Spela&surname=Jurak&email=sj0511@student.uni-lj.si&password=spela
Create (send) new message -> http://localhost:8080/apligs/v1/messages/4?id=5&title=POSTMAN&msg=Kako kaj danes?


PUT:
Edit user -> http://localhost:8080/apligs/v1/users/9?name=Špela&surname=Jurak&email=sj0511@student.uni-lj.si




DELETE
Delete message with id -> http://localhost:8080/apligs/v1/messages/6
Deletes an advert with id -> http://localhost:8080/apligs/v1/adverts/6




