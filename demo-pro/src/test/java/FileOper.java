import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class FileOper {
    /**
     * 根据压缩文件的字节流获取文件内容
     *
     * @param zipData  字节流文件
     * @param fileName 压缩文件中存在的文件名，使用endWith判定，只要包含一部分既可取出
     * @return 解压后的字节流，可使用new String()转为字符串
     * @throws Exception
     */
    public static byte[] ungzip(byte[] zipData, String fileName /*String file*/) throws Exception {
		/* InputStream in = new BufferedInputStream(new FileInputStream(file)); 
	        ZipInputStream zipStream = new ZipInputStream(in); */
        byte[]                tempData              = new byte[1024];
        GZIPInputStream       gzin                  = new GZIPInputStream(new ByteArrayInputStream(zipData));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipEntry              entry                 = null;
        int                   len                   = 0;
//					if(entryName.endsWith("/修改说明.txt")){
        while ((len = gzin.read(tempData)) > 0) {
            byteArrayOutputStream.write(tempData, 0, len);
            ;
        }
//					}
        gzin.close();
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 解压zip
     *
     * @param zipData
     * @param fileName
     * @param zipType
     * @return
     * @throws IOException
     */
    public static byte[] unzip(byte[] zipData, String fileName /*String file*/) throws IOException {
        byte[]                tempData              = new byte[1024];
        ZipInputStream        zipStream             = new ZipInputStream(new ByteArrayInputStream(zipData));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipEntry              entry                 = null;
        while ((entry = zipStream.getNextEntry()) != null) {
            String entryName = entry.getName();
            if (entryName.endsWith(fileName)) {
                int len = 0;
//				if(entryName.endsWith("/修改说明.txt")){
                while ((len = zipStream.read(tempData)) > 0) {
                    byteArrayOutputStream.write(tempData, 0, len);
                    ;
                }
//				}
                zipStream.closeEntry();
            }
        }
        zipStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) {
    	/*try {
			unzip("waishi.zip", "/Volumes/macdata/testextZip/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        try {
            BufferedInputStream   in                    = new BufferedInputStream(new FileInputStream("/Volumes/macdata/testextZip/20180802130359.zip"));
            byte[]                byteData              = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int                   len                   = 0;
            while ((len = in.read(byteData)) > 0) {
                byteArrayOutputStream.write(byteData, 0, len);
            }
            System.out.println(new String(unzip(byteArrayOutputStream.toByteArray(), ".csv"), "gbk"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//    	ugzip("/Volumes/macdata/testextZip/20180802130359.zip", "/Volumes/macdata/testextZip/aaa.csv");
    }


}