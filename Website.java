package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Website {
    private String url;
    private List<User> subscribers = new ArrayList<>();
    private int lastContentLength;

    
    public Website(String url) {
        this.setUrl(url);
    }

   
    public void addSubscriber(User user, String subscriptionPreferences) {
        subscribers.add(user);
        System.out.println(user.getUsername() + " subscribed to " + getUrl() + " with preferences: " + subscriptionPreferences);
    }

   
    public void checkForUpdates() {
        try {
            int currentContentLength = getWebsiteContent();
            if (lastContentLength == 0) {
                lastContentLength = currentContentLength;
            } else if (lastContentLength != currentContentLength) {
                notifySubscribers();
                lastContentLength = currentContentLength;
            } else {
                System.out.println("No updates detected for " + getUrl());
            }
        } catch (IOException e) {
            System.out.println("Error checking updates: " + e.getMessage());
        }
    }

    private int getWebsiteContent() throws IOException {
        URL website = new URL(getUrl());
        HttpURLConnection connection = (HttpURLConnection) website.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        String content = null;

        while ((inputLine = in.readLine()) != null) {
            content += inputLine;
        }
        in.close();

        return content.length();
    }

    private void notifySubscribers() {
        for (User user : subscribers) {
            System.out.println("Notification: Website " + getUrl() + " has been updated! Notifying " + user.getUsername());
        }
    }


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
}

