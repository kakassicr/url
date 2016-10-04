package com.company;







import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yechang on 2016/10/4.
 */


public class RetrivePage {
    private static HttpClient httpClient = new HttpClient();

    // ���ô��������
    static {
// ���ô���������� IP ��ַ�Ͷ˿�
        httpClient.getHostConfiguration().setProxy("172.17.18.84", 8080);
        httpClient.
    }

    public static boolean downloadPage(String path) throws HttpException,
            IOException {
        InputStream input = null;
        OutputStream output = null;
// �õ� post ����
        PostMethod postMethod = new PostMethod(path);
// ���� post �����Ĳ���
        NameValuePair[] postData = new NameValuePair[2];
        postData[0] = new
                NameValuePair("name", "lietu");
        postData[1] = newNameValuePair("password", "*****");
        postMethod.addParameters(postData);
// ִ�У�����״̬��
        int statusCode = httpClient.executeMethod(postMethod);
// ���״̬����д��� ( �������ֻ������ֵΪ 200 ��״̬�� )
        if (statusCode == HttpStatus.SC_OK) {
            input = postMethod.getResponseBodyAsStream();
// �õ��ļ���
            String filename = path.substring(path.lastIndexOf('/') + 1);
// ����ļ������
            output = new FileOutputStream(filename);
// ������ļ�
            int tempByte = -1;
            while ((tempByte = input.read()) > 0) {
                output.write(tempByte);
            }
// �ر����������
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
            return true;
        }
        return false;
    }

    /**
     * ���Դ���
     */
    public static void main(String[] args) {
// ץȡ lietu ��ҳ �� ���
        try {
            RetrivePage.downloadPage("http://www.lietu.com/");
        } catch (HttpException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}