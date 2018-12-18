 package com.resonator.keycloakService.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import  com.resonator.keycloakService.dao.UserData;
@Repository
public interface KeycloakRepository extends CrudRepository<UserData, String> {
    UserData findByIdAndRealmId(String id,String realmId);
    List<UserData> findByRealmId(String realmId);
}
 
