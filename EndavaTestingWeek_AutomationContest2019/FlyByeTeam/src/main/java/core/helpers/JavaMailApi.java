package core.helpers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.mail.*;
import java.util.Date;
import java.util.Properties;

public class JavaMailApi {

    static Properties getProperties(String host) {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        return properties;
    }

    static Date retrieveSendDate(Message m) throws Exception {
        Date sendDate = m.getSentDate();
        System.out.println(sendDate);
        return sendDate;
    }

    static String getSender(Message m) throws Exception {
        Address[] a;
        String sender = "";
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++)
                sender = a[j].toString();
        }
        return sender;
    }

    static boolean isRightEmail() {
        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "tccc.jane@gmail.com";// change accordingly
        String password = "Test.1234";// change accordingly
        try {
            Date sendDate = new Date();
            System.out.println("******Send Date " + sendDate);
            String sender = getSender(check(host, mailStoreType, username, password));
            System.out.println("****Sender " + sender);
            Date mailDate = retrieveSendDate(check(host, mailStoreType, username, password));
            System.out.println("****Mail Date " + mailDate);
            if (sendDate.compareTo(mailDate) < 20 && sender.equals("noreply@janrain.com")) {
                System.out.println("Mail date is still smaller than sendDate");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static Message check(String host, String storeType, String user, String password) {
        Message returnedMessage = null;
        try {
            //create properties field
            Session emailSession = Session.getDefaultInstance(getProperties(host));

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);
            returnedMessage = messages[(messages.length - 1)];

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return returnedMessage;
        }
    }

    public static String writePart(Part p) throws Exception {
        if (p instanceof Message)
            //Call methods writeEnvelope
            writeEnvelope((Message) p);

        if (p.isMimeType("multipart/*")) {
            System.out.println("This is a Multipart");
            System.out.println("---------------------------");
            Multipart mp = (Multipart) p.getContent();

            String strMultiPart = (String) mp.getBodyPart(1).getContent();
            Document docMultiPart = Jsoup.parse(strMultiPart);
            Element magicLinkURL = docMultiPart.select("a").first();
            String parsedLink = magicLinkURL.toString();
            String codeSnippet = parsedLink.substring(72, 104);
            return codeSnippet;
        } else {
            String html = (String) p.getContent();
            Document doc = Jsoup.parse(html);
            Element magicLinkURL = doc.select("a").first();
            String parsedLink = magicLinkURL.toString();
            String codeSnippet = parsedLink.substring(72, 104);
            return codeSnippet;
        }

    }

    public static void writeEnvelope(Message m) throws Exception {
        Address[] a;
        Date sendDate = m.getSentDate();
        System.out.println(sendDate);
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++)
                System.out.println("FROM: " + a[j].toString());
        }
        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++)
                System.out.println("TO: " + a[j].toString());
        }
        // SUBJECT
        if (m.getSubject() != null)
            System.out.println("SUBJECT: " + m.getSubject());
    }

    static String getLoginCode(String host, String mailStoreType, String username, String password) throws Exception {
        int counter = 0;
        while (isRightEmail() == false && counter <= 5) {
            if (isRightEmail() == true) {
                writePart(check(host, mailStoreType, username, password));
            } else if (counter == 5) {
                break;
            }
            counter++;
        }
        return "e-mail did not arrived";
    }


    public static void main(String[] args) {

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "tccc.johndoe@gmail.com";// change accordingly
        String password = "Test.1234";// change accordingly

        try {
//            System.out.println(getLoginCode(host, mailStoreType, username, password));
            System.out.println(writePart(check(host, mailStoreType, username, password)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
