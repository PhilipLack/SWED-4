package model;

import java.util.ArrayList;
import java.util.List;

class Website {
    String url;
    private List<User> subscribers = new ArrayList<>();

   
    public Website(String url) {
        this.url = url;
    }

   
    public void addSubscriber(User user, String subscriptionPreferences) {
        subscribers.add(user);
        System.out.println(user.getUsername() + " subscribed to " + url + " with preferences: " + subscriptionPreferences);
    }

    
    public void checkForUpdates() {
        
    }
}

