# Apache Camel Integration

This repository demonstrates how to integrate [Apache Camel](https://camel.apache.org/) with Spring Boot. All API routes are accessible under the context path `/camel/*`.

## Overview

Apache Camel is a powerful open-source integration framework that enables developers to integrate different systems using well-defined enterprise integration patterns (EIPs). In this project, Camel is used to expose RESTful endpoints, making it easy to build, extend, and maintain integration flows.

## Getting Started

### Prerequisites

- Java (17 or above)
- Maven (for building the project)

### Running the Application

1. Clone this repository:
   ```bash
   git clone https://github.com/bruce-mig/apache-camel-integration.git
   cd apache-camel-integration
   ```
2. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
3. The REST endpoints will be available at:
   ```
   http://localhost:9090/camel/*
   ```

### Example Endpoints

- `GET /camel/get-orders`  
  Example response:
```json
[
    {
        "id": 7,
        "name": "Mobile",
        "price": 5000.0
    },
    {
        "id": 8,
        "name": "Book",
        "price": 400.0
    },
    {
        "id": 8,
        "name": "Laptop",
        "price": 15000.0
    },
    {
        "id": 9,
        "name": "Tablet",
        "price": 8000.0
    }
]
  ```

- `GET /camel/get-orders`
```json
{
  "id": 10,
  "name": "airpods",
  "price": 25
}
```

## Why Use Apache Camel?

### Pros

- **Integration Patterns:** Implements a rich library of Enterprise Integration Patterns (EIPs) for complex routing, transformation, and mediation scenarios.
- **Component Ecosystem:** Offers 300+ components to connect to databases, message brokers, cloud services, and more.
- **Declarative Routing:** Use Java, XML, or DSLs to define routing logic in a readable and maintainable way.
- **Extensible:** Easily add custom processors, components, and error handling.
- **Community & Documentation:** Well-supported with extensive documentation and active community.

### Cons

- **Learning Curve:** The breadth of features and patterns can be daunting for newcomers.
- **Performance Overhead:** High abstraction may introduce some performance trade-offs compared to hand-crafted integrations.
- **Complexity in Large Projects:** Projects with hundreds of routes can become complex and harder to manage if not well-structured.
- **Dependency Management:** Large number of optional components may bloat the project if not managed carefully.

## When to Use Apache Camel

Apache Camel excels in scenarios where you need to integrate multiple systems or protocols, especially when complex routing, transformation, or mediation logic is required. For simple REST APIs without integration requirements, lighter frameworks may be more appropriate.

## Resources

- [Apache Camel Documentation](https://camel.apache.org/manual/latest/)
- [Camel REST DSL](https://camel.apache.org/components/latest/rest-component.html)

---

*Feel free to contribute or raise issues for enhancements!*
