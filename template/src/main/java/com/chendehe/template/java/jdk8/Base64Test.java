package com.chendehe.template.java.jdk8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Test {

  public static void main(String[] args) throws UnsupportedEncodingException {
    // Basic编码
    String asB64 = Base64.getEncoder().encodeToString("some string".getBytes("utf-8"));
    System.out.println(asB64); // 输出为: c29tZSBzdHJpbmc=

    // 解码
    byte[] asBytes = Base64.getDecoder().decode("c29tZSBzdHJpbmc=");
    System.out.println(new String(asBytes, "utf-8")); // 输出为: some string

    //URL编码
    String basicEncoded = Base64.getEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
    System.out.println("Using Basic Alphabet: " + basicEncoded);

    String urlEncoded = Base64.getUrlEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
    System.out.println("Using URL Alphabet: " + urlEncoded);

    //MIME编码
    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < 10; ++t) {
      sb.append(UUID.randomUUID().toString());
    }

    byte[] toEncode = sb.toString().getBytes("utf-8");
    String mimeEncoded = Base64.getMimeEncoder().encodeToString(toEncode);
    System.out.println(mimeEncoded);
  }

  //流的封装
  public void wrapping() throws IOException {
    String src = "This is the content of any resource read from somewhere" +
        " into a stream. This can be text, image, video or any other stream.";

//    // 编码器封装OutputStream, 文件/tmp/buff-base64.txt的内容是BASE64编码的形式
//    try (OutputStream os = Base64.getEncoder().wrap(newFileOutputStream("/tmp/buff-base64.txt"))) {
//      os.write(src.getBytes("utf-8"));
//    }
//
//    // 解码器封装InputStream, 以及以流的方式解码, 无需缓冲
//    // is being consumed. There is no need to buffer the content of the file just for decoding it.
//    try (InputStream is = Base64.getDecoder().wrap(newFileInputStream("/tmp/buff-base64.txt"))) {
//      int len;
//      byte[] bytes = new byte[100];
//      while ((len = is.read(bytes)) != -1) {
//        System.out.print(new String(bytes, 0, len, "utf-8"));
//      }
//    }
  }
}
