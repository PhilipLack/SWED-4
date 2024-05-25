package model;

class CommunicationChannel {
    private String channelType;

    
    public CommunicationChannel(String channelType) {
        this.setChannelType(channelType);
    }

   
    public void deliverNotification(Notification notification) {
        System.out.println("Delivering notification via " + getChannelType());
        notification.deliverNotification();
    }


	public String getChannelType() {
		return channelType;
	}


	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
}