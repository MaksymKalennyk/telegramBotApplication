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
    public static void main(String[] args) throws WriterException, IOException {
        String data="Ukrainets Volodymyr 1";
        String path="/Users/volodimirukrainec/Desktop/qr.jpg";
        BitMatrix matrix = new MultiFormatWriter().encode(data,BarcodeFormat.QR_CODE,500,500);


        MatrixToImageWriter.writeToPath(matrix, "JPG",Paths.get(path));
        System.out.println("Qr good");
    }
}
