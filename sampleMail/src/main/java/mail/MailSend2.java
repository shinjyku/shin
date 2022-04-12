package mail;


import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend2 {

	private final  String myMail = "hanako.sendai.aoba@gmail.com";
	private final  String myName = "仙台　花子";
	private final  String myPass =  "qwertyuiop@123";
	
	//public MailSend2() {	}

    public  boolean mail(List<List<String>> datas , String uname, String umail, String goukei){
    	
        System.out.print("start: main\r\n");
        
        try {
        	
        	String title = "※ご注文確認メール※";
        	String message = "ご注文ありがとうございます。\n\n";

        	for(List<String> data : datas ) {
        		message +=	String.format("%-50s %-20s円 %-20s個 %-30s円\n", data.get(0),data.get(1),data.get(2),data.get(3));
   			}

        	message += String.format("合計 : %-200s円",goukei);
        	
//			Java でメールを送信します。メールサーバは Gmail を拝借します。
//			注意事項としてGoogle アカウントの設定で「安全性の低いアプリのアクセス」を許可する必要があります。

        	Properties property = new Properties();        	
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.auth", "true");
			property.put("mail.smtp.starttls.enable", "true");
			property.put("mail.smtp.port", "587");
//			property.put("mail.smtp.debug", "true");
        	
			
			Session session = Session.getInstance(property, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myMail, myPass);
				}
			});

			
			
			InternetAddress toAddress = new InternetAddress(umail, uname);
			InternetAddress fromAddress = new InternetAddress(myMail, myName);
		
			MimeMessage mimeMessage = new MimeMessage(session);
			
			mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
			
			mimeMessage.setFrom(fromAddress);
			
			mimeMessage.setSubject(title, "ISO-2022-JP");

			mimeMessage.setText(message, "ISO-2022-JP");

			System.out.println("OK");
			
			Transport.send(mimeMessage);

			System.out.println("メール送信が完了しました。");
			return true;
			
		}catch (MessagingException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

        System.out.println("メール送信ができません。");
       	return false;
	}
}
