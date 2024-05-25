package model;

import java.util.List;

class WebsiteMonitorSystem {
    
    public void monitorWebsites(List<Website> websites, CommunicationChannel channel) {
        for (Website website : websites) {
            website.checkForUpdates();
            Notification notification = new Notification("New updates available on " + website.getUrl(), channel.getChannelType());
            CommunicationChannel communicationChannel = new CommunicationChannel(channel.getChannelType());
            communicationChannel.deliverNotification(notification);
        }
    }
}
