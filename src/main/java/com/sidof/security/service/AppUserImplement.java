package com.sidof.security.service;

import com.sidof.security.model.Appuser;
import com.sidof.security.model.Role;
import com.sidof.security.api.AddRoleToUser;

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
    Appuser edit(Appuser user);

}
