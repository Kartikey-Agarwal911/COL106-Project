import HelperClasses.DigitalSignature;
import HelperClasses.Conversion;
import java.security.KeyPair;

public class Signature extends DigitalSignature {

    public static SignatureKeys keygen() {
        KeyPair keys = generate_keys();
        String sk = Conversion.byteToHex(keys.getPrivate().getEncoded());
        String vk = Conversion.byteToHex(keys.getPublic().getEncoded());
        return new SignatureKeys(sk, vk);
    }

    public static String BoundedMsgSign(String message, String sk) {

        assert message.length() == 64;

        return sign_message(message, sk);
    }

    public static boolean BoundedMsgVerify(String message, String pk, String signature) {

        assert message.length() == 64;

        return verify_signature(message, pk, signature);
    }

    /*==========================
    |- To be done by students -|
    ==========================*/

    public static String Sign(String m, String sk) {
        
   
        
        CRF ColResFun = new CRF(64);
        
        String OOT = BoundedMsgSign(ColResFun.Fn(m),sk);        

        return OOT;
    }

    public static boolean Verify(String m, String vk, String sig) {
        
        CRF ColResFun = new CRF(64);

        return BoundedMsgVerify(ColResFun.Fn(m),vk,sig);

    }
}
