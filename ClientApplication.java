
public class ClientApplication {

	private String clientName;
	private int idNumber;
	private String clientMessage;
	
	
    public ClientApplication(String name,int id,String message) {
    	
    	this.clientName = name;
    	this.idNumber = id;
    	this.clientMessage = message;   	
    }
	
	public int getId() { return idNumber; }
	public String getMessage() { return clientMessage; }

	public boolean equals(Object obj) {
		
		if(!(obj instanceof ClientApplication)) {
			return false;
		}
		return (this.idNumber == ((ClientApplication)obj).getId() && 
				this.clientMessage.equals(((ClientApplication)obj).getMessage()));	
	}
	
}