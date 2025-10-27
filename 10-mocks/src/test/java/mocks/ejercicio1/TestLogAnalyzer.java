package mocks.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestLogAnalyzer {

    @Test
    public void testLogAnalyzerWithException(){

        IEmailService emailServiceMock = createMock(IEmailService.class);
        IWebService webServiceMock = createMock(IWebService.class);
        LogAnalyzer logAnalyzer = new LogAnalyzer();

        logAnalyzer.setEmailService(emailServiceMock);
        logAnalyzer.setWebService(webServiceMock);

        webServiceMock.logError("Filename too short:abc");
        expectLastCall().andThrow(new RuntimeException("el servicio de email no estaba disponible"));
        emailServiceMock.sendEmail("a","subject","el servicio de email no estaba disponible");

        replay(emailServiceMock, webServiceMock);

        logAnalyzer.analyze("abc");

        verify(emailServiceMock, webServiceMock);
    }

    @Test
    public void testLogAnalyzerWithoutException(){

        IEmailService emailServiceMock = createMock(IEmailService.class);
        IWebService webServiceMock = createMock(IWebService.class);
        LogAnalyzer logAnalyzer = new LogAnalyzer();

        logAnalyzer.setEmailService(emailServiceMock);
        logAnalyzer.setWebService(webServiceMock);

        webServiceMock.logError("Filename too short:abc");
        expectLastCall();

        replay(emailServiceMock, webServiceMock);

        logAnalyzer.analyze("abc");

        verify(emailServiceMock, webServiceMock);
    }

    @Test
    public void testLogAnalyzerWithoutError(){

        IEmailService emailServiceMock = createMock(IEmailService.class);
        IWebService webServiceMock = createMock(IWebService.class);
        LogAnalyzer logAnalyzer = new LogAnalyzer();

        logAnalyzer.setEmailService(emailServiceMock);
        logAnalyzer.setWebService(webServiceMock);

        replay(emailServiceMock, webServiceMock);

        logAnalyzer.analyze("abcdefghi");

        verify(emailServiceMock, webServiceMock);
    }

}