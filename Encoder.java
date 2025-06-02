import java.util.Base64;

public class Encoder implements EncoderTool {
    @Override
    public String process(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}
