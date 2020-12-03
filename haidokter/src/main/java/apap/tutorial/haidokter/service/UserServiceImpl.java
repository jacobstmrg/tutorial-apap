package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDB;

    @Override
    public String addUser(UserModel user) {
        String password = user.getPassword();
        int containsNumber = 0;
        int containsAlphabet = 0;
        if (password.length() >= 8){
            for (char character : password.toCharArray()) {
                if(Character.isDigit(character)){
                    containsNumber = 1;
                }
                else if(Character.isAlphabetic(character)){
                    containsAlphabet = 1;
                }
            }
            if(containsNumber == 1 && containsAlphabet == 1){
                String fixPassword = encrypt(user.getPassword());
                user.setPassword(fixPassword);
                userDB.save(user);
                return "User berhasil ditambahkan";
            }else if(containsNumber == 0 && containsAlphabet == 1){
                return "password tidak mengandung angka";
            }else{
                return "password tidak mengandung huruf";
            }
        }else{
            return "password kurang dari 8 digit";
        }
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
    @Override
    public String changePassword(UserModel user, String password) {
        int containsNumber = 0;
        int containsAlphabet = 0;
        if (password.length() >= 8){
            for (char character : password.toCharArray()) {
                if(Character.isDigit(character)){
                    containsNumber = 1;
                }
                else if(Character.isAlphabetic(character)){
                    containsAlphabet = 1;
                }
            }
            if(containsNumber == 1 && containsAlphabet == 1){
                String changedPassword = encrypt(password);
                user.setPassword(changedPassword);
                userDB.save(user);
                return "Password berhasil diubah";
            }else if(containsNumber == 0 && containsAlphabet == 1){
                return "password tidak mengandung angka";
            }else{
                return "password tidak mengandung huruf";
            }
        }else{
            return "password kurang dari 8 digit";
        }
    }

    @Override
    public UserModel findUser(String username) {
        return userDB.findByUsername(username);
    }
}
