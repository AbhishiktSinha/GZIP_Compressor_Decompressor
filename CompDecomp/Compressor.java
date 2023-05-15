package CompDecomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor
{
    public static void method(File file) throws IOException
    {
        String fileDirec = file.getParent();
        String fileName = file.getName();

        FileInputStream inFile = new FileInputStream(file);
        FileOutputStream outFile = new FileOutputStream(fileDirec+"/Compressed_"+fileName+".gz");
        GZIPOutputStream gzip = new GZIPOutputStream(outFile);

        byte[] buffer = new byte[1024];
        int len;

        while( (len = inFile.read(buffer)) != -1)
        {
            gzip.write(buffer, 0, len);
        }

        gzip.close();
        outFile.close();
        inFile.close();
    }
}
