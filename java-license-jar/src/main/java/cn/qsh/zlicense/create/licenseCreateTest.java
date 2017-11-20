package cn.qsh.zlicense.create;

/**
 * 测试证书生成
 */
public class licenseCreateTest {


    public static void main(String[] args) {

        CreateLicense cLicense = new CreateLicense();

        //cLicense.setParam("C:/license/createparam.properties");
        cLicense.setParam("src/main/resources/createparam.properties");
        //create
        cLicense.create();
    }
}
