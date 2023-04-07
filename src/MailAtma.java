import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailAtma {
    public void mailAt(String ad, String sif, String email, String baslik, String ileti) {

        //Eposta için doğrulama bilgilerini tanımladım
        final String kullaniciAdi = ad;
        final String sifre = sif;

        //Sunucu ayar ve bilgilerini tanımladım
        Properties ozellikler = new Properties();
        ozellikler.put("mail.smtp.auth", "true");
        ozellikler.put("mail.smtp.starttls.enable", "true");
        ozellikler.put("mail.smtp.host", "smtp.gmail.com");
        ozellikler.put("mail.smtp.port", "587");

        //Oturum nesnesi oluşturdum
        Session oturum = Session.getInstance(ozellikler, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(kullaniciAdi, sifre);
            }
        });

        try {

            //Mesaj nesnesi oluşturdum
            Message mesaj = new MimeMessage(oturum);

            //Mesaj içerik ve bilgilerini ayarladım
            mesaj.setFrom(new InternetAddress(kullaniciAdi));
            mesaj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            mesaj.setSubject(baslik);
            mesaj.setText(ileti);

            //Maili gönderen kod
            Transport.send(mesaj);

            System.out.println("Email basariyla gonderildi!");

        //Kod çalışırken hatayı tespit eden kontrol kısmı
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}