package br.com.leonardoterrao.rest;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String DB_FILE = "users.dat";

   public List<User> findAll() {
       List<User> users = new ArrayList<>();
       try {

           File file = new File(DB_FILE);
           if (!file.exists()) {
               users.add(new User(1L, "Leonardo", LocalDate.of(1992, 2, 17)));
               users.add(new User(2L, "João", LocalDate.of(1960, 9, 20)));
               users.add(new User(3L, "Maria", LocalDate.of(1967, 5, 2)));
               save(users);
           } else {
               FileInputStream fis = new FileInputStream(file);
               ObjectInputStream ois = new ObjectInputStream(fis);
               users = (List<User>) ois.readObject();
               ois.close();
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
       return users;
   }

    private void save(List<User> users) {
        try {
            File file = new File(DB_FILE);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
