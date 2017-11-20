package cn.qsh.zlicense.verify;

/**
 * 验证证书测试
 */
public class licenseVerifyTest {

    public static void main(String[] args) {

        VerifyLicense vLicense = new VerifyLicense();

        try {
            //设置参数
            //vLicense.setParam("C:/license/verifyparam.properties");
            vLicense.setParam("src/main/resources/verifyparam.properties");
            boolean verifyFlag = vLicense.verify();
            System.out.println("验证结果：" + verifyFlag);
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
}
