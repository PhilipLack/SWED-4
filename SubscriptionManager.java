package model;

class SubscriptionManager {
   
    public void addSubscription(User user, Website website) {
       
        System.out.println(user.getUsername() + " subscribed to " + website.url);
    }

   
    public void cancelSubscription(User user, Website website) {
        System.out.println(user.getUsername() + " unsubscribed from " + website.url);
    }
}
