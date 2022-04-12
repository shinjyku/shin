package mail;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend3 {

    public  void mail(){
    	
    	
        System.out.print("start: main\r\n");
        
    	 final  String myMail = "hanako.sendai.aoba@gmail.com";
    	 final  String myName = "仙台　花子";
    	 final  String myPass =  "qwertyuiop@123";

    	 
    	 final  String toMail = "sendai.ts@gmail.com";
    	 final  String toName = "仙台　太郎";
    	 
        
        try {
			Properties property = new Properties();
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.auth", "true");
			property.put("mail.smtp.starttls.enable", "true");
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.port", "587");
			property.put("mail.smtp.debug", "true");

//			Java でメールを送信します。メールサーバは Gmail を拝借します。
//			注意事項としてGoogle アカウントの設定で「安全性の低いアプリのアクセス」を許可する必要があります。

			
			Session session = Session.getInstance(property, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myMail, myPass);
				}
			});


			MimeMessage mimeMessage = new MimeMessage(session);
			
			InternetAddress toAddress = new InternetAddress(toMail, toName);
			mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
			
			InternetAddress fromAddress = new InternetAddress(myMail, myName);
			mimeMessage.setFrom(fromAddress);
			
			mimeMessage.setSubject("title", "ISO-2022-JP");
			mimeMessage.setText("message", "ISO-2022-JP");
			
			Transport.send(mimeMessage);
			
			System.out.println("メール送信が完了しました。");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
