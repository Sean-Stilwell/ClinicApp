
import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

    // EXEMPLE OF MESSAGES SENT BY THE CLIENT TO THE SERVER :
	public static final String SIGN_UP_PATIENT = "SIGNUPPATIENT";
	public static final String SIGN_IN_PATIENT = "SIGNINPATIENT";
	public static final String CHANGE_INFORMATION_PATIENT = "CHANGEINFORMATION";

	// EXEMPLE : SIGNING UP A PATIENT REQUIRES 4 ARGUMENTS IN THIS ORDER : FIRST NAME, LAST NAME, EMAIL, PASSWORD
	// This message would be send by the client (user side) to the server. 


	/**
    * Variable representing the Message Type.
    */

	private String messageType;
	/**
    * To add more generality, arguments could be anything (String, Account, Patient).
    * There could be any number of arguments.
    */

	private ArrayList<Object> arguments;

	public Message(String messageType){
		this.messageType = messageType;
		this.arguments = new ArrayList<Object>();
	}

	/**
    * Adds the specified argument to the end of the list of arguments.
    */

	public void addArgument(Object argument){
		arguments.add(argument);
	}

	/**
    * Adds the specified argument at the specified postion.
    * Position 0 is the first argument.
    */

	public void addArgument(int index, Object argument){
		arguments.add(index, argument);
	}

	/**
    * Returns the type of the message.
    * @return String representing the type of message.
    */

	public String getMessageType(){
		return this.messageType;
	}

	/**
    * Returns the argument at the specified index.
    * @return Object representing argument.
    */

	public Object getArgument(int index){
		return (arguments.get(index));
	}

	/**
    * Returns the number of arguments in this message.
    * @return Object representing argument.
    */

	public int getNumOfArgs(){
		return arguments.size();
	}

}



