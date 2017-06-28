package com.mmall.util;

import java.io.*;

/**
// * Alt+enter:自动导包
 * Alt+insert：补全代码
 * ctrl+j可以查看快捷键
 * psvm:public static void main的首字母
 *
 * try catch代码块：选定代码块，ctrl+alt+T
 * Created by Administrator on 2017/6/28.
 */
public class ImageUtil {
    private static File file=null;
    /*
    * 从本地文件读取图像的二进制流
    * */
    public static FileInputStream getImageByte(String infile){
       FileInputStream imageByte=null;
        file=new File(infile);
        try{
            imageByte=new FileInputStream(file);
        }
        catch (FileNotFoundException e){
         e.printStackTrace();
        }
        return imageByte;
    }

    /*
    * 将图片流读出为图片
    * */
    public static void readBlob(InputStream inputStream,String path){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            byte[]buffer=new byte[1024];
            int len=0;
            while ((len=inputStream.read(buffer))!=-1){
                fileOutputStream.write(buffer,0,len);
            }
            inputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
