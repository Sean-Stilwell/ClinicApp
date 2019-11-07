
import CommunicationProtocol.Message;

public class MyServer extends AbstractServer {

	public MyServer(int port){

		super(port);
	}


	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client){

		if(msg instanceof Message) {

			Message message = (Message) msg;
			this.decrypytMessage(message, client);
		}
	}

	protected void decrypytMessage(Message msg, ConnectionToClient client){

		String msgType = msg.getMessageType();

		switch (msgType) {

			case Message.SIGN_UP_PATIENT : 

			    handle_SignUpPatient_Request(msg, client);
			    break;

			case Message.SIGN_IN_PATIENT :

			    handle_SignInPatient_Request(msg, client);
			    break;

			case Message.SIGN_UP_EMPLOYEE :

			    handle_SignUpEmployee_Request(msg, client);
			    break;

			case Message.SIGN_IN_EMPLOYEE :

			    handle_SignInEmployee_Request(msg, client);
			    break;

			default :

			    //client.sendToClient(new Message("UNSECESFULL"));
			    break;
		}
	}

	private void handle_SignInPatient_Request(Message msg, ConnectionToClient client){

		// Format represents the format of the message.
		// Meaning, it is the number of arguments and the type
		// of each argument. In this case 2 arguments of type String.

        Class<?>[] format = {String.class, String.class};

        if(msg.getNumOfArgs()==2 && this.checkMessageFormat(msg,format)){

		  	String email = (String) msg.getArgument(0);
		  	String password = (String) msg.getArgument(1);

		    //Patient patient = dataBase.signInPatient(email, password);
		    // sendToClient(patient);        	
        }
	}

	private void handle_SignUpPatient_Request(Message msg, ConnectionToClient client){

		// Format represents the format of the message.
		// Meaning, it is the number of arguments and the type
		// of each argument. In this case 2 arguments of type String.

        Class<?>[] format = {String.class, String.class, String.class, String.class};

        if(msg.getNumOfArgs()==4 && this.checkMessageFormat(msg,format)){

        	String firstName = (String) msg.getArgument(0);
        	String lastName = (String) msg.getArgument(1);
		  	String email = (String) msg.getArgument(2);
		  	String password = (String) msg.getArgument(3);

		    //Patient patient = dataBase.signUpPatient(firstName, lastName, email, password);
		    // sendToClient(patient);		            	
        }
	}

	private void handle_SignInEmployee_Request(Message msg, ConnectionToClient client){

		// Format represents the format of the message.
		// Meaning, it is the number of arguments and the type
		// of each argument. In this case 2 arguments of type String.

        Class<?>[] format = {String.class, String.class, String.class, String.class};

        if(msg.getNumOfArgs()==2 && this.checkMessageFormat(msg,format)){


		  	String email = (String) msg.getArgument(0);
		  	String password = (String) msg.getArgument(1);

		    //dataBase.signInPatient(firstName, lastName, email, password);   
		    // sendToClient(patient);		         	
        }
	}

	private void handle_SignUpEmployee_Request(Message msg, ConnectionToClient client){

		// Format represents the format of the message.
		// Meaning, it is the number of arguments and the type
		// of each argument. In this case 2 arguments of type String.

        Class<?>[] format = {String.class, String.class, String.class, String.class};

        if(msg.getNumOfArgs()==4 && this.checkMessageFormat(msg,format)){

        	String firstName = (String) msg.getArgument(0);
        	String lastName = (String) msg.getArgument(1);
		  	String email = (String) msg.getArgument(2);
		  	String password = (String) msg.getArgument(3);

		    //dataBase.signUpEmployee(firstName, lastName, email, password);
		    // sendToClient(patient);		             	
        }
	}


	// HELPER METHOD
	private boolean checkMessageFormat(Message msg, Class<?>[] format){

		for(int i = 0 ; i < msg.getNumOfArgs(); i++){

			if(msg.getArgument(i).getClass()!=format[i]){

				return false;
			}
		}
		return true;
	}

}
