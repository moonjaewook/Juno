package com.good.juno.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.good.juno.dto.ProductDto;

@Repository
public class ProductDao {
    
    private SqlSessionFactory sqlSessionFactory;
    
    
    @Autowired
    public ProductDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public boolean productInsert(ProductDto pDto) {
        SqlSession session = null;
        
        try {
            session = sqlSessionFactory.openSession();
            ProductIDao mapper = session.getMapper(ProductIDao.class);
            mapper.insertProduct(pDto);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
	public void sendEmail(String recipientEmail, String contents) throws MessagingException {
		
		
		System.out.println("sendemail");
		System.out.println("받는사람" + recipientEmail);
		System.out.println("내용" + contents);
		
		String host = "smtp.naver.com";
		String user = "sjung8009@naver.com";
		String password = "FPSJH5ZWGLLS";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	    props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", host);

		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sjung8009@naver.com", "FPSJH5ZWGLLS");
            }
        });

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
			message.setSubject("QnA");

			String htmlContent = "<div style=\"width:600px; margin:10px auto; font-size:0; line-height:0; border:1px solid #000\">"
					+ "<div style=\"padding:0 25px 5px 0; border-bottom:5px solid #000; padding:20px; text-align:center\">"
					+ "<img src=\"https://www.junohair.com/static_resources/images/junohair/junohair_logo_dark.png\" alt=\"GEO DESIGN\" loading=\"lazy\"></div>"
					+ "<div style=\"padding:35px 25px 0; background-color: #f7f7f7;\">"
					+ "<div style=\"padding-bottom:15px; font-weight: 500; font-size:22px; line-height:34px; color: #333;\">"
					+ "주노헤어를 이용해주셔서 감사합니다.</div>"
					+ "<div style=\"width: 100%; padding:25px 20px; background-color: #fff; border:1px solid #ccc; font-size:16px; line-height:24px; color: #666; box-sizing: border-box;\">"
					+ "문의주신 내용에 대한 답변입니다.<br><br>"
					+ "<strong style=\"font-weight: 500; color: #000;\">답변 내용</strong> : " + contents + "</div>"
					+ "<div style=\"padding:15px 0 40px; font-weight: 300; font-size:15px; line-height:1.3; color: #888;\">"
					+ "* 본 메일은 발신전용으로 회신 되지 않습니다.<br>* 문의사항은 상담전화를 이용해 주세요.</div></div></div>";

			message.setContent(htmlContent, "text/html; charset=utf-8");
			Transport.send(message);
			 System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
    
   
}
