import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //Dosya işlemlerinde kullanmak için oluşturduğum dosya nesnesi
        File dosya = new File("kullanıcılar.txt");

        //Menu classındaki fonksiyonları çağırmak için oluşturduğum menü nesnesi
        Menuler menu = new Menuler();

        //MailAtma classından mail atmamızı sağlayan fonksiyonu çağırmak için oluşturduğum mailGonder nesnesi
        MailAtma mailGonder = new MailAtma();

        //Elit ve genel kullanıcıları kaydetmek için oluşturduğum iki boyutlu string dizileri. 15 örnek olarak koyduğum bi sınır, istediğimiz sayıya çıkarabiliriz
        String[][] elitKullanici = new String[15][3];
        String[][] genelKullanici = new String[15][3];

        //Aşağıdaki kodlarda kullandığım değişkenler
        int sayac = 0, sayac2 = 0, kontrol = 1;
        String ad, sifre, elitMail, genelMail, konu, ileti;

        //Kullanıcının istediği zamana kadar çalışması için while döngüsüne aldım
        while(kontrol == 1) {

            //Giriş menüsünü çağırdım
            menu.girisMenusu();

            //Kullanıcının seçtiği işlemi input olarak aldım
            Scanner girdi1 = new Scanner(System.in);
            int islem = girdi1.nextInt();

            //Seçilen işlemlere göre kodun çalışması için switch-case kullandım
            switch (islem) {
                case 1:

                    //Dosyanın oluşup oluşmadığını kontrol ederek, varolan dosya üzerine yazılmasını engelledim
                    if (!dosya.exists()) {
                        dosya.createNewFile();
                    }

                    //Kullanıcıdan eklenecek elit üyenin ad,soyad ve mail bilgilerini alıp 2 boyutlu dizime kaydettim
                    Scanner girdi3 = new Scanner(System.in);
                    System.out.println("Lutfen kullanıcının adını giriniz: ");
                    elitKullanici [sayac][0] = girdi3.nextLine();
                    System.out.println("Lutfen kullanıcının soyadını giriniz: ");
                    elitKullanici [sayac][1] = girdi3.nextLine();
                    System.out.println("Lutfen kullanıcının mailini giriniz: ");
                    elitKullanici [sayac][2] = girdi3.nextLine();

                    //Sayac kullanmamın sebebi kaç tane üye eklendiğini kaydetmek
                    sayac++;

                    System.out.println("Elit uye ekleme islemi basariyla tamamlandi!");
                    break;
                case 2:

                    //Dosyanın oluşup oluşmadığını kontrol ederek, varolan dosya üzerine yazılmasını engelledim
                    if (!dosya.exists()) {
                        dosya.createNewFile();
                    }

                    //Kullanıcıdan eklenecek genel üyenin ad,soyad ve mail bilgilerini alıp 2 boyutlu dizime kaydettim
                    Scanner girdi2 = new Scanner(System.in);
                    System.out.println("Lutfen kullanıcının adını giriniz: ");
                    genelKullanici [sayac2][0] = girdi2.nextLine();
                    System.out.println("Lutfen kullanıcının soyadını giriniz: ");
                    genelKullanici [sayac2][1] = girdi2.nextLine();
                    System.out.println("Lutfen kullanıcının mailini giriniz: ");
                    genelKullanici [sayac2][2] = girdi2.nextLine();

                    //Sayac kullanmamın sebebi kaç tane üye eklendiğini kaydetmek
                    sayac2++;

                    System.out.println("Genel uye ekleme islemi basariyla tamamlandi!");
                    break;
                case 3:

                    //Dosyaya veri yazmak için fWriter ve bWriter nesnelerini oluşturdum
                    FileWriter fWriter = new FileWriter(dosya, false);
                    BufferedWriter bWriter = new BufferedWriter(fWriter);

                    //Elit üyeler başlığı yazdırdım
                    bWriter.write("#Elit Uyeler\n\n");

                    //For döngüsü kullanarak iki boyutlu dizime kaydettiğim elit üyeleri kullanıcılar.txt adlı dosyaya yazdırdım
                    for (int a=0; a<sayac; a++) {
                        for (int b=0; b<3; b++) {
                            bWriter.write(elitKullanici [a][b]);
                            bWriter.write("\t");
                        }
                        bWriter.write("\n");
                    }

                    //Genel üyeler başlığı yazdırdım
                    bWriter.write("#Genel Uyeler\n\n");

                    //For döngüsü kullanarak iki boyutlu dizime kaydettiğim genel üyeleri kullanıcılar.txt adlı dosyaya yazdırdım
                    for (int a=0; a<sayac2; a++) {
                        for (int b=0; b<3; b++) {
                            bWriter.write(genelKullanici [a][b]);
                            bWriter.write("\t");
                        }
                        bWriter.write("\n");
                    }

                    //Dosyayı kapattım
                    bWriter.close();
                    System.out.println("Eklenen uyeleri listeye yazma islemi basariyla tamamlandi!");
                    break;
                case 4:

                    //Mail menüsünü çağırdım
                    menu.mailMenusu();

                    //Kullanıcının menüden seçeceği işlemi input olarak aldım
                    Scanner girdi4 = new Scanner(System.in);
                    System.out.println("Lutfen mail atmak icin gecerli bir islem seciniz: ");
                    int menuIslem = girdi4.nextInt();

                    //Kullanıcının seçtiği işlemin çalışması için switch-case kullandım
                    switch (menuIslem) {
                        case 1:

                            //Mail atılması için gereken bilgileri kullanıcıdan input olarak aldım
                            System.out.println("Lutfen kendi mailinizi giriniz: ");
                            Scanner girdi5 = new Scanner(System.in);
                            ad = girdi5.nextLine();

                            //Hocam bu kısıma Google hesabınızdaki uygulama şifrenizi girmeniz lazım, hatırlatmak istedim
                            System.out.println("Lutfen kendi uygulama sifrenizi giriniz: ");
                            sifre = girdi5.nextLine();
                            System.out.println("Lutfen gondermek istediginiz mailin konusunu yaziniz: ");
                            konu = girdi5.nextLine();
                            System.out.println("Lutfen gondermek istediginiz mesaj icerigini yaziniz: ");
                            ileti = girdi5.nextLine();

                            //For döngüsü kullanarak 2 boyutlu dizimdeki tüm elit üyelere mail gönderdim
                            for (int c=0; c<sayac; c++) {
                                elitMail = elitKullanici[c][2];
                                mailGonder.mailAt(ad, sifre, elitMail, konu, ileti);
                            }
                            break;
                        case 2:

                            //Mail atılması için gereken bilgileri kullanıcıdan input olarak aldım
                            System.out.println("Lutfen kendi mailinizi giriniz: ");
                            girdi5 = new Scanner(System.in);
                            ad = girdi5.nextLine();

                            //Hocam bu kısıma Google hesabınızdaki uygulama şifrenizi girmeniz lazım, hatırlatmak istedim
                            System.out.println("Lutfen kendi uygulama sifrenizi giriniz: ");
                            sifre = girdi5.nextLine();
                            System.out.println("Lutfen gondermek istediginiz mailin konusunu yaziniz: ");
                            konu = girdi5.nextLine();
                            System.out.println("Lutfen gondermek istediginiz mesaj icerigini yaziniz: ");
                            ileti = girdi5.nextLine();

                            //For döngüsü kullanarak 2 boyutlu dizimdeki tüm genel üyelere mail gönderdim
                            for (int d=0; d<sayac; d++) {
                                genelMail = genelKullanici[d][2];
                                mailGonder.mailAt(ad, sifre, genelMail, konu, ileti);
                            }
                            break;
                        case 3:

                            //Mail atılması için gereken bilgileri kullanıcıdan input olarak aldım
                            System.out.println("Lutfen kendi mailinizi giriniz: ");
                            girdi5 = new Scanner(System.in);
                            ad = girdi5.nextLine();

                            //Hocam bu kısıma Google hesabınızdaki uygulama şifrenizi girmeniz lazım, hatırlatmak istedim
                            System.out.println("Lutfen kendi uygulama sifrenizi giriniz: ");
                            sifre = girdi5.nextLine();
                            System.out.println("Lutfen gondermek istediginiz mailin konusunu yaziniz: ");
                            konu = girdi5.nextLine();
                            System.out.println("Lutfen gondermek istediginiz mesaj icerigini yaziniz: ");
                            ileti = girdi5.nextLine();

                            //For döngüsü kullanarak 2 boyutlu dizimdeki hem elit hem de genel üyelere mail gönderdim
                            for (int e=0; e<sayac; e++) {
                                elitMail = elitKullanici[e][2];
                                mailGonder.mailAt(ad, sifre, elitMail, konu, ileti);
                                genelMail = genelKullanici[e][2];
                                mailGonder.mailAt(ad, sifre, genelMail, konu, ileti);
                            }
                            break;
                        default:

                            //Kullanıcı yanlış bir değer girdiğinde gelen uyarı
                            System.out.println("Gecersiz bir islem girdiniz!");
                    }
                    break;
                case 5:

                    //Uygulamanın kapatılmasını sağlayan kod
                    kontrol = 0;
                    System.out.println("Uygulama kapatılıyor..");
                    break;
                default:

                    //Kullanıcı yanlış bir değer girdiğinde gelen uyarı
                    System.out.println("Gecersiz bir islem girdiniz !");
            }
        }
    }
}