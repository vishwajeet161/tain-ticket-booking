package org.ticketBooking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticketBooking.entities.Ticket;
import org.ticketBooking.entities.User;
import org.ticketBooking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private ObjectMapper objMapper = new ObjectMapper();
    private static final String USER_PATH = "../localDb/users.json";


    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        this.userList = this.loadUsers();
    }

    public UserBookingService() throws IOException{
        this.userList = loadUsers();
    }

    public List<User> loadUsers() throws IOException{
        File users = new File(USER_PATH);
        return  objMapper.readValue(users, new TypeReference<List<User>>() {});
    }
    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 ->{
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
    private void saveUserListToFile() throws IOException{
        File userFile = new File(USER_PATH);
        objMapper.writeValue(userFile, userList);
    }
    //jsom --> Object (User) is called Deserialize
    //Object (User) --> Json is called Serialize

    public void fetchBooking(){
        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId){
//        Optional<User> ticketFound = userList.stream().filter(user1->{
//           return user1.getUserId().equalsIgnoreCase()
//        });
        return Boolean.FALSE;
    }

}
