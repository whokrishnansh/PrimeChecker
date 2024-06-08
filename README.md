# PrimeChecker
This is a simple project based on HTML,CSS Frontend and Java Spring Boot Backend that checks whether a given number is prime or not.


```markdown
# PrimeChecker

PrimeChecker is a simple Spring Boot web application that allows users to check if a given number is prime. The application uses Thymeleaf for server-side rendering of the HTML template and Spring Boot for handling the backend logic.

## Features

- Input a number to check if it is prime
- Server-side validation and prime checking logic
- Clean and responsive UI using HTML and CSS

## Project Structure

```
src
└── main
    ├── java
    │   └── com.example.demo
    │       ├── DemoApplication.java
    │       ├── PrimeCheckerController.java
    │       └── PrimeService.java
    └── resources
        ├── static
        │   └── css
        │       └── styles.css
        ├── templates
        │   └── index.html
        └── application.properties
```

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6.0 or later
- An IDE like IntelliJ IDEA or Eclipse
- Git

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/whokrishnansh/PrimeChecker.git
   cd PrimeChecker
   ```

2. **Build the project:**

   ```bash
   mvn clean install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

4. **Open your web browser and navigate to:**

   ```
   http://localhost:8080/
   ```

## Usage

1. **Enter a number** in the input field.
2. **Click the "Check" button** to determine if the number is prime.
3. **View the result** displayed below the form.

## Technologies Used

- Java
- Spring Boot
- Thymeleaf
- HTML
- CSS

## Project Details

### `DemoApplication.java`

This is the main entry point of the Spring Boot application.

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### `PrimeCheckerController.java`

This controller handles HTTP requests and responses.

```java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrimeCheckerController {

    @Autowired
    private PrimeService primeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/check")
    public String checkPrime(@RequestParam("number") int number, Model model) {
        boolean isPrime = primeService.isPrime(number);
        model.addAttribute("number", number);
        model.addAttribute("isPrime", isPrime);
        return "index";
    }
}
```

### `PrimeService.java`

This service contains the logic to determine if a number is prime.

```java
package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class PrimeService {

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

### `index.html`

The HTML template rendered by Thymeleaf.

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Prime Number Checker</title>
    <link rel="stylesheet" type="text/css" th:href="@{/css/styles.css}">
</head>
<body>
    <div class="container">
        <h1>Prime Number Checker</h1>
        <form action="/check" method="post">
            <label for="number">Enter a number:</label>
            <input type="number" id="number" name="number" required>
            <button type="submit">Check</button>
        </form>
        <div th:if="${number != null}">
            <p th:text="'The number ' + ${number} + ' is ' + (${isPrime} ? 'a prime' : 'not a prime') + ' number.'"></p>
        </div>
    </div>
</body>
</html>
```

### `styles.css`

The CSS file for styling the application.

```css
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
    margin-bottom: 20px;
}

form {
    display: flex;
    flex-direction: column;
}

label, input, button {
    margin-bottom: 10px;
}

button {
    padding: 10px;
    background-color: #007BFF;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
```


## Contact

- **Name**: Krishnansh Sharma
- **Email**: contactkrishnansh@gmail.com
- **LinkedIn**: https://www.linkedin.com/in/krishnanshsharma

Feel free to contact me if you have any questions or suggestions regarding this project.
```

### Instructions for Adding the README to Your Repository

1. **Copy the contents** of the above `README.md` file.
2. **Create a new file** named `README.md` in the root directory of your project.
3. **Paste the copied contents** into the `README.md` file.
4. **Commit and push** the `README.md` file to your GitHub repository.

```sh
git add README.md
git commit -m "Add README.md"
git push origin master
```
