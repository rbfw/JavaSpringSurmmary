#密钥库及密钥对的口令 abc123

keytool -genkey -alias privatekey -keystore privateKeys.store -validity 365

keytool -export -alias privatekey -file certfile.cer -keystore privateKeys.store

keytool -import -alias publiccert -file certfile.cer -keystore publicCerts.store