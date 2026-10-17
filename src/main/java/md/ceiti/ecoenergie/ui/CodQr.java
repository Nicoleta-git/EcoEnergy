package md.ceiti.ecoenergie.ui;

/*
 * Makes the QR code image of a room (ZXing). Used by the room page.
 * Assigned to: Sofia
 *
 * TODO:
 * - static method that gets a text and returns an Image (QRCodeWriter -> BitMatrix -> WritableImage)
 * - the text comes from TelefonQr.text(salaConsum), so it works on any phone without internet
 *
 * How to make the QR (ZXing is already in pom.xml, nothing to install):
 *     QRCodeWriter scriitor = new QRCodeWriter();
 *     BitMatrix m = scriitor.encode(text, BarcodeFormat.QR_CODE, 300, 300);   // throws WriterException
 *     WritableImage img = new WritableImage(300, 300);
 *     for (int x = 0; x < 300; x++)
 *         for (int y = 0; y < 300; y++)
 *             img.getPixelWriter().setColor(x, y, m.get(x, y) ? Color.BLACK : Color.WHITE);
 *     ImageView qr = new ImageView(img);
 * Imports: com.google.zxing.BarcodeFormat, com.google.zxing.qrcode.QRCodeWriter, com.google.zxing.common.BitMatrix
 * The text inside is plain text (room, kWh today, limit). Any phone camera shows it, no internet or website needed.
 * Test: open the room page and scan the screen with your phone.
 */
public class CodQr {
}
