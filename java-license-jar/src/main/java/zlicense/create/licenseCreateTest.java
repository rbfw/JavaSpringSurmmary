package zlicense.create;


import java.util.Locale;

public class licenseCreateTest {
	public static void main(String[] args){

//		Locale currentLocale = new Locale("en", "US");
//
//		Locale.setDefault(currentLocale);

		CreateLicense cLicense = new CreateLicense();
		
		//cLicense.setParam("C:/license/createparam.properties");
		cLicense.setParam("/Users/sehuaqi/code/JavaSpringSurmmary/java-license-jar/src/main/resources/createparam.properties");
		//
		cLicense.create();
	}
}
