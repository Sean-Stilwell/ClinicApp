
import java.io.Serializable;

public class Message implements Serializable {

    // EXEMPLE OF MESSAGES SENT BY THE CLIENT TO THE SERVER :
	public static final String SIGN_UP_PATIENT = "SIGNUPPATIENT";
	public static final String SIGN_IN_PATIENT = "SIGNINPATIENT";
	public static final String CHANGE_INFORMATION_PATIENT = "CHANGEINFORMATION";

	// EXEMPLE : SIGNING UP A PATIENT REQUIRES 4 ARGUMENTS IN THIS ORDER : FIRST NAME, LAST NAME, EMAIL, PASSWORD
	// This message would be send by the client (user side) to the server. 

	private String messageType;
	private String firstArgument;
	private String secondArgument;
	private String thirdArgument;


	public Message(String messageType){
		this.messageType = messageType;
	}

	public void setFirstArgument(String argument){
		this.firstArgument = argument;
	}

	public void setSecondArgument(String argument){
		this.secondArgument = argument;
	}

	public void setThirdArgument(String argument){
		this.thirdArgument = argument;
	}

	public String getMessageType(){
		return this.messageType;
	}

	public String getFirstArgument(){
		return this.firstArgument;
	}

	public String getSecondArgument(){
		return this.secondArgument;
	}

	public String getThirdArgument(){
		return this.thirdArgument;
	}

}

