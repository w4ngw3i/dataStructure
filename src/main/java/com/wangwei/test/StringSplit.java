package com.wangwei.test;

/**
 * @author: wangwei
 * @date: 2019-09-20 10:13
 */
public class StringSplit {
    public static void main(String[] args) {

        String filePath = "/workspace/download/20190903/certFileA/sfzzmA.jpg;/workspace/download/20190903/certFileB/sfzfmB.jpg;/workspace/download/20190903/facephoto/face.jpg;/workspace/download/20190903/investigationAuthorization/zxsqs.jpg;";
        // 身份证正面path
        String certPathA = "";
        // 身份证反面path
        String certPathB = "";
        // 人脸照片path
        String facePath = "";
        // 征信授权书path
        String pbocPath = "";
        String[] creditPaths = filePath.split(";");
        for (String path : creditPaths) {
            if (path.contains("certFileA")) {
                certPathA = path;
            }
            if (path.contains("certFileB")) {
                certPathB = path;
            }
            if (path.contains("facephoto")) {
                facePath = path;
            }
            if (path.contains("investigationAuthorization")) {
                pbocPath = path;
            }
        }

        String fileSrc = pbocPath.substring(0, pbocPath.lastIndexOf("/") + 1);
        String fileName = pbocPath.substring(pbocPath.lastIndexOf("/") + 1);
    }
}
