import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipFiles {


    public static String getCsvByte(String urlPath) throws Exception {
        URI         uri     = null;
        HttpHeaders headers = new HttpHeaders();
        String      zipData = null;
        try {
            uri = new URI(urlPath);
            headers.add("Accept", "*/*;q=0.8");
            headers.add("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            headers.add("Accept-Encoding", "zip,gzip,deflate,br");
            HttpEntity<Resource>   httpEntity = new HttpEntity<org.springframework.core.io.Resource>(headers);
            ResponseEntity<byte[]> response   = getRestTemplate().exchange(uri, HttpMethod.GET, httpEntity, byte[].class);
            // 要先解压缩
            zipData = unZipFile(response.getBody(), "csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zipData;
    }


    /**
     * 解压zip到本地磁盘
     *
     * @param zipData
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String unZipFile(byte[] zipData, String fileName) throws IOException {

        byte[]         tempData  = new byte[1024];
        ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(zipData));
        ZipEntry       entry     = null;
        File           file      = null;
        while ((entry = zipStream.getNextEntry()) != null) {
            String entryName = entry.getName();
            if (entryName.endsWith(fileName)) {
                file = new File(entryName);
                if (!file.exists() || !file.isFile()) {
                    File fileDir = new File("F:/temp/");
                    if (fileDir.exists()) {
                        if (fileDir.isDirectory()) {
                            System.out.println("dir exists");
                        } else {
                            System.out.println("the same name file exists, can not create dir");
                        }
                    } else {
                        System.out.println("dir not exists, create it ...");
                        fileDir.mkdir();
                    }
                    file = new File("F:/temp/" + entryName);
                }
                FileOutputStream byteArrayOutputStream = new FileOutputStream(file);
                int              len                   = 0;
                while ((len = zipStream.read(tempData)) > 0) {
                    byteArrayOutputStream.write(tempData, 0, len);
                }
                zipStream.closeEntry();
                byteArrayOutputStream.close();
            }
        }
        zipStream.close();
        return file.getAbsolutePath();
    }

    public static void main(String[] args) {
        String urlPath = "https://apidata.baidu.com/data/v2/getFile.do?t=1535454007&u=19532113&i=fcab66a0b12c3f480f9603fa2b7a0006&f=WAD%2F2018-08-28%2F1953%2F2113%2Fkeyword-20180828-175905-fcab66a0b12c3f480f9603fa2b7a0006.zip&h=200&s=a5c4f64a061a3c9d31a098af81e34341";
        try {
            String csvByte = getCsvByte(urlPath);
            System.out.println(csvByte);
            File file = new File(csvByte);

            // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
            if (file.exists() && file.isFile()) {
                if (file.delete()) {
                    System.out.println("删除单个文件" + csvByte + "成功！");
                } else {
                    System.out.println("删除单个文件" + csvByte + "失败！");
                }
            } else {
                System.out.println("删除单个文件失败：" + csvByte + "不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        return new RestTemplate(requestFactory);
    }
}
