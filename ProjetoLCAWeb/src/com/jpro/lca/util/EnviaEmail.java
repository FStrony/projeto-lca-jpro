package com.jpro.lca.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.jpro.lca.bean.AgendaAudiencia;
import com.jpro.lca.bean.Cliente;
import com.jpro.lca.bean.Processo;

public class EnviaEmail {

    public static void enviar(AgendaAudiencia audiencia){
    	final String emailRemetente = "lca.jpro@gmail.com";
        final String senhaRemetente = "lcaemail";
        
        Processo pro = audiencia.getProcesso();
        Cliente cli = pro.getCliente();
        
        final String emailDestinatario = cli.getDs_email();
        final String assunto = "Processo nœmero " + pro.getNr_processo();
        final String mensagem = pro.getDs_processo();
        
    	try {

            //CONFIG. DO GMAIL
            Properties mailProps = new Properties();
            mailProps.put("mail.transport.protocol", "smtp");
            mailProps.put("mail.smtp.starttls.enable","true");
            mailProps.put("mail.smtp.host", "mail.google.com.br");
            mailProps.put("mail.smtp.auth", "true");
            mailProps.put("mail.smtp.user", emailRemetente);
            mailProps.put("mail.debug", "true");
            mailProps.put("mail.smtp.port", "465");
            mailProps.put("mail.smtp.socketFactory.port", "465");
            mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            mailProps.put("mail.smtp.socketFactory.fallback", "false");

            //EH NECESSARIO AUTENTICAR
            Session mailSession = Session.getInstance(mailProps, new Authenticator() {                  
                public PasswordAuthentication getPasswordAuthentication(){              
                    return new PasswordAuthentication(emailRemetente, senhaRemetente);
                }
            });
            mailSession.setDebug(false);

            //CONFIG. DA MENSAGEM 
            Message mailMessage = new MimeMessage(mailSession);

            //REMETENTE
            mailMessage.setFrom(new InternetAddress(emailRemetente));

            //DESTINATARIO
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));        

            //MENSAGEM QUE VAI NO CORPO DO EMAIL
            MimeBodyPart mbpMensagem = new MimeBodyPart();
            mbpMensagem.setText(mensagem);

            //PARTES DO EMAIL
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbpMensagem);
            

            //ASSUNTO DO EMAIL
            mailMessage.setSubject(assunto);
            
            //SELECIONA O CONTEUDO
            mailMessage.setContent(mp);

            //ENVIA O EMAIL
            Transport.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    }

}
