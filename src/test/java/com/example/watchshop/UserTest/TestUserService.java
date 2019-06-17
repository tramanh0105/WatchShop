package com.example.watchshop.UserTest;

import com.example.watchshop.user.User;
import com.example.watchshop.user.UserDTO;
import com.example.watchshop.user.UserRepo;
import com.example.watchshop.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TestUserService {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepo userRepo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }



    @Test
    public void getAllUsersTest() {
        List<User> list = new ArrayList<>();

    User max = new User("max01","student","max@gmail,com", "05-07-2204", "53442121","max");
    User alex = new User("alex01", "student", "alex@gmail,com", "06-07-2204", "53442161", "max");
    User nicole = new User("nicole01", "student", "nicole@gmail,com", "02-07-2204", "53452121", "max");

        list.add(max);
        list.add(alex);
        list.add(nicole);

    when(userRepo.findAll()).thenReturn(list);

    //test
    List<UserDTO> userList = userService.getUsers();
    assertEquals(3,userList.size());
    verify(userRepo, times(1)).findAll();
}
    @Test
    public void getUserById(){

        when(userRepo.findById(1)).thenReturn(java.util.Optional.of(new User("josh05", "student", "josh@gmail.com", "12-11-2045", "3454545", "Josh")));
        UserDTO user = userService.getUser(1);

        assertEquals("josh05",user.getBenutzerName());
        assertEquals("josh@gmail.com",user.getEmail());
        assertEquals("12-11-2045",user.getGeburtsdatum());
        assertEquals("3454545",user.getPhoneNumer());
        assertEquals("Josh",user.getName());
    }
    @Test
    public void addUser(){

        User josh = new User("josh05", "student", "josh@gmail.com", "12-11-2045", "3454545", "Josh");
        userService.createUser(josh);

        verify(userRepo,times(1)).save(josh);

    }
    @Test
    public void updateUser(){
        User josh = new User("josh05", "student", "josh@gmail.com", "12-11-2045", "3454545", "Josh");

        userService.createUser(josh);

        verify(userRepo,times(1)).save(josh);
    }
    
}
