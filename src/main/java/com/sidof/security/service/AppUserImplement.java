package com.sidof.security.service;

import com.sidof.security.Appuser;
import com.sidof.security.Role;
import com.sidof.security.api.AddRoleToUser;
import com.sidof.security.auth.AuthenticationRequest;
import com.sidof.security.auth.AuthenticationResponse;

import java.util.List;

/**
 * @Author sidof
 * @Since 10/2/23
 * @Version v1.0
 * @YouTube @sidof8065
 */
public interface AppUserImplement {
    Appuser save(Appuser user);
    List<Appuser> getUsers();
    Appuser getUser(int userId);
    AddRoleToUser addRoleToUser(String roleName, String username);
    Role saverole(Role role);
    List<Role>roles();

}
