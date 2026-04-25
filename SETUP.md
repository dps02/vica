# Vica Hydrate - Setup Instructions

A premium alkaline water brand website built with Spring Boot, Thymeleaf, Bootstrap, and MySQL.

## Prerequisites

- Java 17 or higher
- Maven 3.8.1 or higher
- MySQL 8.0 or higher

## Database Setup

### 1. Create MySQL Database

```bash
mysql -u root -p < db/schema.sql
```

This will:
- Create the `vica_hydrate` database
- Create `products` and `inquiries` tables
- Seed initial product data

### 2. Configure Database Connection

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vica_hydrate?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

Or set environment variables:
```bash
export DB_PASSWORD=your_mysql_password
```

## Running the Application

### Development Mode

```bash
mvn clean install
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

### Production Build

```bash
mvn clean package
java -jar target/vica-hydrate-1.0.0.jar --server.port=8080
```

## Project Structure

```
src/main/
├── java/com/vicahydrate/
│   ├── VicaHydrateApplication.java
│   ├── config/WebConfig.java
│   ├── controller/
│   │   ├── HomeController.java       (MVC pages: /, /about, /products, /compliance, /contact)
│   │   └── api/
│   │       ├── ProductApiController.java
│   │       └── InquiryApiController.java
│   ├── model/
│   │   ├── Product.java
│   │   └── Inquiry.java
│   ├── repository/
│   ├── service/
│   └── dto/
└── resources/
    ├── application.properties
    ├── templates/
    │   ├── fragments/layout.html
    │   └── pages/
    │       ├── home.html
    │       ├── about.html
    │       ├── products.html
    │       ├── compliance.html
    │       └── contact.html
    └── static/
        ├── css/main.css
        ├── js/main.js
        └── images/
```

## API Endpoints

### Products
- `GET /api/products` — List all available products
- `GET /api/products/{id}` — Get product by ID

### Inquiries
- `POST /api/inquiries` — Submit contact form inquiry

Example:
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "+91 98765 43210",
  "message": "I'd like to place a bulk order"
}
```

## Features

- Responsive, mobile-first design
- Hero section with animated bottle
- Product showcase with detailed cards
- Certification & compliance information
- Contact form with live AJAX submission
- SEO-optimized meta tags
- Smooth animations and transitions
- Bootstrap 5 + custom CSS
- Thymeleaf templating

## Technologies Used

- **Backend:** Spring Boot 3.2.3, Spring Data JPA
- **Frontend:** Thymeleaf, Bootstrap 5, Vanilla JS
- **Database:** MySQL 8.0
- **Build:** Maven

## License

Proprietary - Vica Hydrate
