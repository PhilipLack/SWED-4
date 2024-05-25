package model;

class User {
    private int userID;
    private String username;

   
    public User(int userID, String username) {
        this.userID = userID;
        this.setUsername(username);
    }

   
    public void registerForUpdates(Website website, String subscriptionPreferences) {
        website.addSubscriber(this, subscriptionPreferences);
    }

    
    public void manageSubscriptions(SubscriptionManager manager, String action, Website website) {
        if (action.equals("add")) {
            manager.addSubscription(this, website);
        } else if (action.equals("cancel")) {
            manager.cancelSubscription(this, website);
        }
    }


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
}