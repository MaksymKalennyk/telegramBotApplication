import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Paths;
public class GenerateQRCode {
  public static void main(String[] args) {
    String data = "Kalennyk Maks 3";
    String path = "/Users/volodimirukrainec/Desktop/qr/qr.jpg";

    Generator generator = new Generator();
    try {
      generator.generator_method(data, path);
    } catch (WriterException | IOException e) {
      e.printStackTrace();
    }
  }
}