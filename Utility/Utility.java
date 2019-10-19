
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

public class Utility {

	private static final String SHA256 = "SHA-256";

    /**
    * This method applies the SHA256 cryptographic on the String argument.
    * The resulted hash is then converted into Hexadcimal String format.
    * The original String is not modified.
    *
    * @param argument the String to be hashed
    * @return Hexadciamal String representation of the resulted Hash.
    */

	public static String SHA256(String argument){

		String toReturn = null;
		try {

		    byte[] data = argument.getBytes(StandardCharsets.UTF_8);
		    MessageDigest messageDigest = MessageDigest.getInstance(SHA256);
		    byte[] hash = messageDigest.digest(data);
		    String hexRepresentation = DatatypeConverter.printHexBinary(hash);
		    toReturn = hexRepresentation;

		} catch (NoSuchAlgorithmException e){

			// WILL NEVER HAPPEN, BUT STILL HAVE TO CATCH
			// THE ALGORITHM WILL RETURN NULL IF THIS EXCEPTION IS THROWN			
		}
		return toReturn;
	}
}

