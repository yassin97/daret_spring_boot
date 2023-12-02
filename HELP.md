# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)

# conception

users: id, username, password
daret: id, created_by, name, participant_number, frequency,
        start_date (nullable; when null ? daret is not operational : operational),
        amount, draw (e.g: 1,5,2,6,8,...), turn_user_id, step_number (which period we're at)
daret_participants: id, user_id, daret_id

