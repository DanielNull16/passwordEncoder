import java.util.Base64;

public class Decoder implements EncoderTool {
    @Override
    public String process(String input) {
        return new String(Base64.getDecoder().decode(input));
    }
}
