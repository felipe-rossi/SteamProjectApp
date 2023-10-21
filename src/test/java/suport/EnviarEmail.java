package suport;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {

    public static final String meuEmail = "felipaovs12@gmail.com";
    public static final String emailFlauzino = "rfgdfghgf@gmail.com";
    public static final String emailCaio = "caioansanelli1@gmail.com";
    public static final String minhaSenha = "celokikjwolrjmoo";

    public static void enviarEmail(String nomeItem, String valorItem){

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        email.setSSLOnConnect(true);

        try {
            email.setFrom(meuEmail);
            email.setSubject("Compra Realizada com sucesso");
            email.setMsg("O item: " + nomeItem + " foi comprado pelo preço de: " + valorItem);
            email.addTo(meuEmail);
            email.addTo(emailFlauzino);
            email.addTo(emailCaio);
            email.send();
            System.out.println("E-mail enviado com sucesso");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
