package com.balakhontsev.ecommerce;

import com.balakhontsev.ecommerce.configuration.JwtRequestFilter;
import com.balakhontsev.ecommerce.dao.RoleDao;
import com.balakhontsev.ecommerce.entity.Role;
import com.balakhontsev.ecommerce.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RoleServiceTest {

    @Mock
    private RoleDao roleDao;

    @InjectMocks
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        JwtRequestFilter.CURRENT_USER = "jsmith";
    }

    @Test
    public void testCreateNewRole() {
        Role role = new Role();
        role.setRoleName("testRole");

        when(roleDao.save(any(Role.class))).thenReturn(role);

        Role createdRole = roleService.createNewRole(role);

        verify(roleDao, times(1)).save(any(Role.class));
        assertNotNull(createdRole);
        assertEquals(role.getRoleName(), createdRole.getRoleName());
    }
}