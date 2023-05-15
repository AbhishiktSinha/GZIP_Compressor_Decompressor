package CompDecomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
public class Decompresssor
{
    public static void method(File file) throws IOException
    {
        String fileDirec = file.getParent();
        String fileName = file.getName();
        fileName = fileName.substring(0, fileName.length() - 3);
        System.out.println(fileName);

        FileInputStream inFile = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(inFile);
        FileOutputStream outFile = new FileOutputStream(fileDirec+"/Decomp_"+fileName);

        byte[] buffer = new byte[1024];
        int len;

        while( (len = gzip.read(buffer)) != -1)
        {
            outFile.write(buffer, 0, len);
        }

        gzip.close();
        outFile.close();
        inFile.close();
    }
}
