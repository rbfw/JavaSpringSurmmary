package cn.qsh.zlicense.create;

import cn.qsh.zlicense.de.schlichtherle.license.LicenseManager;
import cn.qsh.zlicense.de.schlichtherle.license.LicenseParam;

/**
 * LicenseManager
 *
 * @author sehuaqi
 */
public class LicenseManagerHolder {

    private static LicenseManager licenseManager;

    public static synchronized LicenseManager getLicenseManager(LicenseParam licenseParams) {
        if (licenseManager == null) {
            licenseManager = new LicenseManager(licenseParams);
        }
        return licenseManager;
    }
}