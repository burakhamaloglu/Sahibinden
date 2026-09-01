import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

void main(String[] args) throws IOException {
    {
        ObjectMapper mapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);
        

        while (true) {

            JsonNode root = mapper.readTree(new File("src/arabalar.json"));
            JsonNode arabalar = root.get("data");

            System.out.println("        SAHİBİNDEN JAVA         ");


            System.out.println("Yapmak İstediğiniz İşlemi Seçin");

            System.out.println("1 - Araba Bul");
            System.out.println("2 - Araba Ekle");
            System.out.println("3 - Araba Çıkar");
            System.out.println("4 - Çıkış");
            System.out.print("Seçiminiz : ");

            int secim = scanner.nextInt();

            if (secim == 1) {

                int sayac = 1;

                for (JsonNode araba : arabalar) {
                    String marka = araba.get("marka").asText();
                    String model = araba.get("model").asText();
                    System.out.println(sayac + "-" + marka + " " + model);
                    sayac += 1;
                }
                System.out.print("İstediğiniz Markayı Seçin : ");
                int markaSecim = scanner.nextInt();


                System.out.println("YIL SEÇ:");

                System.out.println("1 - 2018");
                System.out.println("2 - 2019");
                System.out.println("3 - 2020");
                System.out.println("4 - 2021");
                System.out.println("5 - 2022+");
                System.out.println("6 - Fark etmez");

                System.out.print("Secimin: ");
                int yilSecim = scanner.nextInt();


                System.out.println("RENK SEÇ:");

                System.out.println("1 - Siyah");
                System.out.println("2 - Beyaz");
                System.out.println("3 - Kırmızı");
                System.out.println("4 - Mavi");
                System.out.println("5 - Gri");
                System.out.println("6 - Fark etmez");

                System.out.print("Secimin: ");
                int renkSecim = scanner.nextInt();


                System.out.println("YAKIT TÜRÜ SEÇ:");

                System.out.println("1 - Benzin");
                System.out.println("2 - Dizel");
                System.out.println("3 - Hibrit");
                System.out.println("4 - Elektrik");
                System.out.println("5 - Fark etmez");

                System.out.print("Secimin: ");
                int yakitSecim = scanner.nextInt();


                System.out.println("MAKSİMUM BUTCE");

                System.out.print("Butceniz: ");
                double maksimumFiyat = scanner.nextDouble();


                System.out.println("          ARAMA SONUÇLARI          ");


                boolean arabaBulundu = false;

                JsonNode uygunAraba = null;


                for (int i = 0; i < arabalar.size(); i++) {

                    JsonNode araba = arabalar.get(i);

                    boolean markaUygun = false;
                    boolean yilUygun = false;
                    boolean renkUygun = false;
                    boolean yakitUygun = false;


                    if (markaSecim == sayac) {
                        markaUygun = true;
                    } else if (markaSecim >= 1 && markaSecim < sayac) {
                        String secilenMarka = arabalar.get(markaSecim - 1).get("marka").asText();
                        if (araba.get("marka").asText().equals(secilenMarka)) {
                            markaUygun = true;
                        }
                    }


                    if (yilSecim == 6) {

                        yilUygun = true;

                    } else if (yilSecim == 1 &&
                            araba.get("yil").asInt() == 2018) {

                        yilUygun = true;

                    } else if (yilSecim == 2 &&
                            araba.get("yil").asInt() == 2019) {

                        yilUygun = true;

                    } else if (yilSecim == 3 &&
                            araba.get("yil").asInt() == 2020) {

                        yilUygun = true;

                    } else if (yilSecim == 4 &&
                            araba.get("yil").asInt() == 2021) {

                        yilUygun = true;

                    } else if (yilSecim == 5 &&
                            araba.get("yil").asInt() >= 2022) {

                        yilUygun = true;
                    }


                    if (renkSecim == 6) {

                        renkUygun = true;

                    } else if (renkSecim == 1 &&
                            araba.get("renk").asText().equals("Siyah")) {

                        renkUygun = true;

                    } else if (renkSecim == 2 &&
                            araba.get("renk").asText().equals("Beyaz")) {

                        renkUygun = true;

                    } else if (renkSecim == 3 &&
                            araba.get("renk").asText().equals("Kırmızı")) {

                        renkUygun = true;

                    } else if (renkSecim == 4 &&
                            araba.get("renk").asText().equals("Mavi")) {

                        renkUygun = true;

                    } else if (renkSecim == 5 &&
                            araba.get("renk").asText().equals("Gri")) {

                        renkUygun = true;
                    }


                    if (yakitSecim == 5) {

                        yakitUygun = true;

                    } else if (yakitSecim == 1 &&
                            araba.get("yakit").asText().equals("Benzin")) {

                        yakitUygun = true;

                    } else if (yakitSecim == 2 &&
                            araba.get("yakit").asText().equals("Dizel")) {

                        yakitUygun = true;

                    } else if (yakitSecim == 3 &&
                            araba.get("yakit").asText().equals("Hibrit")) {

                        yakitUygun = true;

                    } else if (yakitSecim == 4 &&
                            araba.get("yakit").asText().equals("Elektrik")) {

                        yakitUygun = true;
                    }


                    if (markaUygun &&
                            yilUygun &&
                            renkUygun &&
                            yakitUygun &&
                            araba.get("fiyat").asDouble() <= maksimumFiyat) {

                        arabaBulundu = true;


                        System.out.println("Marka : " + araba.get("marka").asText());
                        System.out.println("Model : " + araba.get("model").asText());
                        System.out.println("Yıl   : " + araba.get("yil").asInt());
                        System.out.println("Renk  : " + araba.get("renk").asText());
                        System.out.println("Fiyat : " + araba.get("fiyat").asDouble() + " TL");
                        System.out.println("Yakıt : " + araba.get("yakit").asText());

                        if (uygunAraba == null ||
                                araba.get("fiyat").asDouble() < uygunAraba.get("fiyat").asDouble()) {

                            uygunAraba = araba;
                        }
                    }
                }

                if (arabaBulundu) {

                    System.out.println("-------------------------------------");
                    System.out.println("EN UYGUN FİYATLI ARAÇ ");
                    System.out.println("Marka : " + uygunAraba.get("marka").asText());
                    System.out.println("Model : " + uygunAraba.get("model").asText());
                    System.out.println("Yıl   : " + uygunAraba.get("yil").asInt());
                    System.out.println("Renk  : " + uygunAraba.get("renk").asText());
                    System.out.println("Fiyat : " + uygunAraba.get("fiyat").asDouble() + " TL");
                    System.out.println("Yakıt : " + uygunAraba.get("yakit").asText());


                    System.out.println("Bu araç seçtiğiniz kriterlere uyan en uygun fiyatlı araçtır.");

                } else {

                    System.out.println("UYGUN ARABA BULUNAMADI.");
                    System.out.println("Filtrelerinizi değiştirerek tekrar deneyin.");
                }
            } else if (secim == 2) {

                System.out.print("Şifreyi giriniz: ");
                int sifre = scanner.nextInt();

                if (sifre != 1234) {
                    System.out.println("HATALI ŞİFRE!");

                    break;

                } else {
                    System.out.println("Giriş başarılı!");
                }

                System.out.println("Eklemek istediğiniz özellikleri sırasıyla giriniz.");

                System.out.print("Marka :");
                String marka = scanner.next();

                System.out.print("Model :");
                String model = scanner.next();

                System.out.print("Yıl :");
                int yil = scanner.nextInt();

                System.out.print("Renk :");
                String renk = scanner.next();

                System.out.print("Fiyat :");
                double fiyat = scanner.nextDouble();

                System.out.print("Yakıt :");
                String yakit = scanner.next();

                ObjectNode yeniAraba = mapper.createObjectNode();


                yeniAraba.put("marka", marka);
                yeniAraba.put("model", model);
                yeniAraba.put("yil", yil);
                yeniAraba.put("renk", renk);
                yeniAraba.put("fiyat", fiyat);
                yeniAraba.put("yakit", yakit);


                JsonNode rootNode = mapper.readTree(new File("src/arabalar.json"));

                ArrayNode arabalarArray = (ArrayNode) rootNode.get("data");
                arabalarArray.add(yeniAraba);

                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/arabalar.json"), rootNode);

                System.out.println("Araba başarıyla eklendi.");

            } else if (secim == 3) {

                System.out.print("Şifreyi giriniz: ");
                int sifre = scanner.nextInt();

                if (sifre != 1234) {
                    System.out.println("HATALI ŞİFRE!");
                    break;
                } else {
                    System.out.println("Giriş başarılı!");
                }


                System.out.println("SİLİNEBİLİR ARABALARIN LİSTESİ");
                for (int i = 0; i < arabalar.size(); i++) {
                    JsonNode araba = arabalar.get(i);
                    System.out.println((i + 1) + " - " + araba.get("marka").asText() + " " + araba.get("model").asText());
                }

                System.out.print("Çıkarmak istediğiniz arabanın sıra numarasını giriniz: ");
                int siraNo = scanner.nextInt();
                int cikan = siraNo - 1;

                if (cikan >= 0 && cikan < arabalar.size()) {
                    JsonNode silinecekAraba = arabalar.get(cikan);
                    String marka = silinecekAraba.get("marka").asText();
                    String model = silinecekAraba.get("model").asText();

                    ArrayNode arabalarArray = (ArrayNode) root.get("data");
                    arabalarArray.remove(cikan);

                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/arabalar.json"), root);

                    System.out.println(marka + " - " + model + " başarıyla silindi.");
                } else {
                    System.out.println("Geçersiz sıra numarası girdiniz!");
                }

            } else if (secim == 4) {

                System.out.println("ÇIKIŞ YAPILIYOR...");
                break;

            } else {

                System.out.println("Seçiminiz Geçersiz");
            }
        }
    }
}
