package com;

import com.sendgrid.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class SendEmailWithSendGridTest {

    // The class under test
    SendEmailWithSendGrid sendEmailWithSendGrid;

    // Mock the SendGrid API client
    @Mock
    SendGrid mockSendGrid;

    // Mock the Response class
    @Mock
    Response mockResponse;

    @BeforeEach
    void setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);
        sendEmailWithSendGrid = new SendEmailWithSendGrid();
    }
    
    @Test
    void testSendEmailSuccess() throws IOException {
        // Arrange: Create a mock Response with a 202 status code (successful email send)
        when(mockSendGrid.api(any(Request.class))).thenReturn(mockResponse);
        when(mockResponse.getStatusCode()).thenReturn(202);
        when(mockResponse.getBody()).thenReturn("");
        when(mockResponse.getHeaders()).thenReturn(null);

        // Act: Call the method to send an email
        String result = sendEmailWithSendGrid.sendEmail(mockSendGrid);

        // Assert: Verify the result and interactions
        assertEquals("Email sent successfully.", result);
        verify(mockSendGrid, times(1)).api(any(Request.class));
    }

    @Test
    void testSendEmailFailure() throws IOException {
        // Arrange: Create a mock Response with a 400 status code (failed email send)
        when(mockSendGrid.api(any(Request.class))).thenReturn(mockResponse);
        when(mockResponse.getStatusCode()).thenReturn(400);
        when(mockResponse.getBody()).thenReturn("Bad Request");
        when(mockResponse.getHeaders()).thenReturn(null);

        // Act: Call the method to send an email
        String result = sendEmailWithSendGrid.sendEmail(mockSendGrid);

        // Assert: Verify the result and interactions
        assertEquals("Failed to send email.", result);
        verify(mockSendGrid, times(1)).api(any(Request.class));
    }

}
