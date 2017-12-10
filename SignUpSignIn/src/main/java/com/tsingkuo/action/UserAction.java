package com.tsingkuo.action;

import com.tsingkuo.main.User;
import com.tsingkuo.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;

public class UserAction {
    public Boolean create(User user) {
        UserModel userModel = new UserModel();
        return userModel.createUser(user);
    }

    public void del() {

    }

    public void update() {

    }

    public void query() {

    }

    public void query(String userId) {

    }

    public Boolean search(User user) {
        UserModel userModel = new UserModel();
        Collection<User> collection;
        collection = userModel.searchUser(user);
        if (collection != null && collection.size() > 0) {
            for (User u : collection
                    ) {
                if (user.getPassword().equals(u.getPassword())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
