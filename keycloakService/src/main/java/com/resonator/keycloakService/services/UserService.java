package com.resonator.keycloakService.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.resonator.keycloakService.dao.UserData;
import com.resonator.keycloakService.dao.KeycloakRepository;

@Service
public class UserService {

	@Autowired
    private KeycloakRepository repository;

	static {
		// Initialize Data

		//User tapok = new User("111001", "Only","One","Man","some@gmail.com","photouri,photouri!", "+38067275832");
		//users.add(tapok);
	}

    public List<UserData> findAll() {
        List<UserData> users = (List<UserData>) repository.findByRealmId("resonator");
        return users;
    }
    public Boolean save(UserData user) {
        System.out.println("not supported!");
        return true;
    }
    public UserData update(UserData user) {
    	System.out.println("not supported too");
    
        return null;
        
    }
    public UserData get(String id) {
    	UserData u = repository.findByIdAndRealmId(id,"resonator");
    	if(u==null)u=new UserData(id,null,null,null,null,null);
        return u;
        
    }
	
}

