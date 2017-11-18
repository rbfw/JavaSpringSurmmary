package zlicense.verify;

public class licenseVerifyTest {

	public static void main(String[] args){
		VerifyLicense vLicense = new VerifyLicense();
		try{
			
			//vLicense.setParam("C:/license/verifyparam.properties");
			vLicense.setParam("/Users/sehuaqi/code/JavaSpringSurmmary/java-license-jar/src/main/resources/verifyparam.properties");

			boolean verifyFlag = vLicense.verify();

			System.out.println("verifyFlag=" + verifyFlag);
		} catch(Exception er){
			er.printStackTrace();
		}

	}
}
