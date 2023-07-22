/* Урок 2 
Задание 2
Написать метод «Шифр Цезаря», с булевым параметром зашифрования и 
расшифро- вания и числовым ключом
*/
public class Cipher {

    // Метод для зашифрования или расшифрования 
    public static String caesarCipher(String message, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        // корректируем ключ, чтобы он был в диапазоне [0, 33] в размере длины алфавита
        key = key % 33;
        if (key < 0) {
            key += 33;
        }

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'А' : 'а';
                int shifted = ch - base;

                if (encrypt) {
                    shifted = (shifted + key) % 33;
                } else {
                    shifted = (shifted - key + 33) % 33;
                }

                char newChar = (char) (base + shifted);
                result.append(newChar);
            } else {                
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Текст для зашифровки
        String message = "Сегодня прекрасная погода!";
        int key = 3;
        boolean encrypt = true;

        // Зашифровываем сообщение с ключом 3
        String encryptedMessage = caesarCipher(message, key, encrypt);
        System.out.println("Зашифрованный текст: " + encryptedMessage);

        // Расшифровываем сообщение с тем же ключом 3
        String decryptedMessage = caesarCipher(encryptedMessage, key, false);
        System.out.println("Расшифрованный текст: " + decryptedMessage);
    }
}
