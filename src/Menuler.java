public class Menuler {

    //Program açıldığında ilk menüyü yazdırması için oluşturduğum fonksiyon
    public void girisMenusu () {
        System.out.println("-------------GIRIS-MENU-------------");
        System.out.println("1- Elit Uye Ekleme");
        System.out.println("2- Genel Uye Ekleme");
        System.out.println("3- Uyeleri Lısteye Yazdır");
        System.out.println("4- Mail Gonderme");
        System.out.println("5- Uygulamayi Kapat");
        System.out.println("------------------------------------");

        System.out.println("<-UYARI-> Listeye yazdirma islemini ekleme islemleriniz bitince seciniz! <-UYARI->");
        System.out.println("Lutfen menuden bir islem seciniz: ");
    }

    //Mail gönderme seçildiğinde çıkan menüyü yazdırması için oluşturduğum fonksiyon
    public void mailMenusu () {
        System.out.println("-------------MAIL-MENU-------------");
        System.out.println("1- Elit Uyelere Mail Gonderme");
        System.out.println("2- Genel Uyelere Mail Gonderme");
        System.out.println("3- Tum Uyelere Mail Gonderme");
        System.out.println("-----------------------------------");
    }

}