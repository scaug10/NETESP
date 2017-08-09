package com.g10.ssm.service.impl;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.UserMapper;
import com.g10.ssm.po.User;
import com.g10.ssm.service.LoginService;
import com.g10.ssm.service.PermissionService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserMapper userMapper;

	
	@Autowired
	private PermissionService permissionService;
	/**
	 *新增注册用户,并为用户赋予一个权限
	 */
	@Override
	public int saveUser(User user) throws Exception {
		int res=-1;
		if(user==null)
			return res;
		res=userMapper.insert(user);
		if(res==1){
			String userName=user.getUserName();
			if(userName==null)
				return -1;
			int result=permissionService.giveDefaultPermission(userName);
			return result;
		}else {
			return res;
		}
	}
    
	/**
	 * 验证用户登录密码是否与数据库一致
	 */
	@Override
	public int checkUserPassword(String userName,String password) throws Exception {
		int res=-1;
		if(userName==null||password==null)
			return res;
		User user=userMapper.selectByPrimaryKey(userName);
		if(user==null)
			return res;
		String pwd=user.getPassword();
		if(pwd.equals(password.trim())){
			user.setLoginStatus(true);
			res=userMapper.updateByPrimaryKey(user);
			return res;
		}
		else {
			return res;
		}
	}

	/**
	 * 找回密码
	 */
	@Override
	public int findPassword(String userName) throws Exception {
		int res=-1;
		if(userName==null)
			return res;
		User user=userMapper.selectByPrimaryKey(userName);
		if(user==null)
			return res;
		String email=user.getEmail();
    	String emailServer="smtp.163.com";
    	String subject="【网络应急化培训教育服务平台】用户获取登录密码";
    	String secretKey = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    	user.setPassword(secretKey);
    	res=userMapper.updateByPrimaryKey(user);
    	if(res!=1)
    		return -1;
    	String mailbody="你好，感谢你使用网络应急化培训教育服务平台，你的临时登录密码为   "+secretKey+"   ，请登录系统后立刻修改密码！";
    	String username="18819259339@163.com";
    	String password="faraway123";
    	String nickname="网络应急化培训教育服务平台";
    	res=this.sendEmail(emailServer, subject, mailbody, email, username, password, nickname);
    	return res;
	}

	/**
	 * 查询登录名是否已经存在
	 */
	@Override
	public boolean isUserIdExist(String userName) throws Exception {
		if(userName==null)
			return false;
		User user=userMapper.selectByPrimaryKey(userName);
		if(user==null)
			return false;
		else {
			return true;
		}
	}

	/**
	 * 通过邮件找回密码的具体方法
	 */
	public int sendEmail(String emailServer, String subject, String mailBody, String receiver, String username,String password, String nickname) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", emailServer);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        session.setDebug(true);
        MimeMessage mimeMsg = new MimeMessage(session);
        Multipart mp = new MimeMultipart();
         
        mimeMsg.setSubject(MimeUtility.encodeText(subject, "utf-8", null));
         
        nickname = MimeUtility.encodeText(nickname, "utf-8", null);
        mimeMsg.setFrom(new InternetAddress(username, nickname, "UTF-8"));
         
        BodyPart bp = new MimeBodyPart();
        bp.setContent(mailBody, "text/html;charset=utf-8");
        mp.addBodyPart(bp);
         
        mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
         
        mimeMsg.setContent(mp);
        mimeMsg.saveChanges();
        Transport transport = session.getTransport();
        transport.connect(username, password);
        Address[] allRecipients = mimeMsg.getAllRecipients();
        transport.sendMessage(mimeMsg, allRecipients);
        transport.close();
        return 1;
    }
	
	
}
