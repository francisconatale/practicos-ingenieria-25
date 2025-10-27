package mocks.ejercicio2;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestIpBlackList {
    @Test
    public void testLoginExitosoDespuesDeUnIntento() {
        LoginService loginServiceMock = createNiceMock(LoginService.class);
        String password_hashed = Utils.getPasswordHashMD5("xoxo");

        expect(loginServiceMock.login(eq("192.168.0.1"), eq("chiefkeef"), eq(password_hashed)))
                .andReturn(true).anyTimes();

        expect(loginServiceMock.login(eq("192.168.0.1"), eq("chiefkeef"), anyString()))
                .andReturn(false).anyTimes();

        IPBlacklist ipBlacklist = new IPBlacklist();
        ipBlacklist.setService(loginServiceMock);
        replay(loginServiceMock);

        assertFalse(ipBlacklist.login("192.168.0.1", "chiefkeef", "xoxa"));
        assertTrue(ipBlacklist.login("192.168.0.1", "chiefkeef", "xoxo"));

        verify(loginServiceMock);
    }

    @Test
    public void testIpEnLaListaNegra() {
        LoginService loginServiceMock = createNiceMock(LoginService.class);
        String password_hashed = Utils.getPasswordHashMD5("xoxo");

        expect(loginServiceMock.login(eq("192.168.0.1"), eq("chiefkeef"), eq(password_hashed)))
                .andReturn(true).anyTimes();

        expect(loginServiceMock.login(eq("192.168.0.1"), eq("chiefkeef"), anyString()))
                .andReturn(false).anyTimes();

        IPBlacklist ipBlacklist = new IPBlacklist();
        ipBlacklist.setService(loginServiceMock);
        replay(loginServiceMock);
        for(int i = 1; i <= 3; i++) {
            ipBlacklist.login("192.168.0.1", "chiefkeef", "xoxa");
        }
        assertTrue(ipBlacklist.blacklisted("192.168.0.1"));
        verify(loginServiceMock);
    }

    @Test
    public void testIpQueNoEstaEnLaListaNegra() {
        LoginService loginServiceMock = createNiceMock(LoginService.class);
        String password_hashed = Utils.getPasswordHashMD5("xoxo");

        expect(loginServiceMock.login(eq("192.168.0.1"), eq("chiefkeef"), eq(password_hashed)))
                .andReturn(true).anyTimes();

        expect(loginServiceMock.login(eq("192.168.0.1"), eq("chiefkeef"), anyString()))
                .andReturn(false).anyTimes();

        IPBlacklist ipBlacklist = new IPBlacklist();
        ipBlacklist.setService(loginServiceMock);
        replay(loginServiceMock);
        for(int i = 1; i <= 2; i++) {
            ipBlacklist.login("192.168.0.1", "chiefkeef", "xoxa");
        }
        assertFalse(ipBlacklist.blacklisted("192.168.0.1"));
        verify(loginServiceMock);
    }



}
