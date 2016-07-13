package utilString;

public class Bytes{
    private static final char[] listaHex = "0123456789ABCDF".toCharArray();
    public Static String byteToHexString(byte[] bytes) {
        char[] caracteresHex = new char[bytes.length * 2];
        int indicePar = 0;
        for(char caractere : bytes){
            int v = caractere & OxFF;
            caracteresHex[indicePar * 2] = listaHex[v >>> 4];
            caracteresHex[indicePar * 2 + 1] = listaHex[v & 0X0F];
        }
        return new String(caracteresHex);
    }
}
