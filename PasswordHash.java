import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash
{
    public String hashPW(String plainText)
    {
        String cipherText="";

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest=md.digest(plainText.getBytes());
            BigInteger no=new BigInteger(1, messageDigest);
            cipherText=no.toString(16);
            while(cipherText.length()<32)
            {
                cipherText="0"+cipherText;
            }
        }

        catch(NoSuchAlgorithmException e)
        {
            System.out.println(e.getMessage());
        }

        return cipherText;
    }
}
