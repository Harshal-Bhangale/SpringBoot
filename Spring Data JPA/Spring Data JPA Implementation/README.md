
# 🗂️ Application Management System - Spring Data JPA Implementation

This project demonstrates a complete implementation of Spring Data JPA using the latest repository interfaces like `ListCrudRepository` and `ListPagingAndSortingRepository`. It covers entity creation, annotation usage, CRUD operations, custom queries, and key improvements over older repositories.

---

## 🔧 Project Setup

1. **Create a Spring Boot Project**
   - Use [Spring Initializr](https://start.spring.io/)
   - Dependencies:
     - Spring Web
     - Spring Data JPA
     - H2 / MySQL / PostgreSQL (choose your DB)
     - Lombok (optional)

2. **Configure application.properties**
   ```properties
   spring.datasource.url=jdbc:h2:mem:appdb
   spring.datasource.driver-class-name=org.h2.Driver
   spring.datasource.username=hb
   spring.datasource.password=pass
   spring.jpa.hibernate.ddl-auto=update
   spring.h2.console.enabled=true
   ```

---

## 🧱 Create Entities

```java
@Entity
public class Applicant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;

    // Constructors, Getters, Setters
}
```

---

## 🔖 Spring Data JPA Annotations

| Annotation       | Purpose                                                                 |
|------------------|-------------------------------------------------------------------------|
| `@Entity`        | Marks the class as a JPA entity (mapped to a table).                    |
| `@Id`            | Marks the primary key.                                                  |
| `@GeneratedValue`| Strategy to auto-generate IDs.                                          |
| `@Column`        | Customize column mapping (optional).                                    |
| `@Table`         | Customize table name (optional).                                        |
| `@Query`         | Define custom JPQL or native SQL queries.                              |

---

## 📦 Repositories in Spring Data JPA

### 🕰️ Old Version (Before Spring 6 / Spring Boot 3)

#### `CrudRepository<T, ID>`
- Basic CRUD operations (save, findById, delete, etc.)
- Returns `Iterable` for `findAll()`
- Example:
```java
public interface ApplicantCrudRepository extends CrudRepository<Applicant, Long> {
}
```

> ❗ **Issue:** `findAll()` returns `Iterable`, needs conversion to `List`, increasing boilerplate.

#### `JpaRepository<T, ID>`
- Extends `PagingAndSortingRepository` and `CrudRepository`
- Adds methods like `findAll(Sort sort)`, `saveAll()`, `flush()`
- Suitable for advanced use cases.

#### `PagingAndSortingRepository<T, ID>`
- Adds pagination and sorting capabilities to `CrudRepository`

---

### 🆕 New in Spring Boot 3 / Spring Data 3+

#### `ListCrudRepository<T, ID>`
- Like `CrudRepository`, but `findAll()` returns `List<T>` instead of `Iterable<T>`
- Reduces boilerplate

```java
public interface ApplicantRepository extends ListCrudRepository<Applicant, Long> {
}
```

#### `ListPagingAndSortingRepository<T, ID>`
- Adds sorting + pagination support to `ListCrudRepository`
```java
public interface ApplicantPagingRepository extends ListPagingAndSortingRepository<Applicant, Long> {
}
```

---

## 🛠️ Inbuilt CRUD Methods

| Method                 | Description                          |
|------------------------|--------------------------------------|
| `save(entity)`         | Save or update a record              |
| `findById(id)`         | Retrieve by ID                       |
| `findAll()`            | Get all records                      |
| `deleteById(id)`       | Delete by ID                         |
| `existsById(id)`       | Check if record exists               |
| `count()`              | Total number of records              |

---

## 🔍 Query Methods (Derived Queries)

You can define methods in the repository by naming convention:

```java
List<Applicant> findByName(String name);
List<Applicant> findByEmailContaining(String keyword);
List<Applicant> findByJobRoleAndName(String jobRole, String name);
```

Spring will automatically generate queries based on method names.

---

## 🧾 @Query Annotation

Use `@Query` for custom JPQL or native SQL queries.

### JPQL Example:
```java
@Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
List<Applicant> findApplicantByPartialName(@Param("name") String name);
```

### Native SQL Example:
```java
@Query(value = "SELECT * FROM applicant WHERE email LIKE %:email%", nativeQuery = true)
List<Applicant> searchByEmail(@Param("email") String email);
```

---

## 📈 Pagination and Sorting

```java
Page<Applicant> findAll(Pageable pageable);
List<Applicant> findAll(Sort sort);
```

- Use `PageRequest.of(page, size)` for pagination
- Use `Sort.by("name").ascending()` for sorting

---

## ✅ Summary

| Feature                        | Old Repository           | New Repository                    |
|-------------------------------|--------------------------|------------------------------------|
| Return type for `findAll()`   | `Iterable<T>`            | `List<T>`                         |
| Less boilerplate              | ❌                        | ✅                                 |
| Supports Sorting              | `PagingAndSortingRepository` | `ListPagingAndSortingRepository` |
| Suitable for Simple Projects  | `CrudRepository`         | `ListCrudRepository`              |

---

## 🚀 Run & Test

1. Run the Spring Boot Application
2. Use Postman or Swagger UI to hit endpoints
3. Use H2 Console (`http://localhost:8080/h2-console`) to inspect DB

---

## 📚 Resources

- [Spring Data JPA Docs](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Spring Boot Repository Docs](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/ListCrudRepository.html)
