package JCACrypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import play.Play;
import play.exceptions.UnexpectedException;

public class Crypto{
    // public enum Tipos{
    //
    // }
    // TODO
    // private static final Tipos TIPO_PADRAO = ;

    private static final char[] CARACTERES = {'0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encryptAES(String texto) {
        return encryptAES(texto,
            Play.configuration.getProperty("application.secret")
            .substring(0, 16));
    }

    public static String encryptAES(String texto, String segredo){
        try{
            byte[] raw = segredo.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return Bytes.byteToHexString(cipher.doFinal(texto.getBytes()));

        }catch(Exception ex){
            throw new UnexpectedException(ex);
        }
    }

    public static String decryptAES(String textoEncriptado){
        return decryptAES(textoEncriptado,
            Play.configuration.getProperty("application.secret")
            .substring(0, 16));
    }

    public static String decryptAES(String textoEncriptado, String segredo){
        try{
            byte[] raw = segredo.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return new String(cipher.doFinal(
                Bytes.hexStringToByte(textoEncriptado)));
        }catch(Exception ex){
            throw new UnexpectedException(ex);
        }
    }


}
