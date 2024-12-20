# Send Email with SendGrid

This Java application demonstrates how to send an email using the SendGrid API.

## Prerequisites

- Java 8 or higher
- Maven or Gradle
- SendGrid account and API key

## Setup

1. Clone this repository or download the project.
2. Create a SendGrid account and generate an API key from [SendGrid](https://sendgrid.com/).
3. Replace the `API_KEY` in the code with your SendGrid API key.

## Dependencies

Add the following dependency to your `pom.xml` (for Maven):

```xml
<dependencies>
    <dependency>
        <groupId>com.sendgrid</groupId>
        <artifactId>sendgrid-java</artifactId>
        <version>4.7.0</version>
    </dependency>
</dependencies>
```

## Running the Application

1. Open the project in your IDE or terminal.
2. Run the following Maven command:
   ```
   mvn compile exec:java
   ```
3. The program will send a test email to the recipient defined in the code and print the result.

## Example Output
  ```
  Email sent successfully.
  ```

---

This `README.md` file includes the basic setup, dependencies, running instructions, and an example output. 
