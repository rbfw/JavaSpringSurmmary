package cn.qsh.zlicense.verify;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.prefs.Preferences;

import cn.qsh.zlicense.de.schlichtherle.license.*;
import com.alibaba.fastjson.JSON;

/**
 * 验证许可证
 *
 * @author sehuaqi
 */
public class VerifyLicense {
    //common param
    private static String PUBLICALIAS = "";
    private static String STOREPWD = "";
    private static String SUBJECT = "";
    private static String licPath = "";
    private static String pubPath = "";


    public void setParam(String propertiesPath) throws IOException {
        //
        Properties prop = new Properties();
        System.out.println("propertiesPath=" + propertiesPath);
        //InputStream in = getClass().getResourceAsStream(propertiesPath);
        InputStream in = new FileInputStream(propertiesPath);
        prop.load(in);
        PUBLICALIAS = prop.getProperty("PUBLICALIAS");
        STOREPWD = prop.getProperty("STOREPWD");
        SUBJECT = prop.getProperty("SUBJECT");
        licPath = prop.getProperty("licPath");
        pubPath = prop.getProperty("pubPath");
    }

    /**
     * 验证
     *
     * @return 验证结果
     * @throws Exception
     */
    public boolean verify() throws Exception {

        LicenseManager licenseManager = LicenseManagerHolder.getLicenseManager(initLicenseParams());
        // install license file
        try {
            licenseManager.install(new File(licPath));
            System.out.println("客户端安装证书成功!");
        } catch (Exception e) {
            //e.printStackTrace();
            String moreInfo = "客户端证书安装失败!";
            System.out.println(moreInfo);
            throw e;
        }
        // verify license file
        try {
            LicenseContent content = licenseManager.verify();
            System.out.println("客户端验证证书成功!");

            System.out.println("content = " + JSON.toJSONString(content));

        } catch (Exception e) {
            //e.printStackTrace();
            String moreInfo = "客户端证书验证失效!";
            System.out.println(moreInfo);
            throw e;
        }
        return true;
    }

    /**
     * 返回验证证书需要的参数
     */
    private static LicenseParam initLicenseParams() {
        Preferences preference = Preferences.userNodeForPackage(VerifyLicense.class);
        CipherParam cipherParam = new DefaultCipherParam(STOREPWD);

        KeyStoreParam privateStoreParam = new DefaultKeyStoreParam(
                VerifyLicense.class, pubPath, PUBLICALIAS, STOREPWD, null);
        LicenseParam licenseParams = new DefaultLicenseParam(SUBJECT,
                preference, privateStoreParam, cipherParam);
        return licenseParams;
    }
}